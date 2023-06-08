import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = getInput();
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isBlank()) {
                maxSum = Math.max(maxSum, curSum);
                curSum = 0;
            } else {
                curSum += Integer.parseInt(line);
            }
        }
        System.out.println("The elf carrying the most calories has " + maxSum + " calories.");
    }

    public static Scanner getInput() throws FileNotFoundException {
        File inputFile = new File("Input/Day01.txt");
        return new Scanner(inputFile);
    }
}