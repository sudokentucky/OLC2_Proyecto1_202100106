// Symbol.cs (o donde hayas definido ValueType y Value)

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

    // Helpers de acceso
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

    // Manejo de nil (si quieres tratar "nil" como su propio tipo)
    public static Value FromNil()            => new Value(ValueType.Nil, null);

    // Método de conveniencia para obtener el valor por defecto de un tipo
    public static Value DefaultForType(ValueType t)
    {
        return t switch
        {
            ValueType.Int    => FromInt(0),
            ValueType.Float  => FromFloat(0.0),
            ValueType.String => FromString(""),
            ValueType.Bool   => FromBool(false),
            ValueType.Rune   => FromRune('\0'),     // por ejemplo, 0 ASCII
            ValueType.Nil    => FromNil(),
            _                => FromNil()           // fallback
        };
    }
}



public class Symbol
{
    public string Name { get; set; }
    public ValueType DeclaredType { get; set; }
    public Value RuntimeValue { get; set; } 

    // Otras propiedades que te interese rastrear (ambito, offset, etc.)

    public Symbol(string name, ValueType declaredType)
    {
        Name = name;
        DeclaredType = declaredType;
        // Opcionalmente, podrías iniciar la RuntimeValue con un Value por defecto 
        // (p.ej., 0 si es int, "" si es string, etc.).
        RuntimeValue = new Value(declaredType, GetDefaultValue(declaredType));
    }

    // O un constructor que también reciba un Value inicial
    public Symbol(string name, ValueType declaredType, Value initialValue)
    {
        Name = name;
        DeclaredType = declaredType;
        RuntimeValue = initialValue;
    }

    // Ejemplo de método para obtener un valor por defecto:
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
