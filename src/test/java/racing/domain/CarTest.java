package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.infra.RandomNumberGenerator;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 차는_4미만일때_움직이지_않는다(int condition) {
        Car car = new Car("sage", () -> condition);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 차는_4이상일때_움직인다(int condition) {
        Car car = new Car("sage", () -> condition);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
