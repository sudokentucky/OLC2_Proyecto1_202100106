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
            string op = context.GetChild((i * 2) - 1).GetText(); 

            leftValue = EvaluateRelational(leftValue, rightValue, op, line, column);
        }

        return leftValue;
    }

   public override Value VisitUnaryExpr([NotNull] UnaryExprContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        Console.WriteLine("-------------- Visit Unario-------");
        Console.WriteLine($"[VisitUnaryExpr] Iniciando evaluación de expresión unaria en línea {line}, columna {column}");

        if (context.MINUS() != null)
        {
            Console.WriteLine($"[VisitUnaryExpr] Operador de negación '-' detectado");
            Value exprValue = Visit(context.unaryExpr());
            Console.WriteLine($"[VisitUnaryExpr] Valor a negar: Type = {exprValue.Type}, Value = {exprValue}");
            
            if (IsNumeric(exprValue) == 0)
            {
                string errorMsg = $"No se puede aplicar operador unario '-' a tipo {exprValue.Type}.";
                Console.WriteLine($"[VisitUnaryExpr] Error: {errorMsg}");
                AddSemanticError(line, column, errorMsg);
                return new Value(ValueType.Int, 0);
            }
            
            double val = ToDouble(exprValue);
            Value result;
            
            if (exprValue.Type == ValueType.Float)
                result = new Value(ValueType.Float, -val);
            else
                result = new Value(ValueType.Int, (int)(-val));
                
            Console.WriteLine($"[VisitUnaryExpr] Resultado de negación: Type = {result.Type}, Value = {result}");
            return result;
        }
        else if (context.NOT() != null)
        {
            Console.WriteLine($"[VisitUnaryExpr] Operador de negación lógica '!' detectado");
            Value exprValue = Visit(context.unaryExpr());
            Console.WriteLine($"[VisitUnaryExpr] Valor a negar lógicamente: Type = {exprValue.Type}, Value = {exprValue}");
            
            if (exprValue.Type != ValueType.Bool)
            {
                string errorMsg = $"No se puede aplicar operador '!' a tipo {exprValue.Type}.";
                Console.WriteLine($"[VisitUnaryExpr] Error: {errorMsg}");
                AddSemanticError(line, column, errorMsg);
                return new Value(ValueType.Bool, false);
            }
            
            Value result = new Value(ValueType.Bool, !exprValue.AsBool());
            Console.WriteLine($"[VisitUnaryExpr] Resultado de negación lógica: Type = {result.Type}, Value = {result}");
            return result;
        }
        else if (context.primary() != null)
        {
            Console.WriteLine($"[VisitUnaryExpr] Expresión primaria detectada");
            Value result = Visit(context.primary());
            Console.WriteLine($"[VisitUnaryExpr] Resultado de expresión primaria: Type = {result.Type}, Value = {result}");
            return result;
        }
        else if (context.sliceFunc() != null)
        {
            Console.WriteLine($"[VisitUnaryExpr] Función de slice detectada");
            Value result = Visit(context.sliceFunc());
            Console.WriteLine($"[VisitUnaryExpr] Resultado de función de slice: Type = {result.Type}, Value = {result}");
            return result;
        }
        else if (context.conversionFunc() != null)
        {
            Console.WriteLine($"[VisitUnaryExpr] Función de conversión detectada");
            Value result = Visit(context.conversionFunc());
            Console.WriteLine($"[VisitUnaryExpr] Resultado de función de conversión: Type = {result.Type}, Value = {result}");
            return result;
        }
        
        Console.WriteLine($"[VisitUnaryExpr] Error: Expresión unaria desconocida");
        AddSemanticError(line, column, "Expresión unaria desconocida.");
        return Value.FromNil();
    }

