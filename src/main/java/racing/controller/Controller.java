package racing.controller;

import racing.domain.CarFactory;
import racing.domain.Race;
import racing.view.View;

public class Controller {

    private final View view;
    private final CarFactory carFactory;

    public Controller(View view, CarFactory carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void play() {
        String carNames = view.promptCars();
        Race race = new Race(carFactory.fromCsvNames(carNames));

        int round = view.promptRound();

        view.printResultHeader();

        for (int i = 0; i < round; ++i) {
            race.nextRound();
            printResult(race);
        }

        view.printWinners(race.getWinnersName());
    }

    private void printResult(Race race) {
        race.forEach(view::printResult);
        view.printBlankLine();
    }
}
