package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import racing.infra.RandomNumberGenerator;

public class CarFactoryTest {
    @Test
    void 유효한_이름들() {

        CarFactory factory = new CarFactory(new RandomNumberGenerator());
        List<Car> cars = factory.fromCsvNames("vec,amber,sage");

        List<String> names = cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        assertThat(names).containsExactlyInAnyOrder("vec", "amber", "sage");
    }
}
