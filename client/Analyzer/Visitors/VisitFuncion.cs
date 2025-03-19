using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // Clase para manejar el return en las funciones
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
        
        // Crear la función
        Function function = new Function(functionName, context.bloque(), line, column);
        
        // Procesar parámetros
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
        
        // Procesar tipo de retorno
        if (context.typeSpec() != null)
        {
            function.ReturnType = GetTypeFromTypeSpec(context.typeSpec());
        }
        
        // Registrar la función en la tabla global
        try {
            table.AddFunction(function);
        } catch (Exception ex) {
            AddSemanticError(line, column, ex.Message);
        }
        
        return Value.FromNil();
    }
    
    // Para llamadas a funciones (se usa en VisitPrimary)
    public Value CallFunction(string functionName, Value[] arguments, int line, int column)
    {
        try {
            // Obtener la definición de la función
            Function function = table.GetFunction(functionName);
            
            // Verificar número de argumentos
            if (arguments.Length != function.Parameters.Count)
            {
                AddSemanticError(line, column, 
                    $"La función '{functionName}' espera {function.Parameters.Count} argumentos, " +
                    $"pero se proporcionaron {arguments.Length}");
                return Value.FromNil();
            }
            
            // Crear nuevo entorno para la función
            Environment functionEnv = new Environment(table, null); // Ámbito global para parámetros
            
            // Registrar parámetros en el nuevo entorno
            for (int i = 0; i < function.Parameters.Count; i++)
            {
                var (paramName, paramType) = function.Parameters[i];
                Value argValue = arguments[i];
                
                // Verificar tipos compatibles
                if (!AreTypesCompatible(paramType, argValue.Type))
                {
                    AddSemanticError(line, column, 
                        $"El parámetro '{paramName}' espera tipo {paramType}, " +
                        $"pero se proporcionó {argValue.Type}");
                }
                
                functionEnv.DeclareVariable(paramName, argValue, line, column, functionName);
            }
            
            // Guardar entorno actual y establecer el nuevo
            Environment previousEnv = currentEnv;
            currentEnv = functionEnv;
            
            // Ejecutar el cuerpo de la función
            Value returnValue = Value.FromNil();
            try {
                Visit(function.Body);
            } 
            catch (ReturnException rex) {
                returnValue = rex.Value;
                
                // Verificar tipo de retorno
                if (!AreTypesCompatible(function.ReturnType, returnValue.Type))
                {
                    AddSemanticError(line, column, 
                        $"La función '{functionName}' debe retornar {function.ReturnType}, " +
                        $"pero retornó {returnValue.Type}");
                }
            }
            
            // Restaurar entorno anterior
            currentEnv = previousEnv;
            
            return returnValue;
        }
        catch (Exception ex) {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }
    }
    
    // Método auxiliar para verificar compatibilidad de tipos
    private bool AreTypesCompatible(ValueType expected, ValueType actual)
    {
        if (expected == actual)
            return true;
            
        // Para structs y slices que se pasan por referencia
        if (expected == ValueType.Struct && actual == ValueType.Struct)
            return true;
            
        if (expected == ValueType.Slice && actual == ValueType.Slice)
            return true;
            
        return false;
    }
}