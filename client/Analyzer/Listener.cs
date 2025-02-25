using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using System;
using System.Collections.Generic;

public class CompilerListener : gramaticaBaseListener
{
    private Environment currentEnvironment = new Environment();

    private Dictionary<ParserRuleContext, Value> nodeValues 
        = new Dictionary<ParserRuleContext, Value>();

    public string Output { get; private set; } = "";

    public override void ExitProgram(gramaticaParser.ProgramContext context)
    {
    }

    public override void ExitVarDcl(gramaticaParser.VarDclContext context)
    {
        string id = context.IDENTIFIER().GetText();
        Value exprValue = nodeValues[context.expr()];
        currentEnvironment.SetVariable(id, exprValue);
    }

    public override void ExitExprStmt(gramaticaParser.ExprStmtContext context)
    {
    }

    public override void ExitFmtPrintStmt(gramaticaParser.FmtPrintStmtContext context)
    {
        var argListCtx = context.argumentList();
        if (argListCtx != null)
        {
            var exprs = argListCtx.expr();
            string line = "";
            for (int i = 0; i < exprs.Length; i++)
            {
                Value argVal = nodeValues[exprs[i]];  
                if (i > 0) line += " ";
                line += ValueToString(argVal);
            }
            Output += line + "\n";
        }
        else
        {
            Output += "\n";
        }
    }

    public override void ExitNegate(gramaticaParser.NegateContext context)
    {
        Value val = nodeValues[context.expr()];
        if (val.Type == ValueType.Int)
        {
            nodeValues[context] = Value.FromInt(-val.AsInt());
        }
        else if (val.Type == ValueType.Float)
        {
            nodeValues[context] = Value.FromFloat(-val.AsFloat());
        }
        else
        {
            throw new Exception($"No se puede negar el tipo {val.Type}");
        }
    }

    // ---------- Number ----------
    public override void ExitNumber(gramaticaParser.NumberContext context)
    {
        // parseamos un entero (ej: "123")
        string text = context.INT_LIT().GetText();
        int number = int.Parse(text);
        nodeValues[context] = Value.FromInt(number);
    }

    // ---------- Identifier ----------
    public override void ExitIdentifier(gramaticaParser.IdentifierContext context)
    {
        string id = context.IDENTIFIER().GetText();
        Value val = currentEnvironment.GetVariable(id);
        nodeValues[context] = val;
    }

    // ---------- Parens ----------
    public override void ExitParens(gramaticaParser.ParensContext context)
    {
        nodeValues[context] = nodeValues[context.expr()];
    }

    // ---------- MulDiv ----------
    public override void ExitMulDiv(gramaticaParser.MulDivContext context)
    {
        Value leftVal = nodeValues[context.expr(0)];
        Value rightVal = nodeValues[context.expr(1)];

        string op = context.GetChild(1).GetText(); 

        bool isFloat = (leftVal.Type == ValueType.Float || rightVal.Type == ValueType.Float);

        double L = ToDouble(leftVal);
        double R = ToDouble(rightVal);

        if (op == "*")
        {
            double result = L * R;
            nodeValues[context] = isFloat
                ? Value.FromFloat(result)
                : Value.FromInt((int)result);
        }
        else // "/"
        {
            if (R == 0)
                throw new Exception("División por cero");
            double result = L / R;
            nodeValues[context] = isFloat
                ? Value.FromFloat(result)
                : Value.FromInt((int)result);
        }
    }

    // ---------- AddSub ----------
    public override void ExitAddSub(gramaticaParser.AddSubContext context)
    {
        Value leftVal = nodeValues[context.expr(0)];
        Value rightVal = nodeValues[context.expr(1)];
        string op = context.GetChild(1).GetText(); // "+" o "-"

        bool isFloat = (leftVal.Type == ValueType.Float || rightVal.Type == ValueType.Float);

        double L = ToDouble(leftVal);
        double R = ToDouble(rightVal);
        double result = (op == "+") ? (L + R) : (L - R);

        nodeValues[context] = isFloat
            ? Value.FromFloat(result)
            : Value.FromInt((int)result);
    }


    private string ValueToString(Value val)
    {
        if (val.Type == ValueType.Int)    return val.AsInt().ToString();
        if (val.Type == ValueType.Float)  return val.AsFloat().ToString();
        if (val.Type == ValueType.String) return val.AsString();
        // etc.
        return "UnsupportedType";
    }

    private double ToDouble(Value val)
    {
        if (val.Type == ValueType.Int)   return (double)val.AsInt();
        if (val.Type == ValueType.Float) return val.AsFloat();
        throw new Exception($"No es numérico el tipo {val.Type}");
    }
}
