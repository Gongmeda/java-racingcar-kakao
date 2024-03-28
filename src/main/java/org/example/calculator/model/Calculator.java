package org.example.calculator.model;

import java.util.Arrays;
import java.util.function.Function;

public class Calculator {

    private final String string;

    public Calculator(String string) {
        this.string = string;
    }

    public int calculate() {
        String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CalculatorStringUtils.CUSTOM_DELIMITER_REGEX, CalculatorStringUtils.DEFAULT_DELIMITER);
        String operandString = CalculatorStringUtils.extractOperandStringWithRegex(string, CalculatorStringUtils.CUSTOM_OPERANDS_REGEX);
        String[] operands = operandString.split(delimiter);

        return sumStringOperands(operands);
    }

    private int sumStringOperands(String[] operands) {
        return Arrays.stream(operands)
                .filter(operand -> !operand.isBlank())
                .map(Integer::parseInt)
                .peek(this::validateNonNegativeInteger)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Function<String, String> emptyStringToZero() {
        return s -> s.isBlank() ? "0" : s;
    }

    private void validateNonNegativeInteger(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException("negatives not allowed: " + integer);
        }
    }
}
