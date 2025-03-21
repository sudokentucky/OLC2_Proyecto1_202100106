using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
public override Value VisitAssignacion([NotNull] AssignacionContext context)
{
    int line = context.Start.Line;
    int column = context.Start.Column;

    string targetIdentifier = context.IDENTIFIER(0).GetText();

    // ✅ Ahora se captura correctamente el operador
    string assignmentOperator;

    if (context.ASIGNACION() != null)
    {
        assignmentOperator = context.ASIGNACION().GetText();
    }
    else if (context.ASIGNACIO_INCREMENTO() != null)
    {
        assignmentOperator = context.ASIGNACIO_INCREMENTO().GetText();
    }
    else if (context.ASIGNACIO_DECREMENTO() != null)
    {
        assignmentOperator = context.ASIGNACIO_DECREMENTO().GetText();
    }
    else
    {
        AddSemanticError(line, column, "Operador de asignación no reconocido.");
        return Value.FromNil();
    }

    int exprCount = context.expresion().Length;
    Value rightValue = Visit(context.expresion(exprCount - 1));

    // Índices del slice (opcional)
    var indices = new List<Value>();
    for (int i = 0; i < context.CORCHETE_IZQ().Length; i++)
    {
        indices.Add(Visit(context.expresion(i)));
    }

    // Cadena de campos (opcional)
    var fieldChain = new List<string>();
    int idCount = context.IDENTIFIER().Length;
    for (int i = 1; i < idCount; i++)
    {
        fieldChain.Add(context.IDENTIFIER(i).GetText());
    }

    return HandleAssignment(targetIdentifier, indices, fieldChain, rightValue, assignmentOperator, line, column);
}

private Value HandleAssignment(
    string identifier,
    List<Value> indices,
    List<string> fieldChain,
    Value rightValue,
    string op,
    int line,
    int column)
{
    try
    {
        Value current = currentEnv.GetVariable(identifier);

        // Caso: acceso a slices con índices
        if (indices.Count > 0)
        {
            return HandleSliceIndexAssignment(current, indices, fieldChain, rightValue, op, line, column);
        }

        // Caso: acceso a campos (struct)
        if (fieldChain.Count > 0)
        {
            return HandleStructFieldAssignment(current.AsStruct(), fieldChain, rightValue, line, column);
        }

        // Asignación simple a variable
        Value result = ApplyAssignmentOperator(current, rightValue, op, line, column);
        currentEnv.SetVariable(identifier, result);
        return result;
    }
    catch (Exception ex)
    {
        AddSemanticError(line, column, ex.Message);
        return Value.FromNil();
    }
}
private Value HandleSliceIndexAssignment(
    Value currentValue,
    List<Value> indices,
    List<string> fieldChain,
    Value rightValue,
    string op,
    int line,
    int column)
{
    // Navegamos el slice
    Slice currentSlice = currentValue.AsSlice();

    for (int i = 0; i < indices.Count - 1; i++)
    {
        int index = indices[i].AsInt();
        Value innerValue = SliceOperations.GetElement(currentSlice, index);

        if (innerValue.Type != ValueType.Slice)
        {
            AddSemanticError(line, column, $"El valor en el índice {index} no es un slice.");
            return Value.FromNil();
        }

        currentSlice = innerValue.AsSlice();
    }

    int lastIndex = indices[^1].AsInt();

    if (fieldChain.Count > 0)
    {
        // Accedemos al struct dentro del slice
        Value targetElement = SliceOperations.GetElement(currentSlice, lastIndex);

        if (targetElement.Type != ValueType.Struct)
        {
            AddSemanticError(line, column, $"El valor en el índice {lastIndex} no es un struct para acceder a campos.");
            return Value.FromNil();
        }

        return HandleStructFieldAssignment(targetElement.AsStruct(), fieldChain, rightValue, line, column);
    }

    // Asignación directa al elemento del slice
    Value oldValue = SliceOperations.GetElement(currentSlice, lastIndex);
    Value result = ApplyAssignmentOperator(oldValue, rightValue, op, line, column);
    SliceOperations.SetElement(currentSlice, lastIndex, result);
    return result;
}
private Value ApplyAssignmentOperator(Value currentValue, Value rightValue, string op, int line, int column)
{
    return op switch
    {
        "=" => rightValue,
        "+=" => ApplyPlusAssign(currentValue, rightValue, line, column),
        "-=" => ApplyMinusAssign(currentValue, rightValue, line, column),
        _ => HandleUnknownOperator(op, currentValue, line, column)
    };
}

