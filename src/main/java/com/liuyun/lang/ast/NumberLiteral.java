package com.liuyun.lang.ast;

import com.liuyun.lang.tools.CommonTools;
import lombok.Data;

@Data
public class NumberLiteral extends Literal {

    private double value;

    public NumberLiteral(Object obj) {
        this.value = CommonTools.parseNum(obj);
    }

}
