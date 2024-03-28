package org.example.calculator;

import org.example.calculator.controller.CalculatorController;
import org.example.calculator.view.InputView;
import org.example.calculator.view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(inputView, outputView);
        calculatorController.play();
    }
}
