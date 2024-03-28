package carrace.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_MAX_NUMBER = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(EXCLUSIVE_MAX_NUMBER);
    }
}
