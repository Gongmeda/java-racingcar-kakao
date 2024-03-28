package org.example.racinggame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(String inputString) {
        this.carList = Arrays.stream(inputString.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getCarSize() {
        return carList.size();
    }

    public Car getCarFromName(String carName) {
        return carList.stream()
                .filter(car -> car.isCarNameIs(carName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 차량이 없습니다."));
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void move() {
        carList.forEach(car ->
                car.forward(RandomIntegerGenerator.generateEndInclusive(0, 9))
        );
    }

    public List<Car> getCarList() {
        return carList;
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }
}
