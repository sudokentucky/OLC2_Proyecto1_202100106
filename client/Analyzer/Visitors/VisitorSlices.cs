using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;
public partial class Visitor{

    public override Value VisitSliceType([NotNull] gramaticaParser.SliceTypeContext context)
{
    Value baseTypeVal = Visit(context.typeSpec());
    ValueType baseVT = baseTypeVal.Type; 
    Slice sliceTypeHolder = new Slice(baseVT);
    return new Value(ValueType.Slice, sliceTypeHolder);
}
public override Value VisitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context)
{

    int line = context.Start.Line;
    int col  = context.Start.Column;

    Value sliceTypeValue = null;
    if (context.typeSpec() != null)
    {
        sliceTypeValue = Visit(context.typeSpec());
    }

    var exprList = context.expresion();
    List<Value> elements = new List<Value>();

    foreach (var exprNode in exprList)
    {
        Value elemValue = Visit(exprNode);
        elements.Add(elemValue);
    }

    ValueType finalElemType = ValueType.Nil;

    if (sliceTypeValue != null && sliceTypeValue.Type != ValueType.Nil)
    {
        finalElemType = sliceTypeValue.Type == ValueType.Slice
            ? (sliceTypeValue.Data as Slice)?.ElementType ?? ValueType.Nil
            : sliceTypeValue.Type;
    }
    else
    {
        if (elements.Count > 0)
        {
            finalElemType = elements[0].Type;
        }
        else
        {

            finalElemType = ValueType.Nil;
        }
    }

    foreach (var elem in elements)
    {
        if (elem.Type != finalElemType && finalElemType != ValueType.Nil)
        {
            AddSemanticError(line, col,
                $"Todos los elementos en el slice deben ser del mismo tipo. Se esperaba {finalElemType}, se encontró {elem.Type}.");
        }
    }

    Slice newSlice = null;
    try
    {
        newSlice = new Slice(finalElemType, elements);
    }
    catch (Exception ex)
    {
        AddSemanticError(line, col, ex.Message);
        return Value.FromNil();
    }

    // 6) Retornar un Value que contenga el slice
    return Value.FromSlice(newSlice);
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
        // 3) slices.Index(expr, expr)
        Value sliceVal = Visit(context.expresion(0));
        Value searchVal = Visit(context.expresion(1));
        return EvaluateSlicesIndex(sliceVal, searchVal, line, column);
    }
    else if (context.STRINGS() != null && context.JOIN() != null)
    {
        // 4) strings.join(expr, expr)
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