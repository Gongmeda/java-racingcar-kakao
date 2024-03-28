package org.example.racinggame.view;

import java.util.List;

public class OutputView {

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printCarPosition(String name, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" : ")
                .append("-".repeat(position));
        System.out.println(sb);
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void newLine() {
        System.out.println();
    }
}
