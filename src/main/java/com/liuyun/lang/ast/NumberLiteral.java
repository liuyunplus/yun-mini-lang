package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class NumberLiteral extends Literal {

    private double value;

    public NumberLiteral(double value) {
        this.value = value;
    }

}
