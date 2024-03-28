package carrace.domain;

import carrace.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        Car pobi = new Car("pobi");
        Car dino = new Car("dino");
        Car chris = new Car("chris");
        cars = new Cars(List.of(pobi, dino, chris));
    }

    @DisplayName("경주를 3번 실행하면 4번의 경주 결과를 반환한다")
    @Test
    void race() {
        CarRace carRace = new CarRace(() -> true, cars);

        RaceResult raceResult = carRace.race(new Round(3));

        assertThat(raceResult.getRoundCars().size()).isEqualTo(4);
    }
}
