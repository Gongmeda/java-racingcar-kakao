package racingcar.model;

import racingcar.model.vo.Position;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String SPLIT_REGEX = ",";
    private static final String INVALID_POSITION_MESSAGE = "1등에 해당하는 위치가 존재하지 않습니다.";

    private final List<Car> values;

    public Cars(final String nameInput) {
        this.values = Arrays.stream(nameInput.split(SPLIT_REGEX))
                .map(Car::makeNewCar)
                .collect(Collectors.toUnmodifiableList());
    }

    public void step(final NumberGenerator numberGenerator) {
        for (final Car car : values) {
            moveOrStandCar(numberGenerator, car);
        }
    }

    private void moveOrStandCar(final NumberGenerator numberGenerator, final Car car) {
        final CarAction carAction = CarAction.generate(numberGenerator.generate());
        if (carAction.isMove()) {
            car.move();
        }
    }

    public Winners getWinners() {
        final Position winnerPosition = findWinnerPosition();
        return new Winners(values.stream()
                .filter(car -> car.isAt(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList()));
    }

    private Position findWinnerPosition() {
        return values.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_POSITION_MESSAGE));
    }

    public List<Car> getValues() {
        return values;
    }
}
