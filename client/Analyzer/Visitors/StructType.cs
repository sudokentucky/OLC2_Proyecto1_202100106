public class StructType
{
    public string Name { get; }
    public Dictionary<string, ValueType> Fields { get; } = new Dictionary<string, ValueType>();

    public StructType(string name) => Name = name;

    public void AddField(string name, ValueType type)
    {
        if (Fields.ContainsKey(name))
            throw new Exception($"El campo '{name}' ya existe en el struct '{Name}'.");
        
        Fields.Add(name, type);
    }

    public bool HasField(string name) => Fields.ContainsKey(name);
}

public class StructInstance : Value
{
    public string StructName { get; }
    public StructType TypeDefinition { get; }
    public Dictionary<string, Value> Fields { get; } = new Dictionary<string, Value>();

    public StructInstance(StructType structType)
        : base(ValueType.Struct, null)
    {
        StructName = structType.Name;
        TypeDefinition = structType;

        foreach (var field in structType.Fields)
        {
            Fields[field.Key] = Value.DefaultForType(field.Value);
        }
    }

    public void SetField(string name, Value value)
    {
        if (!TypeDefinition.HasField(name))
            throw new Exception($"El campo '{name}' no existe en el struct '{StructName}'.");

        var expectedType = TypeDefinition.Fields[name];
        if (expectedType != value.Type)
            throw new Exception($"El campo '{name}' espera un valor de tipo '{expectedType}', se recibió '{value.Type}'.");

        Fields[name] = value;
    }

    public Value GetField(string name)
    {
        if (!Fields.ContainsKey(name))
            throw new Exception($"El campo '{name}' no existe en el struct '{StructName}'.");

        return Fields[name];
    }

    public override string ToString()
    {
        var fieldValues = string.Join(", ", Fields.Select(f => $"{f.Key}: {f.Value}"));
        return $"{StructName} {{ {fieldValues} }}";
    }
}
