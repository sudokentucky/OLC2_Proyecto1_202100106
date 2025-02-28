grammar gramatica;

// -------------------------------------------------------------------
// PARTE 1: TOKENS (LÉXICO)
// -------------------------------------------------------------------

// Palabras clave del lenguaje
VAR       : 'var';
IF        : 'if';
ELSE      : 'else';
FMT       : 'fmt';
PRINTLN   : 'Println';

// Caracteres de puntuación / símbolos
DOT       : '.';
LPAREN    : '(';
RPAREN    : ')';
LBRACE    : '{';
RBRACE    : '}';
SEMICOLON : ';';
COMMA     : ',';
ASSIGN    : '=';

// Operadores aritméticos
PLUS      : '+';
MINUS     : '-';
STAR      : '*';
DIV       : '/';
MOD       : '%'; 

// Operadores relacionales
EQUAL        : '==';
NOT_EQUAL    : '!=';
GREATER      : '>';
LESS         : '<';
GREATER_EQ   : '>=';
LESS_EQ      : '<=';

// Operadores lógicos
AND_LOGIC   : '&&';
OR_LOGIC    : '||';
NOT_LOGIC   : '!';

// Tipos de datos
INT_LIT    : [0-9]+;
IDENTIFIER : [a-zA-Z_] [a-zA-Z0-9_]* ;

// Ignorar espacios en blanco y saltos de línea
WS         : [ \t\r\n]+ -> skip;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;
// -------------------------------------------------------------------
// PARTE 2: REGLAS DEL PARSER
// -------------------------------------------------------------------

program
    : dcl* EOF
    ;

dcl
    : varDcl
    | stmt
    ;

varDcl
    : VAR IDENTIFIER ASSIGN expr SEMICOLON
    ;

stmt
    : expr SEMICOLON                                       # ExprStmt
    | FMT DOT PRINTLN LPAREN argumentList? RPAREN SEMICOLON  # FmtPrintStmt

    ;

block
    : LBRACE stmt* RBRACE
    ;

argumentList
    : expr (COMMA expr)*
    ;

expr
    : logicalOrExpr
    ;

logicalOrExpr
    : logicalAndExpr ( OR_LOGIC logicalAndExpr )*
    ;

logicalAndExpr
    : equalityExpr ( AND_LOGIC equalityExpr )*
    ;

equalityExpr
    : relationalExpr ( (EQUAL | NOT_EQUAL) relationalExpr )*
    ;

relationalExpr
    : addExpr ( (GREATER | LESS | GREATER_EQ | LESS_EQ) addExpr )*
    ;

addExpr
    : mulExpr ( (PLUS | MINUS) mulExpr )*
    ;

mulExpr
    : unaryExpr ( (STAR | DIV | MOD) unaryExpr )*
    ;

unaryExpr
    : MINUS unaryExpr
    | NOT_LOGIC unaryExpr
    | primary
    ;

primary
    : INT_LIT
    | IDENTIFIER
    | LPAREN expr RPAREN
    ;
