package org.example.racinggame.model;

import java.util.Random;

public class RandomIntegerGenerator {

    private RandomIntegerGenerator() {
        // utility class
    }

    private static final Random random = new Random();

    public static int generateEndInclusive(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }
}
