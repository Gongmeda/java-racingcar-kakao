package org.example.calculator;

import org.example.calculator.model.Calculator;
import org.example.calculator.model.CalculatorStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 빈_문자면_0을_반환한다() {
        Calculator calculator = new Calculator("");
        int result = calculator.calculate();
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2-3", "1,2,3-6", "1,2:3-6"}, delimiter = '-')
    void 쉼표_콜론으로_문자열을_자르고_더한다(String input, String expect) {
        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(Integer.parseInt(expect));
    }

    @Test
    void 숫자중에_음수가_있으면_에러가_발생한다() {
        Calculator calculator = new Calculator("-1,2,3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_임의로_구분자를_변경할_수_있다() {
        Calculator calculator = new Calculator("//'\n1'2'3");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }
}
