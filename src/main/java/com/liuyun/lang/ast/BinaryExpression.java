package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class BinaryExpression extends Expression {

    private String operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(Expression left, String op, Expression right) {
        this.left = left;
        this.operator = op;
        this.right = right;
    }

}
