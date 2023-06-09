package Day05;

public class Move {
    final private int numBoxes;
    final private int from;
    final private int to;

    public Move(int numBoxes, int from, int to) {
        this.numBoxes = numBoxes;
        this.from = from;
        this.to = to;
    }

    public int numBoxes() {
        return numBoxes;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }
}
