package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class ForStatement extends Statement {

    private ExpressionStatement init;
    private Expression test;
    private ExpressionStatement update;
    private Statement body;

    public ForStatement(ExpressionStatement init, Expression test, ExpressionStatement update, Statement body) {
        this.init = init;
        this.test = test;
        this.update = update;
        this.body = body;
    }

}
