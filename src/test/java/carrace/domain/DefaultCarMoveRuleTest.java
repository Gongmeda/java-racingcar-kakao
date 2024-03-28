package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCarMoveRuleTest {

    @DisplayName("숫자값이 4 이상이면 움직이고, 4 미만이면 움직이지 않는다")
    @CsvSource({"0, false", "3, false", "4, true", "9, true"})
    @ParameterizedTest
    void moveIfOver4Inclusive(int value, boolean move) {
        DefaultCarMoveRule carMoveRule = new DefaultCarMoveRule(() -> value);
        boolean result = carMoveRule.isMovable();
        assertThat(result).isEqualTo(move);
    }
}
