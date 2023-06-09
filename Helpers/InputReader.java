package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    final private Scanner scanner;

    public InputReader(String input) throws FileNotFoundException {
        File inputFile = new File(input);
        scanner = new Scanner(inputFile);
    }

    public boolean hasMore() {
        return scanner.hasNextLine();
    }

    public String next() {
        return scanner.nextLine();
    }
}
