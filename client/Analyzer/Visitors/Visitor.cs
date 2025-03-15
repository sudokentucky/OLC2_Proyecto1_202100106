using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor : gramaticaBaseVisitor<Value>
{
    public string Output { get; private set; } = "";
    private List<ErrorReportEntry> semanticErrors = new List<ErrorReportEntry>();

    // Tabla de símbolos global
    private SymbolTable table;
    private Environment currentEnv;
    private int loopDepth = 0;        
    private int switchDepth = 0;  

    public Visitor()
    {
        table = new SymbolTable();
        currentEnv = new Environment(table, null);
    }

    public SymbolTable GetSymbolTable() => table;
    public IReadOnlyList<ErrorReportEntry> GetSemanticErrors() => semanticErrors.AsReadOnly();
    private bool IsInsideLoop()
    {
        return loopDepth > 0;
    }

    private bool IsInsideLoopOrSwitch()
    {
        return loopDepth > 0 || switchDepth > 0;
    }
    // VisitProgram
    public override Value VisitProgram([NotNull] ProgramContext context)
    {
        foreach (var instr in context.instruction())
        {
            Visit(instr);
        }
        return null;
    }

    // Métodos auxiliares
    internal void AddSemanticError(int line, int col, string msg)
    {
        semanticErrors.Add(new ErrorReportEntry
        {
            Type = "semántico",
            Line = line,
            Column = col,
            Description = msg
        });
    }

    internal double ToDouble(Value val)
    {
        if (val.Type == ValueType.Int) return val.AsInt();
        if (val.Type == ValueType.Float) return val.AsFloat();
        return 0.0;
    }
    internal int IsNumeric(Value val)
    {
        if (val.Type == ValueType.Int) return 1;
        if (val.Type == ValueType.Float) return 2;
        return 0;
    }
    internal string ValueToString(Value val)
    {
        if (val == null) return "null";
        return val.Type switch
        {
            ValueType.Int => val.AsInt().ToString(),
            ValueType.Float => val.AsFloat().ToString(),
            ValueType.String => val.AsString(),
            ValueType.Bool => val.AsBool() ? "true" : "false",
            _ => val.Data?.ToString() ?? "null",
        };
    }
}