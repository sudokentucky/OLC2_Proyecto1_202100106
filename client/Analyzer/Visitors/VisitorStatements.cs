using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
public override Value VisitDeclaracion([NotNull] DeclaracionContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        string varName = context.IDENTIFIER().GetText();

        string? typeSpec = context.typeSpec() != null ? context.typeSpec().GetText() : null;

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
            return new Value(ValueType.Nil, null);
    }
}


    public override Value VisitExprStmt([NotNull] ExprStmtContext context)
    {
        return Visit(context.expresion());
    }

    public override Value VisitPrintStmt([NotNull] PrintStmtContext context)
{
    // Caso simple: sin argumentos
    if (context.argumentList() == null || context.argumentList().expresion().Length == 0)
    {
        Output += "\n"; // Solo imprime una línea vacía
        return null;
    }
    
    // Obtener y evaluar todos los argumentos
    var args = VisitArgumentList(context.argumentList());
    
    // Convertir a string y unir con espacios
    string outputLine = string.Join(" ", args.Select(ValueToString));
    
    // Agregar al output con salto de línea
    Output += outputLine + "\n";
    
    return null;
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
    
    // Ejecutar todas las instrucciones del bloque
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
    
    foreach (var caseStmt in context.caseStmt())
    {
        Value caseValue = Visit(caseStmt.expresion());
        
        bool areEqual = CompareValuesForEquality(switchValue, caseValue, line, column);
        
        if (areEqual)
        {
            caseMatched = true;
            
            foreach (var instruction in caseStmt.instruction())
            {
                Visit(instruction);
            }
            
            break;
        }
    }
    
    if (!caseMatched && context.defaultStmt() != null)
    {
        foreach (var instruction in context.defaultStmt().instruction())
        {
            Visit(instruction);
        }
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
            
        Visit(context.bloque());
    }
    
    return null;
}

public override Value VisitForThreePartStmt([NotNull] ForThreePartStmtContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;
    Environment previousEnv = currentEnv;
    currentEnv = new Environment(table, previousEnv);
    
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
            
            Visit(context.bloque());
            
            if (context.forPost() != null)
            {
                Visit(context.forPost());
            }
        }
    }
    finally
    {
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
