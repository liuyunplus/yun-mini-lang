package com.liuyun.lang.ast;

public class AssignmentExpression extends Expression {

    private Variable left;
    private Expression right;

    public AssignmentExpression(Variable left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Variable getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

}
