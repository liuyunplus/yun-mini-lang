package com.liuyun.lang.entity;

import lombok.Data;

@Data
public class NumberVal implements RuntimeVal {

    public double value;

    public NumberVal(double value) {
        this.value = value;
    }

}
