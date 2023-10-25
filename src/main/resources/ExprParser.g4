grammar ExprParser;

import YunLexer;

expression
    : conditionalOrExpression
	| assignmentExpression
	;

conditionalOrExpression
	: conditionalAndExpression
	| conditionalOrExpression '||' conditionalAndExpression
	;

conditionalAndExpression
	: equalityExpression
	| conditionalAndExpression '&&' equalityExpression
	;

equalityExpression
	: relationalExpression
	| equalityExpression '==' relationalExpression
	| equalityExpression '!=' relationalExpression
	;

relationalExpression
	: additiveExpression
	| relationalExpression '<' additiveExpression
	| relationalExpression '>' additiveExpression
	| relationalExpression '<=' additiveExpression
	| relationalExpression '>=' additiveExpression
	;

additiveExpression
	: multiplicativeExpression
	| additiveExpression '+' multiplicativeExpression
	| additiveExpression '-' multiplicativeExpression
	;

multiplicativeExpression
	: primary
	| multiplicativeExpression '*' primary
	| multiplicativeExpression '/' primary
	;

primary: literal | '(' expression ')' ;
literal: ID | STRING | NUMBER ;
assignmentExpression: ID '=' expression;