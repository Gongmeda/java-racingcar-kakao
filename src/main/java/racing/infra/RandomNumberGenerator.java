package racing.infra;

import java.util.Random;

import racing.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int RANDOM_BOUND = 10;
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
