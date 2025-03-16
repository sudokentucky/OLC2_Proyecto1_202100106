using System;
using System.Collections.Generic;
using System.Linq;

public class Slice
{
    private List<Value> elements;
    public ValueType ElementType { get; private set; }
    public Slice(ValueType elementType) 
    {
        ElementType = elementType;
        elements = new List<Value>();
    }
    public Slice(ValueType elementType, IEnumerable<Value> initialValues)
    {
        ElementType = elementType;
        elements = new List<Value>();

        foreach (var val in initialValues)
        {
            if (val.Type != elementType)
            {
                throw new Exception($"Elemento de tipo {val.Type} no es compatible con el slice de tipo {elementType}.");
            }
            elements.Add(val);
        }
    }

    public int Len()
    {
        return elements.Count;
    }

    public void Append(Value element)
    {
        if (element.Type != ElementType)
        {
            throw new Exception($"No se puede agregar un elemento de tipo {element.Type} a un slice de {ElementType}.");
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
            // etc.
            default:               return false;
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
            if (value.Type != ElementType)
                throw new Exception($"El elemento asignado debe ser de tipo {ElementType}.");
            elements[index] = value;
        }
    }

    public override string ToString()
    {
        if (elements.Count == 0)
            return "[]";
        
        var strElements = elements.Select(e => e.ToString());
        return "[" + string.Join(", ", strElements) + "]";
    }



    public IReadOnlyList<Value> Elements => elements.AsReadOnly();
}
