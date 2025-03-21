using System;
using Antlr4.Runtime.Misc;
using static gramaticaParser;

public class ASTVisitor : gramaticaBaseVisitor<AstNode>
{
    private int nodeCounter = 0;

    public override AstNode VisitProgram(gramaticaParser.ProgramContext context)
    {
        var root = new AstNode("Inicio");

        // Visit struct declarations
        foreach (var structDecl in context.structDecl())
            root.AddChild(Visit(structDecl));

        // Visit function declarations
        foreach (var funcDecl in context.funcDecl())
            root.AddChild(Visit(funcDecl));

        // Visit instructions
        foreach (var instr in context.instruction())
            root.AddChild(Visit(instr));

        return root;
    }

public override AstNode VisitStructLiteral([NotNull] gramaticaParser.StructLiteralContext context)
{
    string structType = "";
    if (context.GetToken(gramaticaParser.IDENTIFIER, 0) != null)
    {
        structType = context.GetToken(gramaticaParser.IDENTIFIER, 0).GetText();
    }
    
    var structNode = new AstNode($"StructLiteral\\n{structType}");
    
    // Agregar valores de campos
    foreach (var field in context.fieldValue())
    {
        structNode.AddChild(Visit(field));
    }
    
    return structNode;
}

public override AstNode VisitSwitchStmt([NotNull] gramaticaParser.SwitchStmtContext context)
{
    var switchNode = new AstNode("Switch");
    
    // Agregar expresión del switch
    if (context.expresion() != null)
    {
        var condNode = new AstNode("Condicion del Switch");
        condNode.AddChild(Visit(context.expresion()));
        switchNode.AddChild(condNode);
    }
    
    // Agregar cases
    foreach (var caseCtx in context.caseStmt())
    {
        switchNode.AddChild(Visit(caseCtx));
    }
    
    // Agregar default si existe
    if (context.defaultStmt() != null)
    {
        switchNode.AddChild(Visit(context.defaultStmt()));
    }
    
    return switchNode;
}

public override AstNode VisitCaseStmt([NotNull] gramaticaParser.CaseStmtContext context)
{
    var caseNode = new AstNode("Case");
    
    // Agregar expresión del case
    if (context.expresion() != null)
    {
        var exprNode = new AstNode("Valor de Case");
        exprNode.AddChild(Visit(context.expresion()));
        caseNode.AddChild(exprNode);
    }
    
    // Agregar instrucciones del case
    var bodyNode = new AstNode("Cuerpo de Case");
    foreach (var instr in context.instruction())
    {
        bodyNode.AddChild(Visit(instr));
    }
    caseNode.AddChild(bodyNode);
    
    return caseNode;
}

public override AstNode VisitDefaultStmt([NotNull] gramaticaParser.DefaultStmtContext context)
{
    var defaultNode = new AstNode("Default");
    
    // Agregar instrucciones del default
    var bodyNode = new AstNode("Cuerpo de Default");
    foreach (var instr in context.instruction())
    {
        bodyNode.AddChild(Visit(instr));
    }
    defaultNode.AddChild(bodyNode);
    
    return defaultNode;
}
public override AstNode VisitFieldValue([NotNull] gramaticaParser.FieldValueContext context)
{
    string fieldName = context.IDENTIFIER().GetText();
    var fieldNode = new AstNode($"Campo\\n{fieldName}");
    
    // Agregar valor del campo
    fieldNode.AddChild(Visit(context.expresion()));
    
    return fieldNode;
}

public override AstNode VisitStructDecl([NotNull] gramaticaParser.StructDeclContext context)
{
    string structName = context.IDENTIFIER().GetText();
    var structNode = new AstNode($"DeclaracionStruct:\\n{structName}");
    
    // Visitar cada campo del struct
    foreach (var field in context.fieldDecl())
    {
        structNode.AddChild(Visit(field));
    }
    
    return structNode;
}
public override AstNode VisitSliceType([NotNull] gramaticaParser.SliceTypeContext context)
{
    var elementType = "";
    if (context.typeSpec() != null)
    {
        elementType = context.typeSpec().GetText();
    }
    
    return new AstNode($"TipoSlice\\n[]({elementType})");
}

public override AstNode VisitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context)
{
    var sliceNode = new AstNode("SliceLiteral");
    
    // Agregar elementos del slice
    foreach (var expr in context.GetRuleContexts<gramaticaParser.ExpresionContext>())
    {
        sliceNode.AddChild(Visit(expr));
    }
    
    return sliceNode;
}
public override AstNode VisitFieldDecl([NotNull] gramaticaParser.FieldDeclContext context)
{
    string fieldName = context.IDENTIFIER().GetText();
    string fieldType = context.typeSpec().GetText();
    
    return new AstNode($"Campo\\n{fieldName}: {fieldType}");
}

