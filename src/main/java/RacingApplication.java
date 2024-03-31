import controller.RacingController;
import model.NumberGenerator;
import service.RacingService;
import infrastructure.RandomNumberGenerator;
import view.RacingGameView;

public class RacingApplication {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        RacingService racingService = new RacingService();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingController racingController =
                new RacingController(racingGameView, racingService, numberGenerator);

        racingController.start();
    }
}
