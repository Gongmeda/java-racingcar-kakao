package carrace.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final NumberGenerator numberGenerator;
    private int position = 0;

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    public Car(String name, NumberGenerator numberGenerator) {
        validateCarNameLength(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int moveForward() {
        if (numberGenerator.isMovable()) {
            return ++position;
        }
        return position;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차의 이름은 %d이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }
}
