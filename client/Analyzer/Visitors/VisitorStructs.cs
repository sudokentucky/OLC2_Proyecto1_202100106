using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    // Conjunto para rastrear structs en proceso de definición
    private HashSet<string> structsBeingDefined = new HashSet<string>();

    public override Value VisitStructDecl([NotNull] StructDeclContext context)
    {
        string structName = context.IDENTIFIER().GetText();
        int line = context.Start.Line;
        int column = context.Start.Column;

        // Detectar si hay campos
        if (context.fieldDecl().Length == 0)
        {
            AddSemanticError(line, column, $"El struct '{structName}' no puede estar vacío");
            return Value.FromNil();
        }

        // Marcar este struct como "en definición"
        structsBeingDefined.Add(structName);

        // Registrar struct en la tabla de símbolos
        currentStruct = new StructType(structName);
        try
        {
            table.AddStruct(currentStruct);
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            structsBeingDefined.Remove(structName);
            return Value.FromNil();
        }

        // Agregar campos
        AddFieldsToStruct(context);

        // Completar la definición
        structsBeingDefined.Remove(structName);
        currentStruct = null;

        return Value.FromNil();
    }

    private void AddFieldsToStruct(StructDeclContext context)
    {
        foreach (var fieldContext in context.fieldDecl())
        {
            Visit(fieldContext);
        }
    }
    
    public override Value VisitFieldDecl([NotNull] FieldDeclContext context)
    {
        ValueType fieldType = GetTypeFromTypeSpec(context.typeSpec());
        string fieldName = context.IDENTIFIER().GetText();

        currentStruct.AddField(fieldName, fieldType);

        return Value.FromNil();
    }

    public override Value VisitStructLiteral([NotNull] StructLiteralContext context)
    {
        string structTypeName = ResolveStructTypeName(context);

        if (string.IsNullOrEmpty(structTypeName))
        {
            AddSemanticError(context.Start.Line, context.Start.Column,
                "No se ha especificado un tipo de struct para el literal");
            return Value.FromNil();
        }

        if (!TryGetStructDefinition(structTypeName, context.Start.Line, context.Start.Column, out StructType structType))
        {
            return Value.FromNil();
        }

        StructInstance instance = InitializeStructInstanceWithDefaults(structType);

        AssignFieldValues(context, instance);

        return Value.FromStruct(instance);
    }

    private string ResolveStructTypeName(StructLiteralContext context)
    {
        if (!string.IsNullOrEmpty(currentStructTypeName))
        {
            return currentStructTypeName;
        }

        if (context.Parent is PrimaryContext primary)
        {
            if (primary.Parent?.Parent is DeclaracionContext decl && decl.IDENTIFIER().Length == 2)
            {
                string typeName = decl.IDENTIFIER(0).GetText();

                if (table.IsStructType(typeName))
                    return typeName;
            }

            if (primary.Parent?.Parent is AssignacionContext assign)
            {
                string varName = assign.IDENTIFIER(0).GetText();

                try
                {
                    Value leftValue = currentEnv.GetVariable(varName);

                    if (leftValue.Type == ValueType.Struct)
                    {
                        string structName = leftValue.AsStruct().StructName;
                        return structName;
                    }
                }
                catch
                {
                    // Ignorar, ya se maneja después si el structName es vacío
                }
            }
        }

        return string.Empty;
    }

    private bool TryGetStructDefinition(string structTypeName, int line, int column, out StructType structType)
    {
        structType = null;

        try
        {
            structType = table.GetStruct(structTypeName);
            return true;
        }
        catch (Exception ex)
        {
            AddSemanticError(line, column, ex.Message);
            return false;
        }
    }

    private StructInstance InitializeStructInstanceWithDefaults(StructType structType)
    {
        var instance = new StructInstance(structType);

        foreach (var field in structType.Fields)
        {
            var defaultValue = GetDefaultValueForFieldType(field.Value);
            instance.SetField(field.Key, defaultValue);
        }

        return instance;
    }

    private void AssignFieldValues(StructLiteralContext context, StructInstance instance)
    {
        foreach (var fieldValueContext in context.fieldValue())
        {
            string fieldName = fieldValueContext.IDENTIFIER().GetText();
            Value fieldValue = Visit(fieldValueContext.expresion());

            try
            {
                instance.SetField(fieldName, fieldValue);
            }
            catch (Exception ex)
            {
                AddSemanticError(fieldValueContext.Start.Line, fieldValueContext.Start.Column, ex.Message);
            }
        }
    }

    private ValueType GetTypeFromTypeSpec(gramaticaParser.TypeSpecContext context)
    {
        if (context.INT_TYPE() != null)
        {
            return ValueType.Int;
        }
        else if (context.FLOAT64_TYPE() != null)
        {
            return ValueType.Float;
        }
        else if (context.STRING_TYPE() != null)
        {
            return ValueType.String;
        }
        else if (context.BOOL_TYPE() != null)
        {
            return ValueType.Bool;
        }
        else if (context.RUNE_TYPE() != null)
        {
            return ValueType.Rune;
        }
        else if (context.sliceType() != null)
        {
            Visit(context.sliceType());
            return ValueType.Slice;
        }
        else if (context.IDENTIFIER() != null)
        {
            string structName = context.IDENTIFIER().GetText();

            try
            {
                table.GetStruct(structName);
                return ValueType.Struct;
            }
            catch (Exception ex)
            {
                AddSemanticError(context.Start.Line, context.Start.Column,
                    $"El tipo '{structName}' no está definido. Detalles: {ex.Message}");
            }
        }

        return ValueType.Nil;
    }
}
