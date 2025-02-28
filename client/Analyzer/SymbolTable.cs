using System;
using System.Collections.Generic;

public class SymbolTableEntry
{
    public string ID { get; set; }
    public string SymbolType { get; set; }
    public string DataType { get; set; }
    public string Scope { get; set; }
    public int Line { get; set; }
    public int Column { get; set; }

    public SymbolTableEntry(string id, string symbolType, string dataType,
                            string scope, int line, int column)
    {
        ID = id;
        SymbolType = symbolType;
        DataType = dataType;
        Scope = scope;
        Line = line;
        Column = column;
    }
}


public class SymbolTable
{
    private List<SymbolTableEntry> entries;
    public SymbolTable()
    {
        entries = new List<SymbolTableEntry>();
    }
    public void AddEntry(SymbolTableEntry entry)
    {
        entries.Add(entry);
    }
    public IReadOnlyList<SymbolTableEntry> GetAllEntries()
    {
        return entries.AsReadOnly();
    }

    public SymbolTableEntry FindSymbol(string id, string scope = "Global")
    {
        foreach (var entry in entries)
        {
            if (entry.ID == id && entry.Scope == scope)
            {
                return entry;
            }
        }
        return null;
    }

    public void PrintTable()
    {
        Console.WriteLine("ID\tSymbolType\tDataType\tScope\tLine\tColumn");
        foreach (var e in entries)
        {
            Console.WriteLine($"{e.ID}\t{e.SymbolType}\t{e.DataType}\t{e.Scope}\t{e.Line}\t{e.Column}");
        }
    }
}
