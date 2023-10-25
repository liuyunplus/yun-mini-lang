package com.liuyun.lang.visitor;

import com.liuyun.lang.antlr.YunLangParser;
import com.liuyun.lang.ast.Program;
import com.liuyun.lang.ast.BlockStatement;
import com.liuyun.lang.ast.BreakStatement;
import com.liuyun.lang.ast.CallExpression;
import com.liuyun.lang.ast.ContinueStatement;
import com.liuyun.lang.ast.Expression;
import com.liuyun.lang.ast.ExpressionStatement;
import com.liuyun.lang.ast.ForStatement;
import com.liuyun.lang.ast.IfStatement;
import com.liuyun.lang.ast.ReturnStatement;
import com.liuyun.lang.ast.Statement;
import com.liuyun.lang.ast.UpdateExpression;
import com.liuyun.lang.ast.Variable;
import com.liuyun.lang.ast.VariableDeclaration;
import com.liuyun.lang.ast.WhileStatement;
import java.util.ArrayList;
import java.util.List;

public class ParseTreeVisitor extends ExpressionVisitor {

    @Override
    public Object visitProgram(YunLangParser.ProgramContext ctx) {
        List<Statement> statements = new ArrayList();
        for (YunLangParser.StatementContext tree : ctx.statement()) {
            Statement statement = (Statement) visit(tree);
            statements.add(statement);
        }
        return new Program(statements);
    }

    @Override
    public Object visitStatement(YunLangParser.StatementContext ctx) {
        if (ctx.blockStatement() != null) {
            return visit(ctx.blockStatement());
        }
        if (ctx.variableDeclaration() != null) {
            return visit(ctx.variableDeclaration());
        }
        if (ctx.expressionStatement() != null) {
            return visit(ctx.expressionStatement());
        }
        if (ctx.ifStatement() != null) {
            return visit(ctx.ifStatement());
        }
        if (ctx.whileStatement() != null) {
            return visit(ctx.whileStatement());
        }
        if (ctx.forStatement() != null) {
            return visit(ctx.forStatement());
        }
        if (ctx.breakStatement() != null) {
            return visit(ctx.breakStatement());
        }
        if (ctx.continueStatement() != null) {
            return visit(ctx.continueStatement());
        }
        if (ctx.returnStatement() != null) {
            return visit(ctx.returnStatement());
        }
        throw new RuntimeException("error");
    }

    @Override
    public Object visitBlockStatement(YunLangParser.BlockStatementContext ctx) {
        List<Statement> statements = new ArrayList();
        for (YunLangParser.StatementContext tree : ctx.statement()) {
            Statement statement = (Statement) visit(tree);
            statements.add(statement);
        }
        return new BlockStatement(statements);
    }

    @Override
    public Object visitVariableDeclaration(YunLangParser.VariableDeclarationContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        Expression expression = (Expression) visit(ctx.expression());
        return new VariableDeclaration(variable, expression);
    }

    @Override
    public Object visitExpressionStatement(YunLangParser.ExpressionStatementContext ctx) {
        if (ctx.assignmentExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.assignmentExpression()));
        }
        if (ctx.callExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.callExpression()));
        }
        if (ctx.preIncrementExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.preIncrementExpression()));
        }
        if (ctx.preDecrementExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.preDecrementExpression()));
        }
        if (ctx.postIncrementExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.postIncrementExpression()));
        }
        if (ctx.postDecrementExpression() != null) {
            return new ExpressionStatement((Expression) visit(ctx.postDecrementExpression()));
        }
        return new RuntimeException("error");
    }

    @Override
    public Object visitCallExpression(YunLangParser.CallExpressionContext ctx) {
        Variable callee = new Variable(ctx.ID().getText());
        List<Expression> arguments = null;
        if (ctx.argsList() != null) {
            arguments = (List<Expression>) visit(ctx.argsList());
        }
        return new CallExpression(callee, arguments);
    }

    @Override
    public Object visitArgsList(YunLangParser.ArgsListContext ctx) {
        List<Expression> arguments = new ArrayList();
        for (YunLangParser.ExpressionContext tree : ctx.expression()) {
            Expression expression = (Expression) visit(tree);
            arguments.add(expression);
        }
        return arguments;
    }

    @Override
    public Object visitPreIncrementExpression(YunLangParser.PreIncrementExpressionContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        return new UpdateExpression(variable, "++", true);
    }

    @Override
    public Object visitPreDecrementExpression(YunLangParser.PreDecrementExpressionContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        return new UpdateExpression(variable, "--", true);
    }

    @Override
    public Object visitPostIncrementExpression(YunLangParser.PostIncrementExpressionContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        return new UpdateExpression(variable, "++", false);
    }

    @Override
    public Object visitPostDecrementExpression(YunLangParser.PostDecrementExpressionContext ctx) {
        Variable variable = new Variable(ctx.ID().getText());
        return new UpdateExpression(variable, "--", false);
    }

    @Override
    public Object visitIfStatement(YunLangParser.IfStatementContext ctx) {
        Expression test = (Expression) visit(ctx.expression());
        BlockStatement consequent = (BlockStatement) visit(ctx.statement().get(0));
        BlockStatement alternate = null;
        if (ctx.statement().size() > 1) {
            alternate = (BlockStatement) visit(ctx.statement().get(1));
        }
        return new IfStatement(test, consequent, alternate);
    }

    @Override
    public Object visitWhileStatement(YunLangParser.WhileStatementContext ctx) {
        Expression test = (Expression) visit(ctx.expression());
        BlockStatement body = (BlockStatement) visit(ctx.statement());
        return new WhileStatement(test, body);
    }

    @Override
    public Object visitForStatement(YunLangParser.ForStatementContext ctx) {
        ExpressionStatement init = (ExpressionStatement) visit(ctx.expressionStatement().get(0));
        Expression test = (Expression) visit(ctx.expression());
        ExpressionStatement update = (ExpressionStatement) visit(ctx.expressionStatement().get(1));
        Statement body = (Statement) visit(ctx.statement());
        return new ForStatement(init, test, update, body);
    }

    @Override
    public Object visitBreakStatement(YunLangParser.BreakStatementContext ctx) {
        return new BreakStatement();
    }

    @Override
    public Object visitContinueStatement(YunLangParser.ContinueStatementContext ctx) {
        return new ContinueStatement();
    }

    @Override
    public Object visitReturnStatement(YunLangParser.ReturnStatementContext ctx) {
        Expression expression = null;
        if (ctx.expression() != null) {
            expression = (Expression) visit(ctx.expression());
        }
        return new ReturnStatement(expression);
    }

}
