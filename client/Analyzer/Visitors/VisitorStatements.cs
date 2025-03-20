using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
public override Value VisitDeclaracion([NotNull] DeclaracionContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    string varName; 
    
    if (context.IDENTIFIER().Length > 1)
    {
        string typeName = context.IDENTIFIER(0).GetText();
        varName = context.IDENTIFIER(1).GetText();
        
        Console.WriteLine($"DEBUG: Declaración con dos identificadores: tipo='{typeName}', nombre='{varName}'");
        
        try {
            StructType structType = table.GetStruct(typeName);
            Console.WriteLine($"DEBUG: Tipo de struct '{typeName}' encontrado en la tabla");
            
            currentStructTypeName = typeName;
            Console.WriteLine($"DEBUG: Estableciendo currentStructTypeName='{typeName}' antes de evaluar");
            
            Value structValue;
            
            if (context.expresion() != null)
            {
                Console.WriteLine($"DEBUG: Evaluando expresión para struct '{typeName}'");
                try {
                    structValue = Visit(context.expresion());
                    Console.WriteLine($"DEBUG: Valor evaluado para '{varName}': Type = {structValue.Type}");
                }
                catch (Exception ex) {
                    Console.WriteLine($"ERROR: Excepción evaluando expresión para struct: {ex.Message}");
                    Console.WriteLine($"DEBUG: Creando instancia vacía debido al error");
                    
                    StructInstance instance = new StructInstance(structType);
                    
                    foreach (var field in structType.Fields)
                    {
                        ValueType fieldType = field.Value;
                        Value defaultValue = GetDefaultValueForFieldType(fieldType);
                        instance.SetField(field.Key, defaultValue);
                        Console.WriteLine($"DEBUG: Inicializado campo '{field.Key}' con valor predeterminado para {fieldType}");
                    }
                    
                    structValue = Value.FromStruct(instance);
                }
            }
            else
            {
                Console.WriteLine($"DEBUG: No hay expresión inicial, creando instancia vacía");
                
                StructInstance instance = new StructInstance(structType);
                
                foreach (var field in structType.Fields)
                {
                    ValueType fieldType = field.Value;
                    Value defaultValue = GetDefaultValueForFieldType(fieldType);
                    instance.SetField(field.Key, defaultValue);
                    Console.WriteLine($"DEBUG: Inicializado campo '{field.Key}' con valor predeterminado para {fieldType}");
                }
                
                structValue = Value.FromStruct(instance);
            }
            
            currentStructTypeName = null;
            if (structValue.Type != ValueType.Struct)
            {
                Console.WriteLine($"DEBUG: El valor evaluado no es un struct, creando instancia vacía");
                StructInstance instance = new StructInstance(structType);
                
                foreach (var field in structType.Fields)
                {
                    ValueType fieldType = field.Value;
                    Value defaultValue = GetDefaultValueForFieldType(fieldType);
                    instance.SetField(field.Key, defaultValue);
                    Console.WriteLine($"DEBUG: Inicializado campo '{field.Key}' con valor predeterminado para {fieldType}");
                }
                
                structValue = Value.FromStruct(instance);
            }
            
            currentEnv.DeclareVariable(varName, structValue, line, column);
            Console.WriteLine($"DEBUG: Variable struct '{varName}' declarada exitosamente");
            
            return structValue;
        } 
        catch (Exception ex) {
            AddSemanticError(line, column, $"Error declarando struct: {ex.Message}");
            Console.WriteLine($"ERROR: {ex.Message}");
            currentStructTypeName = null;
            return Value.FromNil();
        }
    }
    
    varName = context.IDENTIFIER(0).GetText(); 
    string typeSpec = null;
    if (context.typeSpec() != null) {
        typeSpec = context.typeSpec().GetText();
        
        if (table.IsStructType(typeSpec)) {
            currentStructTypeName = typeSpec;
        }
    }
    
    Value initialValue;
    if (context.ASIGNACION() != null)
    {
        initialValue = Visit(context.expresion());
    }
    else
    {
        if (typeSpec != null)
        {
            initialValue = GetDefaultValueForType(typeSpec);
        }
        else
        {
            initialValue = new Value(ValueType.Nil, null);
        }
    }
    
    currentStructTypeName = null;
    
    try
    {
        currentEnv.DeclareVariable(varName, initialValue, line, column, "Global");
    }
    catch (Exception ex)
    {
        AddSemanticError(line, column, ex.Message);
    }
    
    return initialValue;
}
private Value GetDefaultValueForType(string declaredType)
{
    switch (declaredType)
    {
        case "int":
            return new Value(ValueType.Int, 0);
        case "float64":
            return new Value(ValueType.Float, 0.0);
        case "string":
            return new Value(ValueType.String, "");
        case "bool":
            return new Value(ValueType.Bool, false);
        case "rune":
            return new Value(ValueType.Rune, '\0');
        default:
            if (declaredType.StartsWith("[]"))
            {
                string elementType = declaredType.Substring(2);
                Console.WriteLine($"DEBUG: Creando slice vacío con tipo de elemento: {elementType}");
                return new Value(ValueType.Slice, new Slice(GetTypeFromString(elementType)));
            }
            
            try
            {
                if (table.IsStructType(declaredType))
                {
                    Console.WriteLine($"DEBUG: Creando instancia de struct vacía del tipo: {declaredType}");
                    StructType structType = table.GetStruct(declaredType);
                    StructInstance instance = new StructInstance(structType);
                    
                    foreach (var field in structType.Fields)
                    {
                        ValueType fieldType = field.Value;
                        Value defaultValue = GetDefaultValueForFieldType(fieldType);
                        instance.SetField(field.Key, defaultValue);
                        Console.WriteLine($"DEBUG: Inicializado campo '{field.Key}' con valor predeterminado para {fieldType}");
                    }
                    
                    return Value.FromStruct(instance);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"ERROR: No se pudo crear instancia para el tipo '{declaredType}': {ex.Message}");
            }
            
            Console.WriteLine($"DEBUG: Tipo desconocido: {declaredType}, retornando Nil");
            return new Value(ValueType.Nil, null);
    }
}

