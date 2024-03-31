package infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import model.NumberGenerator;

public class RandomNumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        this.numberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("0부터 9까지 랜덤한 숫자를 생성한다")
    void generateRandomNumberTest() {
        int randomNumber = numberGenerator.generate();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
