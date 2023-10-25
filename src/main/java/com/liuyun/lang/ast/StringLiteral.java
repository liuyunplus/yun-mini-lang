package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class StringLiteral extends Literal {

    private String value;

    public StringLiteral(String value) {
        value = value.replaceAll("\"", "");
        this.value = value;
    }

}
