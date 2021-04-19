package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВведите формулу сокращенного языка логики высказываний: ");
            StringBuilder formula = new StringBuilder(scanner.next());
            new Parser(formula);
        }

    }
}
