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
        return BadRequest(new { error = "Solicitud inválida." });
    }

    lastErrors.Clear();
    lastSymbolTable = new SymbolTable();

    try
    {
        var inputStream = new AntlrInputStream(request.code);

        // Lexer y parser
        var lexer = new gramaticaLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new gramaticaParser(tokens);

        var errorListener = new ErrorListener();
        lexer.RemoveErrorListeners();
        parser.RemoveErrorListeners();
        lexer.AddErrorListener(errorListener);
        parser.AddErrorListener(errorListener);

        // 1. Parsear el programa
        var tree = parser.program();

        // 2. Capturar errores de sintaxis
        var parseErrors = errorListener.GetErrors();

        // 3. Crear y ejecutar el visitor
        var visitor = new Visitor();
        visitor.Visit(tree);

        // 4. Capturar errores semánticos desde el visitor
        var semanticErrors = visitor.GetSemanticErrors();

        lastErrors.AddRange(parseErrors);
        lastErrors.AddRange(semanticErrors);

        if (lastErrors.Count > 0)
        {
            _logger.LogWarning("Errores encontrados durante la compilación.");

            var firstError = lastErrors[0];

            var firstErrorMessage = $"Línea {firstError.Line}, Columna {firstError.Column}: " +
                                    $"{firstError.Description ?? firstError.Description}";

            return BadRequest(new
            {
                error = "Errores encontrados durante la compilación.",
                firstError = firstErrorMessage,
                errors = lastErrors.Select(e =>
                    $"Línea {e.Line}, Columna {e.Column}: {e.Description ?? e.Description}").ToList()
            });
        }

        lastSymbolTable = visitor.GetSymbolTable();

        return Ok(new
        {
            result = visitor.Output ?? "Compilación completada sin errores.",
            symbolCount = lastSymbolTable.GetAllEntries().Count
        });
    }
    catch (Exception ex)
    {
        _logger.LogError(ex, "Error inesperado durante la compilación.");

        // Error inesperado en el servidor
        return StatusCode(500, new
        {
            error = "Error interno en el compilador.",
            details = ex.Message
        });
    }
}


    [HttpGet("errors")]
    public IActionResult GetErrors()
    {
        return Ok(lastErrors);
    }

    [HttpGet("symbols")]
public IActionResult GetSymbols()
{
    var entries = lastSymbolTable.GetAllEntries();
    
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

    string paramStr = string.Join(", ", fn.Parameters?.Select(p => $"{p.Name ?? "null"} {p.Type}") 
                                        ?? Enumerable.Empty<string>());
    string returnStr = (fn.ReturnType == null || fn.ReturnType == ValueType.Nil) ? "void" : (fn.ReturnType.ToString() ?? "void");
    
    string result = $"func {fn.Name ?? "unnamed"}({paramStr}) -> {returnStr}";
    return result;
}
/*
[HttpGet("generateDot")]
public IActionResult GenerateDot()
{
    try
    {
        var inputStream = new AntlrInputStream("your code here... o pásalo de algún lado");
        var lexer = new gramaticaLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new gramaticaParser(tokens);

        var tree = parser.program();

        var astBuilder = new AstBuilderVisitor();
        var rootNode = astBuilder.Visit(tree);

        var dotGenerator = new DotGenerator();
        var dotCode = dotGenerator.GenerateDot(rootNode);

        return Content(dotCode, "text/plain");
    }
    catch (Exception ex)
    {
        return StatusCode(500, $"Error generando el DOT: {ex.Message}");
    }
}
*/
}

