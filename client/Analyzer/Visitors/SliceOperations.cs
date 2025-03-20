public static class SliceOperations
{

    public static int Len(Slice slice)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        return slice.Len();
    }

    public static Slice Append(Slice slice, Value element)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        slice.Append(element);
        return slice;
    }
    public static int Index(Slice slice, Value element)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        return slice.Index(element);
    }
    public static string Join(Slice slice, string separator)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        if (slice.ElementType != ValueType.String)
            throw new Exception("La función Join solo es válida para slices de strings.");
        
        var stringValues = slice.Elements.Select(v => v.AsString());
        return string.Join(separator, stringValues);
    }

    public static Value GetElement(Slice slice, int index)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        return slice[index];
    }

    public static void SetElement(Slice slice, int index, Value newValue)
    {
        if (slice == null)
            throw new Exception("El slice es nulo.");
        slice[index] = newValue;
    }
    
}
