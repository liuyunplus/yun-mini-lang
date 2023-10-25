package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class UpdateExpression extends Expression {

    private String operator;
    private Boolean prefix;
    private Variable variable;

    public UpdateExpression(Variable variable, String operator, Boolean prefix) {
        this.variable = variable;
        this.operator = operator;
        this.prefix = prefix;
    }

}
