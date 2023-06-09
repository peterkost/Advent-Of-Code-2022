package Day06;

import Helpers.InputReader;
import Helpers.InvalidInputException;

import java.io.FileNotFoundException;
import java.util.HashMap;

class Day06 {
    private static final int MARKER = 4;

    public static void main(String[] args) throws FileNotFoundException, InvalidInputException {
        InputReader input = new InputReader("Day06/input.txt");

        int marker;
        if (input.hasMore()) {
            String inputString = input.next();
            marker = getMarker(inputString.toCharArray());
        } else {
            throw new InvalidInputException("empty file");
        }

        System.out.println(marker > 0 ? "The marker is at " + marker : "No marker found");
    }

    public static int getMarker(char[] dataStream) {
        HashMap<Character, Integer> cur = new HashMap<>();
        int i = 0;
        for (; i < MARKER; i++) {
            char letter = dataStream[i];
            if (cur.containsKey(letter)) {
                cur.put(letter, cur.get(letter) + 1);
            } else {
                cur.put(letter, 1);
            }
        }

        if (cur.size() == MARKER) {
            return i + 1;
        }

        for (; i < dataStream.length; i++) {
            char newLetter = dataStream[i];
            if (cur.containsKey(newLetter)) {
                cur.put(newLetter, cur.get(newLetter) + 1);
            } else {
                cur.put(newLetter, 1);
            }

            char removedLetter = dataStream[i - MARKER];
            if (cur.get(removedLetter) == 1) {
                cur.remove(removedLetter);
            } else {
                cur.put(removedLetter, cur.get(removedLetter) - 1);
            }

            if (cur.size() == MARKER) {
                return i + 1;
            }
        }

        return -1;
    }
}
