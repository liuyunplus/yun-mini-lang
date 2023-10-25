// Generated from /home/liuyun/Public/MyPro/yun-mini-lang-java/src/main/resources/ExprParser.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExprParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(ExprParserParser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(ExprParserParser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(ExprParserParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(ExprParserParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ExprParserParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ExprParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(ExprParserParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ExprParserParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(ExprParserParser.AssignmentExpressionContext ctx);
}