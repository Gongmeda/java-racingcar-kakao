package racingcar.model.vo;

import java.util.Objects;

public class StepCount {

    private static final String COUNT_UNDER_ZERO_MESSAGE = "시도 횟수는 음수일 수 없습니다.";
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final int count;

    public StepCount(final int inputCount) {
        checkInvalidStepCount(inputCount);
        this.count = inputCount;
    }

    private void checkInvalidStepCount(final int inputCount) {
        if (inputCount < ZERO) {
            throw new IllegalArgumentException(COUNT_UNDER_ZERO_MESSAGE);
        }
    }

    public StepCount decrease() {
        return new StepCount(count - ONE);
    }

    public boolean isZero() {
        return count == ZERO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final StepCount stepCount = (StepCount) o;
        return count == stepCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
