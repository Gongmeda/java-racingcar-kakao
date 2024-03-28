package org.example.calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String getInputString() {
        System.out.println("inputString을 입력하세요 : ");
        String inputString = SCANNER.nextLine();

        if (inputString == null) {
            inputString = "";
        }

        return inputString.replace("\\n", "\n");
    }
}
