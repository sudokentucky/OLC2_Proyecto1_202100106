// Generated from /home/sudokentucky/Documentos/COMPI2/OLC2_Proyecto1_202100106/client/gramatica.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class gramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, IF=2, ELSE=3, FMT=4, PRINTLN=5, DOT=6, LPAREN=7, RPAREN=8, LBRACE=9, 
		RBRACE=10, SEMICOLON=11, COMMA=12, ASSIGN=13, PLUS=14, MINUS=15, STAR=16, 
		DIV=17, MOD=18, EQUAL=19, NOT_EQUAL=20, GREATER=21, LESS=22, GREATER_EQ=23, 
		LESS_EQ=24, AND_LOGIC=25, OR_LOGIC=26, NOT_LOGIC=27, INT_LIT=28, IDENTIFIER=29, 
		WS=30, LINE_COMMENT=31, BLOCK_COMMENT=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAR", "IF", "ELSE", "FMT", "PRINTLN", "DOT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "SEMICOLON", "COMMA", "ASSIGN", "PLUS", "MINUS", "STAR", "DIV", 
			"MOD", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", "GREATER_EQ", "LESS_EQ", 
			"AND_LOGIC", "OR_LOGIC", "NOT_LOGIC", "INT_LIT", "IDENTIFIER", "WS", 
			"LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'if'", "'else'", "'fmt'", "'Println'", "'.'", "'('", 
			"')'", "'{'", "'}'", "';'", "','", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'&&'", "'||'", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "IF", "ELSE", "FMT", "PRINTLN", "DOT", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "SEMICOLON", "COMMA", "ASSIGN", "PLUS", "MINUS", 
			"STAR", "DIV", "MOD", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", "GREATER_EQ", 
			"LESS_EQ", "AND_LOGIC", "OR_LOGIC", "NOT_LOGIC", "INT_LIT", "IDENTIFIER", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
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


	public gramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000 \u00b7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0004\u001b\u008d\b\u001b\u000b\u001b"+
		"\f\u001b\u008e\u0001\u001c\u0001\u001c\u0005\u001c\u0093\b\u001c\n\u001c"+
		"\f\u001c\u0096\t\u001c\u0001\u001d\u0004\u001d\u0099\b\u001d\u000b\u001d"+
		"\f\u001d\u009a\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u00a3\b\u001e\n\u001e\f\u001e\u00a6\t\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u00ae\b\u001f\n\u001f\f\u001f\u00b1\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u00af\u0000 \u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? \u0001\u0000\u0005\u0001\u000009"+
		"\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"\n\n\r\r\u00bb\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0001"+
		"A\u0001\u0000\u0000\u0000\u0003E\u0001\u0000\u0000\u0000\u0005H\u0001"+
		"\u0000\u0000\u0000\u0007M\u0001\u0000\u0000\u0000\tQ\u0001\u0000\u0000"+
		"\u0000\u000bY\u0001\u0000\u0000\u0000\r[\u0001\u0000\u0000\u0000\u000f"+
		"]\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000\u0000\u0013a\u0001"+
		"\u0000\u0000\u0000\u0015c\u0001\u0000\u0000\u0000\u0017e\u0001\u0000\u0000"+
		"\u0000\u0019g\u0001\u0000\u0000\u0000\u001bi\u0001\u0000\u0000\u0000\u001d"+
		"k\u0001\u0000\u0000\u0000\u001fm\u0001\u0000\u0000\u0000!o\u0001\u0000"+
		"\u0000\u0000#q\u0001\u0000\u0000\u0000%s\u0001\u0000\u0000\u0000\'v\u0001"+
		"\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+{\u0001\u0000\u0000\u0000"+
		"-}\u0001\u0000\u0000\u0000/\u0080\u0001\u0000\u0000\u00001\u0083\u0001"+
		"\u0000\u0000\u00003\u0086\u0001\u0000\u0000\u00005\u0089\u0001\u0000\u0000"+
		"\u00007\u008c\u0001\u0000\u0000\u00009\u0090\u0001\u0000\u0000\u0000;"+
		"\u0098\u0001\u0000\u0000\u0000=\u009e\u0001\u0000\u0000\u0000?\u00a9\u0001"+
		"\u0000\u0000\u0000AB\u0005v\u0000\u0000BC\u0005a\u0000\u0000CD\u0005r"+
		"\u0000\u0000D\u0002\u0001\u0000\u0000\u0000EF\u0005i\u0000\u0000FG\u0005"+
		"f\u0000\u0000G\u0004\u0001\u0000\u0000\u0000HI\u0005e\u0000\u0000IJ\u0005"+
		"l\u0000\u0000JK\u0005s\u0000\u0000KL\u0005e\u0000\u0000L\u0006\u0001\u0000"+
		"\u0000\u0000MN\u0005f\u0000\u0000NO\u0005m\u0000\u0000OP\u0005t\u0000"+
		"\u0000P\b\u0001\u0000\u0000\u0000QR\u0005P\u0000\u0000RS\u0005r\u0000"+
		"\u0000ST\u0005i\u0000\u0000TU\u0005n\u0000\u0000UV\u0005t\u0000\u0000"+
		"VW\u0005l\u0000\u0000WX\u0005n\u0000\u0000X\n\u0001\u0000\u0000\u0000"+
		"YZ\u0005.\u0000\u0000Z\f\u0001\u0000\u0000\u0000[\\\u0005(\u0000\u0000"+
		"\\\u000e\u0001\u0000\u0000\u0000]^\u0005)\u0000\u0000^\u0010\u0001\u0000"+
		"\u0000\u0000_`\u0005{\u0000\u0000`\u0012\u0001\u0000\u0000\u0000ab\u0005"+
		"}\u0000\u0000b\u0014\u0001\u0000\u0000\u0000cd\u0005;\u0000\u0000d\u0016"+
		"\u0001\u0000\u0000\u0000ef\u0005,\u0000\u0000f\u0018\u0001\u0000\u0000"+
		"\u0000gh\u0005=\u0000\u0000h\u001a\u0001\u0000\u0000\u0000ij\u0005+\u0000"+
		"\u0000j\u001c\u0001\u0000\u0000\u0000kl\u0005-\u0000\u0000l\u001e\u0001"+
		"\u0000\u0000\u0000mn\u0005*\u0000\u0000n \u0001\u0000\u0000\u0000op\u0005"+
		"/\u0000\u0000p\"\u0001\u0000\u0000\u0000qr\u0005%\u0000\u0000r$\u0001"+
		"\u0000\u0000\u0000st\u0005=\u0000\u0000tu\u0005=\u0000\u0000u&\u0001\u0000"+
		"\u0000\u0000vw\u0005!\u0000\u0000wx\u0005=\u0000\u0000x(\u0001\u0000\u0000"+
		"\u0000yz\u0005>\u0000\u0000z*\u0001\u0000\u0000\u0000{|\u0005<\u0000\u0000"+
		"|,\u0001\u0000\u0000\u0000}~\u0005>\u0000\u0000~\u007f\u0005=\u0000\u0000"+
		"\u007f.\u0001\u0000\u0000\u0000\u0080\u0081\u0005<\u0000\u0000\u0081\u0082"+
		"\u0005=\u0000\u0000\u00820\u0001\u0000\u0000\u0000\u0083\u0084\u0005&"+
		"\u0000\u0000\u0084\u0085\u0005&\u0000\u0000\u00852\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005|\u0000\u0000\u0087\u0088\u0005|\u0000\u0000\u00884"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005!\u0000\u0000\u008a6\u0001\u0000"+
		"\u0000\u0000\u008b\u008d\u0007\u0000\u0000\u0000\u008c\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f8\u0001\u0000\u0000"+
		"\u0000\u0090\u0094\u0007\u0001\u0000\u0000\u0091\u0093\u0007\u0002\u0000"+
		"\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095:\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0097\u0099\u0007\u0003\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0006\u001d\u0000\u0000\u009d<\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005/\u0000\u0000\u009f\u00a0\u0005/\u0000\u0000\u00a0\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a3\b\u0004\u0000\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0006\u001e"+
		"\u0000\u0000\u00a8>\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005/\u0000\u0000"+
		"\u00aa\u00ab\u0005*\u0000\u0000\u00ab\u00af\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ae\t\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00b1"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00af"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005*\u0000\u0000\u00b3\u00b4\u0005"+
		"/\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0006\u001f"+
		"\u0000\u0000\u00b6@\u0001\u0000\u0000\u0000\u0006\u0000\u008e\u0094\u009a"+
		"\u00a4\u00af\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}