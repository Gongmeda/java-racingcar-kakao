package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racing.infra.RandomNumberGenerator;

public class RaceTest {

    private static NumberGenerator zeroGenerator;
    private static NumberGenerator nineGenerator;

    @BeforeAll
    static void beforeAll() {
        zeroGenerator = () -> 0;
        nineGenerator = () -> 9;
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void 유일한_승자(int round) {
        Race race = new Race(List.of(
            new Car("sage", nineGenerator),
            new Car("vec", zeroGenerator),
            new Car("amber", zeroGenerator)
        ));

        for (int i = 0; i < round; ++i) {
            race.nextRound();
        }

        assertThat(race.getWinnersName()).containsExactly("sage");
    }

    @Test
    void 공동승리_0라운드() {
        Race race = new Race(List.of(
            new Car("sage", nineGenerator),
            new Car("vec", zeroGenerator),
            new Car("amber", zeroGenerator)
        ));

        assertThat(race.getWinnersName())
            .containsExactlyInAnyOrder("sage", "vec", "amber");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void 공동승리_1라운드_이상(int round) {
        Race race = new Race(List.of(
            new Car("sage", nineGenerator),
            new Car("vec", nineGenerator),
            new Car("amber", zeroGenerator)
        ));

        for (int i = 0; i < round; ++i) {
            race.nextRound();
        }

        assertThat(race.getWinnersName())
            .containsExactlyInAnyOrder("sage", "vec");
    }
}
