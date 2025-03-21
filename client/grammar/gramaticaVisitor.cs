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
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="gramaticaParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public interface IgramaticaVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitProgram([NotNull] gramaticaParser.ProgramContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.instruction"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitInstruction([NotNull] gramaticaParser.InstructionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.conversionFunc"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitConversionFunc([NotNull] gramaticaParser.ConversionFuncContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.funcDecl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFuncDecl([NotNull] gramaticaParser.FuncDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.paramsList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParamsList([NotNull] gramaticaParser.ParamsListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.param"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitParam([NotNull] gramaticaParser.ParamContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.structDecl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructDecl([NotNull] gramaticaParser.StructDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.fieldDecl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFieldDecl([NotNull] gramaticaParser.FieldDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.structLiteral"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStructLiteral([NotNull] gramaticaParser.StructLiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.fieldValue"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFieldValue([NotNull] gramaticaParser.FieldValueContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.bloque"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBloque([NotNull] gramaticaParser.BloqueContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.breakStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitBreakStmt([NotNull] gramaticaParser.BreakStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.continueStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitContinueStmt([NotNull] gramaticaParser.ContinueStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.returnStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitReturnStmt([NotNull] gramaticaParser.ReturnStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.incDecStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIncDecStmt([NotNull] gramaticaParser.IncDecStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forRangeStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForRangeStmt([NotNull] gramaticaParser.ForRangeStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForStmt([NotNull] gramaticaParser.ForStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forWhileStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForWhileStmt([NotNull] gramaticaParser.ForWhileStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forThreePartStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForThreePartStmt([NotNull] gramaticaParser.ForThreePartStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forInit"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForInit([NotNull] gramaticaParser.ForInitContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.forPost"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitForPost([NotNull] gramaticaParser.ForPostContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.switchStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSwitchStmt([NotNull] gramaticaParser.SwitchStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.caseStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitCaseStmt([NotNull] gramaticaParser.CaseStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.defaultStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDefaultStmt([NotNull] gramaticaParser.DefaultStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.ifStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitIfStmt([NotNull] gramaticaParser.IfStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.elseIfStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitElseIfStmt([NotNull] gramaticaParser.ElseIfStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.elseStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitElseStmt([NotNull] gramaticaParser.ElseStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.declaracion"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitDeclaracion([NotNull] gramaticaParser.DeclaracionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.assignacion"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAssignacion([NotNull] gramaticaParser.AssignacionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.exprStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExprStmt([NotNull] gramaticaParser.ExprStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.printStmt"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPrintStmt([NotNull] gramaticaParser.PrintStmtContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.argumentList"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitArgumentList([NotNull] gramaticaParser.ArgumentListContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.expresionOrSliceLiteral"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExpresionOrSliceLiteral([NotNull] gramaticaParser.ExpresionOrSliceLiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.expresion"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitExpresion([NotNull] gramaticaParser.ExpresionContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.logicalOrExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLogicalOrExpr([NotNull] gramaticaParser.LogicalOrExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.logicalAndExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitLogicalAndExpr([NotNull] gramaticaParser.LogicalAndExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.equalityExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEqualityExpr([NotNull] gramaticaParser.EqualityExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.relationalExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRelationalExpr([NotNull] gramaticaParser.RelationalExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.addExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitAddExpr([NotNull] gramaticaParser.AddExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.mulExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMulExpr([NotNull] gramaticaParser.MulExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.unaryExpr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitUnaryExpr([NotNull] gramaticaParser.UnaryExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.sliceFunc"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceFunc([NotNull] gramaticaParser.SliceFuncContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.sliceType"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceType([NotNull] gramaticaParser.SliceTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.typeSpec"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitTypeSpec([NotNull] gramaticaParser.TypeSpecContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.sliceLiteral"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitSliceLiteral([NotNull] gramaticaParser.SliceLiteralContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.primary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitPrimary([NotNull] gramaticaParser.PrimaryContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="gramaticaParser.functCall"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitFunctCall([NotNull] gramaticaParser.FunctCallContext context);
}
