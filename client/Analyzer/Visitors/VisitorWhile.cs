using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor{
    public override Value VisitForWhileStmt([NotNull] ForWhileStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        loopDepth++;

        try
        {
            while (true)
            {
                Value condition = Visit(context.expresion());

                if (condition.Type != ValueType.Bool)
                {
                    AddSemanticError(line, column,
                        $"La condición del bucle for debe ser booleana, se obtuvo {condition.Type}.");
                    break;
                }

                if (!condition.AsBool())
                    break;

                try
                {
                    Visit(context.bloque());
                }
                catch (ContinueException)
                {
                    continue;
                }
            }
        }
        catch (BreakException)
        {
        }
        finally
        {
            loopDepth--;
        }

        return null!;
    }
}