public class Environment
{
    private Dictionary<string, Value> variables 
        = new Dictionary<string, Value>();

    private Environment? parent;
    private SymbolTable symbolTable;

    public Environment(SymbolTable table, Environment? parentEnv = null)
    {
        symbolTable = table;
        parent = parentEnv;
    }

    public void DeclareVariable(string name, Value value, int line, int column, string scopeName = "Global")
    {
        if (variables.ContainsKey(name))
        {
            throw new Exception($"Variable '{name}' ya declarada en este ámbito.");
        }
        variables[name] = value;

        var entry = new SymbolTableEntry(
            id: name,
            symbolType: "Variable",
            dataType: value.Type.ToString(), 
            scope: scopeName,
            value: value.ToString(),
            line: line,
            column: column
        );
        symbolTable.AddEntry(entry);
    }

public void SetVariable(string name, Value value)
{
    if (variables.TryGetValue(name, out Value? currentValue))
    {
        if (currentValue.Type != value.Type)
        {
            throw new Exception(
                $"Error de asignación: la variable '{name}' es de tipo {currentValue.Type}, " +
                $"no se puede asignar un valor de tipo {value.Type}."
            );
        }
        variables[name] = value;
        return;
    }
    else if (parent != null)
    {
        parent.SetVariable(name, value);
        return;
    }
    throw new Exception($"Variable '{name}' no declarada en ningún ámbito.");
}
    public Value GetVariable(string name)
    {
        if (variables.ContainsKey(name))
        {
            return variables[name];
        }
        else if (parent != null)
        {
            return parent.GetVariable(name);
        }
        else
        {
            throw new Exception($"Variable '{name}' no existe en ningún ámbito.");
        }
    }
    
    public bool HasVariableInCurrentScope(string name)
{
    return variables.ContainsKey(name);
}

}