public override Value VisitPrimary([NotNull] PrimaryContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    Console.WriteLine($"[VisitPrimary] Ingresando a VisitPrimary en línea {line}, columna {column}");

    if (context.functCall() != null)
    {
        Console.WriteLine($"[VisitPrimary] Se encontró una llamada a función.");
        return Visit(context.functCall());
    }

    if (context.INT_LIT() != null)
    {
        string valueText = context.INT_LIT().GetText();
        Console.WriteLine($"[VisitPrimary] Se encontró un literal INT: {valueText}");
        return ParseIntLiteral(valueText, line, column);
    }

    if (context.FLOAT_LIT() != null)
    {
        string valueText = context.FLOAT_LIT().GetText();
        Console.WriteLine($"[VisitPrimary] Se encontró un literal FLOAT: {valueText}");
        return ParseFloatLiteral(valueText, line, column);
    }

    if (context.STRING_LIT() != null)
    {
        string valueText = context.STRING_LIT().GetText();
        Console.WriteLine($"[VisitPrimary] Se encontró un literal STRING: {valueText}");
        return ParseStringLiteral(valueText, line, column);
    }

    if (context.RUNE_LIT() != null)
    {
        string valueText = context.RUNE_LIT().GetText();
        Console.WriteLine($"[VisitPrimary] Se encontró un literal RUNE: {valueText}");
        return ParseRuneLiteral(valueText, line, column);
    }

    if (context.sliceLiteral() != null)
    {
        Console.WriteLine($"[VisitPrimary] Se encontró un slice literal.");
        return Visit(context.sliceLiteral());
    }

    if (context.structLiteral() != null)
    {
        Console.WriteLine($"[VisitPrimary] Se encontró un struct literal.");
        return Visit(context.structLiteral());
    }

    if (context.IDENTIFIER() != null && context.IDENTIFIER().Length > 0)
    {
        string identifierName = context.IDENTIFIER(0).GetText();
        Console.WriteLine($"[VisitPrimary] Se encontró un IDENTIFIER: {identifierName}");
        return EvaluateIdentifier(context, line, column);
    }

    if (context.expresion() != null && context.expresion().Length > 0)
    {
        Console.WriteLine($"[VisitPrimary] Se encontró una expresión entre paréntesis.");
        return Visit(context.expresion(0));
    }

    Console.WriteLine($"[VisitPrimary] Error: Expresión primaria desconocida.");
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
        text = text.Substring(1, text.Length - 2);
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
    Console.WriteLine("--------- DEPURACIÓN EVALUATE_IDENTIFIER ---------");
    Console.WriteLine($"Línea: {line}, Columna: {column}");
    Console.WriteLine($"Texto completo: {context.GetText()}");
    
    // Verificación de seguridad para IDENTIFIER
    if (context.IDENTIFIER() == null)
    {
        Console.WriteLine("ERROR: context.IDENTIFIER() es NULL");
        AddSemanticError(line, column, "Error en llamada a función: Identificador no encontrado");
        return Value.FromNil();
    }
    
    if (context.IDENTIFIER().Length == 0)
    {
        Console.WriteLine("ERROR: context.IDENTIFIER().Length es 0");
        AddSemanticError(line, column, "Error en llamada a función: No hay identificadores");
        return Value.FromNil();
    }
    
    string varName = context.IDENTIFIER(0).GetText();
    Console.WriteLine($"Nombre de variable: '{varName}'");
    
    // Verificar si es un valor booleano literal
    if (varName == "true")
    {
        Console.WriteLine("Es un literal booleano: true");
        return new Value(ValueType.Bool, true);
    }
    else if (varName == "false")
    {
        Console.WriteLine("Es un literal booleano: false");
        return new Value(ValueType.Bool, false);
    }
    
    Console.WriteLine($"Obteniendo valor de variable: {varName}");
    Value currentValue = GetVariableValue(varName, line, column);
    Console.WriteLine($"Valor obtenido: {currentValue?.Type.ToString() ?? "null"}");
    
    Console.WriteLine($"Evaluando índices: {context.CORCHETE_IZQ()?.Length ?? 0}");
    currentValue = EvaluateIndices(currentValue, context, varName, line, column);
    
    Console.WriteLine($"Evaluando campos: {context.PUNTO()?.Length ?? 0}");
    currentValue = EvaluateFieldAccess(currentValue, context, varName, line, column);
    
    Console.WriteLine($"Valor final: {currentValue?.Type.ToString() ?? "null"}");
    Console.WriteLine("------------------------------------------------");
    
    return currentValue;
}


private Value[] EvaluateArgumentList(FunctCallContext context)
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
        Console.WriteLine($"ERROR: Variable '{varName}' no encontrada: {ex.Message}");
        AddSemanticError(line, column, ex.Message);
        return Value.FromNil();  
    }
}

