using System;
using System.Collections.Generic;
using System.Linq;

public class StructType
{
    public string Name { get; }
    public Dictionary<string, ValueType> Fields { get; } = new Dictionary<string, ValueType>();
    
    public Dictionary<string, Function> Methods { get; } = new Dictionary<string, Function>();

    public StructType(string name) => Name = name;

    public void AddField(string name, ValueType type)
    {
        if (Fields.ContainsKey(name))
            throw new Exception($"El campo '{name}' ya existe en el struct '{Name}'.");
        
        Fields.Add(name, type);
    }

    public bool HasField(string name) => Fields.ContainsKey(name);

    public void AddMethod(string name, Function method)
    {
        if (Methods.ContainsKey(name))
            throw new Exception($"El método '{name}' ya existe en el struct '{Name}'.");
        
        Methods.Add(name, method);
        Console.WriteLine($"DEBUG: Método '{name}' agregado al struct '{Name}'");
    }

    public bool HasMethod(string name) => Methods.ContainsKey(name);

    public Function GetMethod(string name)
    {
        if (!Methods.ContainsKey(name))
            throw new Exception($"El método '{name}' no existe en el struct '{Name}'.");
        
        return Methods[name];
    }
    
    public IEnumerable<string> GetMethodNames() => Methods.Keys;
}

public class StructInstance : Value
{
    public string StructName { get; private set; }
    public StructType Type { get; private set; }
    public Dictionary<string, Value> Fields { get; } = new Dictionary<string, Value>();
    
    public StructInstance(StructType structType) 
        : base(ValueType.Struct) 
    {
        if (structType == null)
            throw new Exception("No se puede crear una instancia de struct con un tipo nulo");
            
        Type = structType;
        StructName = structType.Name;
        
        this.Data = this;
    }
    
    public static StructInstance Create(StructType structType)
    {
        if (structType == null)
            throw new Exception("No se puede crear una instancia de struct con un tipo nulo");
            
        var instance = new StructInstance(structType);
        
        // Inicializar campos con valores predeterminados
        foreach (var field in structType.Fields)
        {
            var defaultValue = Value.DefaultForType(field.Value);
            instance.Fields[field.Key] = defaultValue;
        }
        
        return instance;
    }
    

    public void SetField(string name, Value value)
    {
        if (!Type.HasField(name))
            throw new Exception($"El campo '{name}' no existe en el struct '{StructName}'.");

        var expectedType = Type.Fields[name];
        if (expectedType != value.Type && value.Type != ValueType.Nil)
            throw new Exception($"El campo '{name}' espera un valor de tipo '{expectedType}', se recibió '{value.Type}'.");

        Fields[name] = value;
    }

    public Value GetField(string name)
    {
        if (!Fields.ContainsKey(name))
            throw new Exception($"El campo '{name}' no existe en el struct '{StructName}'.");

        return Fields[name];
    }
    
    public bool HasMethod(string name) => Type.HasMethod(name);
    
    public Function GetMethod(string name) => Type.GetMethod(name);

    public override string ToString()
    {
        var fieldValues = string.Join(", ", Fields.Select(f => $"{f.Key}: {f.Value}"));
        return $"{StructName} {{ {fieldValues} }}";
    }
    

}