using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public override Value VisitStructDecl([NotNull] gramaticaParser.StructDeclContext context)
    {
        string structName = context.IDENTIFIER().GetText();
        Console.WriteLine("DEBUG: Iniciando declaración de struct: " + structName);
        currentStruct = new StructType(structName);
        
        foreach (var fieldContext in context.fieldDecl())
        {
            Console.WriteLine("DEBUG: Procesando campo en struct '" + structName + "'");
            Visit(fieldContext); 
        }
        
        table.AddStruct(currentStruct);
        Console.WriteLine("DEBUG: Struct '" + structName + "' agregado a la tabla de símbolos.");
        currentStruct = null; 
        return Value.FromNil();
    }

    public override Value VisitFieldDecl([NotNull] gramaticaParser.FieldDeclContext context)
    {
        ValueType fieldType = GetTypeFromTypeSpec(context.typeSpec());
        string fieldName = context.IDENTIFIER().GetText();
        Console.WriteLine("DEBUG: Declarando campo '" + fieldName + "' de tipo " + fieldType.ToString());
        currentStruct.AddField(fieldName, fieldType);
        return Value.FromNil();
    }

    public override Value VisitStructLiteral([NotNull] gramaticaParser.StructLiteralContext context)
    {
        Console.WriteLine("DEBUG: Iniciando instanciación de literal de struct.");
        
        string structTypeName = null;
        
        if (context.Parent is PrimaryContext primary)
        {
            if (primary.Parent?.Parent is DeclaracionContext decl && decl.IDENTIFIER().Length > 1)
            {
                structTypeName = decl.IDENTIFIER(0).GetText();
                Console.WriteLine($"DEBUG: Tipo de struct obtenido desde declaración: '{structTypeName}'");
            }
            else if (primary.Parent?.Parent is AssignacionContext assign)
            {
                try {
                    // Intentar obtener el tipo de la variable izquierda
                    string varName = assign.IDENTIFIER().GetText();
                    Value leftValue = currentEnv.GetVariable(varName);
                    if (leftValue.Type == ValueType.Struct)
                    {
                        structTypeName = leftValue.AsStruct().Type.Name;
                        Console.WriteLine($"DEBUG: Tipo de struct obtenido desde variable: '{structTypeName}'");
                    }
                } catch (Exception) {
                }
            }
        }
        
        if (string.IsNullOrEmpty(structTypeName))
        {
            structTypeName = currentStructTypeName;
            Console.WriteLine($"DEBUG: Usando currentStructTypeName: '{structTypeName}'");
        }
        
        if (string.IsNullOrEmpty(structTypeName))
        {
            string errorMsg = "No se ha especificado un tipo de struct para el literal";
            Console.WriteLine($"ERROR: {errorMsg}");
            AddSemanticError(context.Start.Line, context.Start.Column, errorMsg);
            return Value.FromNil();
        }
        
        StructType structType;
        try
        {
            Console.WriteLine($"DEBUG: Buscando definición del struct '{structTypeName}' en la tabla.");
            structType = table.GetStruct(structTypeName);
        }
        catch (Exception ex)
        {
            AddSemanticError(context.Start.Line, context.Start.Column, ex.Message);
            return Value.FromNil();
        }
        
        StructInstance instance = new StructInstance(structType);
        Console.WriteLine($"DEBUG: Creando instancia de struct del tipo '{structTypeName}'.");
        
        foreach (var field in structType.Fields)
        {
            Value defaultValue = GetDefaultValueForFieldType(field.Value);
            instance.SetField(field.Key, defaultValue);
            Console.WriteLine($"DEBUG: Inicializado campo '{field.Key}' con valor predeterminado para {field.Value}.");
        }
        
        foreach (var fieldValueContext in context.fieldValue())
        {
            string fieldName = fieldValueContext.IDENTIFIER().GetText();
            Console.WriteLine($"DEBUG: Procesando valor para el campo '{fieldName}'.");
            Value fieldValue = Visit(fieldValueContext.expresion());
            Console.WriteLine($"DEBUG: Valor evaluado para '{fieldName}': {fieldValue}");
            try
            {
                instance.SetField(fieldName, fieldValue);
                Console.WriteLine($"DEBUG: Campo '{fieldName}' asignado exitosamente.");
            }
            catch (Exception ex)
            {
                AddSemanticError(fieldValueContext.Start.Line, fieldValueContext.Start.Column, ex.Message);
                Console.WriteLine($"DEBUG: Error asignando el campo '{fieldName}': {ex.Message}");
            }
        }
        
        Console.WriteLine("DEBUG: Instanciación de struct completada.");
        return Value.FromStruct(instance);
    }

    private ValueType GetTypeFromTypeSpec(gramaticaParser.TypeSpecContext context)
    {
        if (context.INT_TYPE() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: Int");
            return ValueType.Int;
        }
        else if (context.FLOAT64_TYPE() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: Float");
            return ValueType.Float;
        }
        else if (context.STRING_TYPE() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: String");
            return ValueType.String;
        }
        else if (context.BOOL_TYPE() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: Bool");
            return ValueType.Bool;
        }
        else if (context.RUNE_TYPE() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: Rune");
            return ValueType.Rune;
        }
        else if (context.sliceType() != null)
        {
            Console.WriteLine("DEBUG: Tipo detectado: Slice");
            Value sliceValue = Visit(context.sliceType());
            return ValueType.Slice; 
        }
        else if (context.IDENTIFIER() != null)
        {
            string structName = context.IDENTIFIER().GetText();
            Console.WriteLine("DEBUG: Tipo detectado de struct: " + structName);
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
        
        Console.WriteLine("DEBUG: Tipo desconocido, retornando Nil.");
        return ValueType.Nil;
    }
}
