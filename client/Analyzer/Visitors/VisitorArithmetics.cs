using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public override Value VisitAddExpr([NotNull] AddExprContext context)
    {
        var leftValue = Visit(context.mulExpr(0));
        var line = context.Start.Line;
        var column = context.Start.Column;

        for (int i = 1; i < context.mulExpr().Length; i++)
        {
            var rightValue = Visit(context.mulExpr(i));
            var operatorSymbol = context.GetChild((i * 2) - 1).GetText();

            leftValue = EvaluateAdditionOrSubtraction(leftValue, rightValue, operatorSymbol, line, column);
        }

        return leftValue;
    }

    public override Value VisitMulExpr([NotNull] MulExprContext context)
    {
        var leftValue = Visit(context.unaryExpr(0));
        var line = context.Start.Line;
        var column = context.Start.Column;

        for (int i = 1; i < context.unaryExpr().Length; i++)
        {
            var rightValue = Visit(context.unaryExpr(i));
            var operatorSymbol = context.GetChild((i * 2) - 1).GetText();

            leftValue = EvaluateMultiplicationDivisionOrModulo(leftValue, rightValue, operatorSymbol, line, column);
        }

        return leftValue;
    }

    private Value EvaluateAdditionOrSubtraction(Value left, Value right, string operatorSymbol, int line, int column)
    {
        if (operatorSymbol == "+")
        {
            return EvaluateAddition(left, right, line, column);
        }

        return EvaluateSubtraction(left, right, line, column);
    }

    private Value EvaluateAddition(Value left, Value right, int line, int column)
    {
        if (AreBothNumeric(left, right))
        {
            return SumNumericValues(left, right);
        }

        if (AreBothStrings(left, right))
        {
            return ConcatenateStrings(left, right);
        }

        ReportSemanticError(line, column, $"No se puede aplicar '+' entre {left.Type} y {right.Type}.");
        return DefaultIntValue();
    }

    private Value EvaluateSubtraction(Value left, Value right, int line, int column)
    {
        if (AreBothNumeric(left, right))
        {
            return SubtractNumericValues(left, right);
        }

        ReportSemanticError(line, column, $"No se puede aplicar '-' entre {left.Type} y {right.Type}.");
        return DefaultIntValue();
    }

    private Value SumNumericValues(Value left, Value right)
    {
        double result = ToDouble(left) + ToDouble(right);
        return CreateNumericValue(left, right, result);
    }

    private Value SubtractNumericValues(Value left, Value right)
    {
        double result = ToDouble(left) - ToDouble(right);
        return CreateNumericValue(left, right, result);
    }

    private Value ConcatenateStrings(Value left, Value right)
    {
        return new Value(ValueType.String, left.AsString() + right.AsString());
    }

    private bool AreBothNumeric(Value left, Value right)
    {
        return IsNumeric(left) != 0 && IsNumeric(right) != 0;
    }

    private bool AreBothStrings(Value left, Value right)
    {
        return left.Type == ValueType.String && right.Type == ValueType.String;
    }

    private Value CreateNumericValue(Value left, Value right, double result)
    {
        if (left.Type == ValueType.Int && right.Type == ValueType.Int)
        {
            return new Value(ValueType.Int, (int)result);
        }

        return new Value(ValueType.Float, result);
    }

    private void ReportSemanticError(int line, int column, string message)
    {
        AddSemanticError(line, column, message);
    }

    private Value DefaultIntValue()
    {
        return new Value(ValueType.Int, 0);
    }

    private Value EvaluateMultiplicationDivisionOrModulo(Value left, Value right, string operatorSymbol, int line, int column)
    {
        if (!AreBothNumeric(left, right))
        {
            ReportSemanticError(line, column, $"No se puede aplicar '{operatorSymbol}' entre {left.Type} y {right.Type}.");
            return DefaultIntValue();
        }

        double leftNumber = ToDouble(left);
        double rightNumber = ToDouble(right);

        if (IsDivisionByZero(operatorSymbol, rightNumber))
        {
            ReportSemanticError(line, column, "División entre cero no permitida.");
            return DefaultIntValue();
        }

        return operatorSymbol switch
        {
            "*" => MultiplyValues(left, right, leftNumber, rightNumber),
            "/" => DivideValues(leftNumber, rightNumber),
            "%" => ModuloValues(left, right, leftNumber, rightNumber, line, column),
            _ => DefaultIntValue()
        };
    }

    private bool IsDivisionByZero(string operatorSymbol, double rightNumber)
    {
        return (operatorSymbol == "/" || operatorSymbol == "%") && rightNumber == 0;
    }

    private Value MultiplyValues(Value left, Value right, double leftNumber, double rightNumber)
    {
        double product = leftNumber * rightNumber;
        return CreateNumericValue(left, right, product);
    }

    private Value DivideValues(double leftNumber, double rightNumber)
    {
        double quotient = leftNumber / rightNumber;
        return new Value(ValueType.Float, quotient);
    }

    private Value ModuloValues(Value left, Value right, double leftNumber, double rightNumber, int line, int column)
    {
        if (left.Type == ValueType.Int && right.Type == ValueType.Int)
        {
            int mod = (int)leftNumber % (int)rightNumber;
            return new Value(ValueType.Int, mod);
        }

        ReportSemanticError(line, column, $"El operador '%' requiere int, se obtuvo {left.Type} y {right.Type}.");
        return DefaultIntValue();
    }
}