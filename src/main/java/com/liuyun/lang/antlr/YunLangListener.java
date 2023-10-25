// Generated from /home/liuyun/Public/MyPro/yun-mini-lang-java/src/main/resources/YunLang.g4 by ANTLR 4.12.0

package com.liuyun.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YunLangParser}.
 */
public interface YunLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YunLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(YunLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(YunLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(YunLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(YunLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(YunLangParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(YunLangParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(YunLangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(YunLangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(YunLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(YunLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(YunLangParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(YunLangParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#argsList}.
	 * @param ctx the parse tree
	 */
	void enterArgsList(YunLangParser.ArgsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#argsList}.
	 * @param ctx the parse tree
	 */
	void exitArgsList(YunLangParser.ArgsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(YunLangParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(YunLangParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(YunLangParser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(YunLangParser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(YunLangParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(YunLangParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(YunLangParser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(YunLangParser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(YunLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(YunLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(YunLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(YunLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(YunLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(YunLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(YunLangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(YunLangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(YunLangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(YunLangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(YunLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(YunLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(YunLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(YunLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(YunLangParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(YunLangParser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(YunLangParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(YunLangParser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(YunLangParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(YunLangParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(YunLangParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(YunLangParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(YunLangParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(YunLangParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(YunLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(YunLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(YunLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(YunLangParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(YunLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(YunLangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link YunLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(YunLangParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YunLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(YunLangParser.AssignmentExpressionContext ctx);
}