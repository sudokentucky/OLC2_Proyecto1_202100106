using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{

    public override Value VisitForStmt([NotNull] ForStmtContext context)
    {
        if (context.forWhileStmt() != null)
        {
            return Visit(context.forWhileStmt());
        }
        else if (context.forRangeStmt() != null)
        {
            return Visit(context.forRangeStmt());
        }
        else
        {
            return Visit(context.forThreePartStmt());
        }
    }
    public override Value VisitForRangeStmt([NotNull] ForRangeStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        Environment previousEnv = currentEnv;
        currentEnv = new Environment(table, previousEnv);

        loopDepth++;

        try
        {
            Value collection = Visit(context.expresion());

            string indexVar = context.IDENTIFIER(0).GetText();
            string? valueVar = context.IDENTIFIER().Length > 1 ? context.IDENTIFIER(1).GetText() : null;

            currentEnv.DeclareVariable(indexVar, Value.FromInt(0), line, column, "ForRange");

            if (valueVar != null)
            {
                if (collection.Type == ValueType.Slice)
                {
                    Slice slice = collection.AsSlice();
                    currentEnv.DeclareVariable(valueVar, Value.DefaultForType(slice.ElementType), line, column, "ForRange");
                }
                else if (collection.Type == ValueType.String)
                {
                    currentEnv.DeclareVariable(valueVar, Value.DefaultForType(ValueType.Rune), line, column, "ForRange");
                }
                else
                {
                    AddSemanticError(line, column, $"La expresión después de 'range' debe ser un slice o una cadena, se obtuvo {collection.Type}.");
                    return null!;
                }
            }

            if (collection.Type == ValueType.Slice)
            {
                Slice slice = collection.AsSlice();
                int length = slice.Len();

                for (int i = 0; i < length; i++)
                {
                    currentEnv.SetVariable(indexVar, Value.FromInt(i));

                    if (valueVar != null)
                    {
                        currentEnv.SetVariable(valueVar, slice[i]);
                    }

                    try
                    {
                        Visit(context.bloque());
                    }
                    catch (ContinueException)
                    {
                        continue;
                    }
                }
            }
            else if (collection.Type == ValueType.String)
            {
                string str = collection.AsString();
                int length = str.Length;

                for (int i = 0; i < length; i++)
                {
                    currentEnv.SetVariable(indexVar, Value.FromInt(i));

                    if (valueVar != null)
                    {
                        currentEnv.SetVariable(valueVar, Value.FromRune(str[i]));
                    }

                    try
                    {
                        Visit(context.bloque());
                    }
                    catch (ContinueException)
                    {
                        continue;
                    }
                }
            }
            else
            {
                AddSemanticError(line, column, $"La expresión después de 'range' debe ser un slice o una cadena, se obtuvo {collection.Type}.");
            }
        }
        catch (BreakException)
        {
        }
        finally
        {
            loopDepth--;
            currentEnv = previousEnv;
        }

        return null!;
    }


    public override Value VisitForThreePartStmt([NotNull] ForThreePartStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;
        Environment previousEnv = currentEnv;
        currentEnv = new Environment(table, previousEnv);

        loopDepth++;

        try
        {
            if (context.forInit() != null)
            {
                Visit(context.forInit());
            }

            while (true)
            {
                if (context.expresion() != null)
                {
                    Value condition = Visit(context.expresion());

                    if (condition.Type != ValueType.Bool)
                    {
                        AddSemanticError(line, column,
                            $"La condición del bucle for debe ser booleana, se obtuvo {condition.Type}.");
                        break;
                    }

                    if (!condition.AsBool())
                        break;
                }

                try
                {
                    Visit(context.bloque());
                }
                catch (ContinueException)
                {
                }

                if (context.forPost() != null)
                {
                    Visit(context.forPost());
                }
            }
        }
        catch (BreakException)
        {
        }
        finally
        {
            loopDepth--;
            currentEnv = previousEnv;
        }

        return null!;
    }



}