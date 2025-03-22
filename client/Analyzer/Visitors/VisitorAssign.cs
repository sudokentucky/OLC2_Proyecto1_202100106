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
        string assignmentOperator = GetAssignmentOperator(context, line, column);
        if (assignmentOperator == null)
            return Value.FromNil();

        Value rightValue = Visit(context.expresion(context.expresion().Length - 1));
        List<Value> indices = GetIndicesFromContext(context);
        List<string> fieldChain = GetFieldChainFromContext(context);

        return HandleAssignment(targetIdentifier, indices, fieldChain, rightValue, assignmentOperator, line, column);
    }

    private string GetAssignmentOperator(AssignacionContext context, int line, int column)
    {
        if (context.ASIGNACION() != null)
            return context.ASIGNACION().GetText();

        if (context.ASIGNACIO_INCREMENTO() != null)
            return context.ASIGNACIO_INCREMENTO().GetText();

        if (context.ASIGNACIO_DECREMENTO() != null)
            return context.ASIGNACIO_DECREMENTO().GetText();

        AddSemanticError(line, column, "Operador de asignación no reconocido.");
        return null;
    }

    private List<Value> GetIndicesFromContext(AssignacionContext context)
    {
        var indices = new List<Value>();
        int count = context.CORCHETE_IZQ().Length;

        for (int i = 0; i < count; i++)
            indices.Add(Visit(context.expresion(i)));

        return indices;
    }

    private List<string> GetFieldChainFromContext(AssignacionContext context)
    {
        var fieldChain = new List<string>();
        int count = context.IDENTIFIER().Length;

        for (int i = 1; i < count; i++)
            fieldChain.Add(context.IDENTIFIER(i).GetText());

        return fieldChain;
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
            Value currentValue = currentEnv.GetVariable(identifier);

            if (indices.Count > 0)
                return HandleSliceAssignment(currentValue, indices, fieldChain, rightValue, op, line, column);

            if (fieldChain.Count > 0)
                return HandleStructAssignment(currentValue.AsStruct(), fieldChain, rightValue, line, column);

            Value result = ApplyAssignmentOperator(currentValue, rightValue, op, line, column);
            currentEnv.SetVariable(identifier, result);
            return result;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }
    }

    private Value HandleSliceAssignment(
        Value currentValue,
        List<Value> indices,
        List<string> fieldChain,
        Value rightValue,
        string op,
        int line,
        int column)
    {
        Slice slice = currentValue.AsSlice();

        for (int i = 0; i < indices.Count - 1; i++)
        {
            int index = indices[i].AsInt();
            Value innerValue = SliceOperations.GetElement(slice, index);

            if (innerValue.Type != ValueType.Slice)
            {
                AddSemanticError(line, column, $"El valor en el índice {index} no es un slice.");
                return Value.FromNil();
            }

            slice = innerValue.AsSlice();
        }

        int lastIndex = indices[^1].AsInt();

        if (fieldChain.Count > 0)
            return AssignToStructInSlice(slice, lastIndex, fieldChain, rightValue, line, column);

        return AssignToSliceElement(slice, lastIndex, rightValue, op, line, column);
    }

    private Value AssignToStructInSlice(
        Slice slice,
        int index,
        List<string> fieldChain,
        Value rightValue,
        int line,
        int column)
    {
        Value targetElement = SliceOperations.GetElement(slice, index);

        if (targetElement.Type != ValueType.Struct)
        {
            AddSemanticError(line, column, $"El valor en el índice {index} no es un struct para acceder a campos.");
            return Value.FromNil();
        }

        return HandleStructAssignment(targetElement.AsStruct(), fieldChain, rightValue, line, column);
    }

    private Value AssignToSliceElement(
        Slice slice,
        int index,
        Value rightValue,
        string op,
        int line,
        int column)
    {
        Value oldValue = SliceOperations.GetElement(slice, index);
        Value result = ApplyAssignmentOperator(oldValue, rightValue, op, line, column);

        SliceOperations.SetElement(slice, index, result);
        return result;
    }

    private Value HandleStructAssignment(
        StructInstance structInstance,
        List<string> fieldChain,
        Value rightValue,
        int line,
        int column)
    {
        for (int i = 0; i < fieldChain.Count - 1; i++)
        {
            string field = fieldChain[i];
            Value nestedValue = structInstance.GetField(field);

            if (nestedValue.Type != ValueType.Struct)
            {
                AddSemanticError(line, column, $"El campo {field} no es un struct.");
                return Value.FromNil();
            }

            structInstance = nestedValue.AsStruct();
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

    private Value ApplyAssignmentOperator(
        Value currentValue,
        Value rightValue,
        string op,
        int line,
        int column)
    {
        return op switch
        {
            "=" => rightValue,
            "+=" => ApplyPlusAssignment(currentValue, rightValue, line, column),
            "-=" => ApplyMinusAssignment(currentValue, rightValue, line, column),
            _ => HandleUnknownOperator(op, currentValue, line, column)
        };
    }

    private Value ApplyPlusAssignment(
        Value currentValue,
        Value rightValue,
        int line,
        int column)
    {
        if (AreSameNumericTypes(currentValue, rightValue, line, column, "+="))
        {
            double sum = ToDouble(currentValue) + ToDouble(rightValue);
            return currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)sum)
                : new Value(ValueType.Float, sum);
        }

        if (currentValue.Type == ValueType.String && rightValue.Type == ValueType.String)
        {
            string concatenated = currentValue.AsString() + rightValue.AsString();
            return new Value(ValueType.String, concatenated);
        }

        AddSemanticError(line, column, $"No se puede aplicar '+=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }

    private Value ApplyMinusAssignment(
        Value currentValue,
        Value rightValue,
        int line,
        int column)
    {
        if (AreSameNumericTypes(currentValue, rightValue, line, column, "-="))
        {
            double difference = ToDouble(currentValue) - ToDouble(rightValue);
            return currentValue.Type == ValueType.Int
                ? new Value(ValueType.Int, (int)difference)
                : new Value(ValueType.Float, difference);
        }

        AddSemanticError(line, column, $"No se puede aplicar '-=' entre {currentValue.Type} y {rightValue.Type}.");
        return currentValue;
    }

    private bool AreSameNumericTypes(
        Value leftValue,
        Value rightValue,
        int line,
        int column,
        string op)
    {
        if (IsNumeric(leftValue) == 0 || IsNumeric(rightValue) == 0)
            return false;

        if (leftValue.Type != rightValue.Type)
        {
            AddSemanticError(line, column, $"No se puede aplicar '{op}' entre tipos diferentes: {leftValue.Type} y {rightValue.Type}.");
            return false;
        }

        return true;
    }

    private Value HandleUnknownOperator(
        string op,
        Value currentValue,
        int line,
        int column)
    {
        AddSemanticError(line, column, $"Operador de asignación desconocido: {op}");
        return currentValue;
    }
}
