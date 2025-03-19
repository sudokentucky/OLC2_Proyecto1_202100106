using System;
using System.Collections.Generic;

public class SymbolTableEntry
{
    public string ID { get; set; }
    public string SymbolType { get; set; }  // "Struct", "Variable", etc.
    public string DataType { get; set; }   // Tipo de dato (ej: "int", "Persona")
    public string Scope { get; set; }
    public object Value { get; set; }      // StructType (definición) o StructInstance (valor)
    public int Line { get; set; }
    public int Column { get; set; }
    public bool IsStructDefinition { get; set; }

    public SymbolTableEntry(
        string id,
        string symbolType,
        string dataType,
        string scope,
        object value,
        int line,
        int column,
        bool isStructDef = false
    )
    {
        ID = id;
        SymbolType = symbolType;
        DataType = dataType;
        Scope = scope;
        Value = value;
        Line = line;
        Column = column;
        IsStructDefinition = isStructDef;
    }
}

public class SymbolTable
{
    private List<SymbolTableEntry> entries;
    private Dictionary<string, StructType> structs;
    private Dictionary<string, Function> functions;

    public SymbolTable()
    {
        entries = new List<SymbolTableEntry>();
        structs = new Dictionary<string, StructType>();
        functions = new Dictionary<string, Function>();
    }
    public void AddFunction(Function function)
    {
        // Validar que el nombre no exista como struct o función
        if (structs.ContainsKey(function.Name) || functions.ContainsKey(function.Name))
            throw new Exception($"El nombre '{function.Name}' ya está definido");
        
        functions.Add(function.Name, function);
        
        // Agregar a la lista de entradas para reportes
        entries.Add(new SymbolTableEntry(
            id: function.Name,
            symbolType: "Function",
            dataType: function.ReturnType.ToString(),
            scope: "Global",
            value: function,
            line: function.Line,
            column: function.Column
        ));
    }

    public Function GetFunction(string name)
    {
        if (!functions.ContainsKey(name))
            throw new Exception($"Función '{name}' no definida");
            
        return functions[name];
    }
    
    // Verificar si una función existe
    public bool IsFunctionDefined(string name)
    {
        return functions.ContainsKey(name);
    }
    public void AddStruct(StructType structType)
    {
        if (structs.ContainsKey(structType.Name))
            throw new Exception($"El struct '{structType.Name}' ya está definido");

        if (structType.Fields.Count == 0)
            throw new Exception($"El struct '{structType.Name}' no puede estar vacío");

        structs.Add(structType.Name, structType);
        
        entries.Add(new SymbolTableEntry(
            id: structType.Name,
            symbolType: "Struct",
            dataType: "struct",
            scope: "Global",
            value: structType,
            line: 0,
            column: 0,
            isStructDef: true
        ));
    }

    public StructType GetStruct(string name)
    {
        if (!structs.ContainsKey(name))
            throw new Exception($"Struct '{name}' no definido");
        
        return structs[name];
    }
    public bool IsStructType(string typeName)
    {
        return structs.ContainsKey(typeName);
    }
    public IReadOnlyList<SymbolTableEntry> GetAllEntries()
    {
        return entries.AsReadOnly();
    }
    public void AddEntry(SymbolTableEntry entry)
    {
        // Validar structs duplicados
        if (entry.IsStructDefinition && structs.ContainsKey(entry.ID))
            throw new Exception($"Struct '{entry.ID}' ya existe");
        
        entries.Add(entry);
    }
    
    public SymbolTableEntry FindSymbol(string id, string scope = "Global")
    {
        foreach (var entry in entries)
        {
            if (entry.ID == id && entry.Scope == scope)
                return entry;
        }
        return null;
    }

    public void PrintTable()
    {
        Console.WriteLine("ID\tTipo\tTipoDato\tÁmbito\tValor\tLínea\tColumna");
        foreach (var e in entries)
        {
            string valueStr = e.Value switch
            {
                StructType st => $"Struct({st.Name}) Campos: [{string.Join(", ", st.Fields.Keys)}]",
                StructInstance si => $"Instancia de {si.StructName}",
                Function fn => $"{fn.ToString()} ({fn.Parameters.Count} params)",
                _ => e.Value?.ToString() ?? "nil"
            };

            Console.WriteLine(
                $"{e.ID}\t{e.SymbolType}\t{e.DataType}\t{e.Scope}\t{valueStr}\t{e.Line}\t{e.Column}"
            );
        }
    }
}