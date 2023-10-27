package com.liuyun.lang.visitor;

import com.liuyun.lang.antlr.YunLangBaseVisitor;
import com.liuyun.lang.antlr.YunLangParser;
import com.liuyun.lang.ast.AssignmentExpression;
import com.liuyun.lang.ast.BinaryExpression;
import com.liuyun.lang.ast.Expression;
import com.liuyun.lang.ast.NumberLiteral;
import com.liuyun.lang.ast.StringLiteral;
import com.liuyun.lang.ast.Variable;
import com.liuyun.lang.tools.CommonTools;

public class ExpressionVisitor extends YunLangBaseVisitor {

    @Override
    public Object visitExpression(YunLangParser.ExpressionContext ctx) {
        if (ctx.conditionalOrExpression() != null) {
            return visit(ctx.conditionalOrExpression());
        }
        return visit(ctx.assignmentExpression());
    }

    @Override
    public Object visitConditionalOrExpression(YunLangParser.ConditionalOrExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.conditionalAndExpression());
        }
        Expression leftValue = (Expression) visit(ctx.conditionalOrExpression());
        Expression rightValue = (Expression) visit(ctx.conditionalAndExpression());
        return new BinaryExpression(leftValue, "||", rightValue);
    }

    @Override
    public Object visitConditionalAndExpression(YunLangParser.ConditionalAndExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.equalityExpression());
        }
        Expression leftValue = (Expression) visit(ctx.conditionalAndExpression());
        Expression rightValue = (Expression) visit(ctx.equalityExpression());
        return new BinaryExpression(leftValue, "&&", rightValue);
    }

    @Override
    public Object visitEqualityExpression(YunLangParser.EqualityExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.relationalExpression());
        }
        Expression leftValue = (Expression) visit(ctx.equalityExpression());
        Expression rightValue = (Expression) visit(ctx.relationalExpression());
        String operator = ctx.getChild(1).getText();
        return new BinaryExpression(leftValue, operator, rightValue);
    }

    @Override
    public Object visitRelationalExpression(YunLangParser.RelationalExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.additiveExpression());
        }
        Expression leftValue = (Expression) visit(ctx.relationalExpression());
        Expression rightValue = (Expression) visit(ctx.additiveExpression());
        String operator = ctx.getChild(1).getText();
        return new BinaryExpression(leftValue, operator, rightValue);
    }

    @Override
    public Object visitAdditiveExpression(YunLangParser.AdditiveExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.multiplicativeExpression());
        }
        Expression leftValue = (Expression) visit(ctx.additiveExpression());
        Expression rightValue = (Expression) visit(ctx.multiplicativeExpression());
        String operator = ctx.getChild(1).getText();
        return new BinaryExpression(leftValue, operator, rightValue);
    }

    @Override
    public Object visitMultiplicativeExpression(YunLangParser.MultiplicativeExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.primary());
        }
        Expression leftValue = (Expression) visit(ctx.multiplicativeExpression());
        Expression rightValue = (Expression) visit(ctx.primary());
        String operator = ctx.getChild(1).getText();
        return new BinaryExpression(leftValue, operator, rightValue);
    }

    @Override
    public Object visitPrimary(YunLangParser.PrimaryContext ctx) {
        if (ctx.literal() != null) {
            return visit(ctx.literal());
        }
        if (ctx.callExpression() != null) {
            return visit(ctx.callExpression());
        }
        return visit(ctx.expression());
    }

    @Override
    public Object visitLiteral(YunLangParser.LiteralContext ctx) {
        if (ctx.ID() != null) {
            return new Variable(ctx.ID().getText());
        }
        if (ctx.NUMBER() != null) {
            return new NumberLiteral(CommonTools.parseNum(ctx.NUMBER().getText()));
        }
        if (ctx.STRING() != null) {
            return new StringLiteral(ctx.STRING().getText());
        }
        throw new RuntimeException("error");
    }

    @Override
    public Object visitAssignmentExpression(YunLangParser.AssignmentExpressionContext ctx) {
        Variable left = new Variable(ctx.ID().getText());
        Expression right = (Expression) visit(ctx.expression());
        return new AssignmentExpression(left, right);
    }

}
