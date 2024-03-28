package org.example.calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringUtils {

    public static final int FIRST_GROUP_OF_REGEX = 1;
    static final String DEFAULT_DELIMITER = ",|:";
    static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";

    private CalculatorStringUtils() {

    }

    public static String extractDelimiterWithRegex(String string, String regex, String defaultDelimiter) {
        Matcher matcher = Pattern.compile(regex).matcher(string);
        if (matcher.find()) {
            return matcher.group(FIRST_GROUP_OF_REGEX);
        }
        return defaultDelimiter;
    }

    public static String extractOperandStringWithRegex(String string, String regex) {
        Matcher m = Pattern.compile(regex).matcher(string);
        if (m.find()) {
            return m.group(FIRST_GROUP_OF_REGEX);
        }
        return string;
    }
}
