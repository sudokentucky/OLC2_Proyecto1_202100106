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
    
    public override Value VisitFuncDecl([NotNull] gramaticaParser.FuncDeclContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        
        string functionName = context.IDENTIFIER().GetText();
        
        Function function = new Function(functionName, context.bloque(), line, column);
        
        if (context.paramsList() != null)
        {
            foreach (var param in context.paramsList().param())
            {
                string paramName = param.IDENTIFIER().GetText();
                ValueType paramType = GetTypeFromTypeSpec(param.typeSpec());
                
                try {
                    function.AddParameter(paramName, paramType);
                } catch (Exception ex) {
                    AddSemanticError(line, column, ex.Message);
                }
            }
        }
        
        if (context.typeSpec() != null)
        {
            function.ReturnType = GetTypeFromTypeSpec(context.typeSpec());
        }
        
        try {
            table.AddFunction(function);
        } catch (Exception ex) {
            AddSemanticError(line, column, ex.Message);
        }
        
        return Value.FromNil();
    }
    public override Value VisitFunctCall([NotNull] gramaticaParser.FunctCallContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        
        string funcName = context.IDENTIFIER().GetText();
        Value[] arguments = new Value[0];
        if (context.argumentList() != null)
        {
            var exprs = context.argumentList().expresion();
            arguments = new Value[exprs.Length];
            for (int i = 0; i < exprs.Length; i++)
                arguments[i] = Visit(exprs[i]);
        }
        
        return CallFunction(funcName, arguments, line, column);
    }

    public Value CallFunction(string functionName, Value[] arguments, int line, int column)
    {
        try {
            Function function = table.GetFunction(functionName);
            if (arguments.Length != function.Parameters.Count)
            {
                AddSemanticError(line, column, 
                    $"La función '{functionName}' espera {function.Parameters.Count} argumentos, " +
                    $"pero se proporcionaron {arguments.Length}");
                return Value.FromNil();
            }
            
            Environment functionEnv = new Environment(table, null); 
            
            for (int i = 0; i < function.Parameters.Count; i++)
            {
                var (paramName, paramType) = function.Parameters[i];
                Value argValue = arguments[i];
                
                if (!AreTypesCompatible(paramType, argValue.Type))
                {
                    AddSemanticError(line, column, 
                        $"El parámetro '{paramName}' espera tipo {paramType}, " +
                        $"pero se proporcionó {argValue.Type}");
                }
                
                functionEnv.DeclareVariable(paramName, argValue, line, column, functionName);
            }
            
            Environment previousEnv = currentEnv;
            currentEnv = functionEnv;
            
            Value returnValue = Value.FromNil();
            try {
                Visit(function.Body);
            } 
            catch (ReturnException rex) {
                returnValue = rex.Value;
                
                if (!AreTypesCompatible(function.ReturnType, returnValue.Type))
                {
                    AddSemanticError(line, column, 
                        $"La función '{functionName}' debe retornar {function.ReturnType}, " +
                        $"pero retornó {returnValue.Type}");
                }
            }
            
            currentEnv = previousEnv;
            
            return returnValue;
        }
        catch (Exception ex) {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }
    }
    
    private bool AreTypesCompatible(ValueType expected, ValueType actual)
    {
        if (expected == actual)
            return true;
            
        if (expected == ValueType.Struct && actual == ValueType.Struct)
            return true;
            
        if (expected == ValueType.Slice && actual == ValueType.Slice)
            return true;
            
        return false;
    }
}