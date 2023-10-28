package com.liuyun.lang.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Environment {

    private Environment parent;
    private Map<String, RuntimeVal> variables;
    private Set<String> constants;

    public Environment() {
        this(null);
    }

    public Environment(Environment parent) {
        this.parent = parent;
        this.variables = new HashMap<>();
        this.constants = new HashSet<>();
    }

    public RuntimeVal declareVar(String name, RuntimeVal value) {
//        if (this.variables.containsKey(name)) {
//            throw new RuntimeException(String.format("Cannot declare variable '%s'. As it already is defined.", name));
//        }
        this.variables.put(name, value);
        return value;
    }

    public RuntimeVal lookupVar(String name) {
        Environment env = resolve(name);
        return env.variables.get(name);
    }

    public Environment resolve(String name) {
        if (this.variables.containsKey(name)) {
            return this;
        }
        if (this.parent == null) {
            throw new RuntimeException(String.format("Cannot resolve '%s' as it does not exist.", name));
        }
        return this.parent.resolve(name);
    }

    public static Environment createGlobal() {
        Environment env = new Environment();
        env.declareVar("time", new NativeFuncVal(nowTimeFunc));
        env.declareVar("print", new NativeFuncVal(printFunc));
        return env;
    }

    public static FunctionCall nowTimeFunc = (List<RuntimeVal> args, Environment env) -> {
        long nowTime = System.currentTimeMillis();
        return new NumberVal(BigDecimal.valueOf(nowTime));
    };

    public static FunctionCall printFunc = (List<RuntimeVal> args, Environment env) -> {
        List<Object> items = new ArrayList();
        for (RuntimeVal arg : args) {
            if (arg instanceof NumberVal) {
                NumberVal val = (NumberVal) arg;
                BigDecimal num = val.getValue();
                items.add(num.toPlainString());
            }
            if (arg instanceof BooleanVal) {
                BooleanVal val = (BooleanVal) arg;
                items.add(val.getValue());
            }
            if (arg instanceof StringVal) {
                StringVal val = (StringVal) arg;
                items.add(val.getValue());
            }
        }
        print(items.toArray());
        return new NullVal();
    };


    public static void print(Object... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
