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

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.2")]
[System.CLSCompliant(false)]
public partial class gramaticaLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		VAR=1, FMT=2, PRINTLN=3, DOT=4, LPAREN=5, RPAREN=6, SEMICOLON=7, COMMA=8, 
		ASSIGN=9, PLUS=10, MINUS=11, STAR=12, DIV=13, INT_LIT=14, IDENTIFIER=15, 
		WS=16;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"VAR", "FMT", "PRINTLN", "DOT", "LPAREN", "RPAREN", "SEMICOLON", "COMMA", 
		"ASSIGN", "PLUS", "MINUS", "STAR", "DIV", "INT_LIT", "IDENTIFIER", "WS"
	};


	public gramaticaLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public gramaticaLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, "'var'", "'fmt'", "'Println'", "'.'", "'('", "')'", "';'", "','", 
		"'='", "'+'", "'-'", "'*'", "'/'"
	};
	private static readonly string[] _SymbolicNames = {
		null, "VAR", "FMT", "PRINTLN", "DOT", "LPAREN", "RPAREN", "SEMICOLON", 
		"COMMA", "ASSIGN", "PLUS", "MINUS", "STAR", "DIV", "INT_LIT", "IDENTIFIER", 
		"WS"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "gramatica.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override int[] SerializedAtn { get { return _serializedATN; } }

	static gramaticaLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static int[] _serializedATN = {
		4,0,16,88,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,
		2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,
		14,2,15,7,15,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,1,2,1,2,1,
		2,1,2,1,3,1,3,1,4,1,4,1,5,1,5,1,6,1,6,1,7,1,7,1,8,1,8,1,9,1,9,1,10,1,10,
		1,11,1,11,1,12,1,12,1,13,4,13,71,8,13,11,13,12,13,72,1,14,1,14,5,14,77,
		8,14,10,14,12,14,80,9,14,1,15,4,15,83,8,15,11,15,12,15,84,1,15,1,15,0,
		0,16,1,1,3,2,5,3,7,4,9,5,11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,13,27,
		14,29,15,31,16,1,0,4,1,0,48,57,3,0,65,90,95,95,97,122,4,0,48,57,65,90,
		95,95,97,122,3,0,9,10,13,13,32,32,90,0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,
		0,0,7,1,0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,0,15,1,0,0,0,0,17,
		1,0,0,0,0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,0,25,1,0,0,0,0,27,1,0,0,
		0,0,29,1,0,0,0,0,31,1,0,0,0,1,33,1,0,0,0,3,37,1,0,0,0,5,41,1,0,0,0,7,49,
		1,0,0,0,9,51,1,0,0,0,11,53,1,0,0,0,13,55,1,0,0,0,15,57,1,0,0,0,17,59,1,
		0,0,0,19,61,1,0,0,0,21,63,1,0,0,0,23,65,1,0,0,0,25,67,1,0,0,0,27,70,1,
		0,0,0,29,74,1,0,0,0,31,82,1,0,0,0,33,34,5,118,0,0,34,35,5,97,0,0,35,36,
		5,114,0,0,36,2,1,0,0,0,37,38,5,102,0,0,38,39,5,109,0,0,39,40,5,116,0,0,
		40,4,1,0,0,0,41,42,5,80,0,0,42,43,5,114,0,0,43,44,5,105,0,0,44,45,5,110,
		0,0,45,46,5,116,0,0,46,47,5,108,0,0,47,48,5,110,0,0,48,6,1,0,0,0,49,50,
		5,46,0,0,50,8,1,0,0,0,51,52,5,40,0,0,52,10,1,0,0,0,53,54,5,41,0,0,54,12,
		1,0,0,0,55,56,5,59,0,0,56,14,1,0,0,0,57,58,5,44,0,0,58,16,1,0,0,0,59,60,
		5,61,0,0,60,18,1,0,0,0,61,62,5,43,0,0,62,20,1,0,0,0,63,64,5,45,0,0,64,
		22,1,0,0,0,65,66,5,42,0,0,66,24,1,0,0,0,67,68,5,47,0,0,68,26,1,0,0,0,69,
		71,7,0,0,0,70,69,1,0,0,0,71,72,1,0,0,0,72,70,1,0,0,0,72,73,1,0,0,0,73,
		28,1,0,0,0,74,78,7,1,0,0,75,77,7,2,0,0,76,75,1,0,0,0,77,80,1,0,0,0,78,
		76,1,0,0,0,78,79,1,0,0,0,79,30,1,0,0,0,80,78,1,0,0,0,81,83,7,3,0,0,82,
		81,1,0,0,0,83,84,1,0,0,0,84,82,1,0,0,0,84,85,1,0,0,0,85,86,1,0,0,0,86,
		87,6,15,0,0,87,32,1,0,0,0,4,0,72,78,84,1,6,0,0
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}
