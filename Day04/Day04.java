package Day04;

import Helpers.InputReader;

import java.io.FileNotFoundException;

class Day04 {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader input = new InputReader("Day04/input.txt");

        int fullyOverlappingPairs = 0;
        while (input.hasMore()) {
            int[][] intervals = parseIntervals(input.next());
            if (fullyOverlapping(intervals[0], intervals[1])) {
                fullyOverlappingPairs += 1;
            }
        }

        System.out.println("There are " + fullyOverlappingPairs + " fully overlapping pairs.");
    }

    private static int[][] parseIntervals(String input) {
        String[] stringIntervals = input.split(",");
        String[] firstStringInterval = stringIntervals[0].split("-");
        String[] secondStringInterval = stringIntervals[1].split("-");

        int[] firstInterval = new int[]{
                Integer.parseInt(firstStringInterval[0]),
                Integer.parseInt(firstStringInterval[1])
        };

        int[] secondInterval = new int[]{
                Integer.parseInt(secondStringInterval[0]),
                Integer.parseInt(secondStringInterval[1])
        };

        return new int[][]{firstInterval, secondInterval};
    }

    private static boolean fullyOverlapping(int[] a, int[] b) {
        boolean aOverlapsB = a[0] <= b[0] && a[1] >= b[1];
        boolean bOverlapsA = a[0] >= b[0] && a[1] <= b[1];
        return aOverlapsB || bOverlapsA;
    }
}
