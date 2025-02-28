using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // expr : logicalOrExpr ;
    public override Value VisitExpr([NotNull] ExprContext context)
    {
        return Visit(context.logicalOrExpr());
    }

    // logicalOrExpr : logicalAndExpr (OR_LOGIC logicalAndExpr)* ;
    public override Value VisitLogicalOrExpr([NotNull] LogicalOrExprContext context)
    {
        Value leftValue = Visit(context.logicalAndExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.logicalAndExpr().Length; i++)
        {
            Value rightValue = Visit(context.logicalAndExpr(i));
            if (leftValue.Type != ValueType.Bool || rightValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"Operador '||' requiere booleanos, se obtuvo {leftValue.Type} y {rightValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            bool result = leftValue.AsBool() || rightValue.AsBool();
            leftValue = new Value(ValueType.Bool, result);
        }

        return leftValue;
    }

    // logicalAndExpr : equalityExpr (AND_LOGIC equalityExpr)* ;
    public override Value VisitLogicalAndExpr([NotNull] LogicalAndExprContext context)
    {
        Value leftValue = Visit(context.equalityExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.equalityExpr().Length; i++)
        {
            Value rightValue = Visit(context.equalityExpr(i));
            if (leftValue.Type != ValueType.Bool || rightValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"Operador '&&' requiere booleanos, se obtuvo {leftValue.Type} y {rightValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            bool result = leftValue.AsBool() && rightValue.AsBool();
            leftValue = new Value(ValueType.Bool, result);
        }

        return leftValue;
    }

    // equalityExpr : relationalExpr ( (EQUAL | NOT_EQUAL) relationalExpr )* ;
    public override Value VisitEqualityExpr([NotNull] EqualityExprContext context)
    {
        Value leftValue = Visit(context.relationalExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.relationalExpr().Length; i++)
        {
            Value rightValue = Visit(context.relationalExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText();

            leftValue = EvaluateEquality(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

    public override Value VisitRelationalExpr([NotNull] RelationalExprContext context)
    {
        Value leftValue = Visit(context.addExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.addExpr().Length; i++)
        {
            Value rightValue = Visit(context.addExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); // >, <, >=, <=

            leftValue = EvaluateRelational(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

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
            string op = context.GetChild((i * 2) - 1).GetText(); // *, /, %

            leftValue = EvaluateMulDivMod(leftValue, rightValue, op, line, column);
        }

        return leftValue;
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
                AddSemanticError(line, column,
                    $"No se puede aplicar operador unario '-' a tipo {exprValue.Type}.");
                return new Value(ValueType.Int, 0);
            }
            double val = ToDouble(exprValue);
            if (exprValue.Type == ValueType.Float)
                return new Value(ValueType.Float, -val);
            else
                return new Value(ValueType.Int, (int)(-val));
        }
        else if (context.NOT_LOGIC() != null)
        {
            Value exprValue = Visit(context.unaryExpr());
            if (exprValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"No se puede aplicar operador '!' a tipo {exprValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            return new Value(ValueType.Bool, !exprValue.AsBool());
        }
        else
        {
            return Visit(context.primary());
        }
    }
public override Value VisitPrimary([NotNull] PrimaryContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    if (context.INT_LIT() != null)
    {
        string text = context.INT_LIT().GetText();
        if (int.TryParse(text, out int n))
        {
            return new Value(ValueType.Int, n);
        }
        AddSemanticError(line, column, $"Literal entero inválido: {text}.");
        return new Value(ValueType.Int, 0);
    }
    else if (context.IDENTIFIER() != null)
    {
        string varName = context.IDENTIFIER().GetText();
        if (varName == "true")
        {
            return new Value(ValueType.Bool, true);
        }
        else if (varName == "false")
        {
            return new Value(ValueType.Bool, false);
        }
        try
        {
            return currentEnv.GetVariable(varName);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return new Value(ValueType.Int, 0);
        }
    }
    else if (context.expr() != null)
    {
        return Visit(context.expr());
    }

    return new Value(ValueType.Int, 0);
}

    private Value EvaluateEquality(Value left, Value right, string op, int line, int col)
    {
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
