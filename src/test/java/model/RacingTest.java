package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import infrastructure.RandomNumberGenerator;

public class RacingTest {
    @Test
    @DisplayName("가장 포지션 값이 높은 차가 우승한다.")
    void winTest() {
        Car first = generateTestCar("1등", 3);
        Car second = generateTestCar("2등", 2);
        Car third = generateTestCar("3등", 1);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertTrue(result.getWinnerNames().contains(first.getName()));
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다.")
    void multipleWinnersTest() {
        Car first = generateTestCar("1등", 3);
        Car sameFirst = generateTestCar("같은1등", 3);
        Car third = generateTestCar("3등", 1);

        RacingGame result = new RacingGame(Arrays.asList(first, sameFirst, third));
        assertTrue(result.getWinnerNames().contains(first.getName()));
        assertTrue(result.getWinnerNames().contains(sameFirst.getName()));
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상이면 이동한다.")
    void randomWinnerTest() {
        Car first = new Car("1번");
        Car second = new Car("2번");
        NumberGenerator numberGenerator = new TestNumberGenerator(Arrays.asList(4,1));

        RacingGame result = new RacingGame(Arrays.asList(first, second));
        result.moveCars(numberGenerator);

        Assertions.assertThat(result.getWinnerNames()).contains(first.getName());
        Assertions.assertThat(result.getWinnerNames()).doesNotContain(second.getName());
    }

    private Car generateTestCar(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.run(Car.CAR_MOVE_THRESHOLD);
        }
        return car;
    }
}
