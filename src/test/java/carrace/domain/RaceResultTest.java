package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RaceResultTest {

    @DisplayName("위치가 가장 큰 자동차가 하나일 때, 그 이름을 반환한다")
    @Test
    void getWinnerNames_single() {
        Car pobi = new Car("pobi");
        Car dino = new Car("dino");
        Car chris = new Car("chris");

        Car newPobi = pobi.moveForward().moveForward().moveForward();
        Car newDino = dino.moveForward().moveForward();
        Cars cars = new Cars(List.of(newPobi, newDino, chris));

        Cars newCars = cars.moveAll(() -> false);
        RaceResult raceResult = new RaceResult(newCars);

        List<String> winnerNames = raceResult.getWinnerNames();

        assertSoftly(softly -> {
            softly.assertThat(winnerNames).contains("pobi");
            softly.assertThat(winnerNames.size()).isEqualTo(1);
        });
    }

    @DisplayName("위치가 가장 큰 자동차가 하나일 때, 그 이름 리스트를 반환한다")
    @Test
    void getMaxPositionCars_multiple() {
        Car pobi = new Car("pobi");
        Car dino = new Car("dino");
        Car chris = new Car("chris");

        Car newPobi = pobi.moveForward().moveForward();
        Car newDino = dino.moveForward().moveForward();
        Cars cars = new Cars(List.of(newPobi, newDino, chris));

        Cars newCars = cars.moveAll(() -> false);
        RaceResult raceResult = new RaceResult(newCars);

        List<String> winnerNames = raceResult.getWinnerNames();

        assertSoftly(softly -> {
            softly.assertThat(winnerNames).contains("pobi");
            softly.assertThat(winnerNames).contains("dino");
            softly.assertThat(winnerNames.size()).isEqualTo(2);
        });
    }
}