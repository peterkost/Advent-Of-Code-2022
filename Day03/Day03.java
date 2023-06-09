package Day03;

import Helpers.InputReader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;

public class Day03 {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader input = new InputReader("Day03/input.txt");
        int prioritySum = 0;

        while (input.hasMore()) {
            String backpacks = input.next();
            prioritySum += getValueOfDuplicateItemIn(backpacks);
        }

        System.out.println("The sum priority of dupilcate items is " + prioritySum + ".");
    }
    
    private static int getValueOfDuplicateItemIn(String backpacks) {
        char duplicateItem = getDuplicateLetter(backpacks);

        if (Character.isLowerCase(duplicateItem)) {
            return (int) duplicateItem - 96;
        } else {
            return (int) duplicateItem - 38;
        }
    }

    private static char getDuplicateLetter(String backpacks) {
        int backpackSize = backpacks.length() / 2;

        String firstString = backpacks.substring(0, backpackSize);
        HashSet<String> setBackpack = new HashSet<>(Arrays.asList(firstString.split("")));
        char[] arrayBackpack = backpacks.substring(backpackSize).toCharArray();

        char duplicateLetter = 0;
        for (char letter : arrayBackpack) {
            if (setBackpack.contains(String.valueOf(letter))) {
                duplicateLetter = letter;
            }
        }
        return duplicateLetter;
    }
}
