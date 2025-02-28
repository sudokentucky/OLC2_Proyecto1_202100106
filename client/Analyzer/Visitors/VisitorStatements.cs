using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // Visitar declaración de variables: var IDENTIFIER = expr;
    public override Value VisitVarDcl([NotNull] VarDclContext context)
    {
        string varName = context.IDENTIFIER().GetText();
        Value exprValue = Visit(context.expr());

        int line = context.Start.Line;
        int column = context.Start.Column;

        try
        {
            // Registrar la variable en el entorno
            currentEnv.DeclareVariable(
                name: varName,
                value: exprValue,
                line: line,
                column: column,
                scopeName: "Global"
            );
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
        }

        return null;
    }

    // Visitar una sentencia de expresión (expr;)
    public override Value VisitExprStmt([NotNull] ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    // Visitar una llamada a fmt.Println(argumentList?);
    public override Value VisitFmtPrintStmt([NotNull] FmtPrintStmtContext context)
    {
        Value[] args = Array.Empty<Value>();

        if (context.argumentList() != null)
        {
            args = VisitArgumentList(context.argumentList());
        }

        string line = "";
        for (int i = 0; i < args.Length; i++)
        {
            if (i > 0) line += " ";
            line += ValueToString(args[i]);
        }
        
        Output += line + "\n";

        return null;
    }

    // Visitar la lista de argumentos en fmt.Println(x, y, z);
    private new Value[] VisitArgumentList(ArgumentListContext ctx)
    {
        var exprs = ctx.expr();
        Value[] results = new Value[exprs.Length];

        for (int i = 0; i < exprs.Length; i++)
        {
            results[i] = Visit(exprs[i]);
        }

        return results;
    }
}
