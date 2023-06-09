package Day02;

public enum Move {
    ROCK(0),
    PAPER(1),
    SCISSORS(2);

    private final int value;

    Move(int value) {
        this.value = value;
    }

    public static Move fromString(String letter) {
        if (letter.equals("A") || letter.equals("X")) return Move.ROCK;
        else if (letter.equals("B") || letter.equals("Y")) return Move.PAPER;
        else return Move.SCISSORS;
    }

    public int toInt() {
        return value;
    }
}
