using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // expr : logicalOrExpr ;
    public override Value VisitExpresion([NotNull] ExpresionContext context)
    {
        return Visit(context.logicalOrExpr());
    }

   public override Value VisitUnaryExpr([NotNull] UnaryExprContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    if (context.MINUS() != null)
    {
        Value exprValue = Visit(context.unaryExpr());

        if (IsNumeric(exprValue) == 0)
        {
            string errorMsg = $"No se puede aplicar operador unario '-' a tipo {exprValue.Type}.";
            AddSemanticError(line, column, errorMsg);
            return new Value(ValueType.Int, 0);
        }

        double val = ToDouble(exprValue);

        if (exprValue.Type == ValueType.Float)
            return new Value(ValueType.Float, -val);

        return new Value(ValueType.Int, (int)(-val));
    }
    else if (context.NOT() != null)
    {
        Value exprValue = Visit(context.unaryExpr());

        if (exprValue.Type != ValueType.Bool)
        {
            string errorMsg = $"No se puede aplicar operador '!' a tipo {exprValue.Type}.";
            AddSemanticError(line, column, errorMsg);
            return new Value(ValueType.Bool, false);
        }

        return new Value(ValueType.Bool, !exprValue.AsBool());
    }
    else if (context.primary() != null)
    {
        return Visit(context.primary());
    }
    else if (context.sliceFunc() != null)
    {
        return Visit(context.sliceFunc());
    }
    else if (context.conversionFunc() != null)
    {
        return Visit(context.conversionFunc());
    }

    AddSemanticError(line, column, "Expresión unaria desconocida.");
    return Value.FromNil();
}


public override Value VisitPrimary([NotNull] PrimaryContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    if (context.functCall() != null)
    {
        return Visit(context.functCall());
    }
    if (context.NIL() != null)
    {
        return Value.FromNil();
    }
    if (context.INT_LIT() != null)
    {
        string valueText = context.INT_LIT().GetText();
        return ParseIntLiteral(valueText, line, column);
    }

    if (context.FLOAT_LIT() != null)
    {
        string valueText = context.FLOAT_LIT().GetText();
        return ParseFloatLiteral(valueText, line, column);
    }

    if (context.STRING_LIT() != null)
    {
        string valueText = context.STRING_LIT().GetText();
        return ParseStringLiteral(valueText, line, column);
    }

    if (context.RUNE_LIT() != null)
    {
        string valueText = context.RUNE_LIT().GetText();
        return ParseRuneLiteral(valueText, line, column);
    }

    if (context.sliceLiteral() != null)
    {
        return Visit(context.sliceLiteral());
    }


    if (context.IDENTIFIER() != null && context.IDENTIFIER().Length > 0)
    {
        return EvaluateIdentifier(context, line, column);
    }

    if (context.expresion() != null && context.expresion().Length > 0)
    {
        return Visit(context.expresion(0));
    }

    AddSemanticError(line, column, "Expresión primaria desconocida.");
    return new Value(ValueType.Int, 0);
}


public override Value VisitTypeSpec([NotNull] gramaticaParser.TypeSpecContext context)
{

    if (context.INT_TYPE() != null)
    {
        return Value.FromInt(0); 
    }
    else if (context.FLOAT64_TYPE() != null)
    {
        return Value.FromFloat(0.0);
    }
    else if (context.STRING_TYPE() != null)
    {
        return Value.FromString("");
    }
    else if (context.BOOL_TYPE() != null)
    {
        return Value.FromBool(false);
    }
    else if (context.RUNE_TYPE() != null)
    {
        return Value.FromRune('\0');
    }
    else if (context.sliceType() != null)
    {
        return Visit(context.sliceType());
    }
    else
    {
        AddSemanticError(context.Start.Line, context.Start.Column, 
                         "Tipo desconocido en typeSpec.");
        return Value.FromNil();
    }
}

    private Value EvaluateEquality(Value left, Value right, string op, int line, int col)
{
    if (left.Type == ValueType.Nil && right.Type == ValueType.Nil)
    {
        bool result = (op == "=="); 
        return Value.FromBool(result);
    }
    
    if (left.Type == ValueType.Nil || right.Type == ValueType.Nil)
    {
        bool result = (op == "!=");
        return Value.FromBool(result);
    }
    
    if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
    {
        double l = ToDouble(left);
        double r = ToDouble(right);
        bool result = (op == "==") ? (l == r) : (l != r);
        return new Value(ValueType.Bool, result);
    }
    else if (left.Type == ValueType.Bool && right.Type == ValueType.Bool)
    {
        bool result = (op == "==")
            ? (left.AsBool() == right.AsBool())
            : (left.AsBool() != right.AsBool());
        return new Value(ValueType.Bool, result);
    }
    else if (left.Type == ValueType.String && right.Type == ValueType.String)
    {
        bool result = (op == "==")
            ? (left.AsString() == right.AsString())
            : (left.AsString() != right.AsString());
        return new Value(ValueType.Bool, result);
    }
    else if (left.Type == ValueType.Struct && right.Type == ValueType.Struct)
    {
        bool result = (op == "==") 
            ? (left.AsStruct() == right.AsStruct())
            : (left.AsStruct() != right.AsStruct());
        return Value.FromBool(result);
    }
    else
    {
        AddSemanticError(line, col,
            $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
        return new Value(ValueType.Bool, false);
    }
}

    private Value EvaluateRelational(Value left, Value right, string op, int line, int col)
    {
        if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
        {
            double l = ToDouble(left);
            double r = ToDouble(right);

            bool result = false;
            switch (op)
            {
                case ">":  result = l > r;  break;
                case "<":  result = l < r;  break;
                case ">=": result = l >= r; break;
                case "<=": result = l <= r; break;
            }
            return new Value(ValueType.Bool, result);
        }
        else
        {
            AddSemanticError(line, col,
                $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
            return new Value(ValueType.Bool, false);
        }
    }


}
