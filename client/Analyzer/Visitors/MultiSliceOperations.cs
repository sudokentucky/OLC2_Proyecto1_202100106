using System;
using System.Collections.Generic;

public static class MultiSliceOperations
{
    public static int Len(MultiSlice multiSlice)
    {
        if (multiSlice == null)
            throw new Exception("El MultiSlice es nulo.");
            
        return multiSlice.Length();
    }
    public static int TotalElements(MultiSlice multiSlice)
{
    if (multiSlice == null)
        throw new Exception("El MultiSlice es nulo.");
    
    int total = 0;
    // Iteramos por cada fila y sumamos su longitud
    for (int i = 0; i < multiSlice.RowCount; i++)
    {
        Slice row = multiSlice[i];
        total += row.Len();
    }
    return total;
}

    public static (int row, int col) IndexMulti(MultiSlice multiSlice, Value element)
{
    if (multiSlice == null)
        throw new Exception("El MultiSlice es nulo.");

    for (int i = 0; i < multiSlice.RowCount; i++)
    {
        Slice row = multiSlice[i];
        int index = SliceOperations.Index(row, element);
        if (index != -1)
        {
            return (i, index);
        }
    }
    // Si no se encontró, se retorna (-1, -1)
    return (-1, -1);
}

    public static MultiSlice Append(MultiSlice multiSlice, Slice newRow)
    {
        if (multiSlice == null)
            throw new Exception("El MultiSlice es nulo.");
            
        return multiSlice.AppendRow(newRow);
    }
    
    public static Value GetElement(MultiSlice multiSlice, int rowIndex, int colIndex)
    {
        if (multiSlice == null)
            throw new Exception("El MultiSlice es nulo.");
            
        Slice row = multiSlice[rowIndex];
        return row[colIndex];
    }
    
    public static void SetElement(MultiSlice multiSlice, int rowIndex, int colIndex, Value newValue)
    {
        if (multiSlice == null)
            throw new Exception("El MultiSlice es nulo.");
            
        Slice row = multiSlice[rowIndex];
        row[colIndex] = newValue;
    }
}