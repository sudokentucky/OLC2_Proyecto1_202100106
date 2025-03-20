using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor{

    public override Value VisitAddExpr([NotNull] AddExprContext context)
    {
        Value leftValue = Visit(context.mulExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.mulExpr().Length; i++)
        {
            Value rightValue = Visit(context.mulExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); // + o -
            leftValue = EvaluateAddOrSub(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

    public override Value VisitMulExpr([NotNull] MulExprContext context)
    {
        Value leftValue = Visit(context.unaryExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.unaryExpr().Length; i++)
        {
            Value rightValue = Visit(context.unaryExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); 

            leftValue = EvaluateMulDivMod(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

        private Value EvaluateAddOrSub(Value left, Value right, string op, int line, int col)
    {
        if (op == "+")
        {
            if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
            {
                double sum = ToDouble(left) + ToDouble(right);
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)sum);
                }
                else
                {
                    return new Value(ValueType.Float, sum);
                }
            }
            else if (left.Type == ValueType.String && right.Type == ValueType.String)
            {
                return new Value(ValueType.String, left.AsString() + right.AsString());
            }
            else
            {
                AddSemanticError(line, col,
                    $"No se puede aplicar '+' entre {left.Type} y {right.Type}.");
                return new Value(ValueType.Int, 0);
            }
        }
        else // op == "-"
        {
            if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
            {
                double diff = ToDouble(left) - ToDouble(right);
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)diff);
                }
                else
                {
                    return new Value(ValueType.Float, diff);
                }
            }
            else
            {
                AddSemanticError(line, col,
                    $"No se puede aplicar '-' entre {left.Type} y {right.Type}.");
                return new Value(ValueType.Int, 0);
            }
        }
    }

    private Value EvaluateMulDivMod(Value left, Value right, string op, int line, int col)
    {
        if (IsNumeric(left) == 0 || IsNumeric(right) == 0)
        {
            AddSemanticError(line, col,
                $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
            return new Value(ValueType.Int, 0);
        }

        double l = ToDouble(left);
        double r = ToDouble(right);

        if ((op == "/" || op == "%") && r == 0)
        {
            AddSemanticError(line, col, "División entre cero no permitida.");
            return new Value(ValueType.Int, 0);
        }

        switch (op)
        {
            case "*":
            {
                double product = l * r;
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)product);
                }
                else
                {
                    return new Value(ValueType.Float, product);
                }
            }
            case "/":
            {
                double quotient = l / r;
                return new Value(ValueType.Float, quotient);
            }
            case "%":
            {
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    int mod = (int)l % (int)r;
                    return new Value(ValueType.Int, mod);
                }
                else
                {
                    AddSemanticError(line, col,
                        $"El operador '%' requiere int, se obtuvo {left.Type} y {right.Type}.");
                    return new Value(ValueType.Int, 0);
                }
            }
        }

        return new Value(ValueType.Int, 0);
    }



}