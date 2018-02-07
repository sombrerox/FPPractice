package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt {

    private static final Scanner in = new Scanner(System.in);
    private static final List<Integer> listOfNumbers = new ArrayList<>();

    public static void getInput() {
        System.out.println("Enter a range of integers(when finished enter '0')");
        int input;

        while((input = in.nextInt()) != 0) {
            listOfNumbers.add(input);
        }

        NumberStats.average();
        NumberStats.getAllUnique();
        NumberStats.getMax();
        NumberStats.getMin();
        NumberStats.printSorted();
        NumberStats.sumOfAll();
    }

    public static List<Integer> getListOfNumbers() {
        return listOfNumbers;
    }
}
