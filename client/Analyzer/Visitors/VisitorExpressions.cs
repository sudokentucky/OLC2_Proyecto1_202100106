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
        
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (context.MINUS() != null)
        {
            Value exprValue = Visit(context.unaryExpr());
            if (IsNumeric(exprValue) == 0)
            {
                AddSemanticError(line, column,
                    $"No se puede aplicar operador unario '-' a tipo {exprValue.Type}.");
                return new Value(ValueType.Int, 0);
            }
            double val = ToDouble(exprValue);
            if (exprValue.Type == ValueType.Float)
                return new Value(ValueType.Float, -val);
            else
                return new Value(ValueType.Int, (int)(-val));
        }
        else if (context.NOT() != null)
        {
            Value exprValue = Visit(context.unaryExpr());
            if (exprValue.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"No se puede aplicar operador '!' a tipo {exprValue.Type}.");
                return new Value(ValueType.Bool, false);
            }
            return new Value(ValueType.Bool, !exprValue.AsBool());
        }
        else if (context.primary() != null)
        {
            return Visit(context.primary());
        }
        else if (context.sliceFunc() != null)
        {
            return Visit(context.sliceFunc());
        }
        //Si no es ninguno de los anteriores es error
        AddSemanticError(line, column, "Expresión unaria desconocida.");
        return Value.FromNil();
    }
public override Value VisitPrimary([NotNull] PrimaryContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    if (context.INT_LIT() != null)
        return ParseIntLiteral(context.INT_LIT().GetText(), line, column);
    else if (context.FLOAT_LIT() != null)
        return ParseFloatLiteral(context.FLOAT_LIT().GetText(), line, column);
    else if (context.STRING_LIT() != null)
        return ParseStringLiteral(context.STRING_LIT().GetText(), line, column);
    else if (context.RUNE_LIT() != null)
        return ParseRuneLiteral(context.RUNE_LIT().GetText(), line, column);
    else if (context.sliceLiteral() != null)
        return Visit(context.sliceLiteral());
    else if (context.structLiteral() != null)
        return Visit(context.structLiteral());
    else if (context.IDENTIFIER() != null)
        return EvaluateIdentifier(context, line, column);
    else if (context.expresion() != null && context.expresion().Length > 0)
        return Visit(context.expresion(0));

    AddSemanticError(line, column, "Expresión primaria desconocida.");
    return new Value(ValueType.Int, 0);
}

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
        // Eliminar comillas del inicio y final
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

private Value ParseRuneLiteral(string text, int line, int column)
{
    if (text.Length >= 3 && text.StartsWith("'") && text.EndsWith("'"))
    {
        text = text.Substring(1, text.Length - 2);
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
            return new Value(ValueType.Rune, text[0]);
    }
    AddSemanticError(line, column, $"Literal de runa inválido: {text}.");
    return new Value(ValueType.Rune, '\0');
}

private Value EvaluateIdentifier(PrimaryContext context, int line, int column)
{
    string varName = context.IDENTIFIER(0).GetText();

    // Literales booleanos especiales
    if (varName == "true")
        return new Value(ValueType.Bool, true);
    else if (varName == "false")
        return new Value(ValueType.Bool, false);

    // Llamada a función
    if (context.PARENTESIS_IZQ() != null)
    {
        Value[] arguments = EvaluateArgumentList(context);
        return CallFunction(varName, arguments, line, column);
    }

    Value currentValue = GetVariableValue(varName, line, column);
    currentValue = EvaluateIndices(currentValue, context, varName, line, column);
    currentValue = EvaluateFieldAccess(currentValue, context, varName, line, column);
    
    return currentValue;
}

private Value[] EvaluateArgumentList(PrimaryContext context)
{
    if (context.argumentList() != null)
    {
        var exprs = context.argumentList().expresion();
        Value[] arguments = new Value[exprs.Length];
        for (int i = 0; i < exprs.Length; i++)
            arguments[i] = Visit(exprs[i]);
        return arguments;
    }
    return new Value[0];
}

