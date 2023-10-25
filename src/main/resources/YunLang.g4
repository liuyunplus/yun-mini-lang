grammar YunLang;

@header {
package com.liuyun.lang.antlr;
}

import ExprParser;

program: statement* ;

statement
    : blockStatement
    | variableDeclaration
    | expressionStatement
    | ifStatement
    | whileStatement
    | forStatement
    | breakStatement
    | continueStatement
    | returnStatement
    ;

blockStatement: '{' statement+ '}' ;
variableDeclaration: ID ('=' expression)? ;
expressionStatement
    : assignmentExpression
    | callExpression
    | preIncrementExpression
	| preDecrementExpression
	| postIncrementExpression
	| postDecrementExpression
    ;

callExpression: ID'(' argsList? ')' ;
argsList: expression (',' expression)* ;
preIncrementExpression: '++' ID ;
preDecrementExpression:	'--' ID ;
postIncrementExpression: ID '++' ;
postDecrementExpression: ID '--' ;

ifStatement: 'if' '(' expression ')' statement ('else' statement)?;
whileStatement: 'while' '(' expression ')' statement ;
forStatement: 'for' '(' expressionStatement? ';' expression? ';' expressionStatement? ')' statement ;

breakStatement:	'break' ;
continueStatement: 'continue' ;
returnStatement: 'return' expression? ;




