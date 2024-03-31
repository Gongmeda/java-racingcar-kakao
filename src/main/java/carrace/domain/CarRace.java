package carrace.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

	private final List<Car> cars;
	private final int totalRound;
	private int currentRound;

	public CarRace(List<Car> cars, int totalRound) {
		validateDuplicateCarNames(cars);
		validateRound(totalRound);
		validateCarsSize(cars);
		this.cars = cars;
		this.totalRound = totalRound;
	}

	public void runRound() {
		for (Car car : cars) {
			car.moveForward();
		}
		currentRound++;
	}

	public List<Car> getWinningCars() {
		int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalArgumentException("라운드 수는 음수가 아니여야 합니다."));
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return this.cars;
	}

	private void validateDuplicateCarNames(List<Car> cars) {
		if (cars.size() != cars.stream().map(Car::getName).distinct().count()) {
			throw new IllegalArgumentException("중복된 자동차의 이름이 존재합니다.");
		}
	}

	private void validateRound(int totalRound) {
		if (totalRound < 0) {
			throw new IllegalArgumentException("라운드 수는 음수가 아니여야 합니다.");
		}
	}

	private void validateCarsSize(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException("자동차 경주에 참여하는 자동차는 적어도 하나 이상이여야 합니다.");
		}
	}

	public boolean isEnd() {
		return totalRound == currentRound;
	}
}
