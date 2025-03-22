using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public partial class Visitor
{
    public override Value VisitForStmt([NotNull] ForStmtContext context)
    {
        if (context.forWhileStmt() != null)
            return Visit(context.forWhileStmt());

        if (context.forRangeStmt() != null)
            return Visit(context.forRangeStmt());

        return Visit(context.forThreePartStmt());
    }

    public override Value VisitForRangeStmt([NotNull] ForRangeStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        using (CreateLoopEnvironment())
        {
            Value collection = Visit(context.expresion());
            string indexVar = context.IDENTIFIER(0).GetText();
            string? valueVar = GetOptionalValueVar(context);

            if (!DeclareLoopVariables(collection, indexVar, valueVar, line, column))
                return Value.FromNil();

            IterateRange(collection, indexVar, valueVar, context);
        }

        return Value.FromNil();
    }

    public override Value VisitForThreePartStmt([NotNull] ForThreePartStmtContext context)
    {
        int line = context.Start.Line;
        int column = context.Start.Column;

        using (CreateLoopEnvironment())
        {
            Visit(context.forInit());

            while (EvaluateLoopCondition(context.expresion(), line, column))
            {
                try
                {
                    Visit(context.bloque());
                }
                catch (ContinueException)
                {
                }

                Visit(context.forPost());
            }
        }

        return Value.FromNil();
    }

    private IDisposable CreateLoopEnvironment()
    {
        loopDepth++;
        var previousEnv = currentEnv;
        currentEnv = new Environment(table, previousEnv);

        return new DisposableAction(() =>
        {
            loopDepth--;
            currentEnv = previousEnv;
        });
    }

    private string? GetOptionalValueVar(ForRangeStmtContext context)
    {
        return context.IDENTIFIER().Length > 1
            ? context.IDENTIFIER(1).GetText()
            : null;
    }

    private bool DeclareLoopVariables(Value collection, string indexVar, string? valueVar, int line, int column)
    {
        currentEnv.DeclareVariable(indexVar, Value.FromInt(0), line, column, "ForRange");

        if (valueVar == null)
            return true;

        if (collection.Type == ValueType.Slice)
        {
            var slice = collection.AsSlice();
            currentEnv.DeclareVariable(valueVar, Value.DefaultForType(slice.ElementType), line, column, "ForRange");
            return true;
        }

        if (collection.Type == ValueType.String)
        {
            currentEnv.DeclareVariable(valueVar, Value.DefaultForType(ValueType.Rune), line, column, "ForRange");
            return true;
        }

        AddSemanticError(line, column,
            $"La expresión después de 'range' debe ser un slice o una cadena, se obtuvo {collection.Type}.");
        return false;
    }

    private void IterateRange(Value collection, string indexVar, string? valueVar, ForRangeStmtContext context)
    {
        try
        {
            if (collection.Type == ValueType.Slice)
                IterateSlice(collection.AsSlice(), indexVar, valueVar, context.bloque());

            else if (collection.Type == ValueType.String)
                IterateString(collection.AsString(), indexVar, valueVar, context.bloque());
        }
        catch (BreakException)
        {
        }
    }

    private void IterateSlice(Slice slice, string indexVar, string? valueVar, BloqueContext body)
    {
        for (int i = 0; i < slice.Len(); i++)
        {
            currentEnv.SetVariable(indexVar, Value.FromInt(i));

            if (valueVar != null)
                currentEnv.SetVariable(valueVar, slice[i]);

            ExecuteLoopBody(body);
        }
    }

    private void IterateString(string str, string indexVar, string? valueVar, BloqueContext body)
    {
        for (int i = 0; i < str.Length; i++)
        {
            currentEnv.SetVariable(indexVar, Value.FromInt(i));

            if (valueVar != null)
                currentEnv.SetVariable(valueVar, Value.FromRune(str[i]));

            ExecuteLoopBody(body);
        }
    }

    private void ExecuteLoopBody(BloqueContext body)
    {
        try
        {
            Visit(body);
        }
        catch (ContinueException)
        {
        }
    }

    private bool EvaluateLoopCondition(ExpresionContext? conditionExpr, int line, int column)
    {
        if (conditionExpr == null)
            return true;

        Value condition = Visit(conditionExpr);

        if (condition.Type != ValueType.Bool)
        {
            AddSemanticError(line, column,
                $"La condición del bucle for debe ser booleana, se obtuvo {condition.Type}.");
            return false;
        }

        return condition.AsBool();
    }

    private class DisposableAction : IDisposable
    {
        private readonly Action _action;

        public DisposableAction(Action action)
        {
            _action = action;
        }

        public void Dispose()
        {
            _action?.Invoke();
        }
    }
}
