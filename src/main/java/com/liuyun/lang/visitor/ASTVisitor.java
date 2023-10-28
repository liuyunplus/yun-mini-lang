package com.liuyun.lang.visitor;

import com.liuyun.lang.ast.AssignmentExpression;
import com.liuyun.lang.ast.BinaryExpression;
import com.liuyun.lang.ast.BlockStatement;
import com.liuyun.lang.ast.CallExpression;
import com.liuyun.lang.ast.Expression;
import com.liuyun.lang.ast.ExpressionStatement;
import com.liuyun.lang.ast.ForStatement;
import com.liuyun.lang.ast.IfStatement;
import com.liuyun.lang.ast.Node;
import com.liuyun.lang.ast.NumberLiteral;
import com.liuyun.lang.ast.Program;
import com.liuyun.lang.ast.Statement;
import com.liuyun.lang.ast.StringLiteral;
import com.liuyun.lang.ast.UpdateExpression;
import com.liuyun.lang.ast.Variable;
import com.liuyun.lang.ast.VariableDeclaration;
import com.liuyun.lang.ast.WhileStatement;
import com.liuyun.lang.entity.BooleanVal;
import com.liuyun.lang.entity.Environment;
import com.liuyun.lang.entity.NativeFuncVal;
import com.liuyun.lang.entity.NullVal;
import com.liuyun.lang.entity.NumberVal;
import com.liuyun.lang.entity.RuntimeVal;
import com.liuyun.lang.entity.StringVal;
import com.liuyun.lang.tools.CommonTools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ASTVisitor {

    public RuntimeVal interpret(Node node, Environment env) {
        if (node == null) {
            return new NullVal();
        }
        if (node instanceof Program) {
            Program program = (Program) node;
            RuntimeVal result = new NullVal();
            for (Statement statement : program.getBody()) {
                result = interpret(statement, env);
            }
            return result;
        }
        if (node instanceof BlockStatement) {
            BlockStatement blockStatement = (BlockStatement) node;
            List<Statement> body = blockStatement.getBody();
            RuntimeVal result = new NullVal();
            for (Statement statement : body) {
                result = interpret(statement, env);
            }
            return result;
        }
        if (node instanceof VariableDeclaration) {
            VariableDeclaration variableDeclaration = (VariableDeclaration) node;
            Variable variable = variableDeclaration.getVariable();
            Expression expression = variableDeclaration.getExpression();
            env.declareVar(variable.getName(), interpret(expression, env));
            return new NullVal();
        }
        // ExpressionStatement
        if (node instanceof ExpressionStatement) {
            ExpressionStatement expressionStatement = (ExpressionStatement) node;
            Expression expression = expressionStatement.getExpression();
            return interpret(expression, env);
        }
        if (node instanceof AssignmentExpression) {
            AssignmentExpression assignmentExpression = (AssignmentExpression) node;
            Variable left = assignmentExpression.getLeft();
            Expression right = assignmentExpression.getRight();
            env.declareVar(left.getName(), interpret(right, env));
            return new NullVal();
        }
        if (node instanceof CallExpression) {
            return interpretCall(node, env);
        }
        if (node instanceof UpdateExpression) {
            return interpretUpdateExpr(node, env);
        }
        // IfStatement
        if (node instanceof IfStatement) {
            return interpretIf(node, env);
        }
        if (node instanceof WhileStatement) {
            return interpretWhile(node, env);
        }
        if (node instanceof ForStatement) {
            return interpretFor(node, env);
        }
        // Expression
        if (node instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) node;
            return interpretExpr(binaryExpression, env);
        }
        if (node instanceof Variable) {
            Variable variable = (Variable) node;
            return env.lookupVar(variable.getName());
        }
        if (node instanceof NumberLiteral) {
            NumberLiteral numberLiteral = (NumberLiteral) node;
            return new NumberVal(numberLiteral.getValue());
        }
        if (node instanceof StringLiteral) {
            StringLiteral stringLiteral = (StringLiteral) node;
            return new StringVal(stringLiteral.getValue());
        }
        return new NullVal();
    }

    public RuntimeVal interpretExpr(BinaryExpression expr, Environment env) {
        RuntimeVal left = interpret(expr.getLeft(), env);
        RuntimeVal right = interpret(expr.getRight(), env);
        String operator = expr.getOperator();
        if (left instanceof NumberVal && right instanceof NumberVal) {
            return interpretNumberExpr((NumberVal) left, (NumberVal) right, operator);
        }
        if (left instanceof BooleanVal && right instanceof BooleanVal) {
            return interpretBoolExpr((BooleanVal) left, (BooleanVal) right, operator);
        }
        throw new RuntimeException("error");
    }


    public RuntimeVal interpretNumberExpr(NumberVal left, NumberVal right, String operator) {
        BigDecimal lhs = left.getValue();
        BigDecimal rhs = right.getValue();
        switch (operator) {
            case "*":
                return new NumberVal(lhs.multiply(rhs));
            case "/":
                return new NumberVal(lhs.divide(rhs, 15, RoundingMode.HALF_UP).stripTrailingZeros());
            case "+":
                return new NumberVal(lhs.add(rhs));
            case "-":
                return new NumberVal(lhs.subtract(rhs));
            case "<":
                return new BooleanVal(lhs.compareTo(rhs) < 0);
            case ">":
                return new BooleanVal(lhs.compareTo(rhs) > 0);
            case "<=":
                return new BooleanVal(lhs.compareTo(rhs) <= 0);
            case ">=":
                return new BooleanVal(lhs.compareTo(rhs) >= 0);
            case "==":
                return new BooleanVal(lhs.compareTo(rhs) == 0);
            case "!=":
                return new BooleanVal(lhs.compareTo(rhs) != 0);
            default:
                throw new RuntimeException("error");
        }
    }


    public RuntimeVal interpretBoolExpr(BooleanVal left, BooleanVal right, String operator) {
        boolean lhs = left.getValue();
        boolean rhs = right.getValue();
        switch (operator) {
            case "&&":
                return new BooleanVal(lhs && rhs);
            case "||":
                return new BooleanVal(lhs || rhs);
            default:
                throw new RuntimeException("error");
        }
    }


    public RuntimeVal interpretUpdateExpr(Node node, Environment env) {
        UpdateExpression updateExpr = (UpdateExpression) node;
        String operator = updateExpr.getOperator();
        Boolean prefix = updateExpr.getPrefix();
        Variable variable = updateExpr.getVariable();
        NumberVal numberVal = (NumberVal) interpret(variable, env);
        switch (operator) {
            case "++":
                return new NumberVal(numberVal.increment(prefix));
            case "--":
                return new NumberVal(numberVal.decrement(prefix));
            default:
                throw new RuntimeException("error");
        }
    }


    public RuntimeVal interpretIf(Node node, Environment env) {
        IfStatement ifStatement = (IfStatement) node;
        if (ifStatement.getAlternate() == null) {
            if (CommonTools.parseBool(interpret(ifStatement.getTest(), env))) {
                interpret(ifStatement.getConsequent(), env);
            }
        } else {
            if (CommonTools.parseBool(interpret(ifStatement.getTest(), env))) {
                interpret(ifStatement.getConsequent(), env);
            } else {
                interpret(ifStatement.getAlternate(), env);
            }
        }
        return new NullVal();
    }

    public RuntimeVal interpretFor(Node node, Environment env) {
        ForStatement forStatement = (ForStatement) node;
        interpret(forStatement.getInit(), env);
        while (CommonTools.parseBool(interpret(forStatement.getTest(), env))) {
            interpret(forStatement.getBody(), env);
            interpret(forStatement.getUpdate(), env);
        }
        return new NullVal();
    }

    public RuntimeVal interpretWhile(Node node, Environment env) {
        WhileStatement whileStatement = (WhileStatement) node;
        while (CommonTools.parseBool(interpret(whileStatement.getTest(), env))) {
            interpret(whileStatement.getBody(), env);
        }
        return new NullVal();
    }

    public RuntimeVal interpretCall(Node node, Environment env) {
        CallExpression callExpr = (CallExpression) node;

        RuntimeVal callee = interpret(callExpr.getCallee(), env);
        List<Expression> arguments = callExpr.getArguments();
        List<RuntimeVal> args = new ArrayList<>();
        if (arguments != null && arguments.size() > 0) {
            args = arguments.stream().map(e -> interpret(e, env)).collect(Collectors.toList());
        }

        if (callee instanceof NativeFuncVal) {
            NativeFuncVal fn = (NativeFuncVal) callee;
            return fn.getCall().apply(args, env);
        }

        throw new RuntimeException("error");
    }

}
