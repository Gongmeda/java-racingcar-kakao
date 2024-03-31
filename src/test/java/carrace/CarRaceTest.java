package carrace;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import carrace.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarRaceTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {

        Car car1 = new Car("car1", () -> true);
        Car car2 = new Car("car2", () -> true);
        Car car3 = new Car("car3", () -> true);
        cars = new ArrayList<Car>(Arrays.asList(car1, car2, car3));
    }

    @Test
    @DisplayName("getCars 메소드는 자동차 리스트를 반환한다.")
    void getCars() {
        CarRace carRace = new CarRace(cars, 5);

        List<Car> result = carRace.getCars();

        assertThat(result).containsAll(cars);
    }

    @Test
    @DisplayName("라운드가 진행되면 각 자동차에 대해 moveForward()가 호출된다.")
    void runRound() {
        CarRace carRace = new CarRace(cars, 5);

        carRace.runRound();

        assertThat(carRace.getCars()).extracting(Car::getPosition).containsOnly(1);
    }

    @Test
    @DisplayName("가장 위치가 높은 자동차가 하나일 경우 그 자동차가 우승자가 된다.")
    void getWinningCars_singleWinner() {
        Car winnerCar = cars.get(0);
        CarRace carRace = createCarRaceWithSingleWinner(winnerCar);

        List<Car> winningCars = carRace.getWinningCars();

        assertSoftly(softly -> {
            softly.assertThat(winningCars).contains(winnerCar);
            softly.assertThat(winningCars.size()).isEqualTo(1);
        });
    }

    private CarRace createCarRaceWithSingleWinner(Car winnerCar) {
        winnerCar.moveForward();
        winnerCar.moveForward();
        return new CarRace(cars, 5);
    }

    @Test
    @DisplayName("가장 위치가 높은 자동차가 여러개일 경우 이에 해당하는 자동차 모두가 우승자이다.")
    void getWinningCars_multipleWinner() {
        Car winnerCar1 = cars.get(0);
        Car winnerCar2 = cars.get(1);
        CarRace carRace = createCarRaceWithTwoWinners(winnerCar1, winnerCar2);

        List<Car> winningCars = carRace.getWinningCars();

        assertSoftly(softly -> {
            softly.assertThat(winningCars).containsAll(List.of(winnerCar1, winnerCar2));
            softly.assertThat(winningCars.size()).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("자동차 경주에 참여하는 자동차의 이름은 중복되면 안된다.")
    void validateDuplicateNames() {
        Car car4 = new Car("car3", () -> true);
        cars.add(car4);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CarRace(cars, 5));
    }

    private CarRace createCarRaceWithTwoWinners(Car winnerCar1, Car winnerCar2) {
        winnerCar1.moveForward();
        winnerCar1.moveForward();
        winnerCar2.moveForward();
        winnerCar2.moveForward();
        return new CarRace(cars, 5);
    }
}
