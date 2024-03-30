package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 널_또는_0값인_경우_0_반환(String input) {
        int sum = Calculator.calculate(input);

        assertThat(sum).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4;10", "1;1", "2:3,4;9"}, delimiter = ';')
    void 기본_구분자_로_구분된_경우(String input, int expected) {
        int sum = Calculator.calculate(input);

        assertThat(sum).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3,4:5", "//-\n1-2-3,4-5"})
    void 커스텀문자로_구분된_경우(String input) {
        int sum = Calculator.calculate(input);

        assertThat(sum).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n-1;2", "//;\naa-1;2"})
    void 유효하지않은_입력() {
        assertThatThrownBy(() -> Calculator.calculate("//;\n-1;2"))
                .isInstanceOf(RuntimeException.class);
    }
}
