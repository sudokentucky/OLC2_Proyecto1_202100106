using System;
using System.Collections.Generic;
using System.Linq;

public class Function
{
    public string Name { get; }
    public List<(string Name, ValueType Type)> Parameters { get; } = new List<(string, ValueType)>();
    public ValueType ReturnType { get; set; } = ValueType.Nil;
    public gramaticaParser.BloqueContext Body { get; }
    
    public int Line { get; }
    public int Column { get; }
    
    public bool IsStructMethod { get; set; } = false;
    public string StructType { get; set; }
    public string ReceiverName { get; set; }
    public bool IsPointerReceiver { get; set; } = false;
    
    public Function(string name, gramaticaParser.BloqueContext body, int line = 0, int column = 0)
    {
        Name = name;
        Body = body;
        Line = line;
        Column = column;
    }
    
    public bool HasParameter(string paramName)
    {
        return Parameters.Any(p => p.Name == paramName);
    }
    
    public void AddParameter(string name, ValueType type)
    {
        if (HasParameter(name))
            throw new Exception($"El parámetro '{name}' ya existe en la función '{Name}'");
            
        Parameters.Add((name, type));
    }
    
    public bool AreArgumentsCompatible(Value[] arguments)
    {
        if (arguments.Length != Parameters.Count)
            return false;
            
        for (int i = 0; i < Parameters.Count; i++)
        {
            if (arguments[i].Type != Parameters[i].Type && 
                !(Parameters[i].Type == ValueType.Struct && arguments[i].Type == ValueType.Struct) &&
                !(Parameters[i].Type == ValueType.Slice && arguments[i].Type == ValueType.Slice))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public override string ToString()
    {
        string receiverStr = IsStructMethod 
            ? $"({ReceiverName} {(IsPointerReceiver ? "*" : "")}{StructType}) " 
            : "";
            
        string paramStr = string.Join(", ", Parameters.Select(p => $"{p.Name} {p.Type}"));
        string returnStr = ReturnType == ValueType.Nil ? "" : $" {ReturnType}";
        
        return $"func {receiverStr}{Name}({paramStr}){returnStr}";
    }
}