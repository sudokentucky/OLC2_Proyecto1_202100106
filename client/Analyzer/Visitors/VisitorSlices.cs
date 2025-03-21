using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;
public partial class Visitor{

public override Value VisitSliceType(gramaticaParser.SliceTypeContext context)
{
    Value subTypeVal = Visit(context.typeSpec());

    if (subTypeVal.Type == ValueType.Slice)
    {
        Slice innerSlice = (Slice)subTypeVal.Data;
        return new Value(ValueType.Slice, new Slice(ValueType.Slice, innerSlice.NestedValueType));
    }

    return new Value(ValueType.Slice, new Slice(subTypeVal.Type));
}


public override Value VisitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context)
{
    int line = context.Start.Line;
    int col = context.Start.Column;

    // Obtener el tipo declarado (si existe)
    Slice declaredSlice = null;
    if (context.sliceType() != null)
    {
        declaredSlice = Visit(context.sliceType()).AsSlice();
    }

    var exprOrSliceList = context.expresionOrSliceLiteral();
    List<Value> elements = new List<Value>();

    // Recolectar los elementos
    foreach (var node in exprOrSliceList)
    {
        Value element = Visit(node);
        elements.Add(element);
    }

    // Determinar el tipo de elementos según los valores visitados
    ValueType elementType = ValueType.Nil;
    ValueType nestedType = ValueType.Nil;

    if (declaredSlice != null)
    {
        elementType = declaredSlice.ElementType;
        nestedType = declaredSlice.NestedValueType;
    }
    else if (elements.Count > 0)
    {
        if (elements[0].Type == ValueType.Slice)
        {
            elementType = ValueType.Slice;
            nestedType = elements[0].AsSlice().NestedValueType;
        }
        else
        {
            elementType = elements[0].Type;
        }
    }

    // Validar tipos de elementos
    foreach (var elem in elements)
    {
        if (elementType == ValueType.Slice)
        {
            if (elem.Type != ValueType.Slice)
            {
                AddSemanticError(line, col, $"Se esperaba un slice en un slice multidimensional. Se encontró: {elem.Type}");
            }
            else
            {
                Slice innerSlice = elem.AsSlice();
                if (innerSlice.NestedValueType != nestedType)
                {
                    AddSemanticError(line, col, $"Tipo interno no coincide. Esperado: {nestedType}, Encontrado: {innerSlice.NestedValueType}");
                }
            }
        }
        else if (elem.Type != elementType)
        {
            AddSemanticError(line, col, $"Tipo incompatible. Esperado: {elementType}, Encontrado: {elem.Type}");
        }
    }

    // Crear el slice final
    Slice newSlice = elementType == ValueType.Slice
        ? new Slice(ValueType.Slice, nestedType)
        : new Slice(elementType);

    foreach (var elem in elements)
    {
        newSlice.Append(elem);
    }

    return Value.FromSlice(newSlice);
}


private string DescribeSlice(ValueType elementType, ValueType nestedType)
{
    if (elementType == ValueType.Slice)
    {
        return $"[]{DescribeSlice(nestedType, ValueType.Nil)}";
    }
    return elementType.ToString();
}
    public override Value VisitSliceFunc([NotNull] gramaticaParser.SliceFuncContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    if (context.LEN() != null)
    {
        Value arg = Visit(context.expresion(0)); 
        return EvaluateLen(arg, line, column);
    }
    else if (context.APPEND() != null)
    {
        Value[] exprs = context.expresion().Select(e => Visit(e)).ToArray();
        return EvaluateAppend(exprs, line, column);
    }
    else if (context.SLICES() != null && context.INDEX() != null)
    {
        Value sliceVal = Visit(context.expresion(0));
        Value searchVal = Visit(context.expresion(1));
        return EvaluateSlicesIndex(sliceVal, searchVal, line, column);
    }
    else if (context.STRINGS() != null && context.JOIN() != null)
    {
        Value sliceVal  = Visit(context.expresion(0));
        Value sepVal    = Visit(context.expresion(1));
        return EvaluateStringsJoin(sliceVal, sepVal, line, column);
    }
    else
    {
        AddSemanticError(line, column, "Función de slice desconocida.");
        return Value.FromNil();
    }
}
private Value EvaluateLen(Value arg, int line, int col)
{
    if (arg.Type == ValueType.Slice)
    {
        Slice s = arg.AsSlice();
        int length = SliceOperations.Len(s);
        return Value.FromInt(length);
    }
    else if (arg.Type == ValueType.String)
    {
        return Value.FromInt(arg.AsString().Length);
    }
    else
    {
        AddSemanticError(line, col, $"len() no aplica a tipo {arg.Type}.");
        return Value.FromInt(0);
    }
}

private Value EvaluateAppend(Value[] exprs, int line, int col)
{
    if (exprs.Length < 2)
    {
        AddSemanticError(line, col, "append requiere al menos 2 parámetros: append(slice, item1, ...)");
        return Value.FromNil();
    }

    Value sliceVal = exprs[0];

    if (sliceVal.Type != ValueType.Slice)
    {
        AddSemanticError(line, col, "append() el primer argumento debe ser un slice.");
        return Value.FromNil();
    }

    Slice slice = sliceVal.AsSlice();

    for (int i = 1; i < exprs.Length; i++)
    {
        Value elem = exprs[i];

        // Si es un slice multidimensional, validar nested type
        if (slice.ElementType == ValueType.Slice)
        {
            if (elem.Type != ValueType.Slice)
            {
                AddSemanticError(line, col, $"No se puede agregar {elem.Type} a un slice de slices.");
                continue;
            }

            Slice innerSlice = elem.AsSlice();
            if (innerSlice.NestedValueType != slice.NestedValueType)
            {
                AddSemanticError(line, col, $"Tipos incompatibles en el slice anidado. Se esperaba {slice.NestedValueType}.");
                continue;
            }

            slice.Append(elem);
        }
        else
        {
            if (elem.Type != slice.ElementType)
            {
                AddSemanticError(line, col, $"No se puede agregar {elem.Type} a un slice de {slice.ElementType}.");
                continue;
            }

            slice.Append(elem);
        }
    }

    return Value.FromSlice(slice);
}


private Value EvaluateSlicesIndex(Value sliceVal, Value searchVal, int line, int col)
{
    if (sliceVal.Type != ValueType.Slice)
    {
        AddSemanticError(line, col, "slices.Index() el primer argumento debe ser un slice.");
        return Value.FromInt(-1);
    }
    Slice s = sliceVal.AsSlice();
    int idx = SliceOperations.Index(s, searchVal);
    return Value.FromInt(idx);
}

private Value EvaluateStringsJoin(Value sliceVal, Value sepVal, int line, int col)
{
    if (sliceVal.Type != ValueType.Slice)
    {
        AddSemanticError(line, col, "strings.join() el primer argumento debe ser un slice.");
        return Value.FromString("");
    }

    if (sepVal.Type != ValueType.String)
    {
        AddSemanticError(line, col, "strings.join() el segundo argumento debe ser string.");
        return Value.FromString("");
    }

    Slice slice = sliceVal.AsSlice();

    if (slice.ElementType != ValueType.String)
    {
        AddSemanticError(line, col, "strings.join() se aplica solo a slices de strings.");
        return Value.FromString("");
    }

    string result = SliceOperations.Join(slice, sepVal.AsString());
    return Value.FromString(result);
}


}