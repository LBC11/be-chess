package softeer2nd.chess.Board;

public class chessView {

    private final Board board;
    private final PointCalculator pointCalculator;

    public chessView(Board board, PointCalculator pointCalculator) {

        this.board = board;
        this.pointCalculator = pointCalculator;
    }

    private void showBoard() {
        System.out.println(board.showBoard());
    }

    private void showPoint() {

        System.out.println(pointCalculator.showPoint());
    }

    public void showUpdate() {
        showBoard();
        showPoint();
    }
}
