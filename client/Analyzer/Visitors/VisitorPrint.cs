using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor{

public override Value VisitPrintStmt([NotNull] PrintStmtContext context)
    {
        if (context.argumentList() == null || context.argumentList().expresion().Length == 0)
        {
            Output += "\n";
            return null;
        }
        var args = VisitArgumentList(context.argumentList());
        string outputLine = string.Join(" ", args.Select(v => v.ToString()));
        Output += outputLine + "\n";
        
        return null;
    }

}