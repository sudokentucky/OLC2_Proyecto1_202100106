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
		JOIN=17, INDEX=18, STRUCT=19, FUNC=20, STRCONV=21, ATOI=22, PARSERFLOAT=23, 
		REFLECT=24, TYPEOF=25, INT_TYPE=26, FLOAT64_TYPE=27, STRING_TYPE=28, BOOL_TYPE=29, 
		RUNE_TYPE=30, PUNTO=31, PARENTESIS_IZQ=32, PARENTESIS_DER=33, LLAVE_IZQ=34, 
		LLAVE_DER=35, CORCHETE_IZQ=36, CORCHETE_DER=37, PUNTO_Y_COMA=38, COMA=39, 
		DOS_PUNTOS=40, ASIGNACION=41, ASIGNACION_DECLARACION=42, ASIGNACIO_INCREMENTO=43, 
		ASIGNACIO_DECREMENTO=44, INCREMENTO=45, DECREMENTO=46, PLUS=47, MINUS=48, 
		STAR=49, DIV=50, MOD=51, IGUAL=52, DIFERENTE=53, MAYOR_QUE=54, MENOR_QUE=55, 
		MAYOR_IGUAL_QUE=56, MENOR_IGUAL_QUE=57, AND=58, OR=59, NOT=60, INT_LIT=61, 
		FLOAT_LIT=62, STRING_LIT=63, RUNE_LIT=64, IDENTIFIER=65, ESPACIO_BLANCO=66, 
		COMENTARIO_LINE=67, COMENTARIO_MULTILINEA=68;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_conversionFunc = 2, RULE_funcDecl = 3, 
		RULE_paramsList = 4, RULE_param = 5, RULE_structDecl = 6, RULE_fieldDecl = 7, 
		RULE_structLiteral = 8, RULE_fieldValue = 9, RULE_bloque = 10, RULE_breakStmt = 11, 
		RULE_continueStmt = 12, RULE_returnStmt = 13, RULE_incDecStmt = 14, RULE_forStmt = 15, 
		RULE_forWhileStmt = 16, RULE_forThreePartStmt = 17, RULE_forInit = 18, 
		RULE_forPost = 19, RULE_switchStmt = 20, RULE_caseStmt = 21, RULE_defaultStmt = 22, 
		RULE_ifStmt = 23, RULE_elseIfStmt = 24, RULE_elseStmt = 25, RULE_declaracion = 26, 
		RULE_assignacion = 27, RULE_exprStmt = 28, RULE_printStmt = 29, RULE_argumentList = 30, 
		RULE_expresion = 31, RULE_logicalOrExpr = 32, RULE_logicalAndExpr = 33, 
		RULE_equalityExpr = 34, RULE_relationalExpr = 35, RULE_addExpr = 36, RULE_mulExpr = 37, 
		RULE_unaryExpr = 38, RULE_sliceFunc = 39, RULE_sliceType = 40, RULE_typeSpec = 41, 
		RULE_sliceLiteral = 42, RULE_primary = 43, RULE_functCall = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruction", "conversionFunc", "funcDecl", "paramsList", 
			"param", "structDecl", "fieldDecl", "structLiteral", "fieldValue", "bloque", 
			"breakStmt", "continueStmt", "returnStmt", "incDecStmt", "forStmt", "forWhileStmt", 
			"forThreePartStmt", "forInit", "forPost", "switchStmt", "caseStmt", "defaultStmt", 
			"ifStmt", "elseIfStmt", "elseStmt", "declaracion", "assignacion", "exprStmt", 
			"printStmt", "argumentList", "expresion", "logicalOrExpr", "logicalAndExpr", 
			"equalityExpr", "relationalExpr", "addExpr", "mulExpr", "unaryExpr", 
			"sliceFunc", "sliceType", "typeSpec", "sliceLiteral", "primary", "functCall"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'fmt'", "'Println'", "'if'", "'else'", "'for'", "'switch'", 
			"'case'", "'default'", "'break'", "'continue'", "'return'", "'len'", 
			"'append'", "'slices'", "'strings'", "'join'", "'Index'", "'struct'", 
			"'func'", "'strconv'", "'Atoi'", "'ParseFloat'", "'reflect'", "'TypeOf'", 
			"'int'", "'float64'", "'string'", "'bool'", "'rune'", "'.'", "'('", "')'", 
			"'{'", "'}'", "'['", "']'", "';'", "','", "':'", "'='", "':='", "'+='", 
			"'-='", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
			"'>'", "'<'", "'>='", "'<='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "FMT", "PRINTLN", "IF", "ELSE", "FOR", "SWITCH", "CASE", 
			"DEFAULT", "BREAK", "CONTINUE", "RETURN", "LEN", "APPEND", "SLICES", 
			"STRINGS", "JOIN", "INDEX", "STRUCT", "FUNC", "STRCONV", "ATOI", "PARSERFLOAT", 
			"REFLECT", "TYPEOF", "INT_TYPE", "FLOAT64_TYPE", "STRING_TYPE", "BOOL_TYPE", 
			"RUNE_TYPE", "PUNTO", "PARENTESIS_IZQ", "PARENTESIS_DER", "LLAVE_IZQ", 
			"LLAVE_DER", "CORCHETE_IZQ", "CORCHETE_DER", "PUNTO_Y_COMA", "COMA", 
			"DOS_PUNTOS", "ASIGNACION", "ASIGNACION_DECLARACION", "ASIGNACIO_INCREMENTO", 
			"ASIGNACIO_DECREMENTO", "INCREMENTO", "DECREMENTO", "PLUS", "MINUS", 
			"STAR", "DIV", "MOD", "IGUAL", "DIFERENTE", "MAYOR_QUE", "MENOR_QUE", 
			"MAYOR_IGUAL_QUE", "MENOR_IGUAL_QUE", "AND", "OR", "NOT", "INT_LIT", 
			"FLOAT_LIT", "STRING_LIT", "RUNE_LIT", "IDENTIFIER", "ESPACIO_BLANCO", 
			"COMENTARIO_LINE", "COMENTARIO_MULTILINEA"
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152639939415245610L) != 0) || _la==RUNE_LIT || _la==IDENTIFIER) {
				{
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(90);
					structDecl();
					}
					break;
				case FUNC:
					{
					setState(91);
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
				case STRCONV:
				case REFLECT:
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
					setState(92);
					instruction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
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
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				assignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				printStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(104);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				switchStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(106);
				forStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(107);
				incDecStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(108);
				returnStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(109);
				continueStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(110);
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
	public static class ConversionFuncContext extends ParserRuleContext {
		public TerminalNode STRCONV() { return getToken(gramaticaParser.STRCONV, 0); }
		public TerminalNode PUNTO() { return getToken(gramaticaParser.PUNTO, 0); }
		public TerminalNode ATOI() { return getToken(gramaticaParser.ATOI, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public TerminalNode PARSERFLOAT() { return getToken(gramaticaParser.PARSERFLOAT, 0); }
		public TerminalNode REFLECT() { return getToken(gramaticaParser.REFLECT, 0); }
		public TerminalNode TYPEOF() { return getToken(gramaticaParser.TYPEOF, 0); }
		public ConversionFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversionFunc; }
	}

	public final ConversionFuncContext conversionFunc() throws RecognitionException {
		ConversionFuncContext _localctx = new ConversionFuncContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_conversionFunc);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(STRCONV);
				setState(114);
				match(PUNTO);
				setState(115);
				match(ATOI);
				setState(116);
				match(PARENTESIS_IZQ);
				setState(117);
				expresion();
				setState(118);
				match(PARENTESIS_DER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(STRCONV);
				setState(121);
				match(PUNTO);
				setState(122);
				match(PARSERFLOAT);
				setState(123);
				match(PARENTESIS_IZQ);
				setState(124);
				expresion();
				setState(125);
				match(PARENTESIS_DER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(REFLECT);
				setState(128);
				match(PUNTO);
				setState(129);
				match(TYPEOF);
				setState(130);
				match(PARENTESIS_IZQ);
				setState(131);
				expresion();
				setState(132);
				match(PARENTESIS_DER);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(gramaticaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(gramaticaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> PARENTESIS_IZQ() { return getTokens(gramaticaParser.PARENTESIS_IZQ); }
		public TerminalNode PARENTESIS_IZQ(int i) {
			return getToken(gramaticaParser.PARENTESIS_IZQ, i);
		}
		public List<TerminalNode> PARENTESIS_DER() { return getTokens(gramaticaParser.PARENTESIS_DER); }
		public TerminalNode PARENTESIS_DER(int i) {
			return getToken(gramaticaParser.PARENTESIS_DER, i);
		}
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
		enterRule(_localctx, 6, RULE_funcDecl);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(FUNC);
				setState(137);
				match(IDENTIFIER);
				setState(138);
				match(PARENTESIS_IZQ);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(139);
					paramsList();
					}
				}

				setState(142);
				match(PARENTESIS_DER);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & 549755814943L) != 0)) {
					{
					setState(143);
					typeSpec();
					}
				}

				setState(146);
				bloque();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(FUNC);
				setState(148);
				match(PARENTESIS_IZQ);
				setState(149);
				match(IDENTIFIER);
				setState(150);
				match(IDENTIFIER);
				setState(151);
				match(PARENTESIS_DER);
				setState(152);
				match(IDENTIFIER);
				setState(153);
				match(PARENTESIS_IZQ);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(154);
					paramsList();
					}
				}

				setState(157);
				match(PARENTESIS_DER);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & 549755814943L) != 0)) {
					{
					setState(158);
					typeSpec();
					}
				}

				setState(161);
				bloque();
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
		enterRule(_localctx, 8, RULE_paramsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			param();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(165);
				match(COMA);
				setState(166);
				param();
				}
				}
				setState(171);
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
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IDENTIFIER);
			setState(173);
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
		enterRule(_localctx, 12, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(STRUCT);
			setState(176);
			match(IDENTIFIER);
			setState(177);
			match(LLAVE_IZQ);
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				fieldDecl();
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & 549755814943L) != 0) );
			setState(183);
			match(LLAVE_DER);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(184);
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
		enterRule(_localctx, 14, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			typeSpec();
			setState(188);
			match(IDENTIFIER);
			setState(189);
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
		enterRule(_localctx, 16, RULE_structLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LLAVE_IZQ);
			setState(192);
			fieldValue();
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					match(COMA);
					setState(194);
					fieldValue();
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(200);
				match(COMA);
				}
			}

			setState(203);
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
		enterRule(_localctx, 18, RULE_fieldValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(IDENTIFIER);
			setState(206);
			match(DOS_PUNTOS);
			setState(207);
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
		enterRule(_localctx, 20, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(LLAVE_IZQ);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152639939416818474L) != 0) || _la==RUNE_LIT || _la==IDENTIFIER) {
				{
				{
				setState(210);
				instruction();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
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
		enterRule(_localctx, 22, RULE_breakStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(BREAK);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(219);
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
		enterRule(_localctx, 24, RULE_continueStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(CONTINUE);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(223);
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
		enterRule(_localctx, 26, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(RETURN);
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(227);
				expresion();
				}
				break;
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(230);
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
		enterRule(_localctx, 28, RULE_incDecStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(IDENTIFIER);
			setState(234);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(235);
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
		enterRule(_localctx, 30, RULE_forStmt);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				forWhileStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
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
		enterRule(_localctx, 32, RULE_forWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(FOR);
			setState(243);
			expresion();
			setState(244);
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
		enterRule(_localctx, 34, RULE_forThreePartStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(FOR);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR || _la==IDENTIFIER) {
				{
				setState(247);
				forInit();
				}
			}

			setState(250);
			match(PUNTO_Y_COMA);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 8866496137136399L) != 0)) {
				{
				setState(251);
				expresion();
				}
			}

			setState(254);
			match(PUNTO_Y_COMA);
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(255);
				forPost();
				}
				break;
			}
			setState(258);
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
		enterRule(_localctx, 36, RULE_forInit);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				assignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
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
		enterRule(_localctx, 38, RULE_forPost);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				assignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				exprStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
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
		enterRule(_localctx, 40, RULE_switchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(SWITCH);
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(270);
				match(PARENTESIS_IZQ);
				setState(271);
				expresion();
				setState(272);
				match(PARENTESIS_DER);
				}
				break;
			case 2:
				{
				setState(274);
				expresion();
				}
				break;
			}
			setState(277);
			match(LLAVE_IZQ);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(278);
				caseStmt();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(284);
				defaultStmt();
				}
			}

			setState(287);
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
		enterRule(_localctx, 42, RULE_caseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(CASE);
			setState(290);
			expresion();
			setState(291);
			match(DOS_PUNTOS);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152639939416818474L) != 0) || _la==RUNE_LIT || _la==IDENTIFIER) {
				{
				{
				setState(292);
				instruction();
				}
				}
				setState(297);
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
		enterRule(_localctx, 44, RULE_defaultStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(DEFAULT);
			setState(299);
			match(DOS_PUNTOS);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152639939416818474L) != 0) || _la==RUNE_LIT || _la==IDENTIFIER) {
				{
				{
				setState(300);
				instruction();
				}
				}
				setState(305);
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
		enterRule(_localctx, 46, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(IF);
			{
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(307);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(310);
			expresion();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(311);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(314);
			bloque();
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(315);
					elseIfStmt();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(321);
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
		enterRule(_localctx, 48, RULE_elseIfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(ELSE);
			setState(325);
			match(IF);
			{
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(326);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(329);
			expresion();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(330);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(333);
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
		enterRule(_localctx, 50, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(ELSE);
			setState(336);
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
		enterRule(_localctx, 52, RULE_declaracion);
		int _la;
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(VAR);
				setState(339);
				match(IDENTIFIER);
				setState(341);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(340);
					typeSpec();
					}
					break;
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASIGNACION) {
					{
					setState(343);
					match(ASIGNACION);
					setState(344);
					expresion();
					}
				}

				setState(348);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(347);
					match(PUNTO_Y_COMA);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(IDENTIFIER);
				setState(351);
				match(IDENTIFIER);
				setState(352);
				match(ASIGNACION);
				setState(353);
				structLiteral();
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(354);
					match(PUNTO_Y_COMA);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(VAR);
				setState(358);
				match(IDENTIFIER);
				setState(359);
				match(ASIGNACION);
				setState(360);
				match(FUNC);
				setState(361);
				match(PARENTESIS_IZQ);
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(362);
					paramsList();
					}
				}

				setState(365);
				match(PARENTESIS_DER);
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & 549755814943L) != 0)) {
					{
					setState(366);
					typeSpec();
					}
				}

				setState(369);
				bloque();
				setState(371);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(370);
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
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode ASIGNACION() { return getToken(gramaticaParser.ASIGNACION, 0); }
		public TerminalNode ASIGNACIO_INCREMENTO() { return getToken(gramaticaParser.ASIGNACIO_INCREMENTO, 0); }
		public TerminalNode ASIGNACION_DECLARACION() { return getToken(gramaticaParser.ASIGNACION_DECLARACION, 0); }
		public TerminalNode ASIGNACIO_DECREMENTO() { return getToken(gramaticaParser.ASIGNACIO_DECREMENTO, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(gramaticaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(gramaticaParser.IDENTIFIER, i);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public List<TerminalNode> PUNTO() { return getTokens(gramaticaParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(gramaticaParser.PUNTO, i);
		}
		public AssignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignacion; }
	}

	public final AssignacionContext assignacion() throws RecognitionException {
		AssignacionContext _localctx = new AssignacionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(375);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(376);
				match(IDENTIFIER);
				setState(379); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(377);
					match(PUNTO);
					setState(378);
					match(IDENTIFIER);
					}
					}
					setState(381); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PUNTO );
				}
				break;
			}
			setState(385);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348833280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(386);
			expresion();
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(387);
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
		enterRule(_localctx, 56, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			expresion();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(391);
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
		enterRule(_localctx, 58, RULE_printStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(FMT);
			setState(395);
			match(PUNTO);
			setState(396);
			match(PRINTLN);
			setState(397);
			match(PARENTESIS_IZQ);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 8866496137136399L) != 0)) {
				{
				setState(398);
				argumentList();
				}
			}

			setState(401);
			match(PARENTESIS_DER);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(402);
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
		enterRule(_localctx, 60, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			expresion();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(406);
				match(COMA);
				setState(407);
				expresion();
				}
				}
				setState(412);
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
		enterRule(_localctx, 62, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
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
		enterRule(_localctx, 64, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			logicalAndExpr();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(416);
				match(OR);
				setState(417);
				logicalAndExpr();
				}
				}
				setState(422);
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
		enterRule(_localctx, 66, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			equalityExpr();
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(424);
				match(AND);
				setState(425);
				equalityExpr();
				}
				}
				setState(430);
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
		enterRule(_localctx, 68, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			relationalExpr();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUAL || _la==DIFERENTE) {
				{
				{
				setState(432);
				_la = _input.LA(1);
				if ( !(_la==IGUAL || _la==DIFERENTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(433);
				relationalExpr();
				}
				}
				setState(438);
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
		enterRule(_localctx, 70, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			addExpr();
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 270215977642229760L) != 0)) {
				{
				{
				setState(440);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270215977642229760L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(441);
				addExpr();
				}
				}
				setState(446);
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
		enterRule(_localctx, 72, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			mulExpr();
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(448);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(449);
					mulExpr();
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		enterRule(_localctx, 74, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			unaryExpr();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) {
				{
				{
				setState(456);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(457);
				unaryExpr();
				}
				}
				setState(462);
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
		public ConversionFuncContext conversionFunc() {
			return getRuleContext(ConversionFuncContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_unaryExpr);
		try {
			setState(470);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				match(MINUS);
				setState(464);
				unaryExpr();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				match(NOT);
				setState(466);
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
				setState(467);
				primary();
				}
				break;
			case LEN:
			case APPEND:
			case SLICES:
			case STRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
				sliceFunc();
				}
				break;
			case STRCONV:
			case REFLECT:
				enterOuterAlt(_localctx, 5);
				{
				setState(469);
				conversionFunc();
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
		enterRule(_localctx, 78, RULE_sliceFunc);
		int _la;
		try {
			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(472);
				match(LEN);
				setState(473);
				match(PARENTESIS_IZQ);
				setState(474);
				expresion();
				setState(475);
				match(PARENTESIS_DER);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				match(APPEND);
				setState(478);
				match(PARENTESIS_IZQ);
				setState(479);
				expresion();
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(480);
					match(COMA);
					setState(481);
					expresion();
					}
					}
					setState(486);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(487);
				match(PARENTESIS_DER);
				}
				break;
			case SLICES:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				match(SLICES);
				setState(490);
				match(PUNTO);
				setState(491);
				match(INDEX);
				setState(492);
				match(PARENTESIS_IZQ);
				setState(493);
				expresion();
				setState(494);
				match(COMA);
				setState(495);
				expresion();
				setState(496);
				match(PARENTESIS_DER);
				}
				break;
			case STRINGS:
				enterOuterAlt(_localctx, 4);
				{
				setState(498);
				match(STRINGS);
				setState(499);
				match(PUNTO);
				setState(500);
				match(JOIN);
				setState(501);
				match(PARENTESIS_IZQ);
				setState(502);
				expresion();
				setState(503);
				match(COMA);
				setState(504);
				expresion();
				setState(505);
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
		enterRule(_localctx, 80, RULE_sliceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(CORCHETE_IZQ);
			setState(510);
			match(CORCHETE_DER);
			setState(511);
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
		enterRule(_localctx, 82, RULE_typeSpec);
		try {
			setState(520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				match(INT_TYPE);
				}
				break;
			case FLOAT64_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				match(FLOAT64_TYPE);
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(515);
				match(STRING_TYPE);
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(516);
				match(BOOL_TYPE);
				}
				break;
			case RUNE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(517);
				match(RUNE_TYPE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
				match(IDENTIFIER);
				}
				break;
			case CORCHETE_IZQ:
				enterOuterAlt(_localctx, 7);
				{
				setState(519);
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
		public SliceTypeContext sliceType() {
			return getRuleContext(SliceTypeContext.class,0);
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
		enterRule(_localctx, 84, RULE_sliceLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			sliceType();
			setState(523);
			match(LLAVE_IZQ);
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 8866496137136399L) != 0)) {
				{
				setState(524);
				expresion();
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(525);
					match(COMA);
					setState(526);
					expresion();
					}
					}
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(534);
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
		public FunctCallContext functCall() {
			return getRuleContext(FunctCallContext.class,0);
		}
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
		public TerminalNode INT_LIT() { return getToken(gramaticaParser.INT_LIT, 0); }
		public TerminalNode FLOAT_LIT() { return getToken(gramaticaParser.FLOAT_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(gramaticaParser.STRING_LIT, 0); }
		public TerminalNode RUNE_LIT() { return getToken(gramaticaParser.RUNE_LIT, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
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
		enterRule(_localctx, 86, RULE_primary);
		int _la;
		try {
			int _alt;
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				functCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				match(IDENTIFIER);
				setState(544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(538);
						match(CORCHETE_IZQ);
						setState(539);
						expresion();
						setState(540);
						match(CORCHETE_DER);
						}
						} 
					}
					setState(546);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PUNTO) {
					{
					{
					setState(547);
					match(PUNTO);
					setState(548);
					match(IDENTIFIER);
					}
					}
					setState(553);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				match(INT_LIT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(555);
				match(FLOAT_LIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(556);
				match(STRING_LIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(557);
				match(RUNE_LIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(558);
				match(PARENTESIS_IZQ);
				setState(559);
				expresion();
				setState(560);
				match(PARENTESIS_DER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(562);
				sliceLiteral();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(563);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctCallContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(gramaticaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(gramaticaParser.IDENTIFIER, i);
		}
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public List<TerminalNode> PUNTO() { return getTokens(gramaticaParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(gramaticaParser.PUNTO, i);
		}
		public FunctCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functCall; }
	}

	public final FunctCallContext functCall() throws RecognitionException {
		FunctCallContext _localctx = new FunctCallContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_functCall);
		int _la;
		try {
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				match(IDENTIFIER);
				setState(567);
				match(PARENTESIS_IZQ);
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 8866496137136399L) != 0)) {
					{
					setState(568);
					argumentList();
					}
				}

				setState(571);
				match(PARENTESIS_DER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				match(IDENTIFIER);
				setState(575); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(573);
					match(PUNTO);
					setState(574);
					match(IDENTIFIER);
					}
					}
					setState(577); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PUNTO );
				setState(579);
				match(PARENTESIS_IZQ);
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 8866496137136399L) != 0)) {
					{
					setState(580);
					argumentList();
					}
				}

				setState(583);
				match(PARENTESIS_DER);
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
		"\u0004\u0001D\u024b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000^\b\u0000\n\u0000\f\u0000a\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001p\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u0087\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u008d\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0091"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u009c\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u00a0\b\u0003\u0001\u0003\u0003\u0003\u00a3"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00a8\b\u0004"+
		"\n\u0004\f\u0004\u00ab\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00b4\b\u0006\u000b"+
		"\u0006\f\u0006\u00b5\u0001\u0006\u0001\u0006\u0003\u0006\u00ba\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00c4\b\b\n\b\f\b\u00c7\t\b\u0001\b\u0003\b\u00ca\b"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005"+
		"\n\u00d4\b\n\n\n\f\n\u00d7\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00dd\b\u000b\u0001\f\u0001\f\u0003\f\u00e1\b\f\u0001\r\u0001"+
		"\r\u0003\r\u00e5\b\r\u0001\r\u0003\r\u00e8\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00ed\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00f1\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00f9\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00fd\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0101\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u0107\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u010c\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0114"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0118\b\u0014\n\u0014\f\u0014"+
		"\u011b\t\u0014\u0001\u0014\u0003\u0014\u011e\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0126"+
		"\b\u0015\n\u0015\f\u0015\u0129\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u012e\b\u0016\n\u0016\f\u0016\u0131\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0135\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0139"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u013d\b\u0017\n\u0017\f\u0017"+
		"\u0140\t\u0017\u0001\u0017\u0003\u0017\u0143\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0148\b\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u014c\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0156\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u015a\b\u001a\u0001\u001a\u0003\u001a\u015d"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0164\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u016c\b\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0170\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0174\b\u001a"+
		"\u0003\u001a\u0176\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0004\u001b\u017c\b\u001b\u000b\u001b\f\u001b\u017d\u0003\u001b\u0180"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0185\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0189\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0190\b\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u0194\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0005\u001e\u0199\b\u001e\n\u001e\f\u001e\u019c\t\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0005 \u01a3\b \n \f \u01a6\t \u0001!\u0001"+
		"!\u0001!\u0005!\u01ab\b!\n!\f!\u01ae\t!\u0001\"\u0001\"\u0001\"\u0005"+
		"\"\u01b3\b\"\n\"\f\"\u01b6\t\"\u0001#\u0001#\u0001#\u0005#\u01bb\b#\n"+
		"#\f#\u01be\t#\u0001$\u0001$\u0001$\u0005$\u01c3\b$\n$\f$\u01c6\t$\u0001"+
		"%\u0001%\u0001%\u0005%\u01cb\b%\n%\f%\u01ce\t%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0003&\u01d7\b&\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u01e3\b\'\n\'"+
		"\f\'\u01e6\t\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u01fc\b\'\u0001(\u0001(\u0001"+
		"(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0209"+
		"\b)\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u0210\b*\n*\f*\u0213\t*"+
		"\u0003*\u0215\b*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0005+\u021f\b+\n+\f+\u0222\t+\u0001+\u0001+\u0005+\u0226\b+\n+\f+\u0229"+
		"\t+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0003+\u0235\b+\u0001,\u0001,\u0001,\u0003,\u023a\b,\u0001,\u0001,\u0001"+
		",\u0001,\u0004,\u0240\b,\u000b,\f,\u0241\u0001,\u0001,\u0003,\u0246\b"+
		",\u0001,\u0003,\u0249\b,\u0001,\u0000\u0000-\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLNPRTVX\u0000\u0006\u0001\u0000-.\u0001\u0000),\u0001\u0000"+
		"45\u0001\u000069\u0001\u0000/0\u0001\u000013\u0282\u0000_\u0001\u0000"+
		"\u0000\u0000\u0002o\u0001\u0000\u0000\u0000\u0004\u0086\u0001\u0000\u0000"+
		"\u0000\u0006\u00a2\u0001\u0000\u0000\u0000\b\u00a4\u0001\u0000\u0000\u0000"+
		"\n\u00ac\u0001\u0000\u0000\u0000\f\u00af\u0001\u0000\u0000\u0000\u000e"+
		"\u00bb\u0001\u0000\u0000\u0000\u0010\u00bf\u0001\u0000\u0000\u0000\u0012"+
		"\u00cd\u0001\u0000\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000\u0016"+
		"\u00da\u0001\u0000\u0000\u0000\u0018\u00de\u0001\u0000\u0000\u0000\u001a"+
		"\u00e2\u0001\u0000\u0000\u0000\u001c\u00e9\u0001\u0000\u0000\u0000\u001e"+
		"\u00f0\u0001\u0000\u0000\u0000 \u00f2\u0001\u0000\u0000\u0000\"\u00f6"+
		"\u0001\u0000\u0000\u0000$\u0106\u0001\u0000\u0000\u0000&\u010b\u0001\u0000"+
		"\u0000\u0000(\u010d\u0001\u0000\u0000\u0000*\u0121\u0001\u0000\u0000\u0000"+
		",\u012a\u0001\u0000\u0000\u0000.\u0132\u0001\u0000\u0000\u00000\u0144"+
		"\u0001\u0000\u0000\u00002\u014f\u0001\u0000\u0000\u00004\u0175\u0001\u0000"+
		"\u0000\u00006\u017f\u0001\u0000\u0000\u00008\u0186\u0001\u0000\u0000\u0000"+
		":\u018a\u0001\u0000\u0000\u0000<\u0195\u0001\u0000\u0000\u0000>\u019d"+
		"\u0001\u0000\u0000\u0000@\u019f\u0001\u0000\u0000\u0000B\u01a7\u0001\u0000"+
		"\u0000\u0000D\u01af\u0001\u0000\u0000\u0000F\u01b7\u0001\u0000\u0000\u0000"+
		"H\u01bf\u0001\u0000\u0000\u0000J\u01c7\u0001\u0000\u0000\u0000L\u01d6"+
		"\u0001\u0000\u0000\u0000N\u01fb\u0001\u0000\u0000\u0000P\u01fd\u0001\u0000"+
		"\u0000\u0000R\u0208\u0001\u0000\u0000\u0000T\u020a\u0001\u0000\u0000\u0000"+
		"V\u0234\u0001\u0000\u0000\u0000X\u0248\u0001\u0000\u0000\u0000Z^\u0003"+
		"\f\u0006\u0000[^\u0003\u0006\u0003\u0000\\^\u0003\u0002\u0001\u0000]Z"+
		"\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005"+
		"\u0000\u0000\u0001c\u0001\u0001\u0000\u0000\u0000dp\u00034\u001a\u0000"+
		"ep\u00036\u001b\u0000fp\u00038\u001c\u0000gp\u0003:\u001d\u0000hp\u0003"+
		".\u0017\u0000ip\u0003(\u0014\u0000jp\u0003\u001e\u000f\u0000kp\u0003\u001c"+
		"\u000e\u0000lp\u0003\u001a\r\u0000mp\u0003\u0018\f\u0000np\u0003\u0016"+
		"\u000b\u0000od\u0001\u0000\u0000\u0000oe\u0001\u0000\u0000\u0000of\u0001"+
		"\u0000\u0000\u0000og\u0001\u0000\u0000\u0000oh\u0001\u0000\u0000\u0000"+
		"oi\u0001\u0000\u0000\u0000oj\u0001\u0000\u0000\u0000ok\u0001\u0000\u0000"+
		"\u0000ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000p\u0003\u0001\u0000\u0000\u0000qr\u0005\u0015\u0000\u0000"+
		"rs\u0005\u001f\u0000\u0000st\u0005\u0016\u0000\u0000tu\u0005 \u0000\u0000"+
		"uv\u0003>\u001f\u0000vw\u0005!\u0000\u0000w\u0087\u0001\u0000\u0000\u0000"+
		"xy\u0005\u0015\u0000\u0000yz\u0005\u001f\u0000\u0000z{\u0005\u0017\u0000"+
		"\u0000{|\u0005 \u0000\u0000|}\u0003>\u001f\u0000}~\u0005!\u0000\u0000"+
		"~\u0087\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0018\u0000\u0000\u0080"+
		"\u0081\u0005\u001f\u0000\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082"+
		"\u0083\u0005 \u0000\u0000\u0083\u0084\u0003>\u001f\u0000\u0084\u0085\u0005"+
		"!\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086q\u0001\u0000\u0000"+
		"\u0000\u0086x\u0001\u0000\u0000\u0000\u0086\u007f\u0001\u0000\u0000\u0000"+
		"\u0087\u0005\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0014\u0000\u0000"+
		"\u0089\u008a\u0005A\u0000\u0000\u008a\u008c\u0005 \u0000\u0000\u008b\u008d"+
		"\u0003\b\u0004\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0005"+
		"!\u0000\u0000\u008f\u0091\u0003R)\u0000\u0090\u008f\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u00a3\u0003\u0014\n\u0000\u0093\u0094\u0005\u0014\u0000\u0000"+
		"\u0094\u0095\u0005 \u0000\u0000\u0095\u0096\u0005A\u0000\u0000\u0096\u0097"+
		"\u0005A\u0000\u0000\u0097\u0098\u0005!\u0000\u0000\u0098\u0099\u0005A"+
		"\u0000\u0000\u0099\u009b\u0005 \u0000\u0000\u009a\u009c\u0003\b\u0004"+
		"\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0005!\u0000\u0000"+
		"\u009e\u00a0\u0003R)\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3"+
		"\u0003\u0014\n\u0000\u00a2\u0088\u0001\u0000\u0000\u0000\u00a2\u0093\u0001"+
		"\u0000\u0000\u0000\u00a3\u0007\u0001\u0000\u0000\u0000\u00a4\u00a9\u0003"+
		"\n\u0005\u0000\u00a5\u00a6\u0005\'\u0000\u0000\u00a6\u00a8\u0003\n\u0005"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\t\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005A\u0000\u0000\u00ad\u00ae\u0003R)\u0000\u00ae\u000b"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0013\u0000\u0000\u00b0\u00b1"+
		"\u0005A\u0000\u0000\u00b1\u00b3\u0005\"\u0000\u0000\u00b2\u00b4\u0003"+
		"\u000e\u0007\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0005"+
		"#\u0000\u0000\u00b8\u00ba\u0005&\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\r\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0003R)\u0000\u00bc\u00bd\u0005A\u0000\u0000\u00bd\u00be"+
		"\u0005&\u0000\u0000\u00be\u000f\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"\"\u0000\u0000\u00c0\u00c5\u0003\u0012\t\u0000\u00c1\u00c2\u0005\'\u0000"+
		"\u0000\u00c2\u00c4\u0003\u0012\t\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005\'\u0000\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005#\u0000\u0000\u00cc\u0011"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005A\u0000\u0000\u00ce\u00cf\u0005"+
		"(\u0000\u0000\u00cf\u00d0\u0003>\u001f\u0000\u00d0\u0013\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d5\u0005\"\u0000\u0000\u00d2\u00d4\u0003\u0002\u0001\u0000"+
		"\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0005#\u0000\u0000\u00d9\u0015\u0001\u0000\u0000\u0000\u00da"+
		"\u00dc\u0005\n\u0000\u0000\u00db\u00dd\u0005&\u0000\u0000\u00dc\u00db"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u0017"+
		"\u0001\u0000\u0000\u0000\u00de\u00e0\u0005\u000b\u0000\u0000\u00df\u00e1"+
		"\u0005&\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e1\u0019\u0001\u0000\u0000\u0000\u00e2\u00e4\u0005"+
		"\f\u0000\u0000\u00e3\u00e5\u0003>\u001f\u0000\u00e4\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e8\u0005&\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u001b\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0005A\u0000\u0000\u00ea\u00ec\u0007\u0000\u0000\u0000"+
		"\u00eb\u00ed\u0005&\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u001d\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f1\u0003 \u0010\u0000\u00ef\u00f1\u0003\"\u0011\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u001f"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u0006\u0000\u0000\u00f3\u00f4"+
		"\u0003>\u001f\u0000\u00f4\u00f5\u0003\u0014\n\u0000\u00f5!\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f8\u0005\u0006\u0000\u0000\u00f7\u00f9\u0003$\u0012"+
		"\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0005&\u0000\u0000"+
		"\u00fb\u00fd\u0003>\u001f\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe"+
		"\u0100\u0005&\u0000\u0000\u00ff\u0101\u0003&\u0013\u0000\u0100\u00ff\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0003\u0014\n\u0000\u0103#\u0001\u0000"+
		"\u0000\u0000\u0104\u0107\u00036\u001b\u0000\u0105\u0107\u00034\u001a\u0000"+
		"\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000"+
		"\u0107%\u0001\u0000\u0000\u0000\u0108\u010c\u00036\u001b\u0000\u0109\u010c"+
		"\u00038\u001c\u0000\u010a\u010c\u0003\u001c\u000e\u0000\u010b\u0108\u0001"+
		"\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\'\u0001\u0000\u0000\u0000\u010d\u0113\u0005\u0007"+
		"\u0000\u0000\u010e\u010f\u0005 \u0000\u0000\u010f\u0110\u0003>\u001f\u0000"+
		"\u0110\u0111\u0005!\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112"+
		"\u0114\u0003>\u001f\u0000\u0113\u010e\u0001\u0000\u0000\u0000\u0113\u0112"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0119"+
		"\u0005\"\u0000\u0000\u0116\u0118\u0003*\u0015\u0000\u0117\u0116\u0001"+
		"\u0000\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011d\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011e\u0003"+
		",\u0016\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0005#\u0000"+
		"\u0000\u0120)\u0001\u0000\u0000\u0000\u0121\u0122\u0005\b\u0000\u0000"+
		"\u0122\u0123\u0003>\u001f\u0000\u0123\u0127\u0005(\u0000\u0000\u0124\u0126"+
		"\u0003\u0002\u0001\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0129"+
		"\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128"+
		"\u0001\u0000\u0000\u0000\u0128+\u0001\u0000\u0000\u0000\u0129\u0127\u0001"+
		"\u0000\u0000\u0000\u012a\u012b\u0005\t\u0000\u0000\u012b\u012f\u0005("+
		"\u0000\u0000\u012c\u012e\u0003\u0002\u0001\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000"+
		"\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130-\u0001\u0000\u0000"+
		"\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0134\u0005\u0004\u0000"+
		"\u0000\u0133\u0135\u0005 \u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000"+
		"\u0136\u0138\u0003>\u001f\u0000\u0137\u0139\u0005!\u0000\u0000\u0138\u0137"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0001\u0000\u0000\u0000\u013a\u013e\u0003\u0014\n\u0000\u013b\u013d\u0003"+
		"0\u0018\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000"+
		"\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000"+
		"\u0000\u0000\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000"+
		"\u0000\u0000\u0141\u0143\u00032\u0019\u0000\u0142\u0141\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143/\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0005\u0005\u0000\u0000\u0145\u0147\u0005\u0004\u0000\u0000"+
		"\u0146\u0148\u0005 \u0000\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147"+
		"\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149"+
		"\u014b\u0003>\u001f\u0000\u014a\u014c\u0005!\u0000\u0000\u014b\u014a\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0003\u0014\n\u0000\u014e1\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0005\u0005\u0000\u0000\u0150\u0151\u0003\u0014"+
		"\n\u0000\u01513\u0001\u0000\u0000\u0000\u0152\u0153\u0005\u0001\u0000"+
		"\u0000\u0153\u0155\u0005A\u0000\u0000\u0154\u0156\u0003R)\u0000\u0155"+
		"\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156"+
		"\u0159\u0001\u0000\u0000\u0000\u0157\u0158\u0005)\u0000\u0000\u0158\u015a"+
		"\u0003>\u001f\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001"+
		"\u0000\u0000\u0000\u015a\u015c\u0001\u0000\u0000\u0000\u015b\u015d\u0005"+
		"&\u0000\u0000\u015c\u015b\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000"+
		"\u0000\u0000\u015d\u0176\u0001\u0000\u0000\u0000\u015e\u015f\u0005A\u0000"+
		"\u0000\u015f\u0160\u0005A\u0000\u0000\u0160\u0161\u0005)\u0000\u0000\u0161"+
		"\u0163\u0003\u0010\b\u0000\u0162\u0164\u0005&\u0000\u0000\u0163\u0162"+
		"\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0176"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0005\u0001\u0000\u0000\u0166\u0167"+
		"\u0005A\u0000\u0000\u0167\u0168\u0005)\u0000\u0000\u0168\u0169\u0005\u0014"+
		"\u0000\u0000\u0169\u016b\u0005 \u0000\u0000\u016a\u016c\u0003\b\u0004"+
		"\u0000\u016b\u016a\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0005!\u0000\u0000"+
		"\u016e\u0170\u0003R)\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u016f\u0170"+
		"\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0173"+
		"\u0003\u0014\n\u0000\u0172\u0174\u0005&\u0000\u0000\u0173\u0172\u0001"+
		"\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0176\u0001"+
		"\u0000\u0000\u0000\u0175\u0152\u0001\u0000\u0000\u0000\u0175\u015e\u0001"+
		"\u0000\u0000\u0000\u0175\u0165\u0001\u0000\u0000\u0000\u01765\u0001\u0000"+
		"\u0000\u0000\u0177\u0180\u0005A\u0000\u0000\u0178\u017b\u0005A\u0000\u0000"+
		"\u0179\u017a\u0005\u001f\u0000\u0000\u017a\u017c\u0005A\u0000\u0000\u017b"+
		"\u0179\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d"+
		"\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e"+
		"\u0180\u0001\u0000\u0000\u0000\u017f\u0177\u0001\u0000\u0000\u0000\u017f"+
		"\u0178\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0007\u0001\u0000\u0000\u0182\u0184\u0003>\u001f\u0000\u0183\u0185"+
		"\u0005&\u0000\u0000\u0184\u0183\u0001\u0000\u0000\u0000\u0184\u0185\u0001"+
		"\u0000\u0000\u0000\u01857\u0001\u0000\u0000\u0000\u0186\u0188\u0003>\u001f"+
		"\u0000\u0187\u0189\u0005&\u0000\u0000\u0188\u0187\u0001\u0000\u0000\u0000"+
		"\u0188\u0189\u0001\u0000\u0000\u0000\u01899\u0001\u0000\u0000\u0000\u018a"+
		"\u018b\u0005\u0002\u0000\u0000\u018b\u018c\u0005\u001f\u0000\u0000\u018c"+
		"\u018d\u0005\u0003\u0000\u0000\u018d\u018f\u0005 \u0000\u0000\u018e\u0190"+
		"\u0003<\u001e\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u018f\u0190\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0193\u0005"+
		"!\u0000\u0000\u0192\u0194\u0005&\u0000\u0000\u0193\u0192\u0001\u0000\u0000"+
		"\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194;\u0001\u0000\u0000\u0000"+
		"\u0195\u019a\u0003>\u001f\u0000\u0196\u0197\u0005\'\u0000\u0000\u0197"+
		"\u0199\u0003>\u001f\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0199\u019c"+
		"\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u019b"+
		"\u0001\u0000\u0000\u0000\u019b=\u0001\u0000\u0000\u0000\u019c\u019a\u0001"+
		"\u0000\u0000\u0000\u019d\u019e\u0003@ \u0000\u019e?\u0001\u0000\u0000"+
		"\u0000\u019f\u01a4\u0003B!\u0000\u01a0\u01a1\u0005;\u0000\u0000\u01a1"+
		"\u01a3\u0003B!\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a6\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001"+
		"\u0000\u0000\u0000\u01a5A\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a7\u01ac\u0003D\"\u0000\u01a8\u01a9\u0005:\u0000\u0000"+
		"\u01a9\u01ab\u0003D\"\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ae\u0001\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ac"+
		"\u01ad\u0001\u0000\u0000\u0000\u01adC\u0001\u0000\u0000\u0000\u01ae\u01ac"+
		"\u0001\u0000\u0000\u0000\u01af\u01b4\u0003F#\u0000\u01b0\u01b1\u0007\u0002"+
		"\u0000\u0000\u01b1\u01b3\u0003F#\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b6\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5E\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b4\u0001\u0000\u0000\u0000\u01b7\u01bc\u0003H$\u0000\u01b8\u01b9\u0007"+
		"\u0003\u0000\u0000\u01b9\u01bb\u0003H$\u0000\u01ba\u01b8\u0001\u0000\u0000"+
		"\u0000\u01bb\u01be\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bdG\u0001\u0000\u0000\u0000"+
		"\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf\u01c4\u0003J%\u0000\u01c0\u01c1"+
		"\u0007\u0004\u0000\u0000\u01c1\u01c3\u0003J%\u0000\u01c2\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c6\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5I\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c7\u01cc\u0003L&\u0000\u01c8"+
		"\u01c9\u0007\u0005\u0000\u0000\u01c9\u01cb\u0003L&\u0000\u01ca\u01c8\u0001"+
		"\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cdK\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01cf\u01d0\u00050\u0000"+
		"\u0000\u01d0\u01d7\u0003L&\u0000\u01d1\u01d2\u0005<\u0000\u0000\u01d2"+
		"\u01d7\u0003L&\u0000\u01d3\u01d7\u0003V+\u0000\u01d4\u01d7\u0003N\'\u0000"+
		"\u01d5\u01d7\u0003\u0004\u0002\u0000\u01d6\u01cf\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d1\u0001\u0000\u0000\u0000\u01d6\u01d3\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000"+
		"\u01d7M\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005\r\u0000\u0000\u01d9"+
		"\u01da\u0005 \u0000\u0000\u01da\u01db\u0003>\u001f\u0000\u01db\u01dc\u0005"+
		"!\u0000\u0000\u01dc\u01fc\u0001\u0000\u0000\u0000\u01dd\u01de\u0005\u000e"+
		"\u0000\u0000\u01de\u01df\u0005 \u0000\u0000\u01df\u01e4\u0003>\u001f\u0000"+
		"\u01e0\u01e1\u0005\'\u0000\u0000\u01e1\u01e3\u0003>\u001f\u0000\u01e2"+
		"\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e8\u0005!\u0000\u0000\u01e8\u01fc\u0001\u0000\u0000\u0000\u01e9\u01ea"+
		"\u0005\u000f\u0000\u0000\u01ea\u01eb\u0005\u001f\u0000\u0000\u01eb\u01ec"+
		"\u0005\u0012\u0000\u0000\u01ec\u01ed\u0005 \u0000\u0000\u01ed\u01ee\u0003"+
		">\u001f\u0000\u01ee\u01ef\u0005\'\u0000\u0000\u01ef\u01f0\u0003>\u001f"+
		"\u0000\u01f0\u01f1\u0005!\u0000\u0000\u01f1\u01fc\u0001\u0000\u0000\u0000"+
		"\u01f2\u01f3\u0005\u0010\u0000\u0000\u01f3\u01f4\u0005\u001f\u0000\u0000"+
		"\u01f4\u01f5\u0005\u0011\u0000\u0000\u01f5\u01f6\u0005 \u0000\u0000\u01f6"+
		"\u01f7\u0003>\u001f\u0000\u01f7\u01f8\u0005\'\u0000\u0000\u01f8\u01f9"+
		"\u0003>\u001f\u0000\u01f9\u01fa\u0005!\u0000\u0000\u01fa\u01fc\u0001\u0000"+
		"\u0000\u0000\u01fb\u01d8\u0001\u0000\u0000\u0000\u01fb\u01dd\u0001\u0000"+
		"\u0000\u0000\u01fb\u01e9\u0001\u0000\u0000\u0000\u01fb\u01f2\u0001\u0000"+
		"\u0000\u0000\u01fcO\u0001\u0000\u0000\u0000\u01fd\u01fe\u0005$\u0000\u0000"+
		"\u01fe\u01ff\u0005%\u0000\u0000\u01ff\u0200\u0003R)\u0000\u0200Q\u0001"+
		"\u0000\u0000\u0000\u0201\u0209\u0005\u001a\u0000\u0000\u0202\u0209\u0005"+
		"\u001b\u0000\u0000\u0203\u0209\u0005\u001c\u0000\u0000\u0204\u0209\u0005"+
		"\u001d\u0000\u0000\u0205\u0209\u0005\u001e\u0000\u0000\u0206\u0209\u0005"+
		"A\u0000\u0000\u0207\u0209\u0003P(\u0000\u0208\u0201\u0001\u0000\u0000"+
		"\u0000\u0208\u0202\u0001\u0000\u0000\u0000\u0208\u0203\u0001\u0000\u0000"+
		"\u0000\u0208\u0204\u0001\u0000\u0000\u0000\u0208\u0205\u0001\u0000\u0000"+
		"\u0000\u0208\u0206\u0001\u0000\u0000\u0000\u0208\u0207\u0001\u0000\u0000"+
		"\u0000\u0209S\u0001\u0000\u0000\u0000\u020a\u020b\u0003P(\u0000\u020b"+
		"\u0214\u0005\"\u0000\u0000\u020c\u0211\u0003>\u001f\u0000\u020d\u020e"+
		"\u0005\'\u0000\u0000\u020e\u0210\u0003>\u001f\u0000\u020f\u020d\u0001"+
		"\u0000\u0000\u0000\u0210\u0213\u0001\u0000\u0000\u0000\u0211\u020f\u0001"+
		"\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0215\u0001"+
		"\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0214\u020c\u0001"+
		"\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215\u0216\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0005#\u0000\u0000\u0217U\u0001\u0000\u0000"+
		"\u0000\u0218\u0235\u0003X,\u0000\u0219\u0220\u0005A\u0000\u0000\u021a"+
		"\u021b\u0005$\u0000\u0000\u021b\u021c\u0003>\u001f\u0000\u021c\u021d\u0005"+
		"%\u0000\u0000\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u021a\u0001\u0000"+
		"\u0000\u0000\u021f\u0222\u0001\u0000\u0000\u0000\u0220\u021e\u0001\u0000"+
		"\u0000\u0000\u0220\u0221\u0001\u0000\u0000\u0000\u0221\u0227\u0001\u0000"+
		"\u0000\u0000\u0222\u0220\u0001\u0000\u0000\u0000\u0223\u0224\u0005\u001f"+
		"\u0000\u0000\u0224\u0226\u0005A\u0000\u0000\u0225\u0223\u0001\u0000\u0000"+
		"\u0000\u0226\u0229\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000"+
		"\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u0235\u0001\u0000\u0000"+
		"\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u022a\u0235\u0005=\u0000\u0000"+
		"\u022b\u0235\u0005>\u0000\u0000\u022c\u0235\u0005?\u0000\u0000\u022d\u0235"+
		"\u0005@\u0000\u0000\u022e\u022f\u0005 \u0000\u0000\u022f\u0230\u0003>"+
		"\u001f\u0000\u0230\u0231\u0005!\u0000\u0000\u0231\u0235\u0001\u0000\u0000"+
		"\u0000\u0232\u0235\u0003T*\u0000\u0233\u0235\u0003\u0010\b\u0000\u0234"+
		"\u0218\u0001\u0000\u0000\u0000\u0234\u0219\u0001\u0000\u0000\u0000\u0234"+
		"\u022a\u0001\u0000\u0000\u0000\u0234\u022b\u0001\u0000\u0000\u0000\u0234"+
		"\u022c\u0001\u0000\u0000\u0000\u0234\u022d\u0001\u0000\u0000\u0000\u0234"+
		"\u022e\u0001\u0000\u0000\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0234"+
		"\u0233\u0001\u0000\u0000\u0000\u0235W\u0001\u0000\u0000\u0000\u0236\u0237"+
		"\u0005A\u0000\u0000\u0237\u0239\u0005 \u0000\u0000\u0238\u023a\u0003<"+
		"\u001e\u0000\u0239\u0238\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000"+
		"\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u0249\u0005!\u0000"+
		"\u0000\u023c\u023f\u0005A\u0000\u0000\u023d\u023e\u0005\u001f\u0000\u0000"+
		"\u023e\u0240\u0005A\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240"+
		"\u0241\u0001\u0000\u0000\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241"+
		"\u0242\u0001\u0000\u0000\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243"+
		"\u0245\u0005 \u0000\u0000\u0244\u0246\u0003<\u001e\u0000\u0245\u0244\u0001"+
		"\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246\u0247\u0001"+
		"\u0000\u0000\u0000\u0247\u0249\u0005!\u0000\u0000\u0248\u0236\u0001\u0000"+
		"\u0000\u0000\u0248\u023c\u0001\u0000\u0000\u0000\u0249Y\u0001\u0000\u0000"+
		"\u0000G]_o\u0086\u008c\u0090\u009b\u009f\u00a2\u00a9\u00b5\u00b9\u00c5"+
		"\u00c9\u00d5\u00dc\u00e0\u00e4\u00e7\u00ec\u00f0\u00f8\u00fc\u0100\u0106"+
		"\u010b\u0113\u0119\u011d\u0127\u012f\u0134\u0138\u013e\u0142\u0147\u014b"+
		"\u0155\u0159\u015c\u0163\u016b\u016f\u0173\u0175\u017d\u017f\u0184\u0188"+
		"\u018f\u0193\u019a\u01a4\u01ac\u01b4\u01bc\u01c4\u01cc\u01d6\u01e4\u01fb"+
		"\u0208\u0211\u0214\u0220\u0227\u0234\u0239\u0241\u0245\u0248";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}