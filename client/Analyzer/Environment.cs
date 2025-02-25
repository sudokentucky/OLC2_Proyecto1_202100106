public class Environment
{
    private Dictionary<string, Value> variables 
        = new Dictionary<string, Value>();


    private Environment? parent;

    public Environment(Environment? parentEnv = null)
    {
        parent = parentEnv;
    }


    public void DeclareVariable(string name, Value value)
    {
        if (variables.ContainsKey(name))
        {
            throw new Exception($"Variable '{name}' ya declarada en este ámbito.");
        }
        variables[name] = value;
    }

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