public override AstNode VisitFuncDecl([NotNull] gramaticaParser.FuncDeclContext context)
{
    // Determinar si es función normal o método de struct
    bool isMethod = context.IDENTIFIER().Length > 1;
    string funcName;
    string structType = "";
    
    if (isMethod)
    {
        // Es un método de struct
        structType = context.IDENTIFIER(1).GetText();
        funcName = context.IDENTIFIER(2).GetText();
    }
    else
    {
        // Es una función normal
        funcName = context.IDENTIFIER(0).GetText();
    }
    
    // Crear nodo para la función
    string label = isMethod ? 
        $"Method\\n{funcName}\\nfor {structType}" : 
        $"Funcion\\n{funcName}";
    
    var funcNode = new AstNode(label);
    
    // Agregar parámetros si existen
    if (context.paramsList() != null)
    {
        var paramsNode = Visit(context.paramsList());
        funcNode.AddChild(paramsNode);
    }
    
    // Agregar tipo de retorno si existe
    if (context.typeSpec() != null)
    {
        string returnType = context.typeSpec().GetText();
        funcNode.AddChild(new AstNode($"Tipo de Return\\n{returnType}"));
    }
    
    // Agregar cuerpo de la función
    var bodyNode = Visit(context.bloque());
    funcNode.AddChild(bodyNode);
    
    return funcNode;
}

public override AstNode VisitParamsList([NotNull] gramaticaParser.ParamsListContext context)
{
    var paramsNode = new AstNode("Parametros");
    
    foreach (var param in context.param())
    {
        paramsNode.AddChild(Visit(param));
    }
    
    return paramsNode;
}

public override AstNode VisitParam([NotNull] gramaticaParser.ParamContext context)
{
    string paramName = context.IDENTIFIER().GetText();
    string paramType = context.typeSpec().GetText();
    
    return new AstNode($"Parametro\\n{paramName}: {paramType}");
}

public override AstNode VisitBloque([NotNull] gramaticaParser.BloqueContext context)
{
    var bloqueNode = new AstNode("Bloque");
    
    foreach (var instr in context.instruction())
    {
        bloqueNode.AddChild(Visit(instr));
    }
    
    return bloqueNode;
}

public override AstNode VisitInstruction([NotNull] gramaticaParser.InstructionContext context)
{
    if (context.declaracion() != null)
        return Visit(context.declaracion());

    if (context.assignacion() != null)
        return Visit(context.assignacion());

    if (context.exprStmt() != null)
        return Visit(context.exprStmt());

    if (context.printStmt() != null)
        return Visit(context.printStmt());

    if (context.ifStmt() != null)
        return Visit(context.ifStmt());

    if (context.forStmt() != null)
        return Visit(context.forStmt());

    if (context.switchStmt() != null)
        return Visit(context.switchStmt());

    if (context.breakStmt() != null)
        return Visit(context.breakStmt());

    if (context.continueStmt() != null)
        return Visit(context.continueStmt());

    if (context.returnStmt() != null)
        return Visit(context.returnStmt());
    
    if (context.incDecStmt() != null)
        return Visit(context.incDecStmt());

    return new AstNode($"Instruccion Desconocida\\n{context.GetText()}");
}

public override AstNode VisitPrintStmt([NotNull] gramaticaParser.PrintStmtContext context)
{
    var printNode = new AstNode("fmt.Println");

    var argsNode = new AstNode("Arumentos");

    if (context.argumentList() != null)
    {
        foreach (var expr in context.argumentList().expresion())
        {
            argsNode.AddChild(Visit(expr));
        }
    }

    if (argsNode.Children.Count > 0)
    {
        printNode.AddChild(argsNode);
    }

    return printNode;
}

public override AstNode VisitConversionFunc([NotNull] gramaticaParser.ConversionFuncContext context)
{
    string functionName = "";
    
    if (context.STRCONV() != null && context.ATOI() != null)
    {
        functionName = "strconv.Atoi";
    }
    else if (context.STRCONV() != null && context.PARSERFLOAT() != null)
    {
        functionName = "strconv.ParseFloat";
    }
    else if (context.REFLECT() != null && context.TYPEOF() != null)
    {
        functionName = "reflect.TypeOf";
    }
    
    var conversionNode = new AstNode($"Conversion\\n{functionName}");
    
    if (context.expresion() != null)
    {
        conversionNode.AddChild(Visit(context.expresion()));
    }
    
    return conversionNode;
}

