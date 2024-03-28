package org.example.calculator.controller;

import org.example.calculator.model.Calculator;
import org.example.calculator.view.InputView;
import org.example.calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String inputString = inputView.getInputString();
        Calculator calculator = new Calculator(inputString);
        int result = calculator.calculate();
        outputView.printResult(result);
    }
}
