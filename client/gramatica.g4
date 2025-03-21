grammar gramatica;

VAR                     : 'var';
FMT                     : 'fmt';
PRINTLN                 : 'Println';
IF                      : 'if';
ELSE                    : 'else';
FOR                     : 'for';
RANGE                   : 'range';
SWITCH                  : 'switch';
NIL                     : 'nil' ;
CASE                    : 'case';
DEFAULT                 : 'default';
BREAK                   : 'break';
CONTINUE                : 'continue';
RETURN                  : 'return';
LEN                     : 'len';
APPEND                  : 'append';
SLICES                  : 'slices';
STRINGS                 : 'strings';
JOIN                    : 'Join';
INDEX                   : 'Index';
STRUCT                  : 'struct';
FUNC                    : 'func';
STRCONV                 : 'strconv';
ATOI                    : 'Atoi';
PARSERFLOAT             : 'ParseFloat';
REFLECT                 : 'reflect';
TYPEOF                  : 'TypeOf';

INT_TYPE                 : 'int';
FLOAT64_TYPE             : 'float64';
STRING_TYPE              : 'string';
BOOL_TYPE                : 'bool';
RUNE_TYPE                : 'rune';

PUNTO                    : '.';
PARENTESIS_IZQ           : '(';
PARENTESIS_DER           : ')';
LLAVE_IZQ                : '{';
LLAVE_DER                : '}';
CORCHETE_IZQ             : '[';
CORCHETE_DER             : ']';
PUNTO_Y_COMA             : ';';
COMA                     : ',';
DOS_PUNTOS               : ':';

ASIGNACION               : '=';
ASIGNACION_DECLARACION   : ':=';
ASIGNACIO_INCREMENTO     : '+=';
ASIGNACIO_DECREMENTO     : '-=';
INCREMENTO               : '++';
DECREMENTO               : '--';

PLUS                     : '+';
MINUS                    : '-';
STAR                     : '*';
DIV                      : '/';
MOD                      : '%';

IGUAL                    : '==';
DIFERENTE                : '!=';
MAYOR_QUE                : '>';
MENOR_QUE                : '<';
MAYOR_IGUAL_QUE          : '>=';
MENOR_IGUAL_QUE          : '<=';

AND                      : '&&';
OR                       : '||';
NOT                      : '!';