private Value EvaluateIndices(Value currentValue, PrimaryContext context, string varName, int line, int column)
{
    Console.WriteLine($"[EvaluateIndices] Evaluando índices para la variable '{varName}' en línea {line}, columna {column}.");
    Console.WriteLine($"[EvaluateIndices] currentValue inicial: Type = {currentValue.Type}");

    var indexNodes = context.CORCHETE_IZQ();

    if (indexNodes != null && indexNodes.Length > 0)
    {
        Console.WriteLine($"[EvaluateIndices] Se encontraron {indexNodes.Length} índices.");

        var expressionList = context.expresion();

        for (int i = 0; i < expressionList.Length; i++)
        {
            Console.WriteLine($"[EvaluateIndices] Evaluando expresión del índice {i}.");

            Value idxValue = Visit(expressionList[i]);

            Console.WriteLine($"[EvaluateIndices] Valor del índice evaluado: Type = {idxValue.Type}, Value = {idxValue}");

            if (idxValue.Type != ValueType.Int)
            {
                Console.WriteLine($"[EvaluateIndices] Error: El índice no es de tipo entero.");
                AddSemanticError(line, column, "El índice debe ser de tipo entero.");
                return new Value(ValueType.Int, 0);
            }

            int index = idxValue.AsInt();
            Console.WriteLine($"[EvaluateIndices] Índice convertido a int: {index}");

            if (currentValue.Type != ValueType.Slice)
            {
                Console.WriteLine($"[EvaluateIndices] Error: El valor actual no es un slice. Type = {currentValue.Type}");
                AddSemanticError(line, column, $"El valor de '{varName}' no es indexable (no es un slice).");
                return currentValue;
            }

            try
            {
                Slice s = currentValue.AsSlice();
                currentValue = s[index];

                Console.WriteLine($"[EvaluateIndices] Valor actualizado tras acceder al índice {index}: Type = {currentValue.Type}");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"[EvaluateIndices] Excepción al acceder al índice {index}: {ex.Message}");
                AddSemanticError(line, column, ex.Message);
                return new Value(ValueType.Int, 0);
            }
        }
    }
    else
    {
        Console.WriteLine($"[EvaluateIndices] No se encontraron índices que evaluar.");
    }

    Console.WriteLine($"[EvaluateIndices] Valor final tras evaluación de índices: Type = {currentValue.Type}");
    return currentValue;
}


private Value EvaluateFieldAccess(Value currentValue, PrimaryContext context, string varName, int line, int column)
{
    Console.WriteLine("DEBUG: Iniciando EvaluateFieldAccess para variable '" + varName + "'.");
    var puntoNodes = context.PUNTO();
    var identifiers = context.IDENTIFIER();
    if (puntoNodes != null && puntoNodes.Length > 0)
    {
        for (int i = 0; i < puntoNodes.Length; i++)
        {
            if (i + 1 < identifiers.Length)
            {
                string fieldName = identifiers[i + 1].GetText();
                Console.WriteLine("DEBUG: Accediendo al campo '" + fieldName + "' del struct.");
                if (currentValue.Type != ValueType.Struct)
                {
                    string errorMsg = $"No se puede acceder a campos en un valor de tipo {currentValue.Type}";
                    Console.WriteLine("DEBUG: " + errorMsg);
                    AddSemanticError(line, column, errorMsg);
                    return Value.FromNil();
                }
                try
                {
                    StructInstance structInst = currentValue.AsStruct();
                    currentValue = structInst.GetField(fieldName);
                    Console.WriteLine("DEBUG: Campo '" + fieldName + "' obtenido. Nuevo valor: " + currentValue.Type);
                }
                catch (Exception ex)
                {
                    Console.WriteLine("DEBUG: Excepción al obtener el campo '" + fieldName + "': " + ex.Message);
                    AddSemanticError(line, column, ex.Message);
                    return Value.FromNil();
                }
            }
            else
            {
                string errorMsg = "Error de sintaxis: se esperaba un nombre de campo después del punto.";
                Console.WriteLine("DEBUG: " + errorMsg);
                AddSemanticError(line, column, errorMsg);
                return Value.FromNil();
            }
        }
    }
    Console.WriteLine("DEBUG: EvaluateFieldAccess completado. Valor final: " + currentValue.Type);
    return currentValue;
}


