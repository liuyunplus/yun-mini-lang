package com.liuyun.lang.entity;

import java.util.List;

public interface FunctionCall {

    RuntimeVal apply(List<RuntimeVal> call, Environment env);

}
