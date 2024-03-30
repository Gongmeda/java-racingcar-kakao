package racing;

import racing.controller.Controller;
import racing.domain.NumberGenerator;
import racing.domain.CarFactory;
import racing.infra.RandomNumberGenerator;
import racing.view.View;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        View view = new View();
        CarFactory carFactory = new CarFactory(generator);
        Controller controller = new Controller(view, carFactory);
        controller.play();
    }
}
