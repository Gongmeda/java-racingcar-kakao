package carrace;

import carrace.domain.Cars;
import carrace.domain.RaceResult;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRaceView {

	private static final Scanner scanner = new Scanner(System.in);

	public List<String> getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Stream.of(scanner.nextLine().split(",")).collect(Collectors.toUnmodifiableList());
	}

	public int getCarRaceRound() {
		System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
	}

	public void displayRoundResult(RaceResult raceResult) {
		System.out.println("\n실행 결과");
		List<Cars> roundCars = raceResult.getRoundCars();
		for (Cars cars : roundCars) {
			displayRound(cars);
		}
		System.out.printf("%s가 최종 우숭했습니다.", String.join(", ", raceResult.getWinnerNames()));
	}

	private void displayRound(Cars cars) {
		cars.getCars().stream()
			.map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
			.forEach(System.out::println);
		System.out.println();
	}
}
