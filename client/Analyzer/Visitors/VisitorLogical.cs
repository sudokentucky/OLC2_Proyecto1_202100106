using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor{

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
            string op = context.GetChild((i * 2) - 1).GetText(); 

            leftValue = EvaluateRelational(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }
}