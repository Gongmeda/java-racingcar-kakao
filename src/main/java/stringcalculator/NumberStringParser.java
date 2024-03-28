package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberStringParser {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static List<Integer> parse(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            return split(m.group(1), m.group(2));
        }

        return split("[,;]", text);
    }

    private static List<Integer> split(String delimiter, String text) {
        String[] numStrings = text.split(delimiter);
        return Arrays.stream(numStrings)
                .map(NumberStringParser::parsePositiveInteger)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int parsePositiveInteger(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new RuntimeException();
        }
        return value;
    }
}
