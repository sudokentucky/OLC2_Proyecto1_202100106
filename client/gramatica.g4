grammar gramatica;

// -------------------------------------------------------------------
// PARTE 1: REGLAS DE LÉXICO (TOKENS)
// -------------------------------------------------------------------

// Palabras reservadas o tokens literales
VAR       : 'var';
FMT       : 'fmt';
PRINTLN   : 'Println';

// Caracteres de puntuación / símbolos
DOT       : '.';
LPAREN    : '(';
RPAREN    : ')';
SEMICOLON : ';';
COMMA     : ',';
ASSIGN    : '=';

// Operadores aritméticos
PLUS  : '+';
MINUS : '-';
STAR  : '*';
DIV   : '/';

// Literales numéricos sencillos
INT_LIT : [0-9]+ ;

// Identificadores (variables)
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// Ignorar espacios en blanco y saltos de línea
WS
    : [ \t\r\n]+ -> skip
    ;

// Puedes añadir comentarios si lo deseas
// Ejemplo:
// LINE_COMMENT : '//' ~[\r\n]* -> skip;
// BLOCK_COMMENT: '/*' .*? '*/' -> skip;

// -------------------------------------------------------------------
// PARTE 2: REGLAS DE PARSER
// -------------------------------------------------------------------

/*
 * Regla principal: un programa consiste en cero o más declaraciones, seguido de EOF.
 * Podrías requerir al menos una instrucción (dcl+), si gustas.
 */
program
    : dcl* EOF
    ;

/*
 * dcl puede ser una declaración de variable (varDcl) o una sentencia (stmt).
 */
dcl
    : varDcl
    | stmt
    ;

/*
 * varDcl: sintaxis sencilla: var <ident> = <expr> ;
 * Ejemplo: var x = 10;
 */
varDcl
    : VAR IDENTIFIER ASSIGN expr SEMICOLON
    ;

/*
 * stmt: por ahora, puede ser:
 *   - una expresión terminada en punto y coma (expresión suelta)
 *   - una llamada a fmt.Println(...)
 */
stmt
    : expr SEMICOLON                               # ExprStmt
    | FMT DOT PRINTLN LPAREN argumentList? RPAREN SEMICOLON  # FmtPrintStmt
    ;

/*
 * Lista de argumentos para fmt.Println: expr (',' expr)*.
 * Ejemplo: fmt.Println( a, 10, x+5 )
 */
argumentList
    : expr (COMMA expr)*
    ;

/*
 * Reglas de expresión (expr): aritmética muy básica, negación unaria, paréntesis
 * Inspirado en el esbozo original, con op = tokens aritméticos.
 */
expr
    // Ej: -expr
    : MINUS expr                          # Negate

    // Multiplicación / División, con asociatividad de izquierda a derecha
    | expr (STAR | DIV) expr             # MulDiv

    // Adición / Sustracción
    | expr (PLUS | MINUS) expr           # AddSub

    // Un entero
    | INT_LIT                             # Number

    // Un identificador (variable)
    | IDENTIFIER                          # Identifier

    // Expresión entre paréntesis
    | LPAREN expr RPAREN                  # Parens
    ;
