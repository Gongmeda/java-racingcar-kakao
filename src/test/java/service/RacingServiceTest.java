package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("시도 횟수는 1 이상이어야 한다")
    void validateTryNumberTest() {
        int tryNumber = 0;
        assertThrows(IllegalArgumentException.class,
                () -> racingService.validateTryNumber(tryNumber));
    }
}
