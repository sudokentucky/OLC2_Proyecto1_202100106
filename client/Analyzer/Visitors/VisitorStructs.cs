using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;
public partial class Visitor{
public override Value VisitStructDecl([NotNull] gramaticaParser.StructDeclContext context) {
    string structName = context.IDENTIFIER().GetText();
    currentStruct = new StructType(structName);
    
    // Procesar cada campo
    foreach (var fieldContext in context.fieldDecl()) {
        Visit(fieldContext); // Añade campos al struct
    }
    
    // Registrar en tabla de símbolos global
    table.AddStruct(currentStruct);
    currentStruct = null; // Limpiar la referencia
    return Value.FromNil();
}

public override Value VisitFieldDecl([NotNull] gramaticaParser.FieldDeclContext context) {
    ValueType fieldType = GetTypeFromTypeSpec(context.typeSpec());
    string fieldName = context.IDENTIFIER().GetText();
    
    // Añadir al struct actual en construcción
    currentStruct.AddField(fieldName, fieldType);
    return Value.FromNil();
}

public override Value VisitStructLiteral([NotNull] gramaticaParser.StructLiteralContext context)
{
    if (string.IsNullOrEmpty(currentStructTypeName)) {
        AddSemanticError(context.Start.Line, context.Start.Column, 
            "No se ha especificado un tipo de struct para el literal");
        return Value.FromNil();
    }
    
    StructType structType;
    try {
        structType = table.GetStruct(currentStructTypeName);
    } catch (Exception ex) {
        AddSemanticError(context.Start.Line, context.Start.Column, ex.Message);
        return Value.FromNil();
    }
    
    StructInstance instance = new StructInstance(structType);
    
    // Procesar cada par campo-valor
    foreach (var fieldValueContext in context.fieldValue()) {
        string fieldName = fieldValueContext.IDENTIFIER().GetText();
        Value fieldValue = Visit(fieldValueContext.expresion());
        
        try {
            instance.SetField(fieldName, fieldValue);
        } catch (Exception ex) {
            AddSemanticError(fieldValueContext.Start.Line, fieldValueContext.Start.Column, ex.Message);
        }
    }
    
    return Value.FromStruct(instance);
}

private ValueType GetTypeFromTypeSpec(gramaticaParser.TypeSpecContext context)
{
    if (context.INT_TYPE() != null)
        return ValueType.Int;
    else if (context.FLOAT64_TYPE() != null)
        return ValueType.Float;
    else if (context.STRING_TYPE() != null)
        return ValueType.String;
    else if (context.BOOL_TYPE() != null)
        return ValueType.Bool;
    else if (context.RUNE_TYPE() != null)
        return ValueType.Rune;
    else if (context.sliceType() != null)
    {
        Value sliceValue = Visit(context.sliceType());
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
        catch
        {
            AddSemanticError(context.Start.Line, context.Start.Column, 
                $"El tipo '{structName}' no está definido.");
        }
    }
    
    return ValueType.Nil;
}
}