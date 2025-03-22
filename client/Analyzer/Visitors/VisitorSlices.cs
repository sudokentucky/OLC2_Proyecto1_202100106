using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public override Value VisitSliceType(SliceTypeContext context)
    {
        Value subtypeValue = Visit(context.typeSpec());

        if (subtypeValue.Type == ValueType.Slice)
        {
            Slice innerSlice = subtypeValue.AsSlice();
            return Value.FromSlice(new Slice(ValueType.Slice, innerSlice.NestedValueType));
        }

        return Value.FromSlice(new Slice(subtypeValue.Type));
    }

    public override Value VisitSliceLiteral([NotNull] SliceLiteralContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        Slice declaredSlice = GetDeclaredSlice(context);
        List<Value> elements = GetElementsFromContext(context);

        (ValueType elementType, ValueType nestedType) = DetermineElementTypes(declaredSlice, elements);
        ValidateElementsTypes(elements, elementType, nestedType, line, column);

        Slice resultSlice = CreateSlice(elementType, nestedType, elements);
        return Value.FromSlice(resultSlice);
    }

    private Slice GetDeclaredSlice(SliceLiteralContext context)
    {
        return context.sliceType() != null
            ? Visit(context.sliceType()).AsSlice()
            : null;
    }

    private List<Value> GetElementsFromContext(SliceLiteralContext context)
    {
        return context.expresionOrSliceLiteral()
                      .Select(Visit)
                      .ToList();
    }

    private (ValueType elementType, ValueType nestedType) DetermineElementTypes(Slice declaredSlice, List<Value> elements)
    {
        if (declaredSlice != null)
            return (declaredSlice.ElementType, declaredSlice.NestedValueType);

        if (elements.Count == 0)
            return (ValueType.Nil, ValueType.Nil);

        Value firstElement = elements[0];

        if (firstElement.Type == ValueType.Slice)
        {
            Slice innerSlice = firstElement.AsSlice();
            return (ValueType.Slice, innerSlice.NestedValueType);
        }

        return (firstElement.Type, ValueType.Nil);
    }

    private void ValidateElementsTypes(List<Value> elements, ValueType elementType, ValueType nestedType, int line, int column)
    {
        foreach (var element in elements)
        {
            if (elementType == ValueType.Slice)
                ValidateNestedSlice(element, nestedType, line, column);
            else
                ValidateElementType(element, elementType, line, column);
        }
    }

    private void ValidateNestedSlice(Value element, ValueType expectedNestedType, int line, int column)
    {
        if (element.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, $"Se esperaba un slice, pero se encontró: {element.Type}");
            return;
        }

        Slice innerSlice = element.AsSlice();
        if (innerSlice.NestedValueType != expectedNestedType)
        {
            AddSemanticError(line, column, $"Tipo interno no coincide. Esperado: {expectedNestedType}, Encontrado: {innerSlice.NestedValueType}");
        }
    }

    private void ValidateElementType(Value element, ValueType expectedType, int line, int column)
    {
        if (element.Type != expectedType)
        {
            AddSemanticError(line, column, $"Tipo incompatible. Esperado: {expectedType}, Encontrado: {element.Type}");
        }
    }

    private Slice CreateSlice(ValueType elementType, ValueType nestedType, List<Value> elements)
    {
        Slice slice = elementType == ValueType.Slice
            ? new Slice(ValueType.Slice, nestedType)
            : new Slice(elementType);

        elements.ForEach(slice.Append);
        return slice;
    }

    public override Value VisitSliceFunc([NotNull] SliceFuncContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (context.LEN() != null)
            return EvaluateLen(Visit(context.expresion(0)), line, column);

        if (context.APPEND() != null)
            return EvaluateAppend(context.expresion().Select(Visit).ToArray(), line, column);

        if (context.SLICES() != null && context.INDEX() != null)
            return EvaluateSlicesIndex(Visit(context.expresion(0)), Visit(context.expresion(1)), line, column);

        if (context.STRINGS() != null && context.JOIN() != null)
            return EvaluateStringsJoin(Visit(context.expresion(0)), Visit(context.expresion(1)), line, column);

        AddSemanticError(line, column, "Función de slice desconocida.");
        return Value.FromNil();
    }

    private Value EvaluateLen(Value arg, int line, int column)
    {
        return arg.Type switch
        {
            ValueType.Slice => Value.FromInt(SliceOperations.Len(arg.AsSlice())),
            ValueType.String => Value.FromInt(arg.AsString().Length),
            _ => ReportLenTypeError(arg.Type, line, column)
        };
    }

    private Value ReportLenTypeError(ValueType type, int line, int column)
    {
        AddSemanticError(line, column, $"len() no aplica a tipo {type}.");
        return Value.FromInt(0);
    }

    private Value EvaluateAppend(Value[] args, int line, int column)
    {
        if (args.Length < 2)
        {
            AddSemanticError(line, column, "append requiere al menos 2 parámetros: append(slice, item1, ...)");
            return Value.FromNil();
        }

        Value sliceValue = args[0];
        if (sliceValue.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, "append() el primer argumento debe ser un slice.");
            return Value.FromNil();
        }

        return AppendElements(sliceValue.AsSlice(), args.Skip(1), line, column);
    }

    private Value AppendElements(Slice slice, IEnumerable<Value> elements, int line, int column)
    {
        foreach (var element in elements)
        {
            if (slice.ElementType == ValueType.Slice)
            {
                AppendNestedSlice(slice, element, line, column);
            }
            else
            {
                AppendSingleElement(slice, element, line, column);
            }
        }

        return Value.FromSlice(slice);
    }

    private void AppendNestedSlice(Slice slice, Value element, int line, int column)
    {
        if (element.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, $"No se puede agregar {element.Type} a un slice de slices.");
            return;
        }

        Slice innerSlice = element.AsSlice();
        if (innerSlice.NestedValueType != slice.NestedValueType)
        {
            AddSemanticError(line, column, $"Tipos incompatibles en el slice anidado. Se esperaba {slice.NestedValueType}.");
            return;
        }

        slice.Append(element);
    }

    private void AppendSingleElement(Slice slice, Value element, int line, int column)
    {
        if (element.Type != slice.ElementType)
        {
            AddSemanticError(line, column, $"No se puede agregar {element.Type} a un slice de {slice.ElementType}.");
            return;
        }

        slice.Append(element);
    }

    private Value EvaluateSlicesIndex(Value sliceVal, Value searchVal, int line, int column)
    {
        if (sliceVal.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, "slices.Index() el primer argumento debe ser un slice.");
            return Value.FromInt(-1);
        }

        int index = SliceOperations.Index(sliceVal.AsSlice(), searchVal);
        return Value.FromInt(index);
    }

    private Value EvaluateStringsJoin(Value sliceVal, Value sepVal, int line, int column)
    {
        if (sliceVal.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, "strings.join() el primer argumento debe ser un slice.");
            return Value.FromString("");
        }

        if (sepVal.Type != ValueType.String)
        {
            AddSemanticError(line, column, "strings.join() el segundo argumento debe ser string.");
            return Value.FromString("");
        }

        Slice slice = sliceVal.AsSlice();

        if (slice.ElementType != ValueType.String)
        {
            AddSemanticError(line, column, "strings.join() se aplica solo a slices de strings.");
            return Value.FromString("");
        }

        string result = SliceOperations.Join(slice, sepVal.AsString());
        return Value.FromString(result);
    }

    private string DescribeSlice(ValueType elementType, ValueType nestedType)
    {
        return elementType == ValueType.Slice
            ? $"[]{DescribeSlice(nestedType, ValueType.Nil)}"
            : elementType.ToString();
    }
}
