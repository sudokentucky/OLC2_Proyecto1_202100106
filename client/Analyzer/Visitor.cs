using System;
using Antlr4.Runtime.Misc; // Para [NotNull] si lo usas
using static gramaticaParser; // A veces útil para abreviar nombres
// O simplemente referir gramaticaParser.xxxContext en cada override

public class CompilerVisitor : gramaticaBaseVisitor<Value>
{
    public string Output { get; private set; } = "";

    private Environment currentEnv = new Environment();

    public override Value VisitProgram([NotNull] gramaticaParser.ProgramContext context)
    {
        // Recorremos todas las declaraciones dcl
        foreach (var d in context.dcl())
        {
            Visit(d);
        }
        // El "program" no produce un valor en sí
        return null;
    }

    public override Value VisitVarDcl([NotNull] gramaticaParser.VarDclContext context)
    {
        string varName = context.IDENTIFIER().GetText();
        // Obtenemos el Value de la expr
        Value exprValue = Visit(context.expr());

        // Declaramos la variable en el environment
        currentEnv.DeclareVariable(varName, exprValue);

        return null; // no produce un valor
    }

    public override Value VisitExprStmt([NotNull] gramaticaParser.ExprStmtContext context)
    {
        Value val = Visit(context.expr());
        return val;
    }

    public override Value VisitFmtPrintStmt([NotNull] gramaticaParser.FmtPrintStmtContext context)
    {
        Value[] args = Array.Empty<Value>();
        if (context.argumentList() != null)
        {
            args = VisitArugument(context.argumentList());
        }
        
        string line = "";
        for (int i = 0; i < args.Length; i++)
        {
            if (i > 0) line += " ";
            line += ValueToString(args[i]);
        }
        // Guardamos en 'Output'
        Output += line + "\n";

        return null;
    }

    private string ValueToString(Value val)
    {
        if (val == null) return "null";
        switch(val.Type)
        {
            case ValueType.Int:    return val.AsInt().ToString();
            case ValueType.Float:  return val.AsFloat().ToString();
            case ValueType.String: return val.AsString();
            case ValueType.Bool:   return val.AsBool() ? "true" : "false";
            default: return val.Data?.ToString() ?? "null";
        }
    }

    private Value[] VisitArugument(gramaticaParser.ArgumentListContext ctx)
    {
        var exprs = ctx.expr();
        Value[] results = new Value[exprs.Length];
        for(int i=0; i<exprs.Length; i++)
        {
            results[i] = Visit(exprs[i]);
        }
        return results;
    }

    public override Value VisitNegate([NotNull] gramaticaParser.NegateContext context)
    {
        // - expr
        Value val = Visit(context.expr());
        if (val.Type == ValueType.Int)
        {
            return Value.FromInt(-val.AsInt());
        }
        else if (val.Type == ValueType.Float)
        {
            return Value.FromFloat(-val.AsFloat());
        }
        else
        {
            throw new Exception($"No se puede negar el tipo {val.Type}");
        }
    }

    public override Value VisitNumber([NotNull] gramaticaParser.NumberContext context)
    {
        // parsea entero. Si deseas float, revisa si hay '.' o cambia la gramática
        string text = context.INT_LIT().GetText();
        int val = int.Parse(text);
        return Value.FromInt(val);
    }

    // Identifier
    public override Value VisitIdentifier([NotNull] gramaticaParser.IdentifierContext context)
    {
        string name = context.IDENTIFIER().GetText();
        // Buscamos la variable en el environment
        return currentEnv.GetVariable(name);
    }

    // Parens ( '(' expr ')' )
    public override Value VisitParens([NotNull] gramaticaParser.ParensContext context)
    {
        return Visit(context.expr());
    }

    // MulDiv (expr '*' expr) o (expr '/' expr)
    public override Value VisitMulDiv([NotNull] gramaticaParser.MulDivContext context)
    {
        Value left = Visit(context.expr(0));
        Value right = Visit(context.expr(1));

        string op = context.GetChild(1).GetText(); 

        bool isFloat = (left.Type == ValueType.Float) || (right.Type == ValueType.Float);

        double l = ConvertToDouble(left);
        double r = ConvertToDouble(right);

        if (op == "*")
        {
            double result = l * r;
            return isFloat ? Value.FromFloat(result)
                           : Value.FromInt((int)result);
        }
        else // "/"
        {
            if (r == 0) 
                throw new Exception("División por cero");
            double result = l / r;
            return isFloat ? Value.FromFloat(result)
                           : Value.FromInt((int)result);
        }
    }

    // AddSub (expr '+' expr) o (expr '-' expr)
    public override Value VisitAddSub([NotNull] gramaticaParser.AddSubContext context)
    {
        Value left = Visit(context.expr(0));
        Value right = Visit(context.expr(1));

        string op = context.GetChild(1).GetText(); 

        bool isFloat = (left.Type == ValueType.Float) || (right.Type == ValueType.Float);
        double l = ConvertToDouble(left);
        double r = ConvertToDouble(right);

        double result = (op == "+") ? (l + r) : (l - r);
        return isFloat ? Value.FromFloat(result)
                       : Value.FromInt((int)result);
    }

    private double ConvertToDouble(Value val)
    {
        if (val.Type == ValueType.Int)
        {
            return (double)val.AsInt();
        }
        else if (val.Type == ValueType.Float)
        {
            return val.AsFloat();
        }
        else
        {
            throw new Exception($"No es numérico el tipo {val.Type}");
        }
    }
}
