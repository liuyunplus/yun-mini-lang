package com.liuyun.lang.ast;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NumberLiteral extends Literal {

    public BigDecimal value;

    public NumberLiteral(BigDecimal value) {
        this.value = value;
    }

}