private Value HandleStructFieldAssignment(StructInstance structInstance, List<string> fieldChain, Value rightValue, int line, int column)
{
    for (int i = 0; i < fieldChain.Count - 1; i++)
    {
        string field = fieldChain[i];
        Value nested = structInstance.GetField(field);

        if (nested.Type != ValueType.Struct)
        {
            AddSemanticError(line, column, $"El campo {field} no es un struct.");
            return Value.FromNil();
        }

        structInstance = nested.AsStruct();
    }

    string finalField = fieldChain[^1];

    try
    {
        structInstance.SetField(finalField, rightValue);
        return rightValue;
    }
    catch (Exception ex)
    {
        AddSemanticError(line, column, ex.Message);
        return Value.FromNil();
    }
}



    private bool IsStructFieldAssignment(string identifier)
    {
        return identifier.Contains(".");
    }

    private Value HandleStructFieldAssignment(string identifier, Value rightValue, int line, int column)
    {
        string[] fieldPath = identifier.Split('.');
        string structVariableName = fieldPath[0];

        Value structValue = currentEnv.GetVariable(structVariableName);
        if (structValue.Type != ValueType.Struct)
        {
            AddSemanticError(line, column, $"{structVariableName} no es un struct");
            return Value.FromNil();
        }

        StructInstance structInstance = structValue.AsStruct();

        for (int i = 1; i < fieldPath.Length - 1; i++)
        {
            string fieldName = fieldPath[i];
            if (!TryGetNestedStructField(structInstance!, fieldName, out structInstance!, line, column))
            {
                return Value.FromNil();
            }
        }

        string finalFieldName = fieldPath[^1];
        if (!TrySetStructField(structInstance, finalFieldName, rightValue, line, column))
        {
            return Value.FromNil();
        }

        return rightValue;
    }

    private bool TryGetNestedStructField(StructInstance instance, string fieldName, out StructInstance? nestedInstance, int line, int column)
    {
        nestedInstance = null;

        try
        {
            Value fieldValue = instance.GetField(fieldName);
            if (fieldValue.Type != ValueType.Struct)
            {
                AddSemanticError(line, column, $"El campo {fieldName} no es un struct y no permite acceso anidado");
                return false;
            }

            nestedInstance = fieldValue.AsStruct();
            return true;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return false;
        }
    }

    private bool TrySetStructField(StructInstance instance, string fieldName, Value value, int line, int column)
    {
        try
        {
            instance.SetField(fieldName, value);
            return true;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return false;
        }
    }

    private Value HandleVariableAssignment(string identifier, Value rightValue, string op, int line, int column)
    {
        try
        {
            Value currentValue = currentEnv.GetVariable(identifier);

            Value result = op switch
            {
                "=" => rightValue,
                "+=" => ApplyPlusAssign(currentValue, rightValue, line, column),
                "-=" => ApplyMinusAssign(currentValue, rightValue, line, column),
                _ => HandleUnknownOperator(op, currentValue, line, column)
            };

            currentEnv.SetVariable(identifier, result);
            return result;
        }
        catch (Exception)
        {
            AddSemanticError(line, column, $"Variable '{identifier}' no existe.");
            return Value.FromNil();
        }
    }

    private Value HandleUnknownOperator(string op, Value currentValue, int line, int column)
    {
        AddSemanticError(line, column, $"Operador de asignación desconocido: {op}");
        return currentValue;
    }

    private Value ApplyPlusAssign(Value currentValue, Value rightValue, int line, int column)
    {
        if (IsNumeric(currentValue) != 0 && IsNumeric(rightValue) != 0)
        {
            if (currentValue.Type != rightValue.Type)
            {
                AddSemanticError(line, column, $"No se puede aplicar '+=' entre tipos diferentes: {currentValue.Type} y {rightValue.Type}.");
                return currentValue;
            }

            double sum = ToDouble(currentValue) + ToDouble(rightValue);
            return currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)sum)
                : new Value(ValueType.Float, sum);
        }

        if (currentValue.Type == ValueType.String && rightValue.Type == ValueType.String)
        {
            return new Value(ValueType.String, currentValue.AsString() + rightValue.AsString());
        }

        AddSemanticError(line, column, $"No se puede aplicar '+=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }

    private Value ApplyMinusAssign(Value currentValue, Value rightValue, int line, int column)
    {
        if (IsNumeric(currentValue) != 0 && IsNumeric(rightValue) != 0)
        {
            if (currentValue.Type != rightValue.Type)
            {
                AddSemanticError(line, column, $"No se puede aplicar '-=' entre tipos diferentes: {currentValue.Type} y {rightValue.Type}.");
                return currentValue;
            }

            double diff = ToDouble(currentValue) - ToDouble(rightValue);
            return currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)diff)
                : new Value(ValueType.Float, diff);
        }

        AddSemanticError(line, column, $"No se puede aplicar '-=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }
}
