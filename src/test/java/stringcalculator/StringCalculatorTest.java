package stringcalculator;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	@Test
	void 빈_문자열_입력시_0_반환() {
		int returnValue = StringCalculator.calculate("");
		assertThat(returnValue).isEqualTo(0);
	}

	@Test
	void 널_입력시_0_반환() {
		int returnValue = StringCalculator.calculate(null);
		assertThat(returnValue).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource({"1, 1", "2, 2", "5, 5"})
	void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환(String input, int result) {
		int returnValue = StringCalculator.calculate(input);
		assertThat(returnValue).isEqualTo(result);
	}

	@Test
	void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환() {
		int returnValue = StringCalculator.calculate("1,2");
		assertThat(returnValue).isEqualTo(3);
	}

	@Test
	void 구분자를_컴마_이외의_세미콜론을_사용할_수_있다() {
		int returnValue = StringCalculator.calculate("1,2;3");
		assertThat(returnValue).isEqualTo(6);
	}

	@Test
	void 커스텀_구분자를_지정할_수_있다() {
		int returnValue = StringCalculator.calculate("//:\n1:2:3");
		assertThat(returnValue).isEqualTo(6);
	}

	@Test
	void 음수를_전달할_경우_RuntimeException이_발생() {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> StringCalculator.calculate("-1,2,3")
		);
	}
}
