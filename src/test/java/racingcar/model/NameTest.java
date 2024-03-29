package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.vo.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름의 길이가 5자를 초과하면 예외 처리한다.")
    @Test
    void create_FailWhenLengthOver5() {
        // given
        final String inputName = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5자 이하여야 합니다.");
    }

    @DisplayName("이름의 길이가 5자 이하면 올바르게 생성된다.")
    @Test
    void create_SuccessWhenLengthLess5() {
        // given
        final String inputName = "abcde";

        // when
        final Name name = new Name(inputName);

        // then
        assertThat(name.getValue()).isEqualTo(inputName);
    }

    @DisplayName("이름의 길이가 0이면 예외 처리한다.")
    @Test
    void create_FailWhenLengthIsZero() {
        // given
        final String inputName = "";

        // when & then
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 0이 될 수 없습니다.");
    }

    @DisplayName("이름 앞뒤에 띄어쓰기가 있으면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {" a", "abcd ", " abc ", " "})
    void create_FailWhenSpaceExistAtEdge(final String inputName) {
        // when & then
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 앞뒤에 띄어쓰기가 있을 수 없습니다.");
    }
}
