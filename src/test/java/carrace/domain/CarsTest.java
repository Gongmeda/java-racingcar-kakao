package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    @DisplayName("중복된 이름의 자동차를 추가하면 예외가 발생한다")
    @Test
    void validateDuplicateNames() {
        List<Car> carList = List.of(new Car("pobi"), new Car("dino"), new Car("pobi"));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new Cars(carList)
        );
    }

    @DisplayName("CarMoveRule이 참을 반환하면 모든 자동차가 움직인다")
    @Test
    void moveAll_true() {
        List<Car> carList = List.of(new Car("pobi"), new Car("dino"), new Car("chris"));
        Cars cars = new Cars(carList);

        Cars newCars = cars.moveAll(() -> true);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(newCars.getCars().get(i).getPosition()).isEqualTo(cars.getCars().get(i).getPosition() + 1);
        }
    }

    @DisplayName("CarMoveRule이 거짓을 반환하면 모든 자동차가 움직이지 않는다")
    @Test
    void moveAll_false() {
        List<Car> carList = List.of(new Car("pobi"), new Car("dino"), new Car("chris"));
        Cars cars = new Cars(carList);

        Cars newCars = cars.moveAll(() -> false);

        for (int i = 0; i < carList.size(); i++) {
            assertThat(newCars.getCars().get(i).getPosition()).isEqualTo(cars.getCars().get(i).getPosition());
        }
    }
}