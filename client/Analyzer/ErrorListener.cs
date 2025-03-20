using Antlr4.Runtime;
using System.Collections.Generic;
using System.IO;

public class ErrorListener : IAntlrErrorListener<int>, IAntlrErrorListener<IToken>
{
    private List<ErrorReportEntry> errors = new List<ErrorReportEntry>();

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

    public IReadOnlyList<ErrorReportEntry> GetErrors()
    {
        return errors.AsReadOnly();
    }
}

public class ErrorReportEntry
{
    // "léxico", "sintáctico" o "semántico"
    public string Type { get; set; }

    // Línea donde ocurrió el error
    public int Line { get; set; }

    public int Column { get; set; }

    public string Description { get; set; }
}
