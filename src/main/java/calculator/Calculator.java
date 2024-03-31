package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            String customSeparator = DEFAULT_SEPARATOR + "|" + matcher.group(1);
            return add(matcher.group(2).split(customSeparator));
        }
        return add(input.split(DEFAULT_SEPARATOR));
    }

    private int add(String[] numbers) {
        List<Integer> parsedNumbers = Arrays.stream(numbers)
            .map(this::parseToInt).collect(Collectors.toList());
        parsedNumbers.forEach(this::validatePositive);
        return parsedNumbers.stream().reduce(0, Integer::sum);
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만을 입력해야 합니다.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new RuntimeException("0 이상의 숫자를 입력해야 합니다.");
        }
    }
}
