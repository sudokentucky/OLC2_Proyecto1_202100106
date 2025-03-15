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
		BREAK=10, CONTINUE=11, RETURN=12, INT_TYPE=13, FLOAT64_TYPE=14, STRING_TYPE=15, 
		BOOL_TYPE=16, RUNE_TYPE=17, PUNTO=18, PARENTESIS_IZQ=19, PARENTESIS_DER=20, 
		CORCHETE_IZQ=21, CORCHETE_DER=22, PUNTO_Y_COMA=23, COMA=24, DOS_PUNTOS=25, 
		ASIGNACION=26, ASIGNACIO_INCREMENTO=27, ASIGNACIO_DECREMENTO=28, INCREMENTO=29, 
		DECREMENTO=30, PLUS=31, MINUS=32, STAR=33, DIV=34, MOD=35, IGUAL=36, DIFERENTE=37, 
		MAYOR_QUE=38, MENOR_QUE=39, MAYOR_IGUAL_QUE=40, MENOR_IGUAL_QUE=41, AND=42, 
		OR=43, NOT=44, INT_LIT=45, FLOAT_LIT=46, STRING_LIT=47, RUNE_LIT=48, IDENTIFIER=49, 
		ESPACIO_BLANCO=50, COMENTARIO_LINE=51, COMENTARIO_MULTILINEA=52;
	public static final int
		RULE_program = 0, RULE_instruction = 1, RULE_bloque = 2, RULE_breakStmt = 3, 
		RULE_continueStmt = 4, RULE_returnStmt = 5, RULE_incDecStmt = 6, RULE_forStmt = 7, 
		RULE_forWhileStmt = 8, RULE_forThreePartStmt = 9, RULE_forInit = 10, RULE_forPost = 11, 
		RULE_switchStmt = 12, RULE_caseStmt = 13, RULE_defaultStmt = 14, RULE_ifStmt = 15, 
		RULE_elseIfStmt = 16, RULE_elseStmt = 17, RULE_declaracion = 18, RULE_assignacion = 19, 
		RULE_exprStmt = 20, RULE_printStmt = 21, RULE_typeSpec = 22, RULE_argumentList = 23, 
		RULE_expresion = 24, RULE_logicalOrExpr = 25, RULE_logicalAndExpr = 26, 
		RULE_equalityExpr = 27, RULE_relationalExpr = 28, RULE_addExpr = 29, RULE_mulExpr = 30, 
		RULE_unaryExpr = 31, RULE_primary = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instruction", "bloque", "breakStmt", "continueStmt", "returnStmt", 
			"incDecStmt", "forStmt", "forWhileStmt", "forThreePartStmt", "forInit", 
			"forPost", "switchStmt", "caseStmt", "defaultStmt", "ifStmt", "elseIfStmt", 
			"elseStmt", "declaracion", "assignacion", "exprStmt", "printStmt", "typeSpec", 
			"argumentList", "expresion", "logicalOrExpr", "logicalAndExpr", "equalityExpr", 
			"relationalExpr", "addExpr", "mulExpr", "unaryExpr", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'fmt'", "'Println'", "'if'", "'else'", "'for'", "'switch'", 
			"'case'", "'default'", "'break'", "'continue'", "'return'", "'int'", 
			"'float64'", "'string'", "'bool'", "'rune'", "'.'", "'('", "')'", "'{'", 
			"'}'", "';'", "','", "':'", "'='", "'+='", "'-='", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
			"'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "FMT", "PRINTLN", "IF", "ELSE", "FOR", "SWITCH", "CASE", 
			"DEFAULT", "BREAK", "CONTINUE", "RETURN", "INT_TYPE", "FLOAT64_TYPE", 
			"STRING_TYPE", "BOOL_TYPE", "RUNE_TYPE", "PUNTO", "PARENTESIS_IZQ", "PARENTESIS_DER", 
			"CORCHETE_IZQ", "CORCHETE_DER", "PUNTO_Y_COMA", "COMA", "DOS_PUNTOS", 
			"ASIGNACION", "ASIGNACIO_INCREMENTO", "ASIGNACIO_DECREMENTO", "INCREMENTO", 
			"DECREMENTO", "PLUS", "MINUS", "STAR", "DIV", "MOD", "IGUAL", "DIFERENTE", 
			"MAYOR_QUE", "MENOR_QUE", "MAYOR_IGUAL_QUE", "MENOR_IGUAL_QUE", "AND", 
			"OR", "NOT", "INT_LIT", "FLOAT_LIT", "STRING_LIT", "RUNE_LIT", "IDENTIFIER", 
			"ESPACIO_BLANCO", "COMENTARIO_LINE", "COMENTARIO_MULTILINEA"
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
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016297174L) != 0)) {
				{
				{
				setState(66);
				instruction();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				declaracion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				assignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				printStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				ifStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				switchStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				forStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				incDecStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				returnStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(83);
				continueStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(84);
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
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode CORCHETE_IZQ() { return getToken(gramaticaParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(gramaticaParser.CORCHETE_DER, 0); }
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
		enterRule(_localctx, 4, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(CORCHETE_IZQ);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016297174L) != 0)) {
				{
				{
				setState(88);
				instruction();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(CORCHETE_DER);
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
		enterRule(_localctx, 6, RULE_breakStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(BREAK);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(97);
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
		enterRule(_localctx, 8, RULE_continueStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(CONTINUE);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(101);
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
		enterRule(_localctx, 10, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(RETURN);
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(105);
				expresion();
				}
				break;
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(108);
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
		enterRule(_localctx, 12, RULE_incDecStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(IDENTIFIER);
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(113);
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
		enterRule(_localctx, 14, RULE_forStmt);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				forWhileStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
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
		enterRule(_localctx, 16, RULE_forWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(FOR);
			setState(121);
			expresion();
			setState(122);
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
		enterRule(_localctx, 18, RULE_forThreePartStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(FOR);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR || _la==IDENTIFIER) {
				{
				setState(125);
				forInit();
				}
			}

			setState(128);
			match(PUNTO_Y_COMA);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016289792L) != 0)) {
				{
				setState(129);
				expresion();
				}
			}

			setState(132);
			match(PUNTO_Y_COMA);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016289792L) != 0)) {
				{
				setState(133);
				forPost();
				}
			}

			setState(136);
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
		enterRule(_localctx, 20, RULE_forInit);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				assignacion();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				declaracion();
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
		enterRule(_localctx, 22, RULE_forPost);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				assignacion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				exprStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
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
		public TerminalNode CORCHETE_IZQ() { return getToken(gramaticaParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(gramaticaParser.CORCHETE_DER, 0); }
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
		enterRule(_localctx, 24, RULE_switchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(SWITCH);
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(148);
				match(PARENTESIS_IZQ);
				setState(149);
				expresion();
				setState(150);
				match(PARENTESIS_DER);
				}
				break;
			case 2:
				{
				setState(152);
				expresion();
				}
				break;
			}
			setState(155);
			match(CORCHETE_IZQ);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(156);
				caseStmt();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(162);
				defaultStmt();
				}
			}

			setState(165);
			match(CORCHETE_DER);
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
		enterRule(_localctx, 26, RULE_caseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(CASE);
			setState(168);
			expresion();
			setState(169);
			match(DOS_PUNTOS);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016297174L) != 0)) {
				{
				{
				setState(170);
				instruction();
				}
				}
				setState(175);
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
		enterRule(_localctx, 28, RULE_defaultStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(DEFAULT);
			setState(177);
			match(DOS_PUNTOS);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016297174L) != 0)) {
				{
				{
				setState(178);
				instruction();
				}
				}
				setState(183);
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
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(IF);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(185);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(188);
			expresion();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(189);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(192);
			bloque();
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					elseIfStmt();
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(199);
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
		enterRule(_localctx, 32, RULE_elseIfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ELSE);
			setState(203);
			match(IF);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(204);
				match(PARENTESIS_IZQ);
				}
				break;
			}
			setState(207);
			expresion();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTESIS_DER) {
				{
				setState(208);
				match(PARENTESIS_DER);
				}
			}

			}
			setState(211);
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
		enterRule(_localctx, 34, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(ELSE);
			setState(214);
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
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode ASIGNACION() { return getToken(gramaticaParser.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_Y_COMA() { return getToken(gramaticaParser.PUNTO_Y_COMA, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(VAR);
			setState(217);
			match(IDENTIFIER);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 253952L) != 0)) {
				{
				setState(218);
				typeSpec();
				}
			}

			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASIGNACION) {
				{
				setState(221);
				match(ASIGNACION);
				setState(222);
				expresion();
				}
			}

			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(225);
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
		enterRule(_localctx, 38, RULE_assignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(IDENTIFIER);
			setState(229);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(230);
			expresion();
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(231);
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
		enterRule(_localctx, 40, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			expresion();
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
		enterRule(_localctx, 42, RULE_printStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(FMT);
			setState(239);
			match(PUNTO);
			setState(240);
			match(PRINTLN);
			setState(241);
			match(PARENTESIS_IZQ);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1108312016289792L) != 0)) {
				{
				setState(242);
				argumentList();
				}
			}

			setState(245);
			match(PARENTESIS_DER);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_Y_COMA) {
				{
				setState(246);
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
	public static class TypeSpecContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(gramaticaParser.INT_TYPE, 0); }
		public TerminalNode FLOAT64_TYPE() { return getToken(gramaticaParser.FLOAT64_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(gramaticaParser.STRING_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(gramaticaParser.BOOL_TYPE, 0); }
		public TerminalNode RUNE_TYPE() { return getToken(gramaticaParser.RUNE_TYPE, 0); }
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 253952L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		enterRule(_localctx, 46, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			expresion();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(252);
				match(COMA);
				setState(253);
				expresion();
				}
				}
				setState(258);
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
		enterRule(_localctx, 48, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
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
		enterRule(_localctx, 50, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			logicalAndExpr();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(262);
				match(OR);
				setState(263);
				logicalAndExpr();
				}
				}
				setState(268);
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
		enterRule(_localctx, 52, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			equalityExpr();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(270);
				match(AND);
				setState(271);
				equalityExpr();
				}
				}
				setState(276);
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
		enterRule(_localctx, 54, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			relationalExpr();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUAL || _la==DIFERENTE) {
				{
				{
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==IGUAL || _la==DIFERENTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(279);
				relationalExpr();
				}
				}
				setState(284);
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
		enterRule(_localctx, 56, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			addExpr();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) {
				{
				{
				setState(286);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(287);
				addExpr();
				}
				}
				setState(292);
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
		enterRule(_localctx, 58, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			mulExpr();
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(294);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(295);
					mulExpr();
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 60, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			unaryExpr();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) {
				{
				{
				setState(302);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(303);
				unaryExpr();
				}
				}
				setState(308);
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
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_unaryExpr);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(MINUS);
				setState(310);
				unaryExpr();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(NOT);
				setState(312);
				unaryExpr();
				}
				break;
			case PARENTESIS_IZQ:
			case INT_LIT:
			case FLOAT_LIT:
			case STRING_LIT:
			case RUNE_LIT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				primary();
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
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(gramaticaParser.IDENTIFIER, 0); }
		public TerminalNode RUNE_LIT() { return getToken(gramaticaParser.RUNE_LIT, 0); }
		public TerminalNode INT_LIT() { return getToken(gramaticaParser.INT_LIT, 0); }
		public TerminalNode FLOAT_LIT() { return getToken(gramaticaParser.FLOAT_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(gramaticaParser.STRING_LIT, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(gramaticaParser.PARENTESIS_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(gramaticaParser.PARENTESIS_DER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primary);
		try {
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				match(IDENTIFIER);
				}
				break;
			case RUNE_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(RUNE_LIT);
				}
				break;
			case INT_LIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
				match(INT_LIT);
				}
				break;
			case FLOAT_LIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(FLOAT_LIT);
				}
				break;
			case STRING_LIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(320);
				match(STRING_LIT);
				}
				break;
			case PARENTESIS_IZQ:
				enterOuterAlt(_localctx, 6);
				{
				setState(321);
				match(PARENTESIS_IZQ);
				setState(322);
				expresion();
				setState(323);
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

	public static final String _serializedATN =
		"\u0004\u00014\u0148\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002Z\b\u0002\n\u0002\f\u0002]\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0003\u0004g\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005"+
		"k\b\u0005\u0001\u0005\u0003\u0005n\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006s\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007w\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u007f\b\t\u0001"+
		"\t\u0001\t\u0003\t\u0083\b\t\u0001\t\u0001\t\u0003\t\u0087\b\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0003\n\u008d\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u0092\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u009a\b\f\u0001\f\u0001\f\u0005\f\u009e\b\f\n\f\f\f"+
		"\u00a1\t\f\u0001\f\u0003\f\u00a4\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00ac\b\r\n\r\f\r\u00af\t\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00b4\b\u000e\n\u000e\f\u000e\u00b7\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00bb\b\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00bf\b\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00c3\b\u000f"+
		"\n\u000f\f\u000f\u00c6\t\u000f\u0001\u000f\u0003\u000f\u00c9\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ce\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00d2\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00dc"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00e0\b\u0012\u0001\u0012"+
		"\u0003\u0012\u00e3\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00e9\b\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u00ed\b"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00f4\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00f8\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u00ff\b\u0017\n\u0017\f\u0017\u0102\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0109\b\u0019\n\u0019\f\u0019"+
		"\u010c\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0111\b"+
		"\u001a\n\u001a\f\u001a\u0114\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u0119\b\u001b\n\u001b\f\u001b\u011c\t\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u0121\b\u001c\n\u001c\f\u001c\u0124\t\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0129\b\u001d\n\u001d"+
		"\f\u001d\u012c\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u0131\b\u001e\n\u001e\f\u001e\u0134\t\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u013b\b\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0146\b \u0001"+
		" \u0000\u0000!\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000\u0007\u0001\u0000\u001d"+
		"\u001e\u0001\u0000\u001a\u001c\u0001\u0000\r\u0011\u0001\u0000$%\u0001"+
		"\u0000&)\u0001\u0000\u001f \u0001\u0000!#\u015e\u0000E\u0001\u0000\u0000"+
		"\u0000\u0002U\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000\u0006"+
		"`\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000"+
		"\u0000\fo\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010"+
		"x\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014\u008c\u0001"+
		"\u0000\u0000\u0000\u0016\u0091\u0001\u0000\u0000\u0000\u0018\u0093\u0001"+
		"\u0000\u0000\u0000\u001a\u00a7\u0001\u0000\u0000\u0000\u001c\u00b0\u0001"+
		"\u0000\u0000\u0000\u001e\u00b8\u0001\u0000\u0000\u0000 \u00ca\u0001\u0000"+
		"\u0000\u0000\"\u00d5\u0001\u0000\u0000\u0000$\u00d8\u0001\u0000\u0000"+
		"\u0000&\u00e4\u0001\u0000\u0000\u0000(\u00ea\u0001\u0000\u0000\u0000*"+
		"\u00ee\u0001\u0000\u0000\u0000,\u00f9\u0001\u0000\u0000\u0000.\u00fb\u0001"+
		"\u0000\u0000\u00000\u0103\u0001\u0000\u0000\u00002\u0105\u0001\u0000\u0000"+
		"\u00004\u010d\u0001\u0000\u0000\u00006\u0115\u0001\u0000\u0000\u00008"+
		"\u011d\u0001\u0000\u0000\u0000:\u0125\u0001\u0000\u0000\u0000<\u012d\u0001"+
		"\u0000\u0000\u0000>\u013a\u0001\u0000\u0000\u0000@\u0145\u0001\u0000\u0000"+
		"\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005\u0000\u0000\u0001"+
		"I\u0001\u0001\u0000\u0000\u0000JV\u0003$\u0012\u0000KV\u0003&\u0013\u0000"+
		"LV\u0003(\u0014\u0000MV\u0003*\u0015\u0000NV\u0003\u001e\u000f\u0000O"+
		"V\u0003\u0018\f\u0000PV\u0003\u000e\u0007\u0000QV\u0003\f\u0006\u0000"+
		"RV\u0003\n\u0005\u0000SV\u0003\b\u0004\u0000TV\u0003\u0006\u0003\u0000"+
		"UJ\u0001\u0000\u0000\u0000UK\u0001\u0000\u0000\u0000UL\u0001\u0000\u0000"+
		"\u0000UM\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000UO\u0001\u0000"+
		"\u0000\u0000UP\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000UR\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000"+
		"V\u0003\u0001\u0000\u0000\u0000W[\u0005\u0015\u0000\u0000XZ\u0003\u0002"+
		"\u0001\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000^_\u0005\u0016\u0000\u0000_\u0005\u0001\u0000"+
		"\u0000\u0000`b\u0005\n\u0000\u0000ac\u0005\u0017\u0000\u0000ba\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000c\u0007\u0001\u0000\u0000\u0000"+
		"df\u0005\u000b\u0000\u0000eg\u0005\u0017\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000g\t\u0001\u0000\u0000\u0000hj\u0005\f"+
		"\u0000\u0000ik\u00030\u0018\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000km\u0001\u0000\u0000\u0000ln\u0005\u0017\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u000b\u0001\u0000\u0000"+
		"\u0000op\u00051\u0000\u0000pr\u0007\u0000\u0000\u0000qs\u0005\u0017\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\r\u0001\u0000"+
		"\u0000\u0000tw\u0003\u0010\b\u0000uw\u0003\u0012\t\u0000vt\u0001\u0000"+
		"\u0000\u0000vu\u0001\u0000\u0000\u0000w\u000f\u0001\u0000\u0000\u0000"+
		"xy\u0005\u0006\u0000\u0000yz\u00030\u0018\u0000z{\u0003\u0004\u0002\u0000"+
		"{\u0011\u0001\u0000\u0000\u0000|~\u0005\u0006\u0000\u0000}\u007f\u0003"+
		"\u0014\n\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0005\u0017\u0000\u0000"+
		"\u0081\u0083\u00030\u0018\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0005\u0017\u0000\u0000\u0085\u0087\u0003\u0016\u000b\u0000\u0086"+
		"\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0003\u0004\u0002\u0000\u0089"+
		"\u0013\u0001\u0000\u0000\u0000\u008a\u008d\u0003&\u0013\u0000\u008b\u008d"+
		"\u0003$\u0012\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u0015\u0001\u0000\u0000\u0000\u008e\u0092\u0003"+
		"&\u0013\u0000\u008f\u0092\u0003(\u0014\u0000\u0090\u0092\u0003\f\u0006"+
		"\u0000\u0091\u008e\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0017\u0001\u0000\u0000"+
		"\u0000\u0093\u0099\u0005\u0007\u0000\u0000\u0094\u0095\u0005\u0013\u0000"+
		"\u0000\u0095\u0096\u00030\u0018\u0000\u0096\u0097\u0005\u0014\u0000\u0000"+
		"\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u009a\u00030\u0018\u0000\u0099"+
		"\u0094\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009f\u0005\u0015\u0000\u0000\u009c"+
		"\u009e\u0003\u001a\r\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1"+
		"\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a4\u0003\u001c\u000e\u0000\u00a3\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0016\u0000\u0000\u00a6\u0019"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\b\u0000\u0000\u00a8\u00a9\u0003"+
		"0\u0018\u0000\u00a9\u00ad\u0005\u0019\u0000\u0000\u00aa\u00ac\u0003\u0002"+
		"\u0001\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\u001b\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0005\t\u0000\u0000\u00b1\u00b5\u0005\u0019\u0000"+
		"\u0000\u00b2\u00b4\u0003\u0002\u0001\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u001d\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005\u0004\u0000"+
		"\u0000\u00b9\u00bb\u0005\u0013\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00be\u00030\u0018\u0000\u00bd\u00bf\u0005\u0014\u0000\u0000"+
		"\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c4\u0003\u0004\u0002\u0000"+
		"\u00c1\u00c3\u0003 \u0010\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c9\u0003\"\u0011\u0000\u00c8\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u001f"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000\u00cb\u00cd"+
		"\u0005\u0004\u0000\u0000\u00cc\u00ce\u0005\u0013\u0000\u0000\u00cd\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d1\u00030\u0018\u0000\u00d0\u00d2\u0005"+
		"\u0014\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003"+
		"\u0004\u0002\u0000\u00d4!\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u0005"+
		"\u0000\u0000\u00d6\u00d7\u0003\u0004\u0002\u0000\u00d7#\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005\u0001\u0000\u0000\u00d9\u00db\u00051\u0000\u0000"+
		"\u00da\u00dc\u0003,\u0016\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0005\u001a\u0000\u0000\u00de\u00e0\u00030\u0018\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e3\u0005\u0017\u0000\u0000\u00e2\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3%\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u00051\u0000\u0000\u00e5\u00e6\u0007\u0001"+
		"\u0000\u0000\u00e6\u00e8\u00030\u0018\u0000\u00e7\u00e9\u0005\u0017\u0000"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e9\'\u0001\u0000\u0000\u0000\u00ea\u00ec\u00030\u0018\u0000"+
		"\u00eb\u00ed\u0005\u0017\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed)\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0005\u0002\u0000\u0000\u00ef\u00f0\u0005\u0012\u0000\u0000\u00f0"+
		"\u00f1\u0005\u0003\u0000\u0000\u00f1\u00f3\u0005\u0013\u0000\u0000\u00f2"+
		"\u00f4\u0003.\u0017\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f7"+
		"\u0005\u0014\u0000\u0000\u00f6\u00f8\u0005\u0017\u0000\u0000\u00f7\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8+\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0007\u0002\u0000\u0000\u00fa-\u0001\u0000"+
		"\u0000\u0000\u00fb\u0100\u00030\u0018\u0000\u00fc\u00fd\u0005\u0018\u0000"+
		"\u0000\u00fd\u00ff\u00030\u0018\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u0001\u0000\u0000\u0000\u0101/\u0001\u0000\u0000\u0000\u0102"+
		"\u0100\u0001\u0000\u0000\u0000\u0103\u0104\u00032\u0019\u0000\u01041\u0001"+
		"\u0000\u0000\u0000\u0105\u010a\u00034\u001a\u0000\u0106\u0107\u0005+\u0000"+
		"\u0000\u0107\u0109\u00034\u001a\u0000\u0108\u0106\u0001\u0000\u0000\u0000"+
		"\u0109\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0001\u0000\u0000\u0000\u010b3\u0001\u0000\u0000\u0000\u010c"+
		"\u010a\u0001\u0000\u0000\u0000\u010d\u0112\u00036\u001b\u0000\u010e\u010f"+
		"\u0005*\u0000\u0000\u010f\u0111\u00036\u001b\u0000\u0110\u010e\u0001\u0000"+
		"\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u01135\u0001\u0000\u0000"+
		"\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115\u011a\u00038\u001c\u0000"+
		"\u0116\u0117\u0007\u0003\u0000\u0000\u0117\u0119\u00038\u001c\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b"+
		"7\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u0122"+
		"\u0003:\u001d\u0000\u011e\u011f\u0007\u0004\u0000\u0000\u011f\u0121\u0003"+
		":\u001d\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000"+
		"\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000"+
		"\u0000\u0000\u01239\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0125\u012a\u0003<\u001e\u0000\u0126\u0127\u0007\u0005\u0000\u0000"+
		"\u0127\u0129\u0003<\u001e\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129"+
		"\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b;\u0001\u0000\u0000\u0000\u012c\u012a"+
		"\u0001\u0000\u0000\u0000\u012d\u0132\u0003>\u001f\u0000\u012e\u012f\u0007"+
		"\u0006\u0000\u0000\u012f\u0131\u0003>\u001f\u0000\u0130\u012e\u0001\u0000"+
		"\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000"+
		"\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133=\u0001\u0000\u0000"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0136\u0005 \u0000\u0000"+
		"\u0136\u013b\u0003>\u001f\u0000\u0137\u0138\u0005,\u0000\u0000\u0138\u013b"+
		"\u0003>\u001f\u0000\u0139\u013b\u0003@ \u0000\u013a\u0135\u0001\u0000"+
		"\u0000\u0000\u013a\u0137\u0001\u0000\u0000\u0000\u013a\u0139\u0001\u0000"+
		"\u0000\u0000\u013b?\u0001\u0000\u0000\u0000\u013c\u0146\u00051\u0000\u0000"+
		"\u013d\u0146\u00050\u0000\u0000\u013e\u0146\u0005-\u0000\u0000\u013f\u0146"+
		"\u0005.\u0000\u0000\u0140\u0146\u0005/\u0000\u0000\u0141\u0142\u0005\u0013"+
		"\u0000\u0000\u0142\u0143\u00030\u0018\u0000\u0143\u0144\u0005\u0014\u0000"+
		"\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u013c\u0001\u0000\u0000"+
		"\u0000\u0145\u013d\u0001\u0000\u0000\u0000\u0145\u013e\u0001\u0000\u0000"+
		"\u0000\u0145\u013f\u0001\u0000\u0000\u0000\u0145\u0140\u0001\u0000\u0000"+
		"\u0000\u0145\u0141\u0001\u0000\u0000\u0000\u0146A\u0001\u0000\u0000\u0000"+
		")EU[bfjmrv~\u0082\u0086\u008c\u0091\u0099\u009f\u00a3\u00ad\u00b5\u00ba"+
		"\u00be\u00c4\u00c8\u00cd\u00d1\u00db\u00df\u00e2\u00e8\u00ec\u00f3\u00f7"+
		"\u0100\u010a\u0112\u011a\u0122\u012a\u0132\u013a\u0145";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}