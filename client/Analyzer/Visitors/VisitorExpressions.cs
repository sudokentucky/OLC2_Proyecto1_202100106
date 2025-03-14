using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // expr : logicalOrExpr ;
    public override Value VisitExpresion([NotNull] ExpresionContext context)
    {
        return Visit(context.logicalOrExpr());
    }

    // logicalOrExpr : logicalAndExpr (OR_LOGIC logicalAndExpr)* ;
    public override Value VisitLogicalOrExpr([NotNull] LogicalOrExprContext context)    
    {
        Value leftValue = Visit(context.logicalAndExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.logicalAndExpr().Length; i++)
        {
            Value rightValue = Visit(context.logicalAndExpr(i));
            if (leftValue.Type != ValueType.Bool || rightValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"Operador '||' requiere booleanos, se obtuvo {leftValue.Type} y {rightValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            bool result = leftValue.AsBool() || rightValue.AsBool();
            leftValue = new Value(ValueType.Bool, result);
        }

        return leftValue;
    }

    // logicalAndExpr : equalityExpr (AND_LOGIC equalityExpr)* ;
    public override Value VisitLogicalAndExpr([NotNull] LogicalAndExprContext context)
    {
        Value leftValue = Visit(context.equalityExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.equalityExpr().Length; i++)
        {
            Value rightValue = Visit(context.equalityExpr(i));
            if (leftValue.Type != ValueType.Bool || rightValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"Operador '&&' requiere booleanos, se obtuvo {leftValue.Type} y {rightValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            bool result = leftValue.AsBool() && rightValue.AsBool();
            leftValue = new Value(ValueType.Bool, result);
        }

        return leftValue;
    }

    // equalityExpr : relationalExpr ( (EQUAL | NOT_EQUAL) relationalExpr )* ;
    public override Value VisitEqualityExpr([NotNull] EqualityExprContext context)
    {
        Value leftValue = Visit(context.relationalExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.relationalExpr().Length; i++)
        {
            Value rightValue = Visit(context.relationalExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText();

            leftValue = EvaluateEquality(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

    public override Value VisitRelationalExpr([NotNull] RelationalExprContext context)
    {
        Value leftValue = Visit(context.addExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.addExpr().Length; i++)
        {
            Value rightValue = Visit(context.addExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); // >, <, >=, <=

            leftValue = EvaluateRelational(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

    public override Value VisitAddExpr([NotNull] AddExprContext context)
    {
        Value leftValue = Visit(context.mulExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.mulExpr().Length; i++)
        {
            Value rightValue = Visit(context.mulExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); // + o -
            leftValue = EvaluateAddOrSub(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

    public override Value VisitMulExpr([NotNull] MulExprContext context)
    {
        Value leftValue = Visit(context.unaryExpr(0));
        int line = context.Start.Line;
        int column = context.Start.Column;

        for (int i = 1; i < context.unaryExpr().Length; i++)
        {
            Value rightValue = Visit(context.unaryExpr(i));
            string op = context.GetChild((i * 2) - 1).GetText(); 

            leftValue = EvaluateMulDivMod(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

public override Value VisitUnaryExpr([NotNull] UnaryExprContext context)
{
    Value exprValue = Visit(context.primary());
    
    if (context.MINUS() != null)
    {
        if (IsNumeric(exprValue) == 0)
        {
            int line = context.Start.Line;
            int column = context.Start.Column;
            AddSemanticError(line, column, 
                $"No se puede aplicar el operador unario '-' a un valor de tipo {exprValue.Type}");
            return new Value(ValueType.Int, 0);
        }
        
        if (exprValue.Type == ValueType.Float)
            return new Value(ValueType.Float, -exprValue.AsFloat());
        else
            return new Value(ValueType.Int, -exprValue.AsInt());
    }
    else if (context.NOT() != null)
    {
        if (exprValue.Type != ValueType.Bool)
        {
            int line = context.Start.Line;
            int column = context.Start.Column;
            AddSemanticError(line, column, 
                $"No se puede aplicar el operador '!' a un valor de tipo {exprValue.Type}");
            return new Value(ValueType.Bool, false);
        }
        
        return new Value(ValueType.Bool, !exprValue.AsBool());
    }
    else
    {
        return exprValue;
    }
}
public override Value VisitPrimary([NotNull] PrimaryContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    
    // Enteros
    if (context.INT_LIT() != null)
    {
        string text = context.INT_LIT().GetText();
        if (int.TryParse(text, out int n))
        {
            return new Value(ValueType.Int, n);
        }
        AddSemanticError(line, column, $"Literal entero inválido: {text}.");
        return new Value(ValueType.Int, 0);
    }
    
    // Flotantes
    else if (context.FLOAT_LIT() != null)
    {
        string text = context.FLOAT_LIT().GetText();
        if (double.TryParse(text, out double d))
        {
            return new Value(ValueType.Float, d);
        }
        AddSemanticError(line, column, $"Literal flotante inválido: {text}.");
        return new Value(ValueType.Float, 0.0);
    }
    
    // Cadenas
    else if (context.STRING_LIT() != null)
    {
        string text = context.STRING_LIT().GetText();
        // Eliminar comillas del inicio y final
        if (text.Length >= 2 && text.StartsWith("\"") && text.EndsWith("\""))
        {
            text = text.Substring(1, text.Length - 2);
            
            // Procesar secuencias de escape
            text = text.Replace("\\n", "\n")
                      .Replace("\\r", "\r")
                      .Replace("\\t", "\t")
                      .Replace("\\\"", "\"")
                      .Replace("\\\\", "\\");
                      
            return new Value(ValueType.String, text);
        }
        AddSemanticError(line, column, $"Literal de cadena inválido: {text}.");
        return new Value(ValueType.String, "");
    }
    
    // Runas (caracteres)
    else if (context.RUNE_LIT() != null)
    {
        string text = context.RUNE_LIT().GetText();
        // Eliminar comillas simples
        if (text.Length >= 3 && text.StartsWith("'") && text.EndsWith("'"))
        {
            text = text.Substring(1, text.Length - 2);
            
            // Procesar secuencias de escape
            if (text.StartsWith("\\"))
            {
                switch (text)
                {
                    case "\\n": return new Value(ValueType.Rune, '\n');
                    case "\\r": return new Value(ValueType.Rune, '\r');
                    case "\\t": return new Value(ValueType.Rune, '\t');
                    case "\\'": return new Value(ValueType.Rune, '\'');
                    case "\\\\": return new Value(ValueType.Rune, '\\');
                    default:
                        AddSemanticError(line, column, $"Secuencia de escape desconocida: {text}.");
                        return new Value(ValueType.Rune, '\0');
                }
            }
            else if (text.Length == 1)
            {
                return new Value(ValueType.Rune, text[0]);
            }
        }
        AddSemanticError(line, column, $"Literal de runa inválido: {text}.");
        return new Value(ValueType.Rune, '\0');
    }
    
    // Identificadores (incluyendo true/false)
    else if (context.IDENTIFIER() != null)
    {
        string varName = context.IDENTIFIER().GetText();
        
        // Constantes booleanas
        if (varName == "true")
        {
            return new Value(ValueType.Bool, true);
        }
        else if (varName == "false")
        {
            return new Value(ValueType.Bool, false);
        }
        
        // Variables
        try
        {
            return currentEnv.GetVariable(varName);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return new Value(ValueType.Int, 0);
        }
    }
    
    // Expresiones entre paréntesis
    else if (context.expresion() != null)
    {
        return Visit(context.expresion());
    }
    
    // Si no se reconoce ningún tipo (no debería ocurrir según la gramática)
    AddSemanticError(line, column, "Expresión primaria desconocida.");
    return new Value(ValueType.Int, 0);
}


    private Value EvaluateEquality(Value left, Value right, string op, int line, int col)
    {
        if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
        {
            double l = ToDouble(left);
            double r = ToDouble(right);
            bool result = (op == "==") ? (l == r) : (l != r);
            return new Value(ValueType.Bool, result);
        }
        else if (left.Type == ValueType.Bool && right.Type == ValueType.Bool)
        {
            bool result = (op == "==")
                ? (left.AsBool() == right.AsBool())
                : (left.AsBool() != right.AsBool());
            return new Value(ValueType.Bool, result);
        }
        else if (left.Type == ValueType.String && right.Type == ValueType.String)
        {
            bool result = (op == "==")
                ? (left.AsString() == right.AsString())
                : (left.AsString() != right.AsString());
            return new Value(ValueType.Bool, result);
        }
        else
        {
            AddSemanticError(line, col,
                $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
            return new Value(ValueType.Bool, false);
        }
    }

    private Value EvaluateRelational(Value left, Value right, string op, int line, int col)
    {
        if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
        {
            double l = ToDouble(left);
            double r = ToDouble(right);

            bool result = false;
            switch (op)
            {
                case ">":  result = l > r;  break;
                case "<":  result = l < r;  break;
                case ">=": result = l >= r; break;
                case "<=": result = l <= r; break;
            }
            return new Value(ValueType.Bool, result);
        }
        else
        {
            AddSemanticError(line, col,
                $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
            return new Value(ValueType.Bool, false);
        }
    }

    private Value EvaluateAddOrSub(Value left, Value right, string op, int line, int col)
    {
        if (op == "+")
        {
            if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
            {
                double sum = ToDouble(left) + ToDouble(right);
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)sum);
                }
                else
                {
                    return new Value(ValueType.Float, sum);
                }
            }
            else if (left.Type == ValueType.String && right.Type == ValueType.String)
            {
                return new Value(ValueType.String, left.AsString() + right.AsString());
            }
            else
            {
                AddSemanticError(line, col,
                    $"No se puede aplicar '+' entre {left.Type} y {right.Type}.");
                return new Value(ValueType.Int, 0);
            }
        }
        else // op == "-"
        {
            if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
            {
                double diff = ToDouble(left) - ToDouble(right);
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)diff);
                }
                else
                {
                    return new Value(ValueType.Float, diff);
                }
            }
            else
            {
                AddSemanticError(line, col,
                    $"No se puede aplicar '-' entre {left.Type} y {right.Type}.");
                return new Value(ValueType.Int, 0);
            }
        }
    }

    private Value EvaluateMulDivMod(Value left, Value right, string op, int line, int col)
    {
        if (IsNumeric(left) == 0 || IsNumeric(right) == 0)
        {
            AddSemanticError(line, col,
                $"No se puede aplicar '{op}' entre {left.Type} y {right.Type}.");
            return new Value(ValueType.Int, 0);
        }

        double l = ToDouble(left);
        double r = ToDouble(right);

        if ((op == "/" || op == "%") && r == 0)
        {
            AddSemanticError(line, col, "División entre cero no permitida.");
            return new Value(ValueType.Int, 0);
        }

        switch (op)
        {
            case "*":
            {
                double product = l * r;
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    return new Value(ValueType.Int, (int)product);
                }
                else
                {
                    return new Value(ValueType.Float, product);
                }
            }
            case "/":
            {
                double quotient = l / r;
                return new Value(ValueType.Float, quotient);
            }
            case "%":
            {
                if (left.Type == ValueType.Int && right.Type == ValueType.Int)
                {
                    int mod = (int)l % (int)r;
                    return new Value(ValueType.Int, mod);
                }
                else
                {
                    AddSemanticError(line, col,
                        $"El operador '%' requiere int, se obtuvo {left.Type} y {right.Type}.");
                    return new Value(ValueType.Int, 0);
                }
            }
        }

        return new Value(ValueType.Int, 0);
    }
public override Value VisitAssignacion([NotNull] AssignacionContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        string varName = context.IDENTIFIER().GetText();
        Value rightValue = Visit(context.expresion());
        
        try
        {
            Value currentValue = currentEnv.GetVariable(varName);
            // Se obtiene el operador de asignación (=, +=, o -=)
            string op = context.GetChild(1).GetText();
            Value newValue = null;
            
            switch (op)
            {
                case "=":
                    currentEnv.SetVariable(varName, rightValue);
                    return rightValue;
                case "+=":
                    newValue = ApplyPlusAssign(currentValue, rightValue, line, column);
                    break;
                case "-=":
                    newValue = ApplyMinusAssign(currentValue, rightValue, line, column);
                    break;
                default:
                    AddSemanticError(line, column, $"Operador de asignación desconocido: {op}");
                    return currentValue;
            }
            
            currentEnv.SetVariable(varName, newValue);
            return newValue;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return new Value(ValueType.Int, 0);
        }
    }
    
private Value ApplyPlusAssign(Value currentValue, Value rightValue, int line, int column)
{
    // Caso de números: se requiere que ambos operandos sean del mismo tipo.
    if (IsNumeric(currentValue) != 0 && IsNumeric(rightValue) != 0)
    {
        if (currentValue.Type != rightValue.Type)
        {
            AddSemanticError(line, column,
                $"No se puede aplicar '+=' entre tipos diferentes: {currentValue.Type} y {rightValue.Type}.");
            return currentValue;
        }

        double result = ToDouble(currentValue) + ToDouble(rightValue);
        if (currentValue.Type == ValueType.Int)
            return new Value(ValueType.Int, (int)result);
        else
            return new Value(ValueType.Float, result);
    }
    // Caso de concatenación de strings (la validación ya es de igualdad de tipo)
    else if (currentValue.Type == ValueType.String && rightValue.Type == ValueType.String)
    {
        return new Value(ValueType.String, currentValue.AsString() + rightValue.AsString());
    }
    else
    {
        AddSemanticError(line, column,
            $"No se puede aplicar '+=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }
}

private Value ApplyMinusAssign(Value currentValue, Value rightValue, int line, int column)
{
    if (IsNumeric(currentValue) != 0 && IsNumeric(rightValue) != 0)
    {
        if (currentValue.Type != rightValue.Type)
        {
            AddSemanticError(line, column,
                $"No se puede aplicar '-=' entre tipos diferentes: {currentValue.Type} y {rightValue.Type}.");
            return currentValue;
        }

        double result = ToDouble(currentValue) - ToDouble(rightValue);
        if (currentValue.Type == ValueType.Int)
            return new Value(ValueType.Int, (int)result);
        else
            return new Value(ValueType.Float, result);
    }
    else
    {
        AddSemanticError(line, column,
            $"No se puede aplicar '-=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }
}

}
