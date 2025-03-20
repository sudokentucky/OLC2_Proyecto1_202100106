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
        ValueType nestedType = innerSlice.NestedValueType;
        Slice topSlice = new Slice(ValueType.Slice, nestedType);
        return new Value(ValueType.Slice, topSlice);
    }
    else
    {
        Slice topSlice = new Slice(subTypeVal.Type);
        return new Value(ValueType.Slice, topSlice);
    }
}

public override Value VisitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context)
{
    int line = context.Start.Line;
    int col = context.Start.Column;

    Slice declaredSliceType = null;
    ValueType declaredElementType = ValueType.Nil;
    ValueType declaredNestedType = ValueType.Nil;

    if (context.sliceType() != null)
    {
        Value typeValue = Visit(context.sliceType());
        if (typeValue.Type == ValueType.Slice)
        {
            declaredSliceType = typeValue.AsSlice();
            declaredElementType = declaredSliceType.ElementType;
            declaredNestedType = declaredSliceType.NestedValueType;
        }
        else
        {
            declaredElementType = typeValue.Type;
        }
    }

    var exprList = context.expresion();
    List<Value> elements = new List<Value>();
    foreach (var exprNode in exprList)
    {
        Value elemValue = Visit(exprNode);
        elements.Add(elemValue);
    }

    bool isMultiDimensional = declaredElementType == ValueType.Slice;
    ValueType expectedElementType = declaredElementType;
    ValueType expectedNestedType = declaredNestedType;

    if (declaredElementType == ValueType.Nil && elements.Count > 0)
    {
        if (elements[0].Type == ValueType.Slice)
        {
            isMultiDimensional = true;
            Slice firstElement = elements[0].AsSlice();
            expectedElementType = ValueType.Slice;
            expectedNestedType = firstElement.NestedValueType;
        }
        else
        {
            expectedElementType = elements[0].Type;
        }
    }

    foreach (var elem in elements)
    {
        if (isMultiDimensional)
        {
            if (elem.Type != ValueType.Slice)
            {
                AddSemanticError(line, col, 
                    $"Se esperaba un slice en un slice multidimensional. Se encontró: {elem.Type}");
            }
            else
            {
                Slice innerSlice = elem.AsSlice();
                if (innerSlice.NestedValueType != expectedNestedType)
                {
                    AddSemanticError(line, col, 
                        $"Tipo interno no coincide. Esperado: {expectedNestedType}, Encontrado: {innerSlice.NestedValueType}");
                }
            }
        }
        else
        {
            if (elem.Type != expectedElementType)
            {
                AddSemanticError(line, col, 
                    $"Tipo incompatible. Esperado: {expectedElementType}, Encontrado: {elem.Type}");
            }
        }
    }

    Slice newSlice;
    try
    {
        if (isMultiDimensional)
        {
            newSlice = new Slice(ValueType.Slice, expectedNestedType);
            foreach (var elem in elements)
            {
                if (elem.Type == ValueType.Slice)
                {
                    newSlice.Append(elem);
                }
            }
        }
        else
        {
            newSlice = new Slice(expectedElementType, elements);
        }
    }
    catch (Exception ex)
    {
        AddSemanticError(line, col, ex.Message);
        return Value.FromNil();
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
        return sliceVal;
    }

    Slice s = sliceVal.AsSlice();

    for (int i = 1; i < exprs.Length; i++)
    {
        Value elem = exprs[i];
        if (elem.Type != s.ElementType)
        {
            AddSemanticError(line, col, 
                $"No se puede agregar {elem.Type} a un slice de {s.ElementType}.");
            continue; 
        }
        s.Append(elem);
    }
    
    return sliceVal; 
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

    Slice s = sliceVal.AsSlice();
    if (s.ElementType != ValueType.String)
    {
        AddSemanticError(line, col, "strings.join() se aplica solo a slice de strings.");
        return Value.FromString("");
    }

    string result = SliceOperations.Join(s, sepVal.AsString());
    return Value.FromString(result);
}

}