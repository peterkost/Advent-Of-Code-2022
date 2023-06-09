package Day05;

import java.util.ArrayList;
import java.util.Stack;

public class Ship {
    private final ArrayList<Stack<Character>> deck;
    private final ArrayList<Move> moves;

    public Ship(ArrayList<Stack<Character>> deck, ArrayList<Move> moves) {
        this.deck = deck;
        this.moves = moves;
    }

    public void executeMoves() throws InvalidInstructionsException {
        for (Move move : moves) {
            Stack<Character> fromColumn = deck.get(move.from());
            Stack<Character> toColumn = deck.get(move.to());
            for (int i = 0; i < move.numBoxes(); i++) {
                if (fromColumn.empty()) {
                    throw new InvalidInstructionsException("Could not execute moves, needed to take box from empty column.");
                }

                Character box = fromColumn.pop();
                toColumn.push(box);
            }
        }
    }

    public void printTopBoxes() {
        StringBuilder topBoxes = new StringBuilder();

        for (Stack<Character> col : deck) {
            if (!col.empty()) {
                topBoxes.append(col.peek());
            }
        }

        System.out.println("The top box on each stack will be: " + topBoxes);
    }
}
