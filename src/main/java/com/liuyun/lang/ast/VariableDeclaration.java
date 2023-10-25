package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class VariableDeclaration extends Declaration {

    private Variable variable;
    private Expression expression;

    public VariableDeclaration(Variable variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

}
