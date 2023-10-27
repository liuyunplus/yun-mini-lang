package com.liuyun.lang.entity;

import com.liuyun.lang.ast.BlockStatement;
import java.util.List;
import lombok.Data;

@Data
public class UserFuncVal implements RuntimeVal {

    private String name;
    private List<String> parameters;
    private Environment declarationEnv;
    private BlockStatement body;

}
