package softeer2nd.chess;

public class View {

    private final Board board;

    public View(Board board) {
        this.board = board;
    }

    public void showBoard() {
        System.out.println(board.showBoard());
    }
}
