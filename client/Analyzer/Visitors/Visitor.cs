using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor : gramaticaBaseVisitor<Value>
{
    public string Output { get; private set; } = "";
    private List<ErrorReportEntry> semanticErrors = new List<ErrorReportEntry>();

    private SymbolTable table;
    private Environment currentEnv;
    private StructType currentStruct;
    private string currentStructTypeName;
    


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

public override Value VisitProgram([NotNull] ProgramContext context)
{
    Console.WriteLine("=========== INICIO DE PROGRAMA ===========");
    
    // Depuración de estructuras
    int structCount = context.structDecl()?.Length ?? 0;
    Console.WriteLine($"DEBUG: Procesando {structCount} definiciones de estructuras");
    
    foreach (var structDecl in context.structDecl())
    {
        string structName = structDecl.IDENTIFIER()?.GetText() ?? "anónima";
        Console.WriteLine($"DEBUG: Procesando estructura '{structName}' en línea {structDecl.Start.Line}");
        try {
            Visit(structDecl);
            Console.WriteLine($"DEBUG: Estructura '{structName}' procesada exitosamente");
        }
        catch (Exception ex) {
            Console.WriteLine($"ERROR: Fallo al procesar estructura '{structName}': {ex.Message}");
            AddSemanticError(structDecl.Start.Line, structDecl.Start.Column, 
                            $"Error al procesar estructura: {ex.Message}");
        }
    }
    
    // Depuración de funciones
    int funcCount = context.funcDecl()?.Length ?? 0;
    Console.WriteLine($"DEBUG: Procesando {funcCount} definiciones de funciones");
    
    foreach (var funcDecl in context.funcDecl())
    {
        string funcName = funcDecl.IDENTIFIER()?.GetText() ?? "anónima";
        Console.WriteLine($"DEBUG: Procesando función '{funcName}' en línea {funcDecl.Start.Line}");
        try {
            Visit(funcDecl);
            Console.WriteLine($"DEBUG: Función '{funcName}' procesada exitosamente");
        }
        catch (Exception ex) {
            Console.WriteLine($"ERROR: Fallo al procesar función '{funcName}': {ex.Message}");
            AddSemanticError(funcDecl.Start.Line, funcDecl.Start.Column, 
                           $"Error al procesar función: {ex.Message}");
        }
    }
    
    // Depuración de instrucciones
    int instrCount = context.instruction()?.Length ?? 0;
    Console.WriteLine($"DEBUG: Procesando {instrCount} instrucciones de nivel global");
    
    int instrIndex = 0;
    foreach (var instr in context.instruction())
    {
        instrIndex++;
        Console.WriteLine($"DEBUG: Ejecutando instrucción #{instrIndex} en línea {instr.Start.Line}");
        try {
            Value result = Visit(instr);
            Console.WriteLine($"DEBUG: Instrucción #{instrIndex} completada. Resultado = {(result?.Type ?? ValueType.Nil)}");
        }
        catch (Exception ex) {
            Console.WriteLine($"ERROR: Fallo al ejecutar instrucción #{instrIndex}: {ex.Message}");
            AddSemanticError(instr.Start.Line, instr.Start.Column, 
                           $"Error al ejecutar instrucción: {ex.Message}");
        }
    }
    
    // Resumen
    Console.WriteLine("=========== RESUMEN DE EJECUCIÓN ===========");
    Console.WriteLine($"Estructuras procesadas: {structCount}");
    Console.WriteLine($"Funciones procesadas: {funcCount}");
    Console.WriteLine($"Instrucciones ejecutadas: {instrCount}");
    Console.WriteLine($"Errores semánticos: {semanticErrors.Count}");
    Console.WriteLine("=========== FIN DE PROGRAMA ===========");
                
    return Value.FromNil();
}

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