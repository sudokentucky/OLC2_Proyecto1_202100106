using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public class BreakException : Exception { }
public class ContinueException : Exception { }
public class ReturnException : Exception
{
    public Value? ReturnValue { get; }
    public ReturnException(Value? returnValue)
    {
        ReturnValue = returnValue;
    }
}

public partial class Visitor
{
    public override Value VisitBreakStmt([NotNull] BreakStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (!IsInsideLoopOrSwitch())
        {
            AddSemanticError(line, column, "La sentencia 'break' solo puede usarse dentro de un bucle 'for' o una sentencia 'switch'.");
            return null;
        }

        throw new BreakException();
    }

    public override Value VisitContinueStmt([NotNull] ContinueStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (!IsInsideLoop())
        {
            AddSemanticError(line, column, "La sentencia 'continue' solo puede usarse dentro de un bucle 'for'.");
            return null;
        }

        throw new ContinueException();
    }

    public override Value VisitReturnStmt([NotNull] ReturnStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (context.expresion() == null)
        {
            throw new ReturnException(Value.FromNil());
        }

        Value returnValue = Visit(context.expresion());
        if (returnValue == null)
        {
            AddSemanticError(line, column, "La expresión de retorno es nula.");
            returnValue = Value.FromNil();
        }

        throw new ReturnException(returnValue);
    }
}