//  obtener un ValueType a partir de un string
private ValueType GetTypeFromString(string typeName)
{
    switch (typeName)
    {
        case "int": return ValueType.Int;
        case "float64": return ValueType.Float;
        case "string": return ValueType.String;
        case "bool": return ValueType.Bool;
        case "rune": return ValueType.Rune;
        default: return ValueType.Nil;
    }
}
 private string GetTypeNameFromValueType(ValueType type)
    {
        switch (type)
        {
            case ValueType.Int: return "int";
            case ValueType.Float: return "float64";
            case ValueType.String: return "string";
            case ValueType.Bool: return "bool";
            case ValueType.Rune: return "rune";
            case ValueType.Struct: return "struct"; 
            case ValueType.Slice: return "slice"; 
            case ValueType.Nil: return "nil";
            default: return "unknown";
        }
    }
// valores por defecto según el ValueType
private Value GetDefaultValueForFieldType(ValueType type)
{
    switch (type)
    {
        case ValueType.Int:
            return new Value(ValueType.Int, 0);
        case ValueType.Float:
            return new Value(ValueType.Float, 0.0);
        case ValueType.String:
            return new Value(ValueType.String, "");
        case ValueType.Bool:
            return new Value(ValueType.Bool, false);
        case ValueType.Rune:
            return new Value(ValueType.Rune, '\0');
        case ValueType.Slice:
            return new Value(ValueType.Slice, new Slice(ValueType.Nil));
        case ValueType.Struct:
            return new Value(ValueType.Nil, null);
        default:
            return new Value(ValueType.Nil, null);
    }
}


    public override Value VisitExprStmt([NotNull] ExprStmtContext context)
    {
        return Visit(context.expresion());
    }

     private Value[] VisitArgumentList(ArgumentListContext ctx)
    {
        var exprs = ctx.expresion();
        Value[] results = new Value[exprs.Length];
        for (int i = 0; i < exprs.Length; i++)
        {
            results[i] = Visit(exprs[i]);
        }
        return results;
    }

    public override Value VisitBloque([NotNull] BloqueContext context)
{
    Environment previousEnv = currentEnv;
    currentEnv = new Environment(table, previousEnv);
    
    Value lastResult = null;
    
    foreach (var instruction in context.instruction())
    {
        lastResult = Visit(instruction);
    }
    
    currentEnv = previousEnv;
    
    return lastResult;
}

public override Value VisitIfStmt([NotNull] IfStmtContext context)
{
    int line = context.Start.Line;
    int col = context.Start.Column;
    
    Value condition = Visit(context.expresion());
    
    if (condition.Type != ValueType.Bool)
    {
        AddSemanticError(line, col, 
            $"La condición del 'if' debe ser booleana, se obtuvo {condition.Type}.");
        return null;
    }
        if (condition.AsBool())
    {
        Visit(context.bloque());
        return null;
    }
        var elseIfStatements = context.elseIfStmt();
    if (elseIfStatements != null)
    {
        foreach (var elseIfStmt in elseIfStatements)
        {
            int elseIfLine = elseIfStmt.Start.Line;
            int elseIfCol = elseIfStmt.Start.Column;
            
            Value elseIfCondition = Visit(elseIfStmt.expresion());
            
            if (elseIfCondition.Type != ValueType.Bool)
            {
                AddSemanticError(elseIfLine, elseIfCol,
                    $"La condición del 'else if' debe ser booleana, se obtuvo {elseIfCondition.Type}.");
                continue;
            }
            
            if (elseIfCondition.AsBool())
            {
                Visit(elseIfStmt.bloque());
                return null;
            }
        }
    }
    if (context.elseStmt() != null)
    {
        Visit(context.elseStmt().bloque());
    }
    
    return null;
}

