package com.liuyun.lang.entity;

import lombok.Data;

@Data
public class NativeFuncVal implements RuntimeVal {

    private FunctionCall call;

    public NativeFuncVal(FunctionCall call) {
        this.call = call;
    }

}
