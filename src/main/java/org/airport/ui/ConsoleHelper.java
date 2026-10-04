package org.airport.ui;

import java.util.Scanner;

public class ConsoleHelper {

    private final Scanner scanner;

    public ConsoleHelper() {
        this.scanner = new Scanner(System.in);
    }
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}