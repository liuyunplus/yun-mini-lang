// Generated from /home/liuyun/Public/MyPro/yun-mini-lang/src/main/resources/ExprParser.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParserParser}.
 */
public interface ExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprParserParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprParserParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(ExprParserParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(ExprParserParser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(ExprParserParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(ExprParserParser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ExprParserParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ExprParserParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(ExprParserParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(ExprParserParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ExprParserParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ExprParserParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(ExprParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(ExprParserParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ExprParserParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ExprParserParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExprParserParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExprParserParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(ExprParserParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParserParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(ExprParserParser.AssignmentExpressionContext ctx);
}