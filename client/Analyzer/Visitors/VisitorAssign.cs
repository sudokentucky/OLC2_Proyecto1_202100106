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
        string assignmentOperator = context.GetChild(1).GetText();
        bool isDeclaration = assignmentOperator == ":=";

        Value rightValue = Visit(context.expresion());

        if (IsStructFieldAssignment(targetIdentifier))
        {
            return HandleStructFieldAssignment(targetIdentifier, rightValue, line, column);
        }

        return HandleVariableAssignment(targetIdentifier, rightValue, assignmentOperator, isDeclaration, line, column);
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

    private Value HandleVariableAssignment(string identifier, Value rightValue, string op, bool isDeclaration, int line, int column)
    {
        if (isDeclaration)
        {
            return DeclareVariable(identifier, rightValue, line, column);
        }

        return AssignVariable(identifier, rightValue, op, line, column);
    }

    private Value DeclareVariable(string identifier, Value rightValue, int line, int column)
    {
        currentEnv.DeclareVariable(identifier, rightValue, line, column);
        return rightValue;
    }

    private Value AssignVariable(string identifier, Value rightValue, string op, int line, int column)
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
