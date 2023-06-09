package Day02;

public class Turn {
    private final Move playerMove;
    private final Move opponentMove;

    public Turn(Move playerMove, Move opponentMove) {
        this.playerMove = playerMove;
        this.opponentMove = opponentMove;
    }

    private Result result() {
        if ((playerMove.toInt() + 1) % 3 == opponentMove.toInt()) {
            return Result.LOSE;
        } else if (playerMove.toInt() == opponentMove.toInt()) {
            return Result.DRAW;
        } else {
            return Result.WIN;
        }
    }

    public Integer points() {
        return this.result().getPoints() + playerMove.toInt() + 1;
    }
}