INT_LIT                  : [0-9]+;
FLOAT_LIT                : [0-9]+ '.' [0-9]* ;
STRING_LIT               : '"' ( ~["\\] | '\\' . )* '"';
RUNE_LIT                 : '\'' ( ~['\\] | '\\' . ) '\'';
IDENTIFIER               : [a-zA-Z_] [a-zA-Z0-9_]* ;

ESPACIO_BLANCO           : [ \t\r\n]+ -> skip ;
COMENTARIO_LINE          : '//' ~[\r\n]* -> skip ;
COMENTARIO_MULTILINEA    : '/*' .*? '*/' -> skip ;


program
    : (structDecl | funcDecl |instruction)* EOF
    ;

instruction
    : declaracion            
    | assignacion            
    | exprStmt               
    | printStmt
    | ifStmt
    | switchStmt
    | forStmt
    | incDecStmt
    | returnStmt
    | continueStmt
    | breakStmt
    ;

conversionFunc
    :STRCONV PUNTO ATOI PARENTESIS_IZQ expresion PARENTESIS_DER
    |STRCONV PUNTO PARSERFLOAT PARENTESIS_IZQ expresion PARENTESIS_DER
    |REFLECT PUNTO TYPEOF PARENTESIS_IZQ expresion PARENTESIS_DER
    ;

funcDecl
    : FUNC IDENTIFIER PARENTESIS_IZQ paramsList? PARENTESIS_DER typeSpec? bloque
    | FUNC PARENTESIS_IZQ IDENTIFIER IDENTIFIER PARENTESIS_DER IDENTIFIER PARENTESIS_IZQ paramsList? PARENTESIS_DER typeSpec? bloque
    ;

paramsList
    : param (COMA param)*
    ;

param
    : IDENTIFIER typeSpec
    ;

structDecl
    : STRUCT IDENTIFIER LLAVE_IZQ (fieldDecl)+ LLAVE_DER PUNTO_Y_COMA?  
    ;

fieldDecl
    : typeSpec IDENTIFIER PUNTO_Y_COMA  
    ;

structLiteral
    : LLAVE_IZQ fieldValue (COMA fieldValue)* COMA? LLAVE_DER
    ;

fieldValue
    : IDENTIFIER DOS_PUNTOS expresion
    ;
 
bloque
    : LLAVE_IZQ instruction* LLAVE_DER
    ;

breakStmt
    : BREAK PUNTO_Y_COMA?
    ;

continueStmt
    : CONTINUE PUNTO_Y_COMA?
    ;

returnStmt
    : RETURN expresion? PUNTO_Y_COMA?
    ;

incDecStmt
    : IDENTIFIER (INCREMENTO | DECREMENTO) PUNTO_Y_COMA?
    ;

forRangeStmt
    : FOR IDENTIFIER (COMA IDENTIFIER)? ASIGNACION_DECLARACION RANGE expresion bloque
    ;

forStmt
    : forWhileStmt
    | forThreePartStmt
    | forRangeStmt
    ;

forWhileStmt
    : FOR expresion bloque
    ;

forThreePartStmt
    : FOR forInit? PUNTO_Y_COMA expresion? PUNTO_Y_COMA forPost? bloque
    ;

forInit
    : assignacion
    | declaracion
    ;

forPost
    : assignacion
    | exprStmt
    | incDecStmt
    ;

switchStmt
    : SWITCH (PARENTESIS_IZQ expresion PARENTESIS_DER | expresion) LLAVE_IZQ (caseStmt)* (defaultStmt)? LLAVE_DER
    ;

caseStmt
    : CASE expresion DOS_PUNTOS instruction*
    ;

defaultStmt
    : DEFAULT DOS_PUNTOS instruction*
    ;

ifStmt
    : IF (PARENTESIS_IZQ? expresion PARENTESIS_DER?) bloque (elseIfStmt)* (elseStmt)?
    ;

elseIfStmt
    : ELSE IF (PARENTESIS_IZQ? expresion PARENTESIS_DER?) bloque
    ;

elseStmt
    : ELSE bloque
    ;

declaracion
    : VAR IDENTIFIER typeSpec? (ASIGNACION expresion)? PUNTO_Y_COMA?
    | IDENTIFIER IDENTIFIER ASIGNACION structLiteral PUNTO_Y_COMA?
    | VAR IDENTIFIER ASIGNACION FUNC PARENTESIS_IZQ paramsList? PARENTESIS_DER typeSpec? bloque PUNTO_Y_COMA?
    | IDENTIFIER ASIGNACION_DECLARACION expresion PUNTO_Y_COMA?  //declaracion de Slice
    ;

    
assignacion
    : (IDENTIFIER (CORCHETE_IZQ expresion CORCHETE_DER)* (PUNTO IDENTIFIER)*)
      (ASIGNACION | ASIGNACIO_INCREMENTO | ASIGNACIO_DECREMENTO)
      expresion
      PUNTO_Y_COMA?
    ;


exprStmt
    : expresion PUNTO_Y_COMA?
    ;

printStmt
    : FMT PUNTO PRINTLN PARENTESIS_IZQ argumentList? PARENTESIS_DER PUNTO_Y_COMA?
    ;

argumentList
    : expresion (COMA expresion)*
    ;

expresionOrSliceLiteral
    : expresion
    | sliceLiteral
    ;

expresion: logicalOrExpr;

logicalOrExpr
    : logicalAndExpr ( OR logicalAndExpr )*
    ;

logicalAndExpr
    : equalityExpr ( AND equalityExpr )*
    ;

equalityExpr
    : relationalExpr ( (IGUAL | DIFERENTE) relationalExpr )*
    ;

relationalExpr
    : addExpr ( (MAYOR_QUE | MENOR_QUE | MAYOR_IGUAL_QUE | MENOR_IGUAL_QUE) addExpr )*
    ;

addExpr
    : mulExpr ( (PLUS | MINUS) mulExpr )*
    ;

mulExpr
    : unaryExpr ( (STAR | DIV | MOD) unaryExpr )*
    ;

unaryExpr
    : MINUS unaryExpr
    | NOT unaryExpr
    | primary 
    | sliceFunc
    | conversionFunc
    ;

sliceFunc
    : LEN PARENTESIS_IZQ expresion PARENTESIS_DER
    | APPEND PARENTESIS_IZQ expresion (COMA expresion)* PARENTESIS_DER
    | SLICES PUNTO INDEX PARENTESIS_IZQ expresion COMA expresion PARENTESIS_DER
    | STRINGS PUNTO JOIN PARENTESIS_IZQ expresion COMA expresion PARENTESIS_DER
    ;

sliceType
    : CORCHETE_IZQ CORCHETE_DER typeSpec
    ;

typeSpec
    : INT_TYPE
    | FLOAT64_TYPE
    | STRING_TYPE
    | BOOL_TYPE
    | RUNE_TYPE
    | IDENTIFIER
    | sliceType
    ;

sliceLiteral
    : sliceType LLAVE_IZQ (expresionOrSliceLiteral (COMA expresionOrSliceLiteral)* COMA?)? LLAVE_DER
    | LLAVE_IZQ (expresionOrSliceLiteral (COMA expresionOrSliceLiteral)* COMA?)? LLAVE_DER
    ;


primary
    : functCall
    | IDENTIFIER (CORCHETE_IZQ expresion CORCHETE_DER)* (PUNTO IDENTIFIER)*  
    | INT_LIT
    | FLOAT_LIT
    | STRING_LIT
    | RUNE_LIT
    | NIL
    | PARENTESIS_IZQ expresion PARENTESIS_DER  
    | sliceLiteral
    ;


functCall
    : IDENTIFIER PARENTESIS_IZQ argumentList? PARENTESIS_DER
    | IDENTIFIER (PUNTO IDENTIFIER)+ PARENTESIS_IZQ argumentList? PARENTESIS_DER
    ;