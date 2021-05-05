/*
    Author - Зубрицкая Валерия, гр.821701, 03.05.2021
    Лабораторная работа №2
    Вариант 9 - Построить СДНФ для заданной формулы
*/
package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SDNFConstructor {
    private int countOfAtomicAndConstant;
    private Map<String, List<Integer>> tableMap;
    private List<String> listOfKeys;
    private final StringBuilder formulaSDNF = new StringBuilder("");
    private final StringBuilder additionsBrackets = new StringBuilder("");

    public void generateSDNF(int countOfAtomicAndConstant, Map<String, List<Integer>> tableMap) {
        this.countOfAtomicAndConstant = countOfAtomicAndConstant;
        this.tableMap = tableMap;
        this.listOfKeys = new ArrayList<>(tableMap.keySet());
        constructFormula();
    }

    private void constructFormula() {
        int counter = 0;
        for (int indexOfRow = 0; indexOfRow < tableMap.get(listOfKeys.get(0)).size(); indexOfRow++) {

            if (tableMap.get(listOfKeys.get(listOfKeys.size() - 1)).get(indexOfRow) == 0) continue;
            for (int i = 0; i < countOfAtomicAndConstant; i++) {
                if (i == 0) {
                    for (int a = 0; a < countOfAtomicAndConstant - 1; a++) {
                        formulaSDNF.append("(");
                    }
                }
                if (tableMap.get(listOfKeys.get(i)).get(indexOfRow) == 1) {
                    formulaSDNF.append(listOfKeys.get(i));
                } else {
                    formulaSDNF.append("(!").append(listOfKeys.get(i)).append(")");
                }
                if (i > 0) formulaSDNF.append(")/\\");
                else formulaSDNF.append("/\\");
                if (i == countOfAtomicAndConstant - 1) {
                    formulaSDNF.delete(formulaSDNF.length() - 2, formulaSDNF.length());
                }
            }
            if (counter > 0) {
                formulaSDNF.append(")\\/");
            } else {
                formulaSDNF.append("\\/");
            }
            counter++;
        }
        for (int a = 0; a < counter - 1; a++) {
            additionsBrackets.append("(");
        }
        formulaSDNF.insert(0, additionsBrackets);
        if (formulaSDNF.length() == 0) System.out.println("\nДля данной формулы не существует СДНФ");
        else {
            formulaSDNF.delete(formulaSDNF.length() - 2, formulaSDNF.length());
            System.out.println("\nФормула СДНФ: " + formulaSDNF);
        }
    }
}
