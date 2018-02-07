package com.company;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File file = new File(Paths.get(args[0]).toUri());
        FileUtility fu = new FileUtility(file);
        fu.numberOfWords();
        fu.numberOfChars();
        fu.numberOfLines();
        fu.numberOfUniqueWords();
        fu.numberOfCharRepetitions();
    }
}
