package softeer2nd.chess.Board;


import static softeer2nd.chess.Board.Constants.*;

public class PointCalculator {

    private final Board board;

    public PointCalculator(Board board) {
        this.board = board;
    }

    public double calculateWhitePoint() {
        return board.calculatePoint(Color.WHITE);
    }

    public double calculateBlackPoint() {
        return board.calculatePoint(Color.BLACK);
    }
}
