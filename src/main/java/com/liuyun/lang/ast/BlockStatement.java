package com.liuyun.lang.ast;

import java.util.List;
import lombok.Data;

@Data
public class BlockStatement extends Statement {

    private List<Statement> body;

    public BlockStatement(List<Statement> body) {
        this.body = body;
    }

    public List<Statement> getBody() {
        return body;
    }
}
