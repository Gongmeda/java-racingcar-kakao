package carrace.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private final List<Cars> roundCars = new ArrayList<>();

    public RaceResult(Cars cars) {
        roundCars.add(cars);
    }

    public Cars last() {
        return roundCars.get(roundCars.size() - 1);
    }

    public void add(Cars cars) {
        roundCars.add(cars);
    }

    public List<Cars> getRoundCars() {
        return Collections.unmodifiableList(roundCars);
    }

    public List<String> getWinnerNames() {
        return getMaxPositionCars(last())
                .stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getMaxPositionCars(Cars cars) {
        int maxPosition = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList());
    }
}
