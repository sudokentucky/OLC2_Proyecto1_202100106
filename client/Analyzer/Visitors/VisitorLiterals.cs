

public partial class Visitor
{
    private Value ParseIntLiteral(string text, int line, int column)
    {
        if (int.TryParse(text, out int n))
            return new Value(ValueType.Int, n);
        AddSemanticError(line, column, $"Literal entero inválido: {text}.");
        return new Value(ValueType.Int, 0);
    }

    private Value ParseFloatLiteral(string text, int line, int column)
    {
        if (double.TryParse(text, out double d))
            return new Value(ValueType.Float, d);
        AddSemanticError(line, column, $"Literal flotante inválido: {text}.");
        return new Value(ValueType.Float, 0.0);
    }

    private Value ParseStringLiteral(string text, int line, int column)
    {
        if (text.Length >= 2 && text.StartsWith("\"") && text.EndsWith("\""))
        {
            text = text.Substring(1, text.Length - 2)
                       .Replace("\\n", "\n")
                       .Replace("\\r", "\r")
                       .Replace("\\t", "\t")
                       .Replace("\\\"", "\"")
                       .Replace("\\\\", "\\");
            return new Value(ValueType.String, text);
        }
        AddSemanticError(line, column, $"Literal de cadena inválido: {text}.");
        return new Value(ValueType.String, "");
    }

    private Value ParseRuneLiteral(string text, int line, int column)
    {
        if (text.Length >= 3 && text.StartsWith("'") && text.EndsWith("'"))
        {
            text = text.Substring(1, text.Length - 2);
            if (text.StartsWith("\\"))
            {
                return text switch
                {
                    "\\n" => new Value(ValueType.Rune, '\n'),
                    "\\r" => new Value(ValueType.Rune, '\r'),
                    "\\t" => new Value(ValueType.Rune, '\t'),
                    "\\'" => new Value(ValueType.Rune, '\''),
                    "\\\\" => new Value(ValueType.Rune, '\\'),
                    _ => HandleUnknownRuneEscape(text, line, column)
                };
            }
            else if (text.Length == 1)
            {
                return new Value(ValueType.Rune, text[0]);
            }
        }
        AddSemanticError(line, column, $"Literal de runa inválido: {text}.");
        return new Value(ValueType.Rune, '\0');
    }

    private Value HandleUnknownRuneEscape(string text, int line, int column)
    {
        AddSemanticError(line, column, $"Secuencia de escape desconocida: {text}.");
        return new Value(ValueType.Rune, '\0');
    }
}
