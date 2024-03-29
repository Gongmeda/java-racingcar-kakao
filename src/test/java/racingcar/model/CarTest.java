package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차의 위치를 한 칸 전진할 수 있다.")
    @Test
    void moveTest() {
        // given
        final Car car = Car.makeNewCar("lucas");
        final Position expected = new Position(1);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
