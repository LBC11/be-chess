package softeer2nd.chess.Board;

public class chessView {

    private final Board board;
    private final PointCalculator pointCalculator;

    public chessView(Board board, PointCalculator pointCalculator) {

        this.board = board;
        this.pointCalculator = pointCalculator;
    }

    public void showBoard() {
        System.out.println(board.showBoard());
    }

    public void showPoint() {

        System.out.println(pointCalculator.showPoint());
    }
}
