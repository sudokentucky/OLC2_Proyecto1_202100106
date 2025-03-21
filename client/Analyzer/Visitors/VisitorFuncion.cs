using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public class ReturnException : Exception
    {
        public Value Value { get; }

        public ReturnException(Value value) : base("Return statement")
        {
            Value = value;
        }
    }

    public override Value VisitFuncDecl([NotNull] FuncDeclContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (context.IDENTIFIER().Length > 1 && context.PARENTESIS_IZQ().Length > 1)
        {
            return HandleStructMethod(context, line, column);
        }

        string functionName = context.IDENTIFIER()[0].GetText();
        Function function = CreateFunctionFromContext(context, functionName, line, column);

        try
        {
            table.AddFunction(function);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
        }

        return Value.FromNil();
    }

    private Value HandleStructMethod(FuncDeclContext context, int line, int column)
    {
        string receiverVar = context.IDENTIFIER()[0].GetText();
        string structTypeName = context.IDENTIFIER()[1].GetText();
        string methodName = context.IDENTIFIER()[2].GetText();

        bool isPointerReceiver = structTypeName.StartsWith("*");
        if (isPointerReceiver)
        {
            structTypeName = structTypeName.Substring(1);
        }

        try
        {
            StructType structType = table.GetStruct(structTypeName);

            Function method = CreateFunctionFromContext(context, methodName, line, column);

            method.IsStructMethod = true;
            method.StructType = structTypeName;
            method.ReceiverName = receiverVar;
            method.IsPointerReceiver = true;

            structType.AddMethod(methodName, method);

            return Value.FromNil();
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, $"Error al definir método de struct: {ex.Message}");
            return Value.FromNil();
        }
    }

    private Function CreateFunctionFromContext(FuncDeclContext context, string functionName, int line, int column)
    {
        var function = new Function(functionName, context.bloque(), line, column);

        AddFunctionParameters(context, function, line, column);
        SetFunctionReturnType(context, function);

        return function;
    }

    private void AddFunctionParameters(FuncDeclContext context, Function function, int line, int column)
    {
        if (context.paramsList() == null)
            return;

        foreach (var param in context.paramsList().param())
        {
            string paramName = param.IDENTIFIER().GetText();
            ValueType paramType = GetTypeFromTypeSpec(param.typeSpec());

            try
            {
                function.AddParameter(paramName, paramType);
            }
            catch (Exception ex)
            {
                AddSemanticError(line, column, ex.Message);
            }
        }
    }

    private void SetFunctionReturnType(FuncDeclContext context, Function function)
    {
        if (context.typeSpec() != null)
        {
            function.ReturnType = GetTypeFromTypeSpec(context.typeSpec());
        }
    }

    public override Value VisitFunctCall([NotNull] FunctCallContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (context.PUNTO().Length > 0)
        {
            return HandleStructMethodCall(context, line, column);
        }

        string funcName = context.IDENTIFIER()[0].GetText();
        Value[] arguments = GetFunctionArguments(context);

        return CallFunction(funcName, arguments, line, column);
    }

    private Value HandleStructMethodCall(FunctCallContext context, int line, int column)
    {
        string instanceName = context.IDENTIFIER()[0].GetText();
        string methodName = context.IDENTIFIER()[1].GetText();

        try
        {
            Value instanceValue = currentEnv.GetVariable(instanceName);

            if (instanceValue.Type != ValueType.Struct)
            {
                AddSemanticError(line, column, $"La variable '{instanceName}' no es un struct.");
                return Value.FromNil();
            }

            StructInstance instance = instanceValue.AsStruct();

            if (!instance.HasMethod(methodName))
            {
                AddSemanticError(line, column, $"El método '{methodName}' no existe en el struct '{instance.StructName}'.");
                return Value.FromNil();
            }

            Function method = instance.GetMethod(methodName);
            Value[] userArguments = GetFunctionArguments(context);

            Value[] allArguments = new Value[userArguments.Length + 1];
            allArguments[0] = instanceValue;
            Array.Copy(userArguments, 0, allArguments, 1, userArguments.Length);

            Value result = ExecuteStructMethod(instance, method, allArguments, line, column);
            return result;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }
    }

    private Value ExecuteStructMethod(StructInstance instance, Function method, Value[] arguments, int line, int column)
    {
        if (arguments.Length != method.Parameters.Count + 1)
        {
            AddSemanticError(line, column, $"El método '{method.Name}' espera {method.Parameters.Count} argumentos explícitos, pero se proporcionaron {arguments.Length - 1}");
            return Value.FromNil();
        }

        Environment methodEnv = new Environment(table, null);
        methodEnv.DeclareVariable(method.ReceiverName, arguments[0], line, column, "Receptor");

        for (int i = 0; i < method.Parameters.Count; i++)
        {
            var (paramName, paramType) = method.Parameters[i];
            var argumentValue = arguments[i + 1];
            methodEnv.DeclareVariable(paramName, argumentValue, line, column, method.Name);
        }

        var previousEnv = currentEnv;
        currentEnv = methodEnv;

        Value returnValue = Value.FromNil();

        try
        {
            Visit(method.Body);

            if (method.IsPointerReceiver)
            {
                Value modifiedValue = methodEnv.GetVariable(method.ReceiverName);
                if (modifiedValue.Type == ValueType.Struct)
                {
                    StructInstance modifiedInstance = modifiedValue.AsStruct();
                    foreach (var field in modifiedInstance.Fields)
                    {
                        instance.SetField(field.Key, field.Value);
                    }
                }
            }
        }
        catch (ReturnException rex)
        {
            returnValue = rex.Value;
        }
        finally
        {
            currentEnv = previousEnv;
        }

        return returnValue;
    }

    private Value[] GetFunctionArguments(FunctCallContext context)
    {
        if (context.argumentList() == null)
            return Array.Empty<Value>();

        var expressions = context.argumentList().expresion();
        var arguments = new Value[expressions.Length];

        for (int i = 0; i < expressions.Length; i++)
        {
            arguments[i] = Visit(expressions[i]);
        }

        return arguments;
    }

    public Value CallFunction(string functionName, Value[] arguments, int line, int column)
    {
        try
        {
            Function function = table.GetFunction(functionName);

            if (!HasCorrectArgumentCount(function, arguments, line, column))
                return Value.FromNil();

            Environment functionEnv = CreateFunctionEnvironment(function, arguments, line, column);

            return ExecuteFunctionBody(function, functionEnv, line, column);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }
    }

    
    private bool HasCorrectArgumentCount(Function function, Value[] arguments, int line, int column)
    {
        if (arguments.Length == function.Parameters.Count)
            return true;

        AddSemanticError(line, column, $"La función '{function.Name}' espera {function.Parameters.Count} argumentos, pero se proporcionaron {arguments.Length}");
        return false;
    }

    private Environment CreateFunctionEnvironment(Function function, Value[] arguments, int line, int column)
    {
        var functionEnv = new Environment(table, null);

        for (int i = 0; i < function.Parameters.Count; i++)
        {
            var (paramName, paramType) = function.Parameters[i];
            var argumentValue = arguments[i];

            if (argumentValue.Type == ValueType.Struct)
            {
                functionEnv.DeclareVariable(paramName, argumentValue, line, column, function.Name);
            }
            else
            {
                if (!AreTypesCompatible(paramType, argumentValue.Type))
                {
                    AddSemanticError(line, column, $"El parámetro '{paramName}' espera tipo {paramType}, pero se proporcionó {argumentValue.Type}");
                }

                functionEnv.DeclareVariable(paramName, argumentValue, line, column, function.Name);
            }
        }

        return functionEnv;
    }

    private Value ExecuteFunctionBody(Function function, Environment functionEnv, int line, int column)
    {
        var previousEnv = currentEnv;
        currentEnv = functionEnv;

        Value returnValue = Value.FromNil();

        try
        {
            Visit(function.Body);
        }
        catch (ReturnException rex)
        {
            returnValue = rex.Value;
            ValidateFunctionReturnType(function, returnValue, line, column);
        }
        finally
        {
            currentEnv = previousEnv;
        }

        return returnValue;
    }

    private void ValidateFunctionReturnType(Function function, Value returnValue, int line, int column)
    {
        if (!AreTypesCompatible(function.ReturnType, returnValue.Type))
        {
            AddSemanticError(line, column, $"La función '{function.Name}' debe retornar {function.ReturnType}, pero retornó {returnValue.Type}");
        }
    }

    private bool AreTypesCompatible(ValueType expected, ValueType actual)
    {
        return expected == actual ||
               (expected == ValueType.Struct && actual == ValueType.Struct) ||
               (expected == ValueType.Slice && actual == ValueType.Slice);
    }
}
