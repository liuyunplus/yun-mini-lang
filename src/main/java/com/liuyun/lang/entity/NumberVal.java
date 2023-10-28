package com.liuyun.lang.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NumberVal implements RuntimeVal {

    public BigDecimal value;

    public NumberVal(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal increment(Boolean prefix) {
        return prefix ? preIncrement(): postIncrement();
    }

    public BigDecimal decrement(Boolean prefix) {
        return prefix ? preDecrement(): postDecrement();
    }

    public BigDecimal preIncrement() {
        this.value = this.value.add(BigDecimal.ONE);
        BigDecimal result = this.value;
        return result;
    }

    public BigDecimal preDecrement() {
        this.value = this.value.subtract(BigDecimal.ONE);
        BigDecimal result = this.value;
        return result;
    }

    public BigDecimal postIncrement() {
        BigDecimal result = this.value;
        this.value = this.value.add(BigDecimal.ONE);
        return result;
    }

    public BigDecimal postDecrement() {
        BigDecimal result = this.value;
        this.value = this.value.subtract(BigDecimal.ONE);
        return result;
    }

}
