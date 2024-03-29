package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.StepCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StepCountTest {

    @DisplayName("음수이면 예외 처리 한다.")
    @Test
    void create_FailWhenNegative() {
        // when & then
        assertThatThrownBy(() -> new StepCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 음수일 수 없습니다.");
    }

    @DisplayName("시도 횟수가 0이면 true를 반환한다.")
    @Test
    void isEndTest() {
        // given
        final StepCount beforeCount = new StepCount(1);

        // when
        final StepCount afterCount = beforeCount.decrease();

        // then
        assertThat(afterCount.isZero()).isTrue();
    }
}
