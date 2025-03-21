using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public override Value VisitDeclaracion([NotNull] DeclaracionContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        if (IsStructDeclaration(context))
        {
            return HandleStructDeclaration(context, line, column);
        }

        if (context.ASIGNACION_DECLARACION() != null)
        {
            return HandleShortDeclaration(context, line, column);
        }

        return HandleVariableDeclaration(context, line, column);
    }

    private Value HandleShortDeclaration(DeclaracionContext context, int line, int column)
    {
        string varName = context.IDENTIFIER(0).GetText();
        Value initialValue = Visit(context.expresion());

        if (currentEnv.HasVariableInCurrentScope(varName))
        {
            AddSemanticError(line, column, $"La variable '{varName}' ya ha sido declarada en este ámbito.");
            return Value.FromNil();
        }

        try
        {
            currentEnv.DeclareVariable(varName, initialValue, line, column);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return Value.FromNil();
        }

        return initialValue;
    }

    private bool IsStructDeclaration(DeclaracionContext context)
    {
        if (context.IDENTIFIER().Length != 2)
        {
            return false;
        }

        string typeName = context.IDENTIFIER(0).GetText();
        bool isStruct = table.IsStructType(typeName);

        return isStruct;
    }

    private Value HandleStructDeclaration(DeclaracionContext context, int line, int column)
    {
        string typeName = context.IDENTIFIER(0).GetText();
        string varName = context.IDENTIFIER(1).GetText();

        try
        {
            if (!table.IsStructType(typeName))
            {
                throw new Exception($"El tipo '{typeName}' no es un struct válido");
            }

            StructType structType = table.GetStruct(typeName);
            StructInstance instance = StructInstance.Create(structType);

            if (context.structLiteral() != null)
            {
                var fieldValues = context.structLiteral().fieldValue();
                if (fieldValues != null && fieldValues.Length > 0)
                {
                    foreach (var fieldValueContext in fieldValues)
                    {
                        string fieldName = fieldValueContext.IDENTIFIER().GetText();
                        Value fieldValue = Visit(fieldValueContext.expresion());
                        instance.SetField(fieldName, fieldValue);
                    }
                }
            }

            Value structValue = Value.FromStruct(instance);
            currentEnv.DeclareVariable(varName, structValue, line, column);
            return structValue;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, $"Error declarando struct: {ex.Message}");
            return Value.FromNil();
        }
    }

    private Value HandleVariableDeclaration(DeclaracionContext context, int line, int column)
    {
        string varName = context.IDENTIFIER(0).GetText();
        string typeSpec = GetTypeSpec(context);

        if (IsStructType(typeSpec))
        {
            currentStructTypeName = typeSpec;
        }

        Value initialValue = GetInitialValue(context, typeSpec);
        currentStructTypeName = string.Empty;

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

    private string GetTypeSpec(DeclaracionContext context)
    {
        return context.typeSpec() != null ? context.typeSpec().GetText() : string.Empty;
    }

    private bool IsStructType(string typeSpec)
    {
        return typeSpec != null && table.IsStructType(typeSpec);
    }

    private Value GetInitialValue(DeclaracionContext context, string typeSpec)
    {
        if (context.ASIGNACION() != null)
        {
            return Visit(context.expresion());
        }

        if (typeSpec != null)
        {
            return GetDefaultValueForType(typeSpec);
        }

        return new Value(ValueType.Nil, null!);
    }

    private Value GetDefaultValueForType(string declaredType)
    {
        if (IsPrimitiveType(declaredType, out Value? primitiveValue))
        {
            return primitiveValue!;
        }

        if (IsSliceType(declaredType, out Value sliceValue))
        {
            return sliceValue;
        }

        if (IsStructType(declaredType, out Value structValue))
        {
            return structValue;
        }

        return new Value(ValueType.Nil, null!);
    }

    private bool IsPrimitiveType(string typeName, out Value? value)
    {
        value = typeName switch
        {
            "int" => new Value(ValueType.Int, 0),
            "float64" => new Value(ValueType.Float, 0.0),
            "string" => new Value(ValueType.String, ""),
            "bool" => new Value(ValueType.Bool, false),
            "rune" => new Value(ValueType.Rune, '\0'),
            _ => null
        };

        return value != null;
    }

    private bool IsSliceType(string declaredType, out Value value)
    {
        value = null!;

        if (!declaredType.StartsWith("[]"))
            return false;

        string elementType = declaredType.Substring(2);
        ValueType elementValueType = GetValueTypeFromString(elementType);
        value = new Value(ValueType.Slice, new Slice(elementValueType));

        return true;
    }

    private bool IsStructType(string declaredType, out Value value)
    {
        value = null!;

        if (!table.IsStructType(declaredType))
            return false;

        StructType structType = table.GetStruct(declaredType);
        StructInstance instance = CreateEmptyStructInstance(structType);

        value = Value.FromStruct(instance);
        return true;
    }

    private StructInstance CreateEmptyStructInstance(StructType structType)
    {
        var instance = new StructInstance(structType);

        foreach (var field in structType.Fields)
        {
            var fieldType = field.Value;
            var defaultValue = GetDefaultValueForFieldType(fieldType);
            instance.SetField(field.Key, defaultValue);
        }

        return instance;
    }

    private ValueType GetValueTypeFromString(string typeName)
    {
        if (table.IsStructType(typeName))
            return ValueType.Struct;

        return typeName switch
        {
            "int" => ValueType.Int,
            "float64" => ValueType.Float,
            "string" => ValueType.String,
            "bool" => ValueType.Bool,
            "rune" => ValueType.Rune,
            _ => ValueType.Nil
        };
    }

    private string GetTypeNameFromValueType(ValueType type)
    {
        return type switch
        {
            ValueType.Int => "int",
            ValueType.Float => "float64",
            ValueType.String => "string",
            ValueType.Bool => "bool",
            ValueType.Rune => "rune",
            ValueType.Struct => "struct",
            ValueType.Slice => "slice",
            ValueType.Nil => "nil",
            _ => "unknown"
        };
    }

    private Value GetDefaultValueForFieldType(ValueType type)
    {
        switch (type)
        {
            case ValueType.Int:
                return Value.FromInt(0);
            case ValueType.Float:
                return Value.FromFloat(0.0);
            case ValueType.String:
                return Value.FromString("");
            case ValueType.Bool:
                return Value.FromBool(false);
            case ValueType.Rune:
                return Value.FromRune('\0');
            case ValueType.Slice:
                return new Value(ValueType.Slice, null); 
            case ValueType.Struct:
                return Value.FromNil(); 
            default:
                return Value.FromNil();
        }
    }
}
