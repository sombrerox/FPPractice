package com.company;

import java.util.Comparator;


public class NumberStats {

    public static void getMin() {
        int min = Prompt.getListOfNumbers().stream()
                                           .min(Comparator.naturalOrder())
                                           .get();
        System.out.println("Lowest entered number is: " + min);
    }

    public static void getMax() {
        int max = Prompt.getListOfNumbers().stream()
                        .max(Comparator.naturalOrder())
                        .get();
        System.out.println("Highest entered number is: " + max);
    }

    // using reduce() instead of sum()
    public static void sumOfAll() {
        int sum = Prompt.getListOfNumbers().stream()
                                           .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all entered numbers is: " + sum);
    }

    public static void average() {
        double average = Prompt.getListOfNumbers().stream()
                                                  .mapToInt(x -> x)
                                                  .average()
                                                  .getAsDouble();
        System.out.println("Average of all entered numbers is: " + average);
    }

    public static void getAllUnique() {
        System.out.println("Unique numbers are: ");
        Prompt.getListOfNumbers().stream()
                                 .distinct()
                                 .forEach(System.out::println);
    }

    public static void printSorted() {
        System.out.println("Numbers in sorted order are: ");
        Prompt.getListOfNumbers().stream()
                                 .sorted()
                                 .forEach(System.out::println);
    }
}
