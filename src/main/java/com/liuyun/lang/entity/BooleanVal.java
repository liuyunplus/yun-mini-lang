package com.liuyun.lang.entity;

import lombok.Data;

@Data
public class BooleanVal implements RuntimeVal {

    private Boolean value;

    public BooleanVal(Boolean value) {
        this.value = value;
    }

}
