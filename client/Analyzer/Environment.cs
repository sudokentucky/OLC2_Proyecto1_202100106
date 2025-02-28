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

    // Declara variable, registrando en la tabla de símbolos
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
            dataType: value.Type.ToString(), // p.ej. "Int", "Float"
            scope: scopeName,
            line: line,
            column: column
        );
        symbolTable.AddEntry(entry);
    }

    // Asigna variable (no actualiza la tabla de símbolos)
    public void SetVariable(string name, Value value)
    {
        if (variables.ContainsKey(name))
        {
            variables[name] = value;
        }
        else if (parent != null)
        {
            parent.SetVariable(name, value);
        }
        else
        {
            throw new Exception($"Variable '{name}' no declarada en ningún ámbito.");
        }
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
}
