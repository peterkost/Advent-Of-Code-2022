package Day01;

import Helpers.InputReader;

import java.io.FileNotFoundException;

class Day01 {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader input = new InputReader("Day01/Input.txt");
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        while (input.hasMore()) {
            String line = input.next();
            if (line.isBlank()) {
                maxSum = Math.max(maxSum, curSum);
                curSum = 0;
            } else {
                curSum += Integer.parseInt(line);
            }
        }
        System.out.println("The elf carrying the most calories has " + maxSum + " calories.");
    }
}