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
        // Obtenemos las entradas de la tabla y las retornamos
        var entries = lastSymbolTable.GetAllEntries();
        return Ok(entries);
    }
}
