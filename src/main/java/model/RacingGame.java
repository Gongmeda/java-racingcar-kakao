package model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.run(numberGenerator.generate()));
    }

    public List<Car> getRacingCars() {
        return this.cars;
    }

    public List<String> getWinnerNames() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);

        return cars.stream()
            .filter(car -> car.hasSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
