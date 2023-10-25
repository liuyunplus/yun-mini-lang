package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class ReturnStatement extends Statement {

    private Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

}
