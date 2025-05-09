public class Slice
{

    public ValueType ElementType { get; private set; }
    public ValueType NestedValueType { get; private set; }
    private List<Value> elements;
    public Slice(ValueType elementType)
    {
        ElementType = elementType;
        NestedValueType = elementType; 
        elements = new List<Value>();
    }

    public Slice(ValueType elementType, ValueType nestedBaseType)
    {
        ElementType = elementType;         
        NestedValueType = nestedBaseType;  
        elements = new List<Value>();
    }

    public Slice(ValueType elementType, ValueType nestedBaseType, IEnumerable<Value> initialValues)
    {
        ElementType = elementType;
        NestedValueType = nestedBaseType;
        elements = new List<Value>();

        foreach (var val in initialValues)
        {
            if (!IsCompatible(val))
            {
                throw new Exception(
                    $"Elemento de tipo {val.Type} no es compatible con el slice => {DescribeSlice()}."
                );
            }
            elements.Add(val);
        }
    }

    private bool IsCompatible(Value v)
    {
        if (ElementType == ValueType.Slice)
        {
            if (v.Type != ValueType.Slice) return false;
            Slice childSlice = v.AsSlice();
            return childSlice.NestedValueType == this.NestedValueType;
        }
        else
        {
            return (v.Type == ElementType);
        }
    }

    public Slice(ValueType elementType, IEnumerable<Value> initialValues)
        : this(elementType, elementType, initialValues)
    {
    }

    public int Len()
    {
        return elements.Count;
    }

    public void Append(Value element)
    {
        if (!IsCompatible(element))
        {
            throw new Exception(
                $"No se puede agregar {element.Type} a un slice de {DescribeSlice()}."
            );
        }
        elements.Add(element);
    }

    public int Index(Value element)
    {
        for (int i = 0; i < elements.Count; i++)
        {
            if (AreSemanticallyEqual(elements[i], element))
                return i;
        }
        return -1;
    }

    public Slice GetRow(int rowIndex)
    {
        if (ElementType != ValueType.Slice)
            throw new Exception("GetRow() solo aplica a un slice de slices.");
        
        if (rowIndex < 0 || rowIndex >= elements.Count)
            throw new Exception($"Índice de fila {rowIndex} fuera de rango. El slice tiene {elements.Count} filas.");

        Value rowValue = elements[rowIndex];
        return rowValue.AsSlice();
    }


    private bool AreSemanticallyEqual(Value a, Value b)
    {
        if (a.Type != b.Type) return false;

        switch (a.Type)
        {
            case ValueType.Int:    return a.AsInt() == b.AsInt();
            case ValueType.Float:  return a.AsFloat() == b.AsFloat();
            case ValueType.Bool:   return a.AsBool() == b.AsBool();
            case ValueType.String: return a.AsString() == b.AsString();
            case ValueType.Rune:   return a.AsRune() == b.AsRune();
            case ValueType.Nil:    return b.Type == ValueType.Nil;
            case ValueType.Slice:
                return Object.ReferenceEquals(a.Data, b.Data);
            default:
                return false;
        }
    }

    public Value this[int index]
    {
        get 
        { 
            if (index < 0 || index >= elements.Count)
                throw new Exception("Índice fuera de rango.");
            return elements[index];
        }
        set 
        {
            if (index < 0 || index >= elements.Count)
                throw new Exception("Índice fuera de rango.");

            if (!IsCompatible(value))
            {
                throw new Exception(
                    $"El elemento asignado no es compatible con {DescribeSlice()}."
                );
            }
            elements[index] = value;
        }
    }

    public IReadOnlyList<Value> Elements => elements.AsReadOnly();

    public override string ToString()
    {
        if (elements.Count == 0)
            return "[]";
        
        var strElements = elements.Select(e => 
            e.Type == ValueType.Slice 
                ? ((Slice)e.Data).ToString()  
                : e.ToString()
        );
        
        return $"[{string.Join(", ", strElements)}]";
    }

    private string DescribeSlice()
    {
        if (ElementType == ValueType.Slice)
        {
            return $"[]({NestedValueType})";
        }
        else
        {
            return ElementType.ToString();
        }
    }
}
