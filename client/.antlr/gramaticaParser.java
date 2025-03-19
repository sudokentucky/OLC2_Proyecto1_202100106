// Generated from /home/sudokentucky/Documentos/COMPI2/OLC2_Proyecto1_202100106/client/gramatica.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class gramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, FMT=2, PRINTLN=3, IF=4, ELSE=5, FOR=6, SWITCH=7, CASE=8, DEFAULT=9, 
		BREAK=10, CONTINUE=11, RETURN=12, LEN=13, APPEND=14, SLICES=15, STRINGS=16, 
		JOIN=17, INDEX=18, STRUCT=19, FUNC=20, INT_TYPE=21, FLOAT64_TYPE=22, STRING_TYPE=23, 
		BOOL_TYPE=24, RUNE_TYPE=25, PUNTO=26, PARENTESIS_IZQ=27, PARENTESIS_DER=28, 
		LLAVE_IZQ=29, LLAVE_DER=30, CORCHETE_IZQ=31, CORCHETE_DER=32, PUNTO_Y_COMA=33, 
		COMA=34, DOS_PUNTOS=35, ASIGNACION=36, ASIGNACIO_INCREMENTO=37, ASIGNACIO_DECREMENTO=38, 
		INCREMENTO=39, DECREMENTO=40, PLUS=41, MINUS=42, STAR=43, DIV=44, MOD=45, 
		IGUAL=46, DIFERENTE=47, MAYOR_QUE=48, MENOR_QUE=49, MAYOR_IGUAL_QUE=50, 
		MENOR_IGUAL_QUE=51, AND=52, OR=53, NOT=54, INT_LIT=55, FLOAT_LIT=56, STRING_LIT=57, 
		RUNE_LIT=58, IDENTIFIER=59, ESPACIO_BLANCO=60, COMENTARIO_LINE=61, COMENTARIO_MULTILINEA=62;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_funcDecl = 2, RULE_paramsList = 3, 
		RULE_param = 4, RULE_structDecl = 5, RULE_fieldDecl = 6, RULE_structLiteral = 7, 
		RULE_fieldValue = 8, RULE_bloque = 9, RULE_breakStmt = 10, RULE_continueStmt = 11, 
		RULE_returnStmt = 12, RULE_incDecStmt = 13, RULE_forStmt = 14, RULE_forWhileStmt = 15, 
		RULE_forThreePartStmt = 16, RULE_forInit = 17, RULE_forPost = 18, RULE_switchStmt = 19, 
		RULE_caseStmt = 20, RULE_defaultStmt = 21, RULE_ifStmt = 22, RULE_elseIfStmt = 23, 
		RULE_elseStmt = 24, RULE_declaracion = 25, RULE_assignacion = 26, RULE_exprStmt = 27, 
		RULE_printStmt = 28, RULE_argumentList = 29, RULE_expresion = 30, RULE_logicalOrExpr = 31, 
		RULE_logicalAndExpr = 32, RULE_equalityExpr = 33, RULE_relationalExpr = 34, 
		RULE_addExpr = 35, RULE_mulExpr = 36, RULE_unaryExpr = 37, RULE_sliceFunc = 38, 
		RULE_sliceType = 39, RULE_typeSpec = 40, RULE_sliceLiteral = 41, RULE_primary = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruction", "funcDecl", "paramsList", "param", "structDecl", 
			"fieldDecl", "structLiteral", "fieldValue", "bloque", "breakStmt", "continueStmt", 
			"returnStmt", "incDecStmt", "forStmt", "forWhileStmt", "forThreePartStmt", 
			"forInit", "forPost", "switchStmt", "caseStmt", "defaultStmt", "ifStmt", 
			"elseIfStmt", "elseStmt", "declaracion", "assignacion", "exprStmt", "printStmt", 
			"argumentList", "expresion", "logicalOrExpr", "logicalAndExpr", "equalityExpr", 
			"relationalExpr", "addExpr", "mulExpr", "unaryExpr", "sliceFunc", "sliceType", 
			"typeSpec", "sliceLiteral", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'fmt'", "'Println'", "'if'", "'else'", "'for'", "'switch'", 
			"'case'", "'default'", "'break'", "'continue'", "'return'", "'len'", 
			"'append'", "'slices'", "'strings'", "'join'", "'Index'", "'struct'", 
			"'func'", "'int'", "'float64'", "'string'", "'bool'", "'rune'", "'.'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "':'", "'='", 
			"'+='", "'-='", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", 
			"'!='", "'>'", "'<'", "'>='", "'<='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "FMT", "PRINTLN", "IF", "ELSE", "FOR", "SWITCH", "CASE", 
			"DEFAULT", "BREAK", "CONTINUE", "RETURN", "LEN", "APPEND", "SLICES", 
			"STRINGS", "JOIN", "INDEX", "STRUCT", "FUNC", "INT_TYPE", "FLOAT64_TYPE", 
			"STRING_TYPE", "BOOL_TYPE", "RUNE_TYPE", "PUNTO", "PARENTESIS_IZQ", "PARENTESIS_DER", 
			"LLAVE_IZQ", "LLAVE_DER", "CORCHETE_IZQ", "CORCHETE_DER", "PUNTO_Y_COMA", 
			"COMA", "DOS_PUNTOS", "ASIGNACION", "ASIGNACIO_INCREMENTO", "ASIGNACIO_DECREMENTO", 
			"INCREMENTO", "DECREMENTO", "PLUS", "MINUS", "STAR", "DIV", "MOD", "IGUAL", 
			"DIFERENTE", "MAYOR_QUE", "MENOR_QUE", "MAYOR_IGUAL_QUE", "MENOR_IGUAL_QUE", 
			"AND", "OR", "NOT", "INT_LIT", "FLOAT_LIT", "STRING_LIT", "RUNE_LIT", 
			"IDENTIFIER", "ESPACIO_BLANCO", "COMENTARIO_LINE", "COMENTARIO_MULTILINEA"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(gramaticaParser.EOF, 0); }
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506964151510L) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(86);
					structDecl();
					}
					break;
				case FUNC:
					{
					setState(87);
					funcDecl();
					}
					break;
				case VAR:
				case FMT:
				case IF:
				case FOR:
				case SWITCH:
				case BREAK:
				case CONTINUE:
				case RETURN:
				case LEN:
				case APPEND:
				case SLICES:
				case STRINGS:
				case PARENTESIS_IZQ:
				case LLAVE_IZQ:
				case CORCHETE_IZQ:
				case MINUS:
				case NOT:
				case INT_LIT:
				case FLOAT_LIT:
				case STRING_LIT:
				case RUNE_LIT:
				case IDENTIFIER:
					{
					setState(88);
					instruction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AssignacionContext assignacion() {
			return getRuleContext(AssignacionContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public IncDecStmtContext incDecStmt() {
			return getRuleContext(IncDecStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				assignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				printStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
				switchStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				forStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				incDecStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				returnStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(105);
				continueStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(106);
				breakStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(gramaticaParser.FUNC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(FUNC);
			setState(110);
			match(IDENTIFIER);
			setState(111);
			match(PARENTESIS_IZQ);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(112);
				paramsList();
				}
			}

			setState(115);
			match(PARENTESIS_DER);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460754515918848L) != 0)) {
				{
				setState(116);
				typeSpec();
				}
			}

			setState(119);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(gramaticaParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gramaticaParser.COMA, i);
		}
		public ParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsList; }
	}

	public final ParamsListContext paramsList() throws RecognitionException {
		ParamsListContext _localctx = new ParamsListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			param();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(122);
				match(COMA);
				setState(123);
				param();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(IDENTIFIER);
			setState(130);
			typeSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(gramaticaParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(gramaticaParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(gramaticaParser.LLAVE_DER, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(STRUCT);
			setState(133);
			match(IDENTIFIER);
			setState(134);
			match(LLAVE_IZQ);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				fieldDecl();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 576460754515918848L) != 0) );
			setState(140);
			match(LLAVE_DER);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(141);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			typeSpec();
			setState(145);
			match(IDENTIFIER);
			setState(146);
			match(PUNTO_Y_COMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructLiteralContext extends ParserRuleContext {
		public TerminalNode LLAVE_IZQ() { return getToken(gramaticaParser.LLAVE_IZQ, 0); }
		public List<FieldValueContext> fieldValue() {
			return getRuleContexts(FieldValueContext.class);
		}
		public FieldValueContext fieldValue(int i) {
			return getRuleContext(FieldValueContext.class,i);
		}
		public TerminalNode LLAVE_DER() { return getToken(gramaticaParser.LLAVE_DER, 0); }
		public List<TerminalNode> COMA() { return getTokens(gramaticaParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gramaticaParser.COMA, i);
		}
		public StructLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structLiteral; }
	}

	public final StructLiteralContext structLiteral() throws RecognitionException {
		StructLiteralContext _localctx = new StructLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(LLAVE_IZQ);
			setState(149);
			fieldValue();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					match(COMA);
					setState(151);
					fieldValue();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(157);
				match(COMA);
				}
			}

			setState(160);
			match(LLAVE_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldValueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(gramaticaParser.DOS_PUNTOS, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(IDENTIFIER);
			setState(163);
			match(DOS_PUNTOS);
			setState(164);
			expresion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LLAVE_IZQ() { return getToken(gramaticaParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(gramaticaParser.LLAVE_DER, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(LLAVE_IZQ);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962578646L) != 0)) {
				{
				{
				setState(167);
				instruction();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(LLAVE_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(gramaticaParser.BREAK, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_breakStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(BREAK);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(176);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(gramaticaParser.CONTINUE, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_continueStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(CONTINUE);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(180);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(gramaticaParser.RETURN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(RETURN);
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(184);
				expresion();
				}
				break;
			}
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(187);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncDecStmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode INCREMENTO() { return getToken(gramaticaParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(gramaticaParser.DECREMENTO, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public IncDecStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDecStmt; }
	}

	public final IncDecStmtContext incDecStmt() throws RecognitionException {
		IncDecStmtContext _localctx = new IncDecStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_incDecStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(IDENTIFIER);
			setState(191);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(192);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public ForWhileStmtContext forWhileStmt() {
			return getRuleContext(ForWhileStmtContext.class,0);
		}
		public ForThreePartStmtContext forThreePartStmt() {
			return getRuleContext(ForThreePartStmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStmt);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				forWhileStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				forThreePartStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForWhileStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(gramaticaParser.FOR, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ForWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forWhileStmt; }
	}

	public final ForWhileStmtContext forWhileStmt() throws RecognitionException {
		ForWhileStmtContext _localctx = new ForWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FOR);
			setState(200);
			expresion();
			setState(201);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForThreePartStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(gramaticaParser.FOR, 0); }
		public List<TerminalNode> PUNTO_Y_COMA() { return getTokens(gramaticaParser.PUNTO_Y_COMA); }
		public TerminalNode PUNTO_Y_COMA(int i) {
			return getToken(gramaticaParser.PUNTO_Y_COMA, i);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ForPostContext forPost() {
			return getRuleContext(ForPostContext.class,0);
		}
		public ForThreePartStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forThreePartStmt; }
	}

	public final ForThreePartStmtContext forThreePartStmt() throws RecognitionException {
		ForThreePartStmtContext _localctx = new ForThreePartStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forThreePartStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(FOR);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR || _la==IDENTIFIER) {
				{
				setState(204);
				forInit();
				}
			}

			setState(207);
			match(PUNTO_Y_COMA);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962571264L) != 0)) {
				{
				setState(208);
				expresion();
				}
			}

			setState(211);
			match(PUNTO_Y_COMA);
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(212);
				forPost();
				}
				break;
			}
			setState(215);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public AssignacionContext assignacion() {
			return getRuleContext(AssignacionContext.class,0);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forInit);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				assignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				declaracion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForPostContext extends ParserRuleContext {
		public AssignacionContext assignacion() {
			return getRuleContext(AssignacionContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public IncDecStmtContext incDecStmt() {
			return getRuleContext(IncDecStmtContext.class,0);
		}
		public ForPostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forPost; }
	}

	public final ForPostContext forPost() throws RecognitionException {
		ForPostContext _localctx = new ForPostContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forPost);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				assignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				exprStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				incDecStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(gramaticaParser.SWITCH, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(gramaticaParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(gramaticaParser.LLAVE_DER, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public List<CaseStmtContext> caseStmt() {
			return getRuleContexts(CaseStmtContext.class);
		}
		public CaseStmtContext caseStmt(int i) {
			return getRuleContext(CaseStmtContext.class,i);
		}
		public DefaultStmtContext defaultStmt() {
			return getRuleContext(DefaultStmtContext.class,0);
		}
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_switchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(SWITCH);
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(227);
				match(PARENTESIS_IZQ);
				setState(228);
				expresion();
				setState(229);
				match(PARENTESIS_DER);
				}
				break;
			case 2:
				{
				setState(231);
				expresion();
				}
				break;
			}
			setState(234);
			match(LLAVE_IZQ);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(235);
				caseStmt();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(241);
				defaultStmt();
				}
			}

			setState(244);
			match(LLAVE_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseStmtContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(gramaticaParser.CASE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode DOS_PUNTOS() { return getToken(gramaticaParser.DOS_PUNTOS, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStmt; }
	}

	public final CaseStmtContext caseStmt() throws RecognitionException {
		CaseStmtContext _localctx = new CaseStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_caseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(CASE);
			setState(247);
			expresion();
			setState(248);
			match(DOS_PUNTOS);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962578646L) != 0)) {
				{
				{
				setState(249);
				instruction();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultStmtContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(gramaticaParser.DEFAULT, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(gramaticaParser.DOS_PUNTOS, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public DefaultStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStmt; }
	}

	public final DefaultStmtContext defaultStmt() throws RecognitionException {
		DefaultStmtContext _localctx = new DefaultStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_defaultStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(DEFAULT);
			setState(256);
			match(DOS_PUNTOS);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962578646L) != 0)) {
				{
				{
				setState(257);
				instruction();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(gramaticaParser.IF, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<ElseIfStmtContext> elseIfStmt() {
			return getRuleContexts(ElseIfStmtContext.class);
		}
		public ElseIfStmtContext elseIfStmt(int i) {
			return getRuleContext(ElseIfStmtContext.class,i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(IF);
			{
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(264);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(267);
			expresion();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(268);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(271);
			bloque();
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(272);
					elseIfStmt();
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(278);
				elseStmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(gramaticaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(gramaticaParser.IF, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public ElseIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStmt; }
	}

	public final ElseIfStmtContext elseIfStmt() throws RecognitionException {
		ElseIfStmtContext _localctx = new ElseIfStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_elseIfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(ELSE);
			setState(282);
			match(IF);
			{
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(283);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(286);
			expresion();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(287);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(290);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(gramaticaParser.ELSE, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(ELSE);
			setState(293);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(gramaticaParser.VAR, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(gramaticaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(gramaticaParser.IDENTIFIER, i);
		}
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode ASIGNACION() { return getToken(gramaticaParser.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public StructLiteralContext structLiteral() {
			return getRuleContext(StructLiteralContext.class,0);
		}
		public TerminalNode FUNC() { return getToken(gramaticaParser.FUNC, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declaracion);
		int _la;
		try {
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(VAR);
				setState(296);
				match(IDENTIFIER);
				setState(298);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(297);
					typeSpec();
					}
					break;
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIGNACION) {
					{
					setState(300);
					match(ASIGNACION);
					setState(301);
					expresion();
					}
				}

				setState(305);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(304);
					match(PUNTO_Y_COMA);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(IDENTIFIER);
				setState(308);
				match(IDENTIFIER);
				setState(309);
				match(ASIGNACION);
				setState(310);
				structLiteral();
				setState(312);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(311);
					match(PUNTO_Y_COMA);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				match(VAR);
				setState(315);
				match(IDENTIFIER);
				setState(316);
				match(ASIGNACION);
				setState(317);
				match(FUNC);
				setState(318);
				match(PARENTESIS_IZQ);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(319);
					paramsList();
					}
				}

				setState(322);
				match(PARENTESIS_DER);
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460754515918848L) != 0)) {
					{
					setState(323);
					typeSpec();
					}
				}

				setState(326);
				bloque();
				setState(328);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(327);
					match(PUNTO_Y_COMA);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignacionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode ASIGNACION() { return getToken(gramaticaParser.ASIGNACION, 0); }
		public TerminalNode ASIGNACIO_INCREMENTO() { return getToken(gramaticaParser.ASIGNACIO_INCREMENTO, 0); }
		public TerminalNode ASIGNACIO_DECREMENTO() { return getToken(gramaticaParser.ASIGNACIO_DECREMENTO, 0); }
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public AssignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignacion; }
	}

	public final AssignacionContext assignacion() throws RecognitionException {
		AssignacionContext _localctx = new AssignacionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(IDENTIFIER);
			setState(333);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(334);
			expresion();
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(335);
				match(PUNTO_Y_COMA);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			expresion();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(339);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode FMT() { return getToken(gramaticaParser.FMT, 0); }
		public TerminalNode PUNTO() { return getToken(gramaticaParser.PUNTO, 0); }
		public TerminalNode PRINTLN() { return getToken(gramaticaParser.PRINTLN, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_printStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(FMT);
			setState(343);
			match(PUNTO);
			setState(344);
			match(PRINTLN);
			setState(345);
			match(PARENTESIS_IZQ);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962571264L) != 0)) {
				{
				setState(346);
				argumentList();
				}
			}

			setState(349);
			match(PARENTESIS_DER);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(350);
				match(PUNTO_Y_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(gramaticaParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gramaticaParser.COMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			expresion();
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(354);
				match(COMA);
				setState(355);
				expresion();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			logicalOrExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(gramaticaParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(gramaticaParser.OR, i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			logicalAndExpr();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(364);
				match(OR);
				setState(365);
				logicalAndExpr();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(gramaticaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(gramaticaParser.AND, i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			equalityExpr();
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(372);
				match(AND);
				setState(373);
				equalityExpr();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public List<TerminalNode> IGUAL() { return getTokens(gramaticaParser.IGUAL); }
		public TerminalNode IGUAL(int i) {
			return getToken(gramaticaParser.IGUAL, i);
		}
		public List<TerminalNode> DIFERENTE() { return getTokens(gramaticaParser.DIFERENTE); }
		public TerminalNode DIFERENTE(int i) {
			return getToken(gramaticaParser.DIFERENTE, i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			relationalExpr();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUAL || _la==DIFERENTE) {
				{
				{
				setState(380);
				_la = _input.LA(1);
				if ( !(_la==IGUAL || _la==DIFERENTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(381);
				relationalExpr();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public List<TerminalNode> MAYOR_QUE() { return getTokens(gramaticaParser.MAYOR_QUE); }
		public TerminalNode MAYOR_QUE(int i) {
			return getToken(gramaticaParser.MAYOR_QUE, i);
		}
		public List<TerminalNode> MENOR_QUE() { return getTokens(gramaticaParser.MENOR_QUE); }
		public TerminalNode MENOR_QUE(int i) {
			return getToken(gramaticaParser.MENOR_QUE, i);
		}
		public List<TerminalNode> MAYOR_IGUAL_QUE() { return getTokens(gramaticaParser.MAYOR_IGUAL_QUE); }
		public TerminalNode MAYOR_IGUAL_QUE(int i) {
			return getToken(gramaticaParser.MAYOR_IGUAL_QUE, i);
		}
		public List<TerminalNode> MENOR_IGUAL_QUE() { return getTokens(gramaticaParser.MENOR_IGUAL_QUE); }
		public TerminalNode MENOR_IGUAL_QUE(int i) {
			return getToken(gramaticaParser.MENOR_IGUAL_QUE, i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			addExpr();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4222124650659840L) != 0)) {
				{
				{
				setState(388);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4222124650659840L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(389);
				addExpr();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(gramaticaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(gramaticaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(gramaticaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(gramaticaParser.MINUS, i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			mulExpr();
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(396);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(397);
					mulExpr();
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(gramaticaParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(gramaticaParser.STAR, i);
		}
		public List<TerminalNode> DIV() { return getTokens(gramaticaParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(gramaticaParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(gramaticaParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(gramaticaParser.MOD, i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			unaryExpr();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 61572651155456L) != 0)) {
				{
				{
				setState(404);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61572651155456L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(405);
				unaryExpr();
				}
				}
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(gramaticaParser.MINUS, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(gramaticaParser.NOT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public SliceFuncContext sliceFunc() {
			return getRuleContext(SliceFuncContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unaryExpr);
		try {
			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(MINUS);
				setState(412);
				unaryExpr();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				match(NOT);
				setState(414);
				unaryExpr();
				}
				break;
			case PARENTESIS_IZQ:
			case LLAVE_IZQ:
			case CORCHETE_IZQ:
			case INT_LIT:
			case FLOAT_LIT:
			case STRING_LIT:
			case RUNE_LIT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				primary();
				}
				break;
			case LEN:
			case APPEND:
			case SLICES:
			case STRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(416);
				sliceFunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SliceFuncContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(gramaticaParser.LEN, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public TerminalNode APPEND() { return getToken(gramaticaParser.APPEND, 0); }
		public List<TerminalNode> COMA() { return getTokens(gramaticaParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gramaticaParser.COMA, i);
		}
		public TerminalNode SLICES() { return getToken(gramaticaParser.SLICES, 0); }
		public TerminalNode PUNTO() { return getToken(gramaticaParser.PUNTO, 0); }
		public TerminalNode INDEX() { return getToken(gramaticaParser.INDEX, 0); }
		public TerminalNode STRINGS() { return getToken(gramaticaParser.STRINGS, 0); }
		public TerminalNode JOIN() { return getToken(gramaticaParser.JOIN, 0); }
		public SliceFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceFunc; }
	}

	public final SliceFuncContext sliceFunc() throws RecognitionException {
		SliceFuncContext _localctx = new SliceFuncContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_sliceFunc);
		int _la;
		try {
			setState(454);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(LEN);
				setState(420);
				match(PARENTESIS_IZQ);
				setState(421);
				expresion();
				setState(422);
				match(PARENTESIS_DER);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				match(APPEND);
				setState(425);
				match(PARENTESIS_IZQ);
				setState(426);
				expresion();
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(427);
					match(COMA);
					setState(428);
					expresion();
					}
					}
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(434);
				match(PARENTESIS_DER);
				}
				break;
			case SLICES:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				match(SLICES);
				setState(437);
				match(PUNTO);
				setState(438);
				match(INDEX);
				setState(439);
				match(PARENTESIS_IZQ);
				setState(440);
				expresion();
				setState(441);
				match(COMA);
				setState(442);
				expresion();
				setState(443);
				match(PARENTESIS_DER);
				}
				break;
			case STRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				match(STRINGS);
				setState(446);
				match(PUNTO);
				setState(447);
				match(JOIN);
				setState(448);
				match(PARENTESIS_IZQ);
				setState(449);
				expresion();
				setState(450);
				match(COMA);
				setState(451);
				expresion();
				setState(452);
				match(PARENTESIS_DER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SliceTypeContext extends ParserRuleContext {
		public TerminalNode CORCHETE_IZQ() { return getToken(gramaticaParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(gramaticaParser.CORCHETE_DER, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public SliceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceType; }
	}

	public final SliceTypeContext sliceType() throws RecognitionException {
		SliceTypeContext _localctx = new SliceTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sliceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(CORCHETE_IZQ);
			setState(457);
			match(CORCHETE_DER);
			setState(458);
			typeSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(gramaticaParser.INT_TYPE, 0); }
		public TerminalNode FLOAT64_TYPE() { return getToken(gramaticaParser.FLOAT64_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(gramaticaParser.STRING_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(gramaticaParser.BOOL_TYPE, 0); }
		public TerminalNode RUNE_TYPE() { return getToken(gramaticaParser.RUNE_TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public SliceTypeContext sliceType() {
			return getRuleContext(SliceTypeContext.class,0);
		}
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_typeSpec);
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				match(INT_TYPE);
				}
				break;
			case FLOAT64_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				match(FLOAT64_TYPE);
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(462);
				match(STRING_TYPE);
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				match(BOOL_TYPE);
				}
				break;
			case RUNE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(464);
				match(RUNE_TYPE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(465);
				match(IDENTIFIER);
				}
				break;
			case CORCHETE_IZQ:
				enterOuterAlt(_localctx, 7);
				{
				setState(466);
				sliceType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SliceLiteralContext extends ParserRuleContext {
		public TerminalNode CORCHETE_IZQ() { return getToken(gramaticaParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(gramaticaParser.CORCHETE_DER, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode LLAVE_IZQ() { return getToken(gramaticaParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(gramaticaParser.LLAVE_DER, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(gramaticaParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(gramaticaParser.COMA, i);
		}
		public SliceLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceLiteral; }
	}

	public final SliceLiteralContext sliceLiteral() throws RecognitionException {
		SliceLiteralContext _localctx = new SliceLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_sliceLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(CORCHETE_IZQ);
			setState(470);
			match(CORCHETE_DER);
			setState(471);
			typeSpec();
			setState(472);
			match(LLAVE_IZQ);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962571264L) != 0)) {
				{
				setState(473);
				expresion();
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(474);
					match(COMA);
					setState(475);
					expresion();
					}
					}
					setState(480);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(483);
			match(LLAVE_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(gramaticaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(gramaticaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> CORCHETE_IZQ() { return getTokens(gramaticaParser.CORCHETE_IZQ); }
		public TerminalNode CORCHETE_IZQ(int i) {
			return getToken(gramaticaParser.CORCHETE_IZQ, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> CORCHETE_DER() { return getTokens(gramaticaParser.CORCHETE_DER); }
		public TerminalNode CORCHETE_DER(int i) {
			return getToken(gramaticaParser.CORCHETE_DER, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(gramaticaParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(gramaticaParser.PUNTO, i);
		}
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode RUNE_LIT() { return getToken(gramaticaParser.RUNE_LIT, 0); }
		public TerminalNode INT_LIT() { return getToken(gramaticaParser.INT_LIT, 0); }
		public TerminalNode FLOAT_LIT() { return getToken(gramaticaParser.FLOAT_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(gramaticaParser.STRING_LIT, 0); }
		public SliceLiteralContext sliceLiteral() {
			return getRuleContext(SliceLiteralContext.class,0);
		}
		public StructLiteralContext structLiteral() {
			return getRuleContext(StructLiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_primary);
		int _la;
		try {
			int _alt;
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				match(IDENTIFIER);
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(486);
						match(CORCHETE_IZQ);
						setState(487);
						expresion();
						setState(488);
						match(CORCHETE_DER);
						}
						} 
					}
					setState(494);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PUNTO) {
					{
					{
					setState(495);
					match(PUNTO);
					setState(496);
					match(IDENTIFIER);
					}
					}
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				match(IDENTIFIER);
				setState(503);
				match(PARENTESIS_IZQ);
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1134911506962571264L) != 0)) {
					{
					setState(504);
					argumentList();
					}
				}

				setState(507);
				match(PARENTESIS_DER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(508);
				match(RUNE_LIT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				match(INT_LIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(510);
				match(FLOAT_LIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(511);
				match(STRING_LIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(512);
				match(PARENTESIS_IZQ);
				setState(513);
				expresion();
				setState(514);
				match(PARENTESIS_DER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(516);
				sliceLiteral();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(517);
				structLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u0209\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000Z\b\u0000\n\u0000\f\u0000]\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"l\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"r\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002v\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003}\b\u0003\n\u0003"+
		"\f\u0003\u0080\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0089\b\u0005\u000b\u0005"+
		"\f\u0005\u008a\u0001\u0005\u0001\u0005\u0003\u0005\u008f\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0099\b\u0007\n\u0007\f\u0007\u009c\t\u0007"+
		"\u0001\u0007\u0003\u0007\u009f\b\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u00a9\b\t\n\t\f\t\u00ac"+
		"\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u00b2\b\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00b6\b\u000b\u0001\f\u0001\f\u0003\f\u00ba\b\f\u0001"+
		"\f\u0003\f\u00bd\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u00c2\b\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00c6\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00ce\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00d2\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00d6\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00dc\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00e1\b"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u00e9\b\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00ed"+
		"\b\u0013\n\u0013\f\u0013\u00f0\t\u0013\u0001\u0013\u0003\u0013\u00f3\b"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u00fb\b\u0014\n\u0014\f\u0014\u00fe\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u0103\b\u0015\n\u0015\f\u0015\u0106"+
		"\t\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u010a\b\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u010e\b\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u0112\b\u0016\n\u0016\f\u0016\u0115\t\u0016\u0001\u0016\u0003\u0016\u0118"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u011d\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u0121\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u012b\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u012f\b"+
		"\u0019\u0001\u0019\u0003\u0019\u0132\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0139\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0141"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0145\b\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0149\b\u0019\u0003\u0019\u014b\b\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0151\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u0155\b\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u015c\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u0160\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u0165\b\u001d\n\u001d\f\u001d\u0168\t\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u016f\b\u001f\n\u001f"+
		"\f\u001f\u0172\t\u001f\u0001 \u0001 \u0001 \u0005 \u0177\b \n \f \u017a"+
		"\t \u0001!\u0001!\u0001!\u0005!\u017f\b!\n!\f!\u0182\t!\u0001\"\u0001"+
		"\"\u0001\"\u0005\"\u0187\b\"\n\"\f\"\u018a\t\"\u0001#\u0001#\u0001#\u0005"+
		"#\u018f\b#\n#\f#\u0192\t#\u0001$\u0001$\u0001$\u0005$\u0197\b$\n$\f$\u019a"+
		"\t$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u01a2\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u01ae"+
		"\b&\n&\f&\u01b1\t&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u01c7\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u01d4\b(\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0005)\u01dd\b)\n)\f)\u01e0\t)\u0003"+
		")\u01e2\b)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u01eb"+
		"\b*\n*\f*\u01ee\t*\u0001*\u0001*\u0005*\u01f2\b*\n*\f*\u01f5\t*\u0001"+
		"*\u0001*\u0001*\u0003*\u01fa\b*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u0207\b*\u0001*\u0000\u0000"+
		"+\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRT\u0000\u0006\u0001\u0000\'(\u0001"+
		"\u0000$&\u0001\u0000./\u0001\u000003\u0001\u0000)*\u0001\u0000+-\u0237"+
		"\u0000[\u0001\u0000\u0000\u0000\u0002k\u0001\u0000\u0000\u0000\u0004m"+
		"\u0001\u0000\u0000\u0000\u0006y\u0001\u0000\u0000\u0000\b\u0081\u0001"+
		"\u0000\u0000\u0000\n\u0084\u0001\u0000\u0000\u0000\f\u0090\u0001\u0000"+
		"\u0000\u0000\u000e\u0094\u0001\u0000\u0000\u0000\u0010\u00a2\u0001\u0000"+
		"\u0000\u0000\u0012\u00a6\u0001\u0000\u0000\u0000\u0014\u00af\u0001\u0000"+
		"\u0000\u0000\u0016\u00b3\u0001\u0000\u0000\u0000\u0018\u00b7\u0001\u0000"+
		"\u0000\u0000\u001a\u00be\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000"+
		"\u0000\u0000\u001e\u00c7\u0001\u0000\u0000\u0000 \u00cb\u0001\u0000\u0000"+
		"\u0000\"\u00db\u0001\u0000\u0000\u0000$\u00e0\u0001\u0000\u0000\u0000"+
		"&\u00e2\u0001\u0000\u0000\u0000(\u00f6\u0001\u0000\u0000\u0000*\u00ff"+
		"\u0001\u0000\u0000\u0000,\u0107\u0001\u0000\u0000\u0000.\u0119\u0001\u0000"+
		"\u0000\u00000\u0124\u0001\u0000\u0000\u00002\u014a\u0001\u0000\u0000\u0000"+
		"4\u014c\u0001\u0000\u0000\u00006\u0152\u0001\u0000\u0000\u00008\u0156"+
		"\u0001\u0000\u0000\u0000:\u0161\u0001\u0000\u0000\u0000<\u0169\u0001\u0000"+
		"\u0000\u0000>\u016b\u0001\u0000\u0000\u0000@\u0173\u0001\u0000\u0000\u0000"+
		"B\u017b\u0001\u0000\u0000\u0000D\u0183\u0001\u0000\u0000\u0000F\u018b"+
		"\u0001\u0000\u0000\u0000H\u0193\u0001\u0000\u0000\u0000J\u01a1\u0001\u0000"+
		"\u0000\u0000L\u01c6\u0001\u0000\u0000\u0000N\u01c8\u0001\u0000\u0000\u0000"+
		"P\u01d3\u0001\u0000\u0000\u0000R\u01d5\u0001\u0000\u0000\u0000T\u0206"+
		"\u0001\u0000\u0000\u0000VZ\u0003\n\u0005\u0000WZ\u0003\u0004\u0002\u0000"+
		"XZ\u0003\u0002\u0001\u0000YV\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^_\u0005\u0000\u0000\u0001_\u0001\u0001\u0000\u0000"+
		"\u0000`l\u00032\u0019\u0000al\u00034\u001a\u0000bl\u00036\u001b\u0000"+
		"cl\u00038\u001c\u0000dl\u0003,\u0016\u0000el\u0003&\u0013\u0000fl\u0003"+
		"\u001c\u000e\u0000gl\u0003\u001a\r\u0000hl\u0003\u0018\f\u0000il\u0003"+
		"\u0016\u000b\u0000jl\u0003\u0014\n\u0000k`\u0001\u0000\u0000\u0000ka\u0001"+
		"\u0000\u0000\u0000kb\u0001\u0000\u0000\u0000kc\u0001\u0000\u0000\u0000"+
		"kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kf\u0001\u0000\u0000"+
		"\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0003\u0001\u0000\u0000\u0000"+
		"mn\u0005\u0014\u0000\u0000no\u0005;\u0000\u0000oq\u0005\u001b\u0000\u0000"+
		"pr\u0003\u0006\u0003\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000su\u0005\u001c\u0000\u0000tv\u0003P(\u0000"+
		"ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0003\u0012\t\u0000x\u0005\u0001\u0000\u0000\u0000y~\u0003\b"+
		"\u0004\u0000z{\u0005\"\u0000\u0000{}\u0003\b\u0004\u0000|z\u0001\u0000"+
		"\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0007\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0082\u0005;\u0000\u0000\u0082\u0083\u0003"+
		"P(\u0000\u0083\t\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0013\u0000"+
		"\u0000\u0085\u0086\u0005;\u0000\u0000\u0086\u0088\u0005\u001d\u0000\u0000"+
		"\u0087\u0089\u0003\f\u0006\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c"+
		"\u008e\u0005\u001e\u0000\u0000\u008d\u008f\u0005!\u0000\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u000b"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0003P(\u0000\u0091\u0092\u0005;"+
		"\u0000\u0000\u0092\u0093\u0005!\u0000\u0000\u0093\r\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005\u001d\u0000\u0000\u0095\u009a\u0003\u0010\b\u0000"+
		"\u0096\u0097\u0005\"\u0000\u0000\u0097\u0099\u0003\u0010\b\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0005\"\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0005\u001e\u0000\u0000\u00a1\u000f\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005;\u0000\u0000\u00a3\u00a4\u0005#\u0000\u0000\u00a4\u00a5\u0003<"+
		"\u001e\u0000\u00a5\u0011\u0001\u0000\u0000\u0000\u00a6\u00aa\u0005\u001d"+
		"\u0000\u0000\u00a7\u00a9\u0003\u0002\u0001\u0000\u00a8\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u001e"+
		"\u0000\u0000\u00ae\u0013\u0001\u0000\u0000\u0000\u00af\u00b1\u0005\n\u0000"+
		"\u0000\u00b0\u00b2\u0005!\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u0015\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b5\u0005\u000b\u0000\u0000\u00b4\u00b6\u0005!\u0000\u0000\u00b5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u0017\u0001\u0000\u0000\u0000\u00b7\u00b9\u0005\f\u0000\u0000\u00b8\u00ba"+
		"\u0003<\u001e\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00bd\u0005"+
		"!\u0000\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u0019\u0001\u0000\u0000\u0000\u00be\u00bf\u0005;\u0000"+
		"\u0000\u00bf\u00c1\u0007\u0000\u0000\u0000\u00c0\u00c2\u0005!\u0000\u0000"+
		"\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u001b\u0001\u0000\u0000\u0000\u00c3\u00c6\u0003\u001e\u000f\u0000"+
		"\u00c4\u00c6\u0003 \u0010\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c6\u001d\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005\u0006\u0000\u0000\u00c8\u00c9\u0003<\u001e\u0000\u00c9\u00ca"+
		"\u0003\u0012\t\u0000\u00ca\u001f\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005"+
		"\u0006\u0000\u0000\u00cc\u00ce\u0003\"\u0011\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d1\u0005!\u0000\u0000\u00d0\u00d2\u0003<\u001e\u0000"+
		"\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d5\u0005!\u0000\u0000\u00d4"+
		"\u00d6\u0003$\u0012\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0003\u0012\t\u0000\u00d8!\u0001\u0000\u0000\u0000\u00d9\u00dc\u0003"+
		"4\u001a\u0000\u00da\u00dc\u00032\u0019\u0000\u00db\u00d9\u0001\u0000\u0000"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc#\u0001\u0000\u0000\u0000"+
		"\u00dd\u00e1\u00034\u001a\u0000\u00de\u00e1\u00036\u001b\u0000\u00df\u00e1"+
		"\u0003\u001a\r\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000\u00e0\u00de\u0001"+
		"\u0000\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1%\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e8\u0005\u0007\u0000\u0000\u00e3\u00e4\u0005\u001b"+
		"\u0000\u0000\u00e4\u00e5\u0003<\u001e\u0000\u00e5\u00e6\u0005\u001c\u0000"+
		"\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e9\u0003<\u001e\u0000"+
		"\u00e8\u00e3\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ee\u0005\u001d\u0000\u0000"+
		"\u00eb\u00ed\u0003(\u0014\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003*\u0015\u0000\u00f2\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u001e\u0000\u0000\u00f5\'\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0005\b\u0000\u0000\u00f7\u00f8\u0003<"+
		"\u001e\u0000\u00f8\u00fc\u0005#\u0000\u0000\u00f9\u00fb\u0003\u0002\u0001"+
		"\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd)\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0005\t\u0000\u0000\u0100\u0104\u0005#\u0000\u0000\u0101"+
		"\u0103\u0003\u0002\u0001\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0001\u0000\u0000\u0000\u0105+\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u0109\u0005\u0004\u0000\u0000\u0108\u010a"+
		"\u0005\u001b\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010d"+
		"\u0003<\u001e\u0000\u010c\u010e\u0005\u001c\u0000\u0000\u010d\u010c\u0001"+
		"\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0113\u0003\u0012\t\u0000\u0110\u0112\u0003."+
		"\u0017\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000"+
		"\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u00030\u0018\u0000\u0117\u0116\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118-\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005\u0005\u0000\u0000\u011a\u011c\u0005\u0004\u0000\u0000"+
		"\u011b\u011d\u0005\u001b\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000"+
		"\u011e\u0120\u0003<\u001e\u0000\u011f\u0121\u0005\u001c\u0000\u0000\u0120"+
		"\u011f\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"\u0122\u0001\u0000\u0000\u0000\u0122\u0123\u0003\u0012\t\u0000\u0123/"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u0005\u0000\u0000\u0125\u0126"+
		"\u0003\u0012\t\u0000\u01261\u0001\u0000\u0000\u0000\u0127\u0128\u0005"+
		"\u0001\u0000\u0000\u0128\u012a\u0005;\u0000\u0000\u0129\u012b\u0003P("+
		"\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000"+
		"\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012d\u0005$\u0000\u0000"+
		"\u012d\u012f\u0003<\u001e\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0001\u0000\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130"+
		"\u0132\u0005!\u0000\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0001\u0000\u0000\u0000\u0132\u014b\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0005;\u0000\u0000\u0134\u0135\u0005;\u0000\u0000\u0135\u0136\u0005$"+
		"\u0000\u0000\u0136\u0138\u0003\u000e\u0007\u0000\u0137\u0139\u0005!\u0000"+
		"\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u014b\u0001\u0000\u0000\u0000\u013a\u013b\u0005\u0001\u0000"+
		"\u0000\u013b\u013c\u0005;\u0000\u0000\u013c\u013d\u0005$\u0000\u0000\u013d"+
		"\u013e\u0005\u0014\u0000\u0000\u013e\u0140\u0005\u001b\u0000\u0000\u013f"+
		"\u0141\u0003\u0006\u0003\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142"+
		"\u0144\u0005\u001c\u0000\u0000\u0143\u0145\u0003P(\u0000\u0144\u0143\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0148\u0003\u0012\t\u0000\u0147\u0149\u0005!"+
		"\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000"+
		"\u0000\u0000\u0149\u014b\u0001\u0000\u0000\u0000\u014a\u0127\u0001\u0000"+
		"\u0000\u0000\u014a\u0133\u0001\u0000\u0000\u0000\u014a\u013a\u0001\u0000"+
		"\u0000\u0000\u014b3\u0001\u0000\u0000\u0000\u014c\u014d\u0005;\u0000\u0000"+
		"\u014d\u014e\u0007\u0001\u0000\u0000\u014e\u0150\u0003<\u001e\u0000\u014f"+
		"\u0151\u0005!\u0000\u0000\u0150\u014f\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0001\u0000\u0000\u0000\u01515\u0001\u0000\u0000\u0000\u0152\u0154\u0003"+
		"<\u001e\u0000\u0153\u0155\u0005!\u0000\u0000\u0154\u0153\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u01557\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0005\u0002\u0000\u0000\u0157\u0158\u0005\u001a\u0000\u0000"+
		"\u0158\u0159\u0005\u0003\u0000\u0000\u0159\u015b\u0005\u001b\u0000\u0000"+
		"\u015a\u015c\u0003:\u001d\u0000\u015b\u015a\u0001\u0000\u0000\u0000\u015b"+
		"\u015c\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"+
		"\u015f\u0005\u001c\u0000\u0000\u015e\u0160\u0005!\u0000\u0000\u015f\u015e"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u01609\u0001"+
		"\u0000\u0000\u0000\u0161\u0166\u0003<\u001e\u0000\u0162\u0163\u0005\""+
		"\u0000\u0000\u0163\u0165\u0003<\u001e\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167;\u0001\u0000\u0000\u0000"+
		"\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016a\u0003>\u001f\u0000\u016a"+
		"=\u0001\u0000\u0000\u0000\u016b\u0170\u0003@ \u0000\u016c\u016d\u0005"+
		"5\u0000\u0000\u016d\u016f\u0003@ \u0000\u016e\u016c\u0001\u0000\u0000"+
		"\u0000\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000"+
		"\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171?\u0001\u0000\u0000\u0000"+
		"\u0172\u0170\u0001\u0000\u0000\u0000\u0173\u0178\u0003B!\u0000\u0174\u0175"+
		"\u00054\u0000\u0000\u0175\u0177\u0003B!\u0000\u0176\u0174\u0001\u0000"+
		"\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179A\u0001\u0000\u0000"+
		"\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u0180\u0003D\"\u0000"+
		"\u017c\u017d\u0007\u0002\u0000\u0000\u017d\u017f\u0003D\"\u0000\u017e"+
		"\u017c\u0001\u0000\u0000\u0000\u017f\u0182\u0001\u0000\u0000\u0000\u0180"+
		"\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181"+
		"C\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u0188"+
		"\u0003F#\u0000\u0184\u0185\u0007\u0003\u0000\u0000\u0185\u0187\u0003F"+
		"#\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000\u0000"+
		"\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000"+
		"\u0000\u0189E\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000\u0000"+
		"\u018b\u0190\u0003H$\u0000\u018c\u018d\u0007\u0004\u0000\u0000\u018d\u018f"+
		"\u0003H$\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018f\u0192\u0001\u0000"+
		"\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000"+
		"\u0000\u0000\u0191G\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0193\u0198\u0003J%\u0000\u0194\u0195\u0007\u0005\u0000\u0000\u0195"+
		"\u0197\u0003J%\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\u019a\u0001"+
		"\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199I\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0005*\u0000\u0000\u019c\u01a2\u0003J%\u0000"+
		"\u019d\u019e\u00056\u0000\u0000\u019e\u01a2\u0003J%\u0000\u019f\u01a2"+
		"\u0003T*\u0000\u01a0\u01a2\u0003L&\u0000\u01a1\u019b\u0001\u0000\u0000"+
		"\u0000\u01a1\u019d\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a2K\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a4\u0005\r\u0000\u0000\u01a4\u01a5\u0005\u001b\u0000\u0000\u01a5"+
		"\u01a6\u0003<\u001e\u0000\u01a6\u01a7\u0005\u001c\u0000\u0000\u01a7\u01c7"+
		"\u0001\u0000\u0000\u0000\u01a8\u01a9\u0005\u000e\u0000\u0000\u01a9\u01aa"+
		"\u0005\u001b\u0000\u0000\u01aa\u01af\u0003<\u001e\u0000\u01ab\u01ac\u0005"+
		"\"\u0000\u0000\u01ac\u01ae\u0003<\u001e\u0000\u01ad\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000"+
		"\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005\u001c"+
		"\u0000\u0000\u01b3\u01c7\u0001\u0000\u0000\u0000\u01b4\u01b5\u0005\u000f"+
		"\u0000\u0000\u01b5\u01b6\u0005\u001a\u0000\u0000\u01b6\u01b7\u0005\u0012"+
		"\u0000\u0000\u01b7\u01b8\u0005\u001b\u0000\u0000\u01b8\u01b9\u0003<\u001e"+
		"\u0000\u01b9\u01ba\u0005\"\u0000\u0000\u01ba\u01bb\u0003<\u001e\u0000"+
		"\u01bb\u01bc\u0005\u001c\u0000\u0000\u01bc\u01c7\u0001\u0000\u0000\u0000"+
		"\u01bd\u01be\u0005\u0010\u0000\u0000\u01be\u01bf\u0005\u001a\u0000\u0000"+
		"\u01bf\u01c0\u0005\u0011\u0000\u0000\u01c0\u01c1\u0005\u001b\u0000\u0000"+
		"\u01c1\u01c2\u0003<\u001e\u0000\u01c2\u01c3\u0005\"\u0000\u0000\u01c3"+
		"\u01c4\u0003<\u001e\u0000\u01c4\u01c5\u0005\u001c\u0000\u0000\u01c5\u01c7"+
		"\u0001\u0000\u0000\u0000\u01c6\u01a3\u0001\u0000\u0000\u0000\u01c6\u01a8"+
		"\u0001\u0000\u0000\u0000\u01c6\u01b4\u0001\u0000\u0000\u0000\u01c6\u01bd"+
		"\u0001\u0000\u0000\u0000\u01c7M\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005"+
		"\u001f\u0000\u0000\u01c9\u01ca\u0005 \u0000\u0000\u01ca\u01cb\u0003P("+
		"\u0000\u01cbO\u0001\u0000\u0000\u0000\u01cc\u01d4\u0005\u0015\u0000\u0000"+
		"\u01cd\u01d4\u0005\u0016\u0000\u0000\u01ce\u01d4\u0005\u0017\u0000\u0000"+
		"\u01cf\u01d4\u0005\u0018\u0000\u0000\u01d0\u01d4\u0005\u0019\u0000\u0000"+
		"\u01d1\u01d4\u0005;\u0000\u0000\u01d2\u01d4\u0003N\'\u0000\u01d3\u01cc"+
		"\u0001\u0000\u0000\u0000\u01d3\u01cd\u0001\u0000\u0000\u0000\u01d3\u01ce"+
		"\u0001\u0000\u0000\u0000\u01d3\u01cf\u0001\u0000\u0000\u0000\u01d3\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d4Q\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005"+
		"\u001f\u0000\u0000\u01d6\u01d7\u0005 \u0000\u0000\u01d7\u01d8\u0003P("+
		"\u0000\u01d8\u01e1\u0005\u001d\u0000\u0000\u01d9\u01de\u0003<\u001e\u0000"+
		"\u01da\u01db\u0005\"\u0000\u0000\u01db\u01dd\u0003<\u001e\u0000\u01dc"+
		"\u01da\u0001\u0000\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de"+
		"\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df"+
		"\u01e2\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1"+
		"\u01d9\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2"+
		"\u01e3\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005\u001e\u0000\u0000\u01e4"+
		"S\u0001\u0000\u0000\u0000\u01e5\u01ec\u0005;\u0000\u0000\u01e6\u01e7\u0005"+
		"\u001f\u0000\u0000\u01e7\u01e8\u0003<\u001e\u0000\u01e8\u01e9\u0005 \u0000"+
		"\u0000\u01e9\u01eb\u0001\u0000\u0000\u0000\u01ea\u01e6\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ee\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01f3\u0001\u0000\u0000"+
		"\u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ef\u01f0\u0005\u001a\u0000"+
		"\u0000\u01f0\u01f2\u0005;\u0000\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000"+
		"\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000"+
		"\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4\u0207\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f6\u01f7\u0005;\u0000\u0000\u01f7"+
		"\u01f9\u0005\u001b\u0000\u0000\u01f8\u01fa\u0003:\u001d\u0000\u01f9\u01f8"+
		"\u0001\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u01fb"+
		"\u0001\u0000\u0000\u0000\u01fb\u0207\u0005\u001c\u0000\u0000\u01fc\u0207"+
		"\u0005:\u0000\u0000\u01fd\u0207\u00057\u0000\u0000\u01fe\u0207\u00058"+
		"\u0000\u0000\u01ff\u0207\u00059\u0000\u0000\u0200\u0201\u0005\u001b\u0000"+
		"\u0000\u0201\u0202\u0003<\u001e\u0000\u0202\u0203\u0005\u001c\u0000\u0000"+
		"\u0203\u0207\u0001\u0000\u0000\u0000\u0204\u0207\u0003R)\u0000\u0205\u0207"+
		"\u0003\u000e\u0007\u0000\u0206\u01e5\u0001\u0000\u0000\u0000\u0206\u01f6"+
		"\u0001\u0000\u0000\u0000\u0206\u01fc\u0001\u0000\u0000\u0000\u0206\u01fd"+
		"\u0001\u0000\u0000\u0000\u0206\u01fe\u0001\u0000\u0000\u0000\u0206\u01ff"+
		"\u0001\u0000\u0000\u0000\u0206\u0200\u0001\u0000\u0000\u0000\u0206\u0204"+
		"\u0001\u0000\u0000\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0207U\u0001"+
		"\u0000\u0000\u0000>Y[kqu~\u008a\u008e\u009a\u009e\u00aa\u00b1\u00b5\u00b9"+
		"\u00bc\u00c1\u00c5\u00cd\u00d1\u00d5\u00db\u00e0\u00e8\u00ee\u00f2\u00fc"+
		"\u0104\u0109\u010d\u0113\u0117\u011c\u0120\u012a\u012e\u0131\u0138\u0140"+
		"\u0144\u0148\u014a\u0150\u0154\u015b\u015f\u0166\u0170\u0178\u0180\u0188"+
		"\u0190\u0198\u01a1\u01af\u01c6\u01d3\u01de\u01e1\u01ec\u01f3\u01f9\u0206";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}