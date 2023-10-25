package com.liuyun.lang.ast;

import java.util.List;
import lombok.Data;

@Data
public class CallExpression extends Expression {

    private Variable callee;
    private List<Expression> arguments;

    public CallExpression(Variable callee, List<Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }

}
