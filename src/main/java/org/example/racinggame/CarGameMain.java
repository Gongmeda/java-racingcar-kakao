package org.example.racinggame;

import org.example.racinggame.controller.RacingCarController;
import org.example.racinggame.view.InputView;
import org.example.racinggame.view.OutputView;

public class CarGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarController racingCarController = new RacingCarController(inputView, outputView);
        racingCarController.play();
    }
}
