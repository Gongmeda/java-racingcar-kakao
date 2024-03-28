package org.example.racinggame;

import org.example.racinggame.model.Car;
import org.example.racinggame.model.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void 쉼표로_구분된_이름의_목록을_입력받아_자동차를_생성한다() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        assertThat(cars.getCarSize()).isEqualTo(4);
    }

    @Test
    void 자동차들을_생성하고_가장_위치가_큰_차가_승리한다() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        Car car = cars.getCarFromName("pobi1");
        car.forward(5);

        List<String> winners = cars.selectWinners();

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(winners).containsExactly("pobi1");
        assertThat(winners).hasSize(1);
    }

    @Test
    void 우승자는_1명_이상이다() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        Car car = cars.getCarFromName("pobi1");
        car.forward(5);

        Car car2 = cars.getCarFromName("pobi2");
        car2.forward(5);

        List<String> winners = cars.selectWinners();
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(winners).containsExactly("pobi1", "pobi2");
        assertThat(winners).hasSize(2);
    }
}
