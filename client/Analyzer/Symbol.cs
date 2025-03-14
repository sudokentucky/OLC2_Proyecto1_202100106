public enum ValueType
{
    Int,
    Float,
    String,
    Bool,
    Rune,  
    Nil   
}

public class Value
{
    public ValueType Type { get; set; }
    public object Data { get; set; }

    public Value(ValueType type, object data)
    {
        Type = type;
        Data = data;
    }

    public int AsInt() => (int)Data;
    public double AsFloat() => (double)Data;
    public bool AsBool() => (bool)Data;
    public string AsString() => (string)Data;
    public char AsRune() => (char)Data;  // NUEVO para runes

    // Creadores estáticos
    public static Value FromInt(int i)       => new Value(ValueType.Int, i);
    public static Value FromFloat(double d)  => new Value(ValueType.Float, d);
    public static Value FromString(string s) => new Value(ValueType.String, s);
    public static Value FromBool(bool b)     => new Value(ValueType.Bool, b);
    public static Value FromRune(char c)     => new Value(ValueType.Rune, c);
    public static Value FromNil()            => new Value(ValueType.Nil, null);

    public static Value DefaultForType(ValueType t)
    {
        return t switch
        {
            ValueType.Int    => FromInt(0),
            ValueType.Float  => FromFloat(0.0),
            ValueType.String => FromString(""),
            ValueType.Bool   => FromBool(false),
            ValueType.Rune   => FromRune('\0'),     
            ValueType.Nil    => FromNil(),
            _                => FromNil()          
        };
    }
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
        RuntimeValue = new Value(declaredType, GetDefaultValue(declaredType));
    }

    public Symbol(string name, ValueType declaredType, Value initialValue)
    {
        Name = name;
        DeclaredType = declaredType;
        RuntimeValue = initialValue;
    }

    private object GetDefaultValue(ValueType t)
    {
        return t switch
        {
            ValueType.Int => 0,
            ValueType.Float => 0.0,
            ValueType.String => "",
            ValueType.Bool => false,
            _ => null!, 
        };
    }
}