public override Value VisitSwitchStmt([NotNull] SwitchStmtContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    
    Value switchValue = Visit(context.expresion());
    
    bool caseMatched = false;
    bool executeNext = false; 
    
    switchDepth++; 
    
    try
    {
        foreach (var caseStmt in context.caseStmt())
        {
            Value caseValue = Visit(caseStmt.expresion());
            
            bool areEqual = executeNext || CompareValuesForEquality(switchValue, caseValue, line, column);
            
            if (areEqual)
            {
                caseMatched = true;
                
                // Si este case tiene instrucciones
                if (caseStmt.instruction().Length > 0)
                {
                    executeNext = false;  
                    
                    try
                    {
                        foreach (var instruction in caseStmt.instruction())
                        {
                            Visit(instruction);
                        }
                    }
                    catch (BreakException)
                    {
                        return null;
                    }
                    
                    break;
                }
                else
                {
                    executeNext = true;
                }
            }
        }
        
        if (!caseMatched && context.defaultStmt() != null)
        {
            try
            {
                foreach (var instruction in context.defaultStmt().instruction())
                {
                    Visit(instruction);
                }
            }
            catch (BreakException)
            {
                return null;
            }
        }
    }
    finally
    {
        switchDepth--; 
    }
    
    return null;
}

private bool CompareValuesForEquality(Value left, Value right, int line, int column)
{
    if (IsNumeric(left) != 0 && IsNumeric(right) != 0)
    {
        return ToDouble(left) == ToDouble(right);
    }
    else if (left.Type == ValueType.Bool && right.Type == ValueType.Bool)
    {
        return left.AsBool() == right.AsBool();
    }
    else if (left.Type == ValueType.String && right.Type == ValueType.String)
    {
        return left.AsString() == right.AsString();
    }
    else if (left.Type == ValueType.Rune && right.Type == ValueType.Rune)
    {
        return left.AsRune() == right.AsRune();
    }
    else
    {
        AddSemanticError(line, column,
            $"No se pueden comparar valores de tipo {left.Type} y {right.Type} en un switch-case.");
        return false;
    }
}

public override Value VisitForStmt([NotNull] ForStmtContext context)
{
    if (context.forWhileStmt() != null)
    {
        return Visit(context.forWhileStmt());
    }
    else 
    {
        return Visit(context.forThreePartStmt());
    }
}

public override Value VisitForWhileStmt([NotNull] ForWhileStmtContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    loopDepth++; 
    
    try
    {
        while (true)
        {
            Value condition = Visit(context.expresion());
            
            if (condition.Type != ValueType.Bool)
            {
                AddSemanticError(line, column,
                    $"La condición del bucle for debe ser booleana, se obtuvo {condition.Type}.");
                break;
            }
            
            if (!condition.AsBool())
                break;
                
            try
            {
                Visit(context.bloque());
            }
            catch (ContinueException)
            {
                continue;
            }
        }
    }
    catch (BreakException)
    {
    }
    finally
    {
        loopDepth--; 
    }
    
    return null;
}

public override Value VisitForThreePartStmt([NotNull] ForThreePartStmtContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    Environment previousEnv = currentEnv;
    currentEnv = new Environment(table, previousEnv);
    
    loopDepth++; 
    
    try
    {
        if (context.forInit() != null)
        {
            Visit(context.forInit());
        }
        
        while (true)
        {
            if (context.expresion() != null)
            {
                Value condition = Visit(context.expresion());
                
                if (condition.Type != ValueType.Bool)
                {
                    AddSemanticError(line, column,
                        $"La condición del bucle for debe ser booleana, se obtuvo {condition.Type}.");
                    break;
                }
                
                if (!condition.AsBool())
                    break;
            }
            
            try
            {
                Visit(context.bloque());
            }
            catch (ContinueException)
            {
            }
            
            if (context.forPost() != null)
            {
                Visit(context.forPost());
            }
        }
    }
    catch (BreakException)
    {
    }
    finally
    {
        loopDepth--; 
        currentEnv = previousEnv; 
    }
    
    return null;
}

public override Value VisitIncDecStmt([NotNull] IncDecStmtContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    string varName = context.IDENTIFIER().GetText();

    try
    {
        Value currentValue = currentEnv.GetVariable(varName);
        
        if (currentValue.Type != ValueType.Int && currentValue.Type != ValueType.Float)
        {
            AddSemanticError(line, column, 
                $"El operador de incremento/decremento solo es aplicable a tipos numéricos, se obtuvo {currentValue.Type}.");
            return currentValue;
        }
        
        string op = context.GetChild(1).GetText();
        Value newValue = null;
        
        if (op == "++")
        {
            double updated = ToDouble(currentValue) + 1;
            newValue = currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)updated)
                : new Value(ValueType.Float, updated);
        }
        else if (op == "--")
        {
            double updated = ToDouble(currentValue) - 1;
            newValue = currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)updated)
                : new Value(ValueType.Float, updated);
        }
        else
        {
            AddSemanticError(line, column, $"Operador desconocido: {op}");
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

    
}
