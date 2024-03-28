package carrace.domain;

public class Round {

    private final int value;

    public Round(int value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value <= 0) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
