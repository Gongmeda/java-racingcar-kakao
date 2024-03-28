package org.example.calculator;

import static org.assertj.core.api.Assertions.*;

import org.example.calculator.model.CalculatorStringUtils;
import org.junit.jupiter.api.Test;

public class CalculatorStringUtilsTest {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
	private static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";

	@Test
	void 사용자가_임의로_구분자를_변경할_수_있다() {
		String string = "//;\n1;2";
		String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CUSTOM_DELIMITER_REGEX, DEFAULT_DELIMITER);
		assertThat(delimiter).isEqualTo(";");
	}

	@Test
	void 구분자를_설정하지_않으면_쉼표_또는_콜론으로_구분한다() {
		String string = "1;2";
		String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CUSTOM_DELIMITER_REGEX, DEFAULT_DELIMITER);
		assertThat(delimiter).isEqualTo(",|:");
	}

	@Test
	void 역슬래쉬_n뒤에_숫자_리스트를_받는다() {
		String string = "//;\n1;2";
		String operands = CalculatorStringUtils.extractOperandStringWithRegex(string, CUSTOM_OPERANDS_REGEX);
		assertThat(operands).isEqualTo("1;2");
	}

	@Test
	void 구분자를_설정하지_않으면_숫자_리스트만_받는다() {
		String string = "1,2,3";
		String operands = CalculatorStringUtils.extractOperandStringWithRegex(string, CUSTOM_OPERANDS_REGEX);
		assertThat(operands).isEqualTo("1,2,3");
	}

}
