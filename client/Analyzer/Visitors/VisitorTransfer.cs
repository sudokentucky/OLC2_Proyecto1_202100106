using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

// Excepciones especiales para controlar el flujo
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
        Value? retValue = context.expresion() != null ? Visit(context.expresion()) : null;
        throw new ReturnException(retValue);
    }
}
