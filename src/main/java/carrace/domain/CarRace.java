package carrace.domain;

public class CarRace {

	private final CarMoveRule carMoveRule;
	private final Cars cars;

	public CarRace(CarMoveRule carMoveRule, Cars cars) {
		this.carMoveRule = carMoveRule;
        this.cars = cars;
    }

	public RaceResult race(Round round) {
		RaceResult result = new RaceResult(cars);

		for (int i = 0; i < round.getValue(); i++) {
			Cars newCars = result.last().moveAll(carMoveRule);
			result.add(newCars);
		}

		return result;
	}
}
