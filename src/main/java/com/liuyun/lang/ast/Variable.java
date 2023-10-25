package com.liuyun.lang.ast;

import lombok.Data;

@Data
public class Variable extends Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

}
