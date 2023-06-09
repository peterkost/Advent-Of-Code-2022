package Day05;

import Helpers.InputReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day05 {
    public static void main(String[] args) throws FileNotFoundException, InvalidInstructionsException {
        Ship ship = processInput();
        ship.executeMoves();
        ship.printTopBoxes();
    }

    public static Ship processInput() throws FileNotFoundException {
        InputReader input = new InputReader("Day05/input.txt");
        String line = input.next();

        ArrayList<String> boxesInput = new ArrayList<>();
        while (input.hasMore() && !line.isBlank()) {
            boxesInput.add(line);
            line = input.next();
        }

        ArrayList<Stack<Character>> deck = processBoxes(boxesInput.toArray(new String[boxesInput.size()]));

        ArrayList<Move> moves = new ArrayList<>();
        while (input.hasMore()) {
            line = input.next();
            String strippedLine = line.replace("move ", "").replace(" from ", ",").replace(" to ", ",");
            String[] stringMove = strippedLine.split(",");
            // from and to are zero indexed
            Move move = new Move(
                    Integer.parseInt(stringMove[0]),
                    Integer.parseInt(stringMove[1]) - 1,
                    Integer.parseInt(stringMove[2]) - 1
            );
            moves.add(move);
        }

        return new Ship(deck, moves);
    }

    public static ArrayList<Stack<Character>> processBoxes(String[] input) {
        int colNum = 0;
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher columnCounter = numberPattern.matcher(input[input.length - 1]);
        while (columnCounter.find()) {
            colNum++;
        }

        ArrayList<Stack<Character>> deck = new ArrayList<>();
        for (int i = 0; i < colNum; i++) {
            deck.add(new Stack<>());
        }

        for (int row = input.length - 2; row >= 0; row--) {
            for (int i = 1, col = 0; i < input[0].length(); i += 4, col++) {
                Character cur = input[row].charAt(i);
                if (!cur.equals(' ')) {
                    deck.get(col).add(cur);
                }
            }
        }

        return deck;
    }
}
