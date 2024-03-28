package carrace.domain;

import java.util.ArrayList;
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
        return roundCars;
    }

    public List<String> getWinnerNames() {
        return last()
                .getMaxPositionCars()
                .getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
