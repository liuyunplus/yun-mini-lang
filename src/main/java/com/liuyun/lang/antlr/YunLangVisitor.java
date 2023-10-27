// Generated from /home/liuyun/Public/MyPro/yun-mini-lang/src/main/resources/YunLang.g4 by ANTLR 4.12.0

package com.liuyun.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YunLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YunLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YunLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(YunLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(YunLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(YunLangParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(YunLangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(YunLangParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(YunLangParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#argsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsList(YunLangParser.ArgsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(YunLangParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(YunLangParser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(YunLangParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(YunLangParser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(YunLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(YunLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(YunLangParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(YunLangParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(YunLangParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(YunLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(YunLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(YunLangParser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(YunLangParser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(YunLangParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(YunLangParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(YunLangParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(YunLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(YunLangParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(YunLangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link YunLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(YunLangParser.AssignmentExpressionContext ctx);
}