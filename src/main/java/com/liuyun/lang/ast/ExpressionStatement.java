package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class ExpressionStatement extends Statement{

    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

}
