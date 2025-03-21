public enum ValueType
{
    Int,
    Float,
    String,
    Bool,
    Rune,
    Slice,
    Struct,
    Nil
}

public class Value
{
    public ValueType Type { get; protected set; }
    public object Data { get; protected set; }

    public Value(ValueType type, object data)
    {
        if (!ValidateType(type, data))
            throw new Exception($"El tipo {data?.GetType()} no es válido para {type}.");

        Type = type;
        Data = data;
    }

    
    // Accesores tipados
    public int AsInt() => (int)Data;
    public double AsFloat() => (double)Data;
    public bool AsBool() => (bool)Data;
    public string AsString() => (string)Data;
    public char AsRune() => (char)Data;
    public Slice AsSlice() => (Slice)Data;
    public StructInstance AsStruct()
{
    if (Type == ValueType.Nil)
        return null;
    return (StructInstance)Data;
}

    public static Value FromInt(int i)       => new Value(ValueType.Int, i);
    public static Value FromFloat(double d)  => new Value(ValueType.Float, d);
    public static Value FromString(string s) => new Value(ValueType.String, s);
    public static Value FromBool(bool b)     => new Value(ValueType.Bool, b);
    public static Value FromRune(char c)     => new Value(ValueType.Rune, c);
    public static Value FromSlice(Slice s)   => new Value(ValueType.Slice, s);
    public static Value FromStruct(StructInstance s) => new Value(ValueType.Struct, s);
    public static Value FromNil()            => new Value(ValueType.Nil, null);
// Nuevo constructor protegido que omite la validación.
    protected Value(ValueType type)
    {
        Type = type;
        Data = null;
    }
    public static Value DefaultForType(ValueType t)
    {
        return t switch
        {
            ValueType.Int    => FromInt(0),
            ValueType.Float  => FromFloat(0.0),
            ValueType.String => FromString(""),
            ValueType.Bool   => FromBool(false),
            ValueType.Rune   => FromRune('\0'),
            ValueType.Slice  => FromSlice(new Slice(ValueType.Nil)),
            ValueType.Struct => FromNil(), 
            ValueType.Nil    => FromNil(),
            _                => FromNil()
        };
    }

    public override string ToString()
    {
        return Type switch
        {
            ValueType.Int    => AsInt().ToString(),
            ValueType.Float  => AsFloat().ToString("0.0#"),
            ValueType.Bool   => AsBool() ? "true" : "false",
            ValueType.String => $"{AsString()}",
            ValueType.Rune   => $"{AsRune()}",
            ValueType.Slice  => AsSlice()?.ToString() ?? "[]",
            ValueType.Struct => AsStruct()?.ToString() ?? "nil",
            ValueType.Nil    => "nil",
            _                => "nil"
        };
    }

private bool ValidateType(ValueType type, object data)
{
    return type switch
    {
        ValueType.Int    => data is int,
        ValueType.Float  => data is double,
        ValueType.String => data is string,
        ValueType.Bool   => data is bool,
        ValueType.Rune   => data is char,
        ValueType.Slice  => data is Slice,
        ValueType.Struct => data is StructInstance,  
        ValueType.Nil    => data == null,
        _                => false
    };
}

public class Symbol
{
    public string Name { get; set; }
    public ValueType DeclaredType { get; set; }
    public Value RuntimeValue { get; set; }

    public Symbol(string name, ValueType declaredType)
    {
        Name = name;
        DeclaredType = declaredType;
        RuntimeValue = Value.DefaultForType(declaredType);
    }

    public Symbol(string name, ValueType declaredType, Value initialValue)
    {
        Name = name;
        DeclaredType = declaredType;
        RuntimeValue = initialValue;
    }

}
}