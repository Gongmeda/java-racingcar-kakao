package carrace.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MOVE_THRESHOLD = 4;
    @Override
    public boolean isMovable() {
        return (random.nextInt(MAX_RANDOM_NUMBER-MIN_RANDOM_NUMBER+1) + MIN_RANDOM_NUMBER) >= MOVE_THRESHOLD;
    }
}
