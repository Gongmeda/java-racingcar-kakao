package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RoundTest {

    @DisplayName("음수로 초기화시 예외가 발생한다")
    @Test
    void validatePositive() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Round(-1)
        );
    }
}