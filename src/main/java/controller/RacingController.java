package controller;

import model.Car;
import model.NumberGenerator;
import model.RacingGame;
import service.RacingService;
import view.RacingGameView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final RacingGameView racingGameView;
    private final RacingService racingService;
    private final NumberGenerator numberGenerator;


    public RacingController(RacingGameView racingGameView,
                            RacingService racingService,
                            NumberGenerator numberGenerator) {
        this.racingGameView = racingGameView;
        this.racingService = racingService;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            racingGameView.printErrorMessage(e.getMessage());
            start();
        }
    }

    private void play() {
        RacingGame racingGame = new RacingGame(createCars());
        int tryNumber = getTryNumber();

        racingGameView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.moveCars(numberGenerator);
            racingGame.getRacingCars()
                    .forEach(car -> racingGameView.printCarResult(car.getName(), car.getPosition()));
        }

        racingGameView.printWinnerMessage(racingGame.getWinnerNames());
    }

    private List<Car> createCars() {
        String carNames = racingGameView.getCarNameInput();
        return racingService.extractCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    private int getTryNumber() {
        return racingService.validateTryNumber(racingGameView.getNumberInput());
    }
}
