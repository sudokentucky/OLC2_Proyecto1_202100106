public class Function
{
    // Propiedades básicas
    public string Name { get; }
    public List<(string Name, ValueType Type)> Parameters { get; } = new List<(string, ValueType)>();
    public ValueType ReturnType { get; set; } = ValueType.Nil;
    public gramaticaParser.BloqueContext Body { get; }
    
    // Información de posición para mensajes de error
    public int Line { get; }
    public int Column { get; }
    
    // Constructor mejorado con información de posición
    public Function(string name, gramaticaParser.BloqueContext body, int line = 0, int column = 0)
    {
        Name = name;
        Body = body;
        Line = line;
        Column = column;
    }
    
    // Método para validar si un parámetro ya existe
    public bool HasParameter(string paramName)
    {
        return Parameters.Any(p => p.Name == paramName);
    }
    
    // Método para añadir un parámetro con validación
    public void AddParameter(string name, ValueType type)
    {
        if (HasParameter(name))
            throw new Exception($"El parámetro '{name}' ya existe en la función '{Name}'");
            
        Parameters.Add((name, type));
    }
    
    // Método para verificar compatibilidad de argumentos
    public bool AreArgumentsCompatible(Value[] arguments)
    {
        if (arguments.Length != Parameters.Count)
            return false;
            
        for (int i = 0; i < Parameters.Count; i++)
        {
            // Verificar tipos (excepto para structs y slices que son por referencia)
            if (arguments[i].Type != Parameters[i].Type && 
                !(Parameters[i].Type == ValueType.Struct && arguments[i].Type == ValueType.Struct) &&
                !(Parameters[i].Type == ValueType.Slice && arguments[i].Type == ValueType.Slice))
            {
                return false;
            }
        }
        
        return true;
    }
    
    // ToString para facilitar depuración
    public override string ToString()
    {
        string paramStr = string.Join(", ", Parameters.Select(p => $"{p.Name} {p.Type}"));
        string returnStr = ReturnType == ValueType.Nil ? "" : $" {ReturnType}";
        
        return $"func {Name}({paramStr}){returnStr}";
    }
}