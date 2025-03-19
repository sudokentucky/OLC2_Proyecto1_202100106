using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

[Route("[controller]")]
public class Compile : Controller
{
    private readonly ILogger<Compile> _logger;

    // Almacenamos estáticamente los últimos errores y la última tabla de símbolos
    private static List<ErrorReportEntry> lastErrors = new List<ErrorReportEntry>();
    private static SymbolTable lastSymbolTable = new SymbolTable();

    public Compile(ILogger<Compile> logger)
    {
        _logger = logger;
    }

    public class CompileRequest
    {
        [Required]
        public required string code { get; set; }
    }

    [HttpPost]
    public IActionResult Post([FromBody] CompileRequest request)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(new { error = "Invalid request" });
        }

        lastErrors.Clear();
        lastSymbolTable = new SymbolTable();

        var inputStream = new AntlrInputStream(request.code);

        // 2. Crear lexer y parser
        var lexer = new gramaticaLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new gramaticaParser(tokens);
        var errorListener = new ErrorListener();
        lexer.RemoveErrorListeners();
        parser.RemoveErrorListeners();
        lexer.AddErrorListener(errorListener);
        parser.AddErrorListener(errorListener);

        var tree = parser.program();
        var parseErrors = errorListener.GetErrors();

        var visitor = new Visitor();
        visitor.Visit(tree);

        lastErrors.AddRange(parseErrors);
        lastSymbolTable = visitor.GetSymbolTable();

        return Ok(new { result = visitor.Output });
    }


    [HttpGet("errors")]
    public IActionResult GetErrors()
    {
        // Retornamos la lista de errores en JSON
        return Ok(lastErrors);
    }

    [HttpGet("symbols")]
public IActionResult GetSymbols()
{
    var entries = lastSymbolTable.GetAllEntries();
    
    // Transformar las entradas para una mejor serialización JSON
    var formattedEntries = entries.Select(e => new {
        ID = e.ID,
        Type = e.SymbolType,
        DataType = e.DataType,
        Scope = e.Scope,
        Value = FormatSymbolValue(e),
        Line = e.Line,
        Column = e.Column
    });
    
    return Ok(formattedEntries);
}

// Método auxiliar para formatear los valores de los símbolos
private string FormatSymbolValue(SymbolTableEntry entry)
{
    if (entry.Value == null)
        return "nil";
        
    return entry.Value switch
    {
        StructType st => $"Struct({st.Name}) con campos: {string.Join(", ", st.Fields.Keys)}",
        StructInstance si => $"Instancia de {si.StructName}",
        Function fn => FormatFunction(fn),
        _ => entry.Value.ToString()
    };
}

private string FormatFunction(Function fn)
{
    if (fn == null)
        throw new ArgumentNullException(nameof(fn));

    // Verifica que Parameters no sea nulo, y en caso de que alguna propiedad de p pueda ser nula.
    string paramStr = string.Join(", ", fn.Parameters?.Select(p => $"{p.Name ?? "null"} {p.Type}") 
                                        ?? Enumerable.Empty<string>());
    // Verifica también fn.ReturnType, agregando una verificación nula
    string returnStr = (fn.ReturnType == null || fn.ReturnType == ValueType.Nil) ? "void" : (fn.ReturnType.ToString() ?? "void");
    
    string result = $"func {fn.Name ?? "unnamed"}({paramStr}) -> {returnStr}";
    return result;
}
}
