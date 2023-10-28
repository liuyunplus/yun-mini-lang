package com.liuyun.lang.tools;

import com.google.common.io.Resources;
import com.liuyun.lang.entity.BooleanVal;
import com.liuyun.lang.entity.RuntimeVal;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonTools {

    public static boolean parseBool(RuntimeVal val) {
        if (val instanceof BooleanVal) {
            BooleanVal booleanVal = (BooleanVal) val;
            return booleanVal.getValue();
        }
        throw new RuntimeException("error");
    }

    public static BigDecimal parseNum(String input) {
        if (isInteger(input)) {
            return BigDecimal.valueOf(Long.parseLong(input));
        }
        if (isDouble(input)) {
            return BigDecimal.valueOf(Double.parseDouble(input));
        }
        throw new IllegalArgumentException("Invalid input: " + input);
    }

    public static boolean isInteger(String input) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isDouble(String input) {
        Pattern pattern = Pattern.compile("^-?\\d*\\.\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String readFileToString(String filePath) {
        try {
            if (filePath.startsWith("classpath:")) {
                String resourceName = filePath.replace("classpath:", "");
                return Resources.toString(Resources.getResource(resourceName), StandardCharsets.UTF_8);
            }
            return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("read file error.");
        }
    }

}
