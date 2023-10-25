package com.liuyun.lang.visitor;

import com.liuyun.lang.ast.ExpressionStatement;
import com.liuyun.lang.ast.Literal;
import com.liuyun.lang.ast.NumberLiteral;
import com.liuyun.lang.ast.Program;
import com.liuyun.lang.ast.AssignmentExpression;
import com.liuyun.lang.ast.BinaryExpression;
import com.liuyun.lang.ast.BlockStatement;
import com.liuyun.lang.ast.CallExpression;
import com.liuyun.lang.ast.Expression;
import com.liuyun.lang.ast.ForStatement;
import com.liuyun.lang.ast.IfStatement;
import com.liuyun.lang.ast.Node;
import com.liuyun.lang.ast.Statement;
import com.liuyun.lang.ast.StringLiteral;
import com.liuyun.lang.ast.UpdateExpression;
import com.liuyun.lang.ast.Variable;
import com.liuyun.lang.ast.VariableDeclaration;
import com.liuyun.lang.ast.WhileStatement;
import com.liuyun.lang.tools.CommonTools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTVisitor {

    private Map<String, Object> globals = new HashMap();

    public Object interpret(Node node) {
        if (node == null) {
            return 0;
        }
        if (node instanceof Program) {
            Program program = (Program) node;
            for (Statement statement : program.getBody()) {
                interpret(statement);
            }
            return 1;
        }
        if (node instanceof BlockStatement) {
            BlockStatement blockStatement = (BlockStatement) node;
            List<Statement> body = blockStatement.getBody();
            for (Statement statement : body) {
                interpret(statement);
            }
            return 1;
        }
        if (node instanceof VariableDeclaration) {
            VariableDeclaration variableDeclaration = (VariableDeclaration) node;
            Variable variable = variableDeclaration.getVariable();
            Expression expression = variableDeclaration.getExpression();
            globals.put(variable.getName(), interpret(expression));
            return 1;
        }
        // ExpressionStatement
        if (node instanceof ExpressionStatement) {
            ExpressionStatement expressionStatement = (ExpressionStatement) node;
            Expression expression = expressionStatement.getExpression();
            return interpret(expression);
        }
        if (node instanceof AssignmentExpression) {
            AssignmentExpression assignmentExpression = (AssignmentExpression) node;
            Variable left = assignmentExpression.getLeft();
            Expression right = assignmentExpression.getRight();
            globals.put(left.getName(), interpret(right));
            return 1;
        }
        if (node instanceof CallExpression) {
            CallExpression callExpression = (CallExpression) node;
            return interpretCall(callExpression);
        }
        if (node instanceof UpdateExpression) {
            UpdateExpression updateExpression = (UpdateExpression) node;
            String operator = updateExpression.getOperator();
            Variable variable = updateExpression.getVariable();
            Boolean prefix = updateExpression.getPrefix();
            double var = CommonTools.parseNum(interpret(variable));
            switch (operator) {
                case "++": return prefix ? ++var : var++;
                case "--": return prefix ? --var : var--;
                default: throw new RuntimeException("error");
            }
        }
        // IfStatement
        if (node instanceof IfStatement) {
            IfStatement ifStatement = (IfStatement) node;
            return interpretIf(ifStatement);
        }
        if (node instanceof WhileStatement) {
            WhileStatement whileStatement = (WhileStatement) node;
            return interpretWhile(whileStatement);
        }
        if (node instanceof ForStatement) {
            ForStatement forStatement = (ForStatement) node;
            return interpretFor(forStatement);
        }
        // Expression
        if (node instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) node;
            return interpretExpr(binaryExpression);
        }
        if (node instanceof Variable) {
            Variable variable = (Variable) node;
            return globals.get(variable.getName());
        }
        if (node instanceof NumberLiteral) {
            NumberLiteral numberLiteral = (NumberLiteral) node;
            return numberLiteral.getValue();
        }
        if (node instanceof StringLiteral) {
            StringLiteral stringLiteral = (StringLiteral) node;
            return stringLiteral.getValue();
        }
        return 1;
    }

    public double interpretExpr(BinaryExpression expr) {
        double left = CommonTools.parseNum(interpret(expr.getLeft()));
        double right = CommonTools.parseNum(interpret(expr.getRight()));
        String operator = expr.getOperator();
        switch (operator) {
            case "*":
                return left * right;
            case "/":
                return left / right;
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "<":
                return left < right ? 1 : 0;
            case ">":
                return left > right ? 1 : 0;
            case "<=":
                return left <= right ? 1 : 0;
            case ">=":
                return left >= right ? 1 : 0;
            case "==":
                return left == right ? 1 : 0;
            case "!=":
                return left != right ? 1 : 0;
            case "&&":
                return (left != 0 && right != 0) ? 1 : 0;
            case "||":
                return (left != 0 || right != 0) ? 1 : 0;
        }
        return left + right;
    }

    public double interpretIf(IfStatement ifStatement) {
        if (ifStatement.getAlternate() == null) {
            if (CommonTools.parseBool(interpret(ifStatement.getTest()))) {
                interpret(ifStatement.getConsequent());
            }
        } else {
            if (CommonTools.parseBool(interpret(ifStatement.getTest()))) {
                interpret(ifStatement.getConsequent());
            } else {
                interpret(ifStatement.getAlternate());
            }
        }
        return 1;
    }

    public double interpretFor(ForStatement forStatement) {
        interpret(forStatement.getInit());
        while (CommonTools.parseBool(interpret(forStatement.getTest()))) {
            interpret(forStatement.getBody());
            interpret(forStatement.getUpdate());
        }
        return 1;
    }

    public double interpretWhile(WhileStatement whileStatement) {
        while (CommonTools.parseBool(interpret(whileStatement.getTest()))) {
            interpret(whileStatement.getBody());
        }
        return 1;
    }

    public Object interpretCall(CallExpression callExpression) {
        Variable callee = callExpression.getCallee();
        List<Expression> arguments = callExpression.getArguments();
        List<Object> args = new ArrayList();
        for (Expression argument : arguments) {
            args.add(interpret(argument));
        }
        String functionName = callee.getName();
        if ("print".equals(functionName)) {
            print(args);
            return 1;
        }
        throw new RuntimeException("error");
    }

    public void print(List<Object> args) {
        String text = args.get(0) + "";
        System.out.println(text);
    }

}
