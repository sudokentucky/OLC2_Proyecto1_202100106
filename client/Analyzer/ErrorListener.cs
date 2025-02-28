using Antlr4.Runtime;
using System.Collections.Generic;
using System.IO;

public class ErrorListener : IAntlrErrorListener<int>, IAntlrErrorListener<IToken>
{
    private List<ErrorReportEntry> errors = new List<ErrorReportEntry>();

    // Este método se invoca cuando el lexer encuentra un símbolo léxico inválido
    public void SyntaxError(TextWriter output,
                            IRecognizer recognizer,
                            int offendingSymbol,
                            int line,
                            int charPositionInLine,
                            string msg,
                            RecognitionException e)
    {
        errors.Add(new ErrorReportEntry
        {
            Type = "léxico",
            Line = line,
            Column = charPositionInLine,
            Description = msg
        });
    }

    // Este método se invoca cuando el parser encuentra un error de sintaxis
    public void SyntaxError(TextWriter output,
                            IRecognizer recognizer,
                            IToken offendingSymbol,
                            int line,
                            int charPositionInLine,
                            string msg,
                            RecognitionException e)
    {
        errors.Add(new ErrorReportEntry
        {
            Type = "sintáctico",
            Line = line,
            Column = charPositionInLine,
            Description = msg
        });
    }

    // Permite obtener la lista de errores detectados
    public IReadOnlyList<ErrorReportEntry> GetErrors()
    {
        return errors.AsReadOnly();
    }
}

// Clase para describir la entrada de un error en el reporte
public class ErrorReportEntry
{
    // "léxico", "sintáctico" o "semántico"
    public string Type { get; set; }

    // Línea donde ocurrió el error
    public int Line { get; set; }

    // Columna
    public int Column { get; set; }

    // Mensaje o descripción del error
    public string Description { get; set; }
}
