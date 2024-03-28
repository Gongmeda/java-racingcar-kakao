package carrace;

import carrace.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {

	private final CarRaceView view;

	public CarRaceController(CarRaceView view) {
		this.view = view;
	}

	public void play() {
		CarRace carRace = new CarRace(new DefaultCarMoveRule(new RandomNumberGenerator()), createCars(view.getCarNames()));
		Round round = new Round(view.getCarRaceRound());
		RaceResult raceResult = carRace.race(round);
		view.displayRoundResult(raceResult);
	}

	private Cars createCars(List<String> carNames) {
		return new Cars(carNames.stream()
				.map(Car::new)
				.collect(Collectors.toUnmodifiableList()));
	}
}
