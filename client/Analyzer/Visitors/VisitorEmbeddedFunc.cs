using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor{

     public override Value VisitConversionFunc([NotNull] ConversionFuncContext context)
    {
        if (context.ATOI() != null)
        {
            return VisitStrconvAtoi(context);
        }
        else if (context.PARSERFLOAT() != null)
        {
            return VisitStrconvParseFloat(context);
        }
        else if (context.TYPEOF() != null)
        {
            return VisitReflectTypeOf(context);
        }

        AddSemanticError(context.Start.Line, context.Start.Column, 
            $" La funcion {context.GetText()} no es una funcion de conversion valida"
);
        return Value.FromNil();
    }

    private Value VisitStrconvAtoi(ConversionFuncContext context)
    {
        Value strValue = Visit(context.expresion());

        if (strValue.Type != ValueType.String)
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                $"Error en strconv.Atoi: se esperaba un argumento de tipo 'string', pero se recibió  {strValue.Type}");
            return Value.FromNil();
        }

        string str = strValue.AsString();
        
        if (str.Contains("."))
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                $"strconv.Atoi no puede convertir números decimales: '{str}'");
            return Value.FromNil();
        }

        if (int.TryParse(str, out int result))
        {
            return new Value(ValueType.Int, result);
        }
        else
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                $"strconv.Atoi no puede convertir la cadena a entero: '{str}'");
            return Value.FromNil();
        }
    }

    private Value VisitStrconvParseFloat(ConversionFuncContext context)
    {
        Value strValue = Visit(context.expresion());
        if (strValue.Type != ValueType.String)
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                $"strconv.ParseFloat requiere una cadena como argumento, se recibió {strValue.Type}");
            return Value.FromNil();
        }

        string str = strValue.AsString();

        if (double.TryParse(str, out double result))
        {
            return new Value(ValueType.Float, result);
        }
        else
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                $"strconv.ParseFloat no puede convertir la cadena a float: '{str}'");
            return Value.FromNil();
        }
    }

    private Value VisitReflectTypeOf(ConversionFuncContext context)
    {
        Value val = Visit(context.expresion());
        string typeName = GetTypeName(val);
        return new Value(ValueType.String, typeName);
    }

        private string GetTypeName(Value value)
    {
        switch (value.Type)
        {
            case ValueType.Int:
                return "int";
            case ValueType.Float:
                return "float64";
            case ValueType.String:
                return "string";
            case ValueType.Bool:
                return "bool";
            case ValueType.Rune:
                return "rune";
            case ValueType.Slice:
                Slice slice = value.AsSlice();
                return $"[]" + GetTypeNameFromValueType(slice.ElementType);
            case ValueType.Struct:
                StructInstance structInstance = value.AsStruct();
                return structInstance.Type.Name;
            case ValueType.Nil:
                return "nil";
            default:
                return "unknown";
        }
    }
}
