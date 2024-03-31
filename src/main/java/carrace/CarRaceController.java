package carrace;

import carrace.domain.Car;
import carrace.domain.CarRace;
import carrace.domain.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {

	private final CarRaceView view;

	public CarRaceController(CarRaceView view) {
		this.view = view;
	}

	public void play() {
		List<Car> cars = createCars(view.getCarNames());
		int round = view.getCarRaceRound();
		CarRace carRace = new CarRace(cars, round);
		proceedRounds(carRace);
		endRace(carRace);
	}


	private List<Car> createCars(List<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}

	private void proceedRounds(CarRace carRace) {
		view.displayResultStartMessage();
		while (!carRace.isEnd()) {
			carRace.runRound();
			view.displayRoundResult(carRace.getCars());
		}
	}

	private void endRace(CarRace carRace) {
		view.displayWinnerNames(carRace.getWinningCars()
			.stream()
			.map(Car::getName)
			.collect(Collectors.toList()));
	}
}