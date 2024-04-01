package carrace.domain;

public class Round {

    private final int value;

    public Round(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
