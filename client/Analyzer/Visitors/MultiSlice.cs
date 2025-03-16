using System;
using System.Collections.Generic;
using System.Linq;

public class MultiSlice
{
    private List<Slice> rows;
    public ValueType ElementType { get; private set; }
    public MultiSlice(ValueType elementType)
    {
        ElementType = elementType;
        rows = new List<Slice>();
    }

    public MultiSlice(List<Slice> initialRows, ValueType elementType)
    {
        foreach (var row in initialRows)
        {
            if (row.ElementType != elementType)
            {
                throw new Exception($"Todos los elementos deben ser de tipo {elementType}, se encontró {row.ElementType}");
            }
        }

        ElementType = elementType;
        rows = new List<Slice>(initialRows);
    }

    public int RowCount => rows.Count;

    public Slice GetRow(int rowIndex)
    {
        if (rowIndex < 0 || rowIndex >= rows.Count)
        {
            throw new Exception($"Índice de fila {rowIndex} fuera de rango. El slice tiene {rows.Count} filas.");
        }
        return rows[rowIndex];
    }

    public Slice this[int index]
    {
        get
        {
            if (index < 0 || index >= rows.Count)
            {
                throw new Exception($"Índice de fila {index} fuera de rango. El slice tiene {rows.Count} filas.");
            }
            return rows[index];
        }
    }

    public void Append(Slice newRow)
    {
        if (newRow.ElementType != ElementType)
        {
            throw new Exception($"No se puede agregar una fila de tipo {newRow.ElementType} a un MultiSlice de tipo {ElementType}");
        }
        
        rows.Add(newRow);
    }

    public MultiSlice AppendRow(Slice newRow)
    {
        Append(newRow);
        return this;
    }

    public int Length()
    {
        return rows.Count;
    }

    public override string ToString()
    {
        if (rows.Count == 0)
            return "[]";
            
        var rowStrings = rows.Select(r => r.ToString());
        return $"[{string.Join(", ", rowStrings)}]";
    }

    public static MultiSlice Create(List<Slice> rows, ValueType elementType)
    {
        return new MultiSlice(rows, elementType);
    }

    public static MultiSlice CreateEmpty(ValueType elementType)
    {
        return new MultiSlice(elementType);
    }
}