package Day02;

import Helpers.InputReader;

import java.io.FileNotFoundException;

class Day02 {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader input = new InputReader("Day02/Input.txt");

        int score = 0;
        while (input.hasMore()) {
            String line = input.next();
            Turn turn = lineToTurn(line);
            score += turn.points();
        }
        System.out.println("The total score would be " + score + ".");
    }

    static Turn lineToTurn(String line) {
        String[] moves = line.split(" ");
        String opponentString = moves[0], playerString = moves[1];
        Move opponentMove = Move.fromString(opponentString), playerMove = Move.fromString(playerString);
        return new Turn(playerMove, opponentMove);
    }
}
