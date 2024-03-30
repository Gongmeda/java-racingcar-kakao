package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"amber", "vec", "sage"})
    void 차_이름_5글자_이하면_성공(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"vector", "sixOver"})
    void 차_이름_6글자_이상이면_실패(String name) {
        assertThatThrownBy(() -> new CarName(name))
            .isInstanceOf(RuntimeException.class);
    }
}
