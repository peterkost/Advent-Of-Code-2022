package Day02;

public enum Result {
    WIN(6), LOSE(0), DRAW(3);

    private final int points;

    Result(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
