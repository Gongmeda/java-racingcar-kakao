package stringcalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int EMPTY_INPUT_RETURN_VALUE = 0;

    public static int calculate(String input) {
        if (isNullOrBlank(input)) {
            return EMPTY_INPUT_RETURN_VALUE;
        }

        List<Integer> numbers = NumberStringParser.parse(input);

        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty();
    }
}
