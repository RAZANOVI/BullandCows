package com.company;

import java.util.ArrayList;

public class NumberGenerator  {
    Response response;
    Integer elements;
    Integer elements2;
    StringBuilder a = new StringBuilder();;
    Integer [] element = null;
    ArrayList arrayList = new ArrayList();
    public <Integer> void printAllRecursive(Integer[] elements, String delimiter) {
        printAllRecursive(elements.length, elements, delimiter);
    }
    public <Integer> void printAllRecursive(int n, Integer[] elements, String delimiter) {
        if (n == 1) {
            printArray(elements, delimiter);
        } else {
            for (int i = 0; i < n - 1; ++i) {
                printAllRecursive(n - 1, elements, delimiter);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }
    private <Integer> void swap(Integer[] elements, int a, int b) {
        Integer tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
    private <Integer> void printArray(Integer[] elements, String delimiter) {
            String sum = "";
            for (int i = 0; i < 4; ++i) {
                sum += elements[i];
            }
            a.append(sum).append(delimiter);
        }
    public String generateNumber(Integer[] elements){
            printAllRecursive(elements,",");
        return String.valueOf(a);
    }
    }
    ///Получить все возможные комбинации чисел и цифр java

