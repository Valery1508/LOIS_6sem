/*
    Author - Зубрицкая Валерия, гр.821701, 03.05.2021
    Лабораторная работа №2
    Вариант 9 - Построить СДНФ для заданной формулы
*/
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите формулу: ");
            Scanner scannerString = new Scanner(System.in);
            StringBuilder formula = new StringBuilder(scannerString.next());
            new Parser(formula);
        }
    }
}
