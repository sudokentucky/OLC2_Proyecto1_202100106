using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

[Route("[controller]")]
public class Compile : Controller
{
    private readonly ILogger<Compile> _logger;

    public Compile(ILogger<Compile> logger)
    {
        _logger = logger;
    }

    public class CompileRequest
    {
        [Required]
        public required string code { get; set; }
    }

    // POST /compile
    [HttpPost]
    public IActionResult Post([FromBody] CompileRequest request)
    {
        if (!ModelState.IsValid)
        {
            return BadRequest(new { error = "Invalid request" });
        }

        var inputStream = new AntlrInputStream(request.code);
        var lexer = new gramaticaLexer(inputStream);
        var tokens = new CommonTokenStream(lexer);
        var parser = new gramaticaParser(tokens);

        // Generamos el árbol desde la regla 'program'
        var tree = parser.program();

        // Usamos un Visitor (CompilerVisitor) para recorrer el árbol
        var visitor = new CompilerVisitor();
        visitor.Visit(tree);

        // Retornamos el output en un objeto JSON
        return Ok(new { result = visitor.Output });

        // Para usar Listener, podrías descomentar:
        // var walker = new ParseTreeWalker();
        // var lister = new CompilerListener();
        // walker.Walk(lister, tree);
        // return Ok(new { result = lister.Output });
    }
}
