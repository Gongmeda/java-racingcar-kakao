package model;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    public static final int CAR_MOVE_THRESHOLD = 4;

    private int position;
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void run(int decider) {
        if (decider >= CAR_MOVE_THRESHOLD) {
            position += 1;
        }
    }

    public boolean hasSamePosition(int position) {
        return this.position == position;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