public override AstNode VisitBreakStmt([NotNull] gramaticaParser.BreakStmtContext context)
{
    return new AstNode("Break");
}

public override AstNode VisitContinueStmt([NotNull] gramaticaParser.ContinueStmtContext context)
{
    return new AstNode("Continue");
}

public override AstNode VisitReturnStmt([NotNull] gramaticaParser.ReturnStmtContext context)
{
    var returnNode = new AstNode("Return");
    
    if (context.expresion() != null)
    {
        returnNode.AddChild(Visit(context.expresion()));
    }
    
    return returnNode;
}

public override AstNode VisitDeclaracion([NotNull] gramaticaParser.DeclaracionContext context)
{
    var declaracionNode = new AstNode("Declaracion");
    
    // Manejar var o declaración con tipo
    if (context.VAR() != null)
    {
        string varName = context.IDENTIFIER(0).GetText();
        declaracionNode.AddChild(new AstNode($"NombreVariable\\n{varName}"));
    }
    else if (context.IDENTIFIER().Length >= 2)
    {
        string typeName = context.IDENTIFIER(0).GetText();
        string varName = context.IDENTIFIER(1).GetText();
        declaracionNode.AddChild(new AstNode($"TipoVariable\\n{varName}: {typeName}"));
    }
    
    // Valor inicial si existe
    if (context.expresion() != null)
    {
        declaracionNode.AddChild(new AstNode("ValorInicial"));
        declaracionNode.Children.Last().AddChild(Visit(context.expresion()));
    }
    
    return declaracionNode;
}

public override AstNode VisitAssignacion([NotNull] gramaticaParser.AssignacionContext context)
{
    var assignNode = new AstNode("Asignacion");
    
    string leftSide = "";
    for (int i = 0; i < context.IDENTIFIER().Length; i++)
    {
        leftSide += context.IDENTIFIER(i).GetText();
        if (i < context.IDENTIFIER().Length - 1 && context.PUNTO().Length > 0)
            leftSide += ".";
    }
    
    assignNode.AddChild(new AstNode($"Asigno A:\\n{leftSide}"));
    
    if (context.expresion() != null)
    {
        assignNode.AddChild(new AstNode("Valor"));
        assignNode.Children.Last().AddChild(Visit(context.expresion(0)));
    }
    
    return assignNode;
}

public override AstNode VisitExprStmt([NotNull] gramaticaParser.ExprStmtContext context)
{
    var node = new AstNode("Expresion");
    node.AddChild(Visit(context.expresion()));
    return node;
}

public override AstNode VisitExpresion([NotNull] gramaticaParser.ExpresionContext context)
{
    // Expresión unaria (menos o negación)
    if (context.ChildCount == 2 && 
        (context.GetChild(0).GetText() == "-" || context.GetChild(0).GetText() == "!"))
    {
        string op = context.GetChild(0).GetText();
        var unaryNode = new AstNode($"Unario\\n{op}");
        unaryNode.AddChild(Visit(context.GetChild(1)));
        return unaryNode;
    }
    
    // Expresión binaria (operador entre dos expresiones)
    if (context.ChildCount == 3 && 
        context.GetChild(0) is gramaticaParser.ExpresionContext && 
        context.GetChild(2) is gramaticaParser.ExpresionContext)
    {
        string op = context.GetChild(1).GetText();
        var binaryNode = new AstNode($"OperadorBinario\\n{op}");
        binaryNode.AddChild(Visit(context.GetChild(0)));
        binaryNode.AddChild(Visit(context.GetChild(2)));
        return binaryNode;
    }
    
    // Expresión con paréntesis
    if (context.ChildCount >= 3 && 
        context.GetChild(0).GetText() == "(" && 
        context.GetChild(context.ChildCount - 1).GetText() == ")")
    {
        var parenNode = new AstNode("Parentesis");
        // Visitar el contenido dentro de los paréntesis
        parenNode.AddChild(Visit(context.GetChild(1)));
        return parenNode;
    }
    
    // Expresión primaria (literal, identificador, etc.)
    for (int i = 0; i < context.ChildCount; i++)
    {
        if (context.GetChild(i) is gramaticaParser.PrimaryContext)
        {
            return Visit(context.GetChild(i));
        }
    }
    
    // Si no se reconoce ningún patrón específico
    if (context.ChildCount == 1)
    {
        return Visit(context.GetChild(0));
    }
    
    // Fallback: Crear un nodo genérico que muestre el texto de la expresión
    return new AstNode($"Expresion\\n{context.GetText()}");
}

