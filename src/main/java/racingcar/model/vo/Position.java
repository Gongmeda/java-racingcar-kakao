package racingcar.model.vo;

import java.util.Objects;

public class Position implements Comparable<Position>{

    private static final int ZERO = 0;
    private static final String POSITION_UNDER_ZERO_MESSAGE = "위치는 음수일 수 없습니다.";

    private final int value;

    public Position(final int value) {
        checkInvalidPosition(value);
        this.value = value;
    }

    private void checkInvalidPosition(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException(POSITION_UNDER_ZERO_MESSAGE);
        }
    }

    public Position moveFront() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(final Position otherPosition) {
        return Integer.compare(this.value, otherPosition.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
