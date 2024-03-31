package infrastructure;

import java.util.Random;

import model.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private final static Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
