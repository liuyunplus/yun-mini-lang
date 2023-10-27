package com.liuyun.lang.entity;

import lombok.Data;

@Data
public class StringVal implements RuntimeVal {

    private String value;

    public StringVal(String value) {
        this.value = value;
    }

}
