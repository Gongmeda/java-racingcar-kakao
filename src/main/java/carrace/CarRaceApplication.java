package carrace;

public class CarRaceApplication {

	public static void main(String[] args) {
		CarRaceView view = new CarRaceView();
		CarRaceController controller = new CarRaceController(view);
		controller.play();
	}
}
