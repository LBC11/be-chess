package softeer2nd.chess;

import softeer2nd.utils.StringUtils;

import java.util.stream.IntStream;

public class View {

    private final int ROW_LENGTH = Constants.BoardConfig.ROW_LENGTH.getValue();
    private final int COLUMN_LENGTH = Constants.BoardConfig.COLUMN_LENGTH.getValue();
    private final int KEY_GENERATION_MULTIPLIER = Constants.BoardConfig.KEY_GENERATION_MULTIPLIER.getValue();

    private final Board board;

    public View(Board board) {
        this.board = board;
    }

    public void showBoard() {
        System.out.println(board.showBoard());
    }
}