public override Value VisitAssignacion([NotNull] AssignacionContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    string targetIdentifier = context.IDENTIFIER().GetText();
    Console.WriteLine("DEBUG: Iniciando asignación a '" + targetIdentifier + "'.");
    Value rightValue = Visit(context.expresion());
    Console.WriteLine("DEBUG: Valor derecho evaluado: " + rightValue.Type);

    try
    {
        string op = context.GetChild(1).GetText();
        Console.WriteLine("DEBUG: Operador de asignación: " + op);
        
        bool isDeclaration = op == ":=";
        if (targetIdentifier.Contains("."))
        {
            Console.WriteLine("DEBUG: Asignación a campo(s) de struct detectada: " + targetIdentifier);
            string[] parts = targetIdentifier.Split('.');
            string structVarName = parts[0];
            Console.WriteLine("DEBUG: Nombre de la variable struct: " + structVarName);

            Value structValue = currentEnv.GetVariable(structVarName);
            Console.WriteLine("DEBUG: Valor obtenido para '" + structVarName + "': " + structValue.Type);
            if (structValue.Type != ValueType.Struct)
            {
                string errorMsg = $"{structVarName} no es un struct";
                Console.WriteLine("DEBUG: " + errorMsg);
                AddSemanticError(line, column, errorMsg);
                return Value.FromNil();
            }
            
            StructInstance instance = structValue.AsStruct();
            for (int i = 1; i < parts.Length - 1; i++)
            {
                string fieldName = parts[i];
                Console.WriteLine("DEBUG: Accediendo al campo anidado '" + fieldName + "'.");
                try
                {
                    Value fieldValue = instance.GetField(fieldName);
                    Console.WriteLine("DEBUG: Valor del campo '" + fieldName + "': " + fieldValue.Type);
                    if (fieldValue.Type != ValueType.Struct)
                    {
                        string errorMsg = $"El campo {fieldName} no es un struct y no permite acceso anidado";
                        Console.WriteLine("DEBUG: " + errorMsg);
                        AddSemanticError(line, column, errorMsg);
                        return Value.FromNil();
                    }
                    instance = fieldValue.AsStruct();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("DEBUG: Excepción accediendo al campo anidado '" + fieldName + "': " + ex.Message);
                    AddSemanticError(line, column, ex.Message);
                    return Value.FromNil();
                }
            }
            
            string finalFieldName = parts[parts.Length - 1];
            Console.WriteLine("DEBUG: Asignando valor al campo final '" + finalFieldName + "'.");
            try
            {
                instance.SetField(finalFieldName, rightValue);
                Console.WriteLine("DEBUG: Asignación realizada exitosamente.");
                return rightValue;
            }
            catch (Exception ex)
            {
                Console.WriteLine("DEBUG: Excepción al asignar al campo '" + finalFieldName + "': " + ex.Message);
                AddSemanticError(line, column, ex.Message);
                return Value.FromNil();
            }
        }
        else
        {
            Console.WriteLine("DEBUG: Asignación a variable simple: " + targetIdentifier);
            
            if (isDeclaration)
            {
                Console.WriteLine($"DEBUG: Declarando nueva variable '{targetIdentifier}' con tipo {rightValue.Type}");
                currentEnv.DeclareVariable(targetIdentifier, rightValue, line, column);
                Console.WriteLine($"DEBUG: Variable '{targetIdentifier}' declarada exitosamente con tipo: {rightValue.Type}");
                
                Value storedValue = currentEnv.GetVariable(targetIdentifier);
                Console.WriteLine($"DEBUG: Verificación - Tipo almacenado: {storedValue.Type}");
                
                return rightValue;
            }
            
            try {
                Value currentValue = currentEnv.GetVariable(targetIdentifier);
                Console.WriteLine("DEBUG: Valor actual de la variable: " + currentValue.Type);
                Value newValue = null;
                
                switch (op)
                {
                    case "=":
                        currentEnv.SetVariable(targetIdentifier, rightValue);
                        Console.WriteLine("DEBUG: Asignación simple '=' realizada. Nuevo valor: " + rightValue.Type);
                        return rightValue;
                    case "+=":
                        newValue = ApplyPlusAssign(currentValue, rightValue, line, column);
                        break;
                    case "-=":
                        newValue = ApplyMinusAssign(currentValue, rightValue, line, column);
                        break;
                    default:
                        string errorMsg = $"Operador de asignación desconocido: {op}";
                        Console.WriteLine("DEBUG: " + errorMsg);
                        AddSemanticError(line, column, errorMsg);
                        return currentValue;
                }
                
                currentEnv.SetVariable(targetIdentifier, newValue);
                Console.WriteLine("DEBUG: Asignación compuesta realizada. Nuevo valor: " + newValue.Type);
                return newValue;
            }
            catch (Exception ex) {
                Console.WriteLine("DEBUG: Error al obtener variable: " + ex.Message);
                AddSemanticError(line, column, $"Variable '{targetIdentifier}' no existe.");
                return Value.FromNil();
            }
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine("DEBUG: Excepción en VisitAssignacion: " + ex.Message);
        AddSemanticError(line, column, ex.Message);
        return Value.FromNil();
    }
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

   
private Value ApplyPlusAssign(Value currentValue, Value rightValue, int line, int column)
{
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
