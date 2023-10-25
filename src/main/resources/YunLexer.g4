grammar YunLexer;

//STRING: SSTRING | DSTRING ;
//SSTRING: '\'' (ESC | ~['\\] | '"')* '\'' ;
STRING: '"' (ESC | ~['\\"] | '\'')* '"' ;

NUMBER: INTEGER | FLOAT ;
INTEGER: ('0' | [1-9] [0-9]*) ;
FLOAT: DIGIT+ '.' DIGIT* | '.' DIGIT+;

ID: (LETTER | DIGIT | '_' | '-' | '.')+ ;
WS: [ \t\r\n]+ -> skip ;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment ESC: '\\' . ;