//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from gramatica.g4 by ANTLR 4.13.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419


using Antlr4.Runtime.Misc;
using IErrorNode = Antlr4.Runtime.Tree.IErrorNode;
using ITerminalNode = Antlr4.Runtime.Tree.ITerminalNode;
using IToken = Antlr4.Runtime.IToken;
using ParserRuleContext = Antlr4.Runtime.ParserRuleContext;

/// <summary>
/// This class provides an empty implementation of <see cref="IgramaticaListener"/>,
/// which can be extended to create a listener which only needs to handle a subset
/// of the available methods.
/// </summary>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.Diagnostics.DebuggerNonUserCode]
[System.CLSCompliant(false)]
public partial class gramaticaBaseListener : IgramaticaListener {
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.program"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterProgram([NotNull] gramaticaParser.ProgramContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.program"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitProgram([NotNull] gramaticaParser.ProgramContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.instruction"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterInstruction([NotNull] gramaticaParser.InstructionContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.instruction"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitInstruction([NotNull] gramaticaParser.InstructionContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.conversionFunc"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterConversionFunc([NotNull] gramaticaParser.ConversionFuncContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.conversionFunc"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitConversionFunc([NotNull] gramaticaParser.ConversionFuncContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.funcDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterFuncDecl([NotNull] gramaticaParser.FuncDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.funcDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitFuncDecl([NotNull] gramaticaParser.FuncDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.paramsList"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterParamsList([NotNull] gramaticaParser.ParamsListContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.paramsList"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitParamsList([NotNull] gramaticaParser.ParamsListContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.param"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterParam([NotNull] gramaticaParser.ParamContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.param"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitParam([NotNull] gramaticaParser.ParamContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.structDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterStructDecl([NotNull] gramaticaParser.StructDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.structDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitStructDecl([NotNull] gramaticaParser.StructDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.fieldDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterFieldDecl([NotNull] gramaticaParser.FieldDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.fieldDecl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitFieldDecl([NotNull] gramaticaParser.FieldDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.structLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterStructLiteral([NotNull] gramaticaParser.StructLiteralContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.structLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitStructLiteral([NotNull] gramaticaParser.StructLiteralContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.fieldValue"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterFieldValue([NotNull] gramaticaParser.FieldValueContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.fieldValue"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitFieldValue([NotNull] gramaticaParser.FieldValueContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.bloque"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterBloque([NotNull] gramaticaParser.BloqueContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.bloque"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitBloque([NotNull] gramaticaParser.BloqueContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.breakStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterBreakStmt([NotNull] gramaticaParser.BreakStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.breakStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitBreakStmt([NotNull] gramaticaParser.BreakStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.continueStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterContinueStmt([NotNull] gramaticaParser.ContinueStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.continueStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitContinueStmt([NotNull] gramaticaParser.ContinueStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.returnStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterReturnStmt([NotNull] gramaticaParser.ReturnStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.returnStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitReturnStmt([NotNull] gramaticaParser.ReturnStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.incDecStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterIncDecStmt([NotNull] gramaticaParser.IncDecStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.incDecStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitIncDecStmt([NotNull] gramaticaParser.IncDecStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forRangeStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForRangeStmt([NotNull] gramaticaParser.ForRangeStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forRangeStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForRangeStmt([NotNull] gramaticaParser.ForRangeStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForStmt([NotNull] gramaticaParser.ForStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForStmt([NotNull] gramaticaParser.ForStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forWhileStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForWhileStmt([NotNull] gramaticaParser.ForWhileStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forWhileStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForWhileStmt([NotNull] gramaticaParser.ForWhileStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forThreePartStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForThreePartStmt([NotNull] gramaticaParser.ForThreePartStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forThreePartStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForThreePartStmt([NotNull] gramaticaParser.ForThreePartStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forInit"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForInit([NotNull] gramaticaParser.ForInitContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forInit"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForInit([NotNull] gramaticaParser.ForInitContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.forPost"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterForPost([NotNull] gramaticaParser.ForPostContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.forPost"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitForPost([NotNull] gramaticaParser.ForPostContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.switchStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterSwitchStmt([NotNull] gramaticaParser.SwitchStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.switchStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitSwitchStmt([NotNull] gramaticaParser.SwitchStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.caseStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterCaseStmt([NotNull] gramaticaParser.CaseStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.caseStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitCaseStmt([NotNull] gramaticaParser.CaseStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.defaultStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterDefaultStmt([NotNull] gramaticaParser.DefaultStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.defaultStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitDefaultStmt([NotNull] gramaticaParser.DefaultStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.ifStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterIfStmt([NotNull] gramaticaParser.IfStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.ifStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitIfStmt([NotNull] gramaticaParser.IfStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.elseIfStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterElseIfStmt([NotNull] gramaticaParser.ElseIfStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.elseIfStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitElseIfStmt([NotNull] gramaticaParser.ElseIfStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.elseStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterElseStmt([NotNull] gramaticaParser.ElseStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.elseStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitElseStmt([NotNull] gramaticaParser.ElseStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.declaracion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterDeclaracion([NotNull] gramaticaParser.DeclaracionContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.declaracion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitDeclaracion([NotNull] gramaticaParser.DeclaracionContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.assignacion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterAssignacion([NotNull] gramaticaParser.AssignacionContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.assignacion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitAssignacion([NotNull] gramaticaParser.AssignacionContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.exprStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterExprStmt([NotNull] gramaticaParser.ExprStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.exprStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitExprStmt([NotNull] gramaticaParser.ExprStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.printStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterPrintStmt([NotNull] gramaticaParser.PrintStmtContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.printStmt"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitPrintStmt([NotNull] gramaticaParser.PrintStmtContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.argumentList"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterArgumentList([NotNull] gramaticaParser.ArgumentListContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.argumentList"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitArgumentList([NotNull] gramaticaParser.ArgumentListContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.expresionOrSliceLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterExpresionOrSliceLiteral([NotNull] gramaticaParser.ExpresionOrSliceLiteralContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.expresionOrSliceLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitExpresionOrSliceLiteral([NotNull] gramaticaParser.ExpresionOrSliceLiteralContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.expresion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterExpresion([NotNull] gramaticaParser.ExpresionContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.expresion"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitExpresion([NotNull] gramaticaParser.ExpresionContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.logicalOrExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterLogicalOrExpr([NotNull] gramaticaParser.LogicalOrExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.logicalOrExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitLogicalOrExpr([NotNull] gramaticaParser.LogicalOrExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.logicalAndExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterLogicalAndExpr([NotNull] gramaticaParser.LogicalAndExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.logicalAndExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitLogicalAndExpr([NotNull] gramaticaParser.LogicalAndExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.equalityExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterEqualityExpr([NotNull] gramaticaParser.EqualityExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.equalityExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitEqualityExpr([NotNull] gramaticaParser.EqualityExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.relationalExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRelationalExpr([NotNull] gramaticaParser.RelationalExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.relationalExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRelationalExpr([NotNull] gramaticaParser.RelationalExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.addExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterAddExpr([NotNull] gramaticaParser.AddExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.addExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitAddExpr([NotNull] gramaticaParser.AddExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.mulExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterMulExpr([NotNull] gramaticaParser.MulExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.mulExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitMulExpr([NotNull] gramaticaParser.MulExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.unaryExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterUnaryExpr([NotNull] gramaticaParser.UnaryExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.unaryExpr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitUnaryExpr([NotNull] gramaticaParser.UnaryExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.sliceFunc"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterSliceFunc([NotNull] gramaticaParser.SliceFuncContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.sliceFunc"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitSliceFunc([NotNull] gramaticaParser.SliceFuncContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.sliceType"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterSliceType([NotNull] gramaticaParser.SliceTypeContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.sliceType"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitSliceType([NotNull] gramaticaParser.SliceTypeContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.typeSpec"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterTypeSpec([NotNull] gramaticaParser.TypeSpecContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.typeSpec"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitTypeSpec([NotNull] gramaticaParser.TypeSpecContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.sliceLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.sliceLiteral"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.primary"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterPrimary([NotNull] gramaticaParser.PrimaryContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.primary"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitPrimary([NotNull] gramaticaParser.PrimaryContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="gramaticaParser.functCall"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterFunctCall([NotNull] gramaticaParser.FunctCallContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="gramaticaParser.functCall"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitFunctCall([NotNull] gramaticaParser.FunctCallContext context) { }

	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void EnterEveryRule([NotNull] ParserRuleContext context) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void ExitEveryRule([NotNull] ParserRuleContext context) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void VisitTerminal([NotNull] ITerminalNode node) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void VisitErrorNode([NotNull] IErrorNode node) { }
}
