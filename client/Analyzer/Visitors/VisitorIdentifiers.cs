using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    private Value EvaluateIdentifier(PrimaryContext context, int line, int column)
    {
        if (context.IDENTIFIER() == null || context.IDENTIFIER().Length == 0)
        {
            AddSemanticError(line, column, "Identificador no encontrado.");
            return Value.FromNil();
        }

        string varName = context.IDENTIFIER(0).GetText();

        if (varName == "true") return new Value(ValueType.Bool, true);
        if (varName == "false") return new Value(ValueType.Bool, false);

        Value currentValue = GetVariableValue(varName, line, column);
        currentValue = EvaluateIndices(currentValue, context, varName, line, column);
        currentValue = EvaluateFieldAccess(currentValue, context, varName, line, column);

        return currentValue;
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
            return Value.FromNil();
        }
    }

    private Value EvaluateIndices(Value currentValue, PrimaryContext context, string varName, int line, int column)
    {
        var indexNodes = context.CORCHETE_IZQ();
        if (indexNodes == null || indexNodes.Length == 0)
            return currentValue;

        var expressionList = context.expresion();
        for (int i = 0; i < expressionList.Length; i++)
        {
            Value idxValue = Visit(expressionList[i]);
            if (idxValue.Type != ValueType.Int)
            {
                AddSemanticError(line, column, "El índice debe ser de tipo entero.");
                return Value.FromNil();
            }

            if (currentValue.Type != ValueType.Slice)
            {
                AddSemanticError(line, column, $"El valor de '{varName}' no es indexable.");
                return currentValue;
            }

            try
            {
                Slice s = currentValue.AsSlice();
                currentValue = s[idxValue.AsInt()];
            }
            catch (Exception ex)
            {
                AddSemanticError(line, column, ex.Message);
                return Value.FromNil();
            }
        }

        return currentValue;
    }

    private Value EvaluateFieldAccess(Value currentValue, PrimaryContext context, string varName, int line, int column)
    {
        var puntoNodes = context.PUNTO();
        var identifiers = context.IDENTIFIER();

        if (puntoNodes == null || puntoNodes.Length == 0)
            return currentValue;

        for (int i = 0; i < puntoNodes.Length; i++)
        {
            if (i + 1 >= identifiers.Length)
            {
                AddSemanticError(line, column, "Se esperaba un nombre de campo después del punto.");
                return Value.FromNil();
            }

            string fieldName = identifiers[i + 1].GetText();

            if (currentValue.Type != ValueType.Struct)
            {
                AddSemanticError(line, column, $"No se puede acceder a campos en {currentValue.Type}.");
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

        return currentValue;
    }
}
