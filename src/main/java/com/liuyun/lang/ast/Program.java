package com.liuyun.lang.ast;

import java.util.List;
import lombok.Data;

@Data
public class Program extends Node {

    private List<Statement> body;

    public Program(List<Statement> body) {
        this.body = body;
    }

}
