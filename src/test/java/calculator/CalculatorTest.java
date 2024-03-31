package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 합을 계산한다.")
    void defaultSeparatorTest() {
        String input = "1,2:3,4:5,6";

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("사용자 지정 구분자를 사용할 수 있다.")
    void customSeparatorTest() {
        String input = "//;\n1;2;3;4;5;6";

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("사용자 지정 구분자를 추가할 수 있다.")
    void defaultAndCustomSeparatorTest() {
        String input = "//;\n1;2:3;4,5;6";

        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("한 자리 숫자를 입력할 경우 해당 숫자를 반환한다.")
    void numberInputTest() {
        String input = "1";

        assertThat(calculator.calculate(input)).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void blankInputTest(String input) {
        assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("음수를 전달하는 경우 예외를 발생한다.")
    void invalidNumberInputTest() {
        String input = "//;\n-1;2:3;4,5;6";

        assertThrows(RuntimeException.class,
                () -> calculator.calculate(input));
    }

    @Test
    @DisplayName("숫자 이외의 문자를 전달하는 경우 예외를 발생한다.")
    void invalidInputTest() {
        String input = "//;\nab;cd;ef";

        assertThrows(RuntimeException.class,
                () -> calculator.calculate(input));
    }
}
