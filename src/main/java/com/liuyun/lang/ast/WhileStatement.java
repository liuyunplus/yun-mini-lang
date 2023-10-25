package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class WhileStatement extends Statement {

    private Expression test;
    private BlockStatement body;

    public WhileStatement(Expression test, BlockStatement body) {
        this.test = test;
        this.body = body;
    }

}
