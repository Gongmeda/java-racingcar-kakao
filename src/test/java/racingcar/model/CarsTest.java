package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.Name;
import racingcar.model.vo.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    @DisplayName("하나의 문자열을 받아 콤마(,)로 구분된 수 만큼 자동차를 생성한다.")
    @Test
    void create_SuccessTest() {
        // given
        final Cars cars = new Cars("lucas,dino,eve,helen");

        // when & then
        assertThat(cars.getValues()).hasSize(4);
    }

    @DisplayName("자동차들에 대해 한 번의 스탭을 진행할 수 있다.")
    @Test
    void stepTest() {
        // given
        final Cars cars = new Cars("lucas,dino,eve,helen");
        final Position zreoPosition = new Position(0);
        final Position onePosition = new Position(1);

        // when
        cars.step(new CustomNumberGenerator(List.of(9, 4, 2, 0)));
        final List<Car> carsValues = cars.getValues();

        // then
        assertAll(
                () -> assertThat(carsValues.get(0).getPosition()).isEqualTo(onePosition),
                () -> assertThat(carsValues.get(1).getPosition()).isEqualTo(onePosition),
                () -> assertThat(carsValues.get(2).getPosition()).isEqualTo(zreoPosition),
                () -> assertThat(carsValues.get(3).getPosition()).isEqualTo(zreoPosition)
        );
    }

    @DisplayName("자동차들에 대해 한 번의 스탭을 진행할 수 있다.")
    @Test
    void winnersTest() {
        // given
        final Cars cars = new Cars("lucas,dino,eve,helen");
        final Winners expectedWinners = new Winners(
                List.of(
                        new Name("lucas"),
                        new Name("dino")
                )
        );

        // when
        cars.step(new CustomNumberGenerator(List.of(9, 4, 2, 0)));

        // then
        assertThat(cars.getWinners()).usingRecursiveComparison().isEqualTo(expectedWinners);
    }
}
