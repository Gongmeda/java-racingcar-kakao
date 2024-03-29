package racingcar;

import racingcar.model.RacingGame;
import racingcar.infrastructure.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        final RacingGame racingGame = initializeGame();
        runGame(racingGame);
        OutputView.printWinner(racingGame.getWinnerNames());
    }

    private static RacingGame initializeGame() {
        final String carNames = InputView.readCarNames();
        final int stepCount = InputView.readStepCount();
        return new RacingGame(carNames, new RandomNumberGenerator(), stepCount);
    }

    private static void runGame(final RacingGame racingGame) {
        OutputView.printPlayTitle();
        while (!racingGame.isEnd()) {
            racingGame.play();
            OutputView.printRoundResult(racingGame.extractCarInfos());
        }
    }
}