public override AstNode VisitIfStmt([NotNull] gramaticaParser.IfStmtContext context)
{
    var ifNode = new AstNode("if");
    
    var condNode = new AstNode("Condicion");
    condNode.AddChild(Visit(context.expresion()));
    ifNode.AddChild(condNode);
    
    var thenNode = new AstNode("Entonces");
    
    if (context.GetChild(2) is gramaticaParser.BloqueContext)
    {
        thenNode.AddChild(Visit(context.GetChild(2)));
    }
    else
    {
        for (int i = 0; i < context.ChildCount; i++) 
        {
            if (context.GetChild(i) is gramaticaParser.BloqueContext)
            {
                thenNode.AddChild(Visit(context.GetChild(i)));
                break;
            }
        }
    }
    
    ifNode.AddChild(thenNode);
        bool hasElse = false;
        for (int i = 0; i < context.ChildCount; i++) 
    {
        if (context.GetChild(i).GetText() == "else") 
        {
            hasElse = true;
            
            if (i + 1 < context.ChildCount && 
                context.GetChild(i + 1) is gramaticaParser.BloqueContext) 
            {
                var elseNode = new AstNode("Else");
                elseNode.AddChild(Visit(context.GetChild(i + 1)));
                ifNode.AddChild(elseNode);
            }
            
            break;
        }
    }
    
    return ifNode;
}

public override AstNode VisitForStmt([NotNull] gramaticaParser.ForStmtContext context)
{
    var forNode = new AstNode("For");
    
    for (int i = 0; i < context.ChildCount; i++)
    {
        if (context.GetChild(i) is gramaticaParser.ExpresionContext)
        {
            var condNode = new AstNode("Condicion");
            condNode.AddChild(Visit(context.GetChild(i)));
            forNode.AddChild(condNode);
            break;
        }
    }
    
    for (int i = 0; i < context.ChildCount; i++)
    {
        if (context.GetChild(i) is gramaticaParser.BloqueContext)
        {
            forNode.AddChild(Visit(context.GetChild(i)));
            break;
        }
    }
    
    return forNode;
}

public override AstNode VisitPrimary([NotNull] gramaticaParser.PrimaryContext context)
{
    
    if (context.IDENTIFIER() != null && context.IDENTIFIER().Length > 0)
        return new AstNode($"Identificador\\n{context.IDENTIFIER(0).GetText()}");

    if (context.INT_LIT() != null)
        return new AstNode($"Entero\\n{context.INT_LIT().GetText()}");

    if (context.FLOAT_LIT() != null)
        return new AstNode($"Flotante\\n{context.FLOAT_LIT().GetText()}");

    if (context.STRING_LIT() != null)
        return new AstNode($"String\\n{context.STRING_LIT().GetText()}");

    if (context.RUNE_LIT() != null)
        return new AstNode($"Rune\\n{context.RUNE_LIT().GetText()}");

    if (context.expresion() != null && context.expresion().Length > 0)
        return Visit(context.expresion(0));

    if (context.functCall() != null)
        return Visit(context.functCall());

    if (context.NIL() != null)
        return new AstNode("NULO");

    return new AstNode($"Unknown Primary -> {context.GetText()}");
}


public override AstNode VisitFunctCall([NotNull] gramaticaParser.FunctCallContext context)
{
    string funcName = "";
    
    for (int i = 0; i < context.ChildCount; i++)
    {
        string childText = context.GetChild(i).GetText();
        if (childText != "(" && childText != ")")
        {
            if (childText.Contains("."))
            {
                funcName = childText.Split('(')[0];
                break;
            }
            
            if (!string.IsNullOrEmpty(childText) && childText[0] != '(' && childText[0] != ')')
            {
                funcName = childText;
                break;
            }
        }
    }
    
    var funcCallNode = new AstNode($"LlamadaFuncion\\n{funcName}");
    
    bool inArgs = false;
    var argsNode = new AstNode("Parametros");
    
    for (int i = 0; i < context.ChildCount; i++)
    {
        var child = context.GetChild(i);
        string childText = child.GetText();
        
        if (childText == "(")
        {
            inArgs = true;
            continue;
        }
        else if (childText == ")")
        {
            inArgs = false;
            continue;
        }
        
        if (inArgs)
        {
            if (child is gramaticaParser.ExpresionContext)
            {
                argsNode.AddChild(Visit(child));
            }
            else
            {
                for (int j = 0; j < child.ChildCount; j++)
                {
                    var grandchild = child.GetChild(j);
                    
                    if (grandchild is gramaticaParser.ExpresionContext)
                    {
                        argsNode.AddChild(Visit(grandchild));
                    }

                }
            }
        }
    }
    
    if (argsNode.Children.Count > 0)
    {
        funcCallNode.AddChild(argsNode);
    }
    
    return funcCallNode;
}
}
