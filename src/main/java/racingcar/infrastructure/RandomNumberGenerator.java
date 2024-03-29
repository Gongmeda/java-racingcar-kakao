package racingcar.infrastructure;

import racingcar.model.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int NUMBER_BOUND = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(NUMBER_BOUND);
    }
}
