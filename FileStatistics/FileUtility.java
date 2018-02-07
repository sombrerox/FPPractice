package com.company;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileUtility {

    private File file;

    public FileUtility(File file) {
        this.file = file;
    }

    public void numberOfLines() throws IOException {
        System.out.print("Number of lines in a file: ");
        System.out.println(Files.lines(file.toPath())
                                .count());
    }

    public void numberOfWords() throws IOException {
        System.out.print("Number of words in a file: ");
        System.out.println(Files.lines(file.toPath())
                                .mapToInt(s -> s.split(" ").length)
                                .sum());
    }

    public void numberOfUniqueWords() throws IOException {
        System.out.print("Number of unique words in a file: ");
        System.out.println(Files.lines(file.toPath())
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .count());
    }

    public void numberOfChars() throws IOException {
        System.out.print("Number of characters in a file: ");
        System.out.println(Files.lines(file.toPath())
                                .map(s -> s.split(""))
                                .flatMap(Arrays::stream)
                                .filter(s -> !s.equals(" "))
                                .count());
    }

    public void numberOfCharRepetitions() throws IOException {
        System.out.print("Number of characters in a file: ");
        Map<String, Long> charRepetitions =
                Files.lines(file.toPath())
                     .map(s -> s.split(""))
                     .flatMap(Arrays::stream)
                     .filter(s -> !s.equals(" "))
                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        printCharRepetitions(charRepetitions);
    }

    private void printCharRepetitions(Map<String, Long> m) {
        for (Map.Entry<String, Long> e : m.entrySet())
            System.out.printf("Character %s repeats %d times.\n", e.getKey(), e.getValue());
    }

}
