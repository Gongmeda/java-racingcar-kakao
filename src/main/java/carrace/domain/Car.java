package carrace.domain;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 1;
    private static final int MOVE_AMOUNT = 1;

    private final String name;
    private final int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
        validateName();
    }

    private void validateName() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하여야 합니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 아니여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car moveForward() {
        return new Car(name, position + MOVE_AMOUNT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
