public enum ValueType
{
    Int,
    Float,
    String,
    Bool,
    // etc. (rune, struct, etc.)
}

// Clase Value:
// Representa un DATO en tiempo de ejecución (resultado de una expresión).
public class Value
{
    public ValueType Type { get; set; }
    public object Data { get; set; }

    public Value(ValueType type, object data)
    {
        Type = type;
        Data = data;
    }

    // Helpers
    public int AsInt() => (int)Data;
    public double AsFloat() => (double)Data;
    public bool AsBool() => (bool)Data;
    public string AsString() => (string)Data;

    // Creadores estáticos
    public static Value FromInt(int i)       => new Value(ValueType.Int, i);
    public static Value FromFloat(double d)  => new Value(ValueType.Float, d);
    public static Value FromString(string s) => new Value(ValueType.String, s);
    public static Value FromBool(bool b)     => new Value(ValueType.Bool, b);
}

// Clase Symbol:
// Representa la ENTRADA EN LA TABLA DE SÍMBOLOS, generalmente para variables.
// Puede almacenar su nombre, tipo declarado, valor actual, etc.
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
