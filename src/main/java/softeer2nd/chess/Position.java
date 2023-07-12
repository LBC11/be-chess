package softeer2nd.chess;

import softeer2nd.chess.Constants.BoardConfig;

public class Position {

    private final int ROW_LENGTH = BoardConfig.ROW_LENGTH.getValue();
    private final int KEY_GENERATION_MULTIPLIER = BoardConfig.KEY_GENERATION_MULTIPLIER.getValue();


    public int generatePieceLoc(String position) {

        int row = ROW_LENGTH - (position.charAt(1) - '0');
        int col = position.charAt(0) - 'a';

        return KEY_GENERATION_MULTIPLIER * row + col;
    }
}
