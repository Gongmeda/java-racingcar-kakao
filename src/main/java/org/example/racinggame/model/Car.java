package org.example.racinggame.model;

public class Car {

    private static final int FORWARD_THRESHOLD = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void forward(int number) {
        if (number >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isCarNameIs(String targetName) {
        return this.name.equals(targetName);
    }
}
