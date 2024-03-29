package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.vo.Position;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PositionTest {

    @DisplayName("위치가 음수면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10})
    void create_FailWhenNegative(final int input) {
        // when & then
        assertThatThrownBy(() -> new Position(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }

    @DisplayName("위치가 0 이상의 정수이면 올바르게 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 1000})
    void create_SuccessWhenCorrectNum(final int input) {
        // when & then
        assertDoesNotThrow(() -> new Position(input));
    }
}
