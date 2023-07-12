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

    public String showBoard() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_LENGTH).forEach(row -> {
            IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                    ret.append(board.findPiece(row * KEY_GENERATION_MULTIPLIER + col).getRepresentation()));
            StringUtils.appendNewLine(ret);
        });

        return ret.toString();
    }
}