private Value GetVariableValue(string varName, int line, int column)
{
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

private Value EvaluateIndices(Value currentValue, PrimaryContext context, string varName, int line, int column)
{
    var indexNodes = context.CORCHETE_IZQ();
    if (indexNodes != null && indexNodes.Length > 0)
    {
        var expressionList = context.expresion();
        for (int i = 0; i < expressionList.Length; i++)
        {
            Value idxValue = Visit(expressionList[i]);
            if (idxValue.Type != ValueType.Int)
            {
                AddSemanticError(line, column, "El índice debe ser de tipo entero.");
                return new Value(ValueType.Int, 0);
            }
            int index = idxValue.AsInt();
            if (currentValue.Type != ValueType.Slice)
            {
                AddSemanticError(line, column, $"El valor de '{varName}' no es indexable (no es un slice).");
                return currentValue;
            }
            try
            {
                Slice s = currentValue.AsSlice();
                currentValue = s[index];
            }
            catch (Exception ex)
            {
                AddSemanticError(line, column, ex.Message);
                return new Value(ValueType.Int, 0);
            }
        }
    }
    return currentValue;
}

private Value EvaluateFieldAccess(Value currentValue, PrimaryContext context, string varName, int line, int column)
{
    var puntoNodes = context.PUNTO();
    var identifiers = context.IDENTIFIER();
    if (puntoNodes != null && puntoNodes.Length > 0)
    {
        for (int i = 0; i < puntoNodes.Length; i++)
        {
            if (i + 1 < identifiers.Length)
            {
                string fieldName = identifiers[i + 1].GetText();
                if (currentValue.Type != ValueType.Struct)
                {
                    AddSemanticError(line, column,
                        $"No se puede acceder a campos en un valor de tipo {currentValue.Type}");
                    return Value.FromNil();
                }
                try
                {
                    StructInstance structInst = currentValue.AsStruct();
                    currentValue = structInst.GetField(fieldName);
                }
                catch (Exception ex)
                {
                    AddSemanticError(line, column, ex.Message);
                    return Value.FromNil();
                }
            }
            else
            {
                AddSemanticError(line, column, "Error de sintaxis: se esperaba un nombre de campo después del punto.");
                return Value.FromNil();
            }
        }
    }
    return currentValue;
}

public override Value VisitTypeSpec([NotNull] gramaticaParser.TypeSpecContext context)
{

    if (context.INT_TYPE() != null)
    {
        return Value.FromInt(0); 
    }
    else if (context.FLOAT64_TYPE() != null)
    {
        return Value.FromFloat(0.0);
    }
    else if (context.STRING_TYPE() != null)
    {
        return Value.FromString("");
    }
    else if (context.BOOL_TYPE() != null)
    {
        return Value.FromBool(false);
    }
    else if (context.RUNE_TYPE() != null)
    {
        return Value.FromRune('\0');
    }
    else if (context.sliceType() != null)
    {
        return Visit(context.sliceType());
    }
    else
    {
        AddSemanticError(context.Start.Line, context.Start.Column, 
                         "Tipo desconocido en typeSpec.");
        return Value.FromNil();
    }
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
    string targetIdentifier = context.IDENTIFIER().GetText();
    Value rightValue = Visit(context.expresion());
    
    try
    {
        // Si tenemos una asignación a un campo de struct (contiene un punto)
        if (targetIdentifier.Contains("."))
        {
            // Dividir en partes: "persona.direccion.calle" -> ["persona", "direccion", "calle"]
            string[] parts = targetIdentifier.Split('.');
            string structVarName = parts[0];
            
            // Obtener la instancia base del struct
            Value structValue = currentEnv.GetVariable(structVarName);
            if (structValue.Type != ValueType.Struct)
            {
                AddSemanticError(line, column, $"{structVarName} no es un struct");
                return Value.FromNil();
            }
            
            StructInstance instance = structValue.AsStruct();
            
            // Navegar a través de los campos intermedios hasta llegar al penúltimo
            for (int i = 1; i < parts.Length - 1; i++)
            {
                string fieldName = parts[i];
                try
                {
                    Value fieldValue = instance.GetField(fieldName);
                    if (fieldValue.Type != ValueType.Struct)
                    {
                        AddSemanticError(line, column, 
                            $"El campo {fieldName} no es un struct y no permite acceso anidado");
                        return Value.FromNil();
                    }
                    instance = fieldValue.AsStruct();
                }
                catch (Exception ex)
                {
                    AddSemanticError(line, column, ex.Message);
                    return Value.FromNil();
                }
            }
            
            // Asignar al último campo
            string finalFieldName = parts[parts.Length - 1];
            try
            {
                instance.SetField(finalFieldName, rightValue);
                return rightValue;
            }
            catch (Exception ex)
            {
                AddSemanticError(line, column, ex.Message);
                return Value.FromNil();
            }
        }
        else
        {
            // Asignación normal a una variable
            Value currentValue = currentEnv.GetVariable(targetIdentifier);
            // Se obtiene el operador de asignación (=, +=, o -=)
            string op = context.GetChild(1).GetText();
            Value newValue = null;
            
            switch (op)
            {
                case "=":
                    currentEnv.SetVariable(targetIdentifier, rightValue);
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
            
            currentEnv.SetVariable(targetIdentifier, newValue);
            return newValue;
        }
    }
    catch (Exception ex)
    {
        AddSemanticError(line, column, ex.Message);
        return Value.FromNil();
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
