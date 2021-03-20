package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите формулу: ");
            String formula = scanner.next();
            if(formula.equals(0)) return;
            System.out.println(isFormula(formula));
        }

    }
    public static boolean isFormula(String formula){
        //parser
        return false;
    }
}
