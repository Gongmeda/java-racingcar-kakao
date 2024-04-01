package carrace.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = cars;
    }

    private void validateDuplicateNames(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }


    public Cars moveAll(CarMoveRule carMoveRule) {
        List<Car> newCars = new ArrayList<>();

        for (Car car : cars) {
            newCars.add(moveCar(carMoveRule, car));
        }

        return new Cars(newCars);
    }

    private Car moveCar(CarMoveRule carMoveRule, Car car) {
        if (carMoveRule.isMovable()) {
            return car.moveForward();
        }
        return car;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars getMaxPositionCars() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
        return new Cars(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList()));
    }
}
