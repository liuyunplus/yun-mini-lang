package com.liuyun.lang.tools;

import com.google.common.io.Resources;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonTools {

    public static boolean parseBool(Object obj) {
        return parseNum(obj) != 0;
    }

    public static double parseNum(Object obj) {
        if (obj instanceof Number) {
            return (double) obj;
        }
        if (obj instanceof Boolean) {
            return (boolean) obj ? 1 : 0;
        }
        if (obj instanceof String) {
            String input = (String) obj;
            return castNum(input);
        }
        throw new RuntimeException("error");
    }

    public static double castNum(String input) {
        String integerRegex = "^-?\\d+$";
        String decimalRegex = "^-?\\d*\\.\\d+$";
        String numberRegex = String.format("(%s|%s)", integerRegex, decimalRegex);
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(input);
        if (numberMatcher.matches()) {
            return Double.parseDouble(input);
        }
        throw new IllegalArgumentException("Invalid input: " + input);
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
