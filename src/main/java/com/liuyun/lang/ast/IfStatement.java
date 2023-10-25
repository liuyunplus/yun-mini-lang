package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class IfStatement extends Statement {

    private Expression test;
    private BlockStatement consequent;
    private BlockStatement alternate;

    public IfStatement(Expression test, BlockStatement consequent, BlockStatement alternate) {
        this.test = test;
        this.consequent = consequent;
        this.alternate = alternate;
    }

}
