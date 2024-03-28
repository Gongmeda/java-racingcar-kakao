package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("초기 위치는 1이다")
    @Test
    void initialPosition1() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("호출한 횟수만큼 앞으로 움직인다")
    @ValueSource(ints = {1, 3, 5, 11})
    @ParameterizedTest
    void moveForward(int moveCount) {
        Car car = new Car("pobi");
        for (int i = 0; i < moveCount; i++) {
            car = car.moveForward();
        }
        assertThat(car.getPosition()).isEqualTo(1 + moveCount);
    }

    @DisplayName("자동차 이름을 반환한다")
    @Test
    void name() {
        Car car = new Car("pobi");
        String carName = car.getName();
        assertThat(carName).isEqualTo("pobi");
    }
}