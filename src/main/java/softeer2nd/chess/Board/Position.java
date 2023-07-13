package softeer2nd.chess.Board;

public class Position {

    private final int row;
    private final int col;

    public Position(String position) {

        this.row = Constants.ROW_LENGTH - (position.charAt(1) - '0');
        this.col = position.charAt(0) - 'a';
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int generatePieceLoc() {
        return Constants.KEY_GENERATION_MULTIPLIER * row + col;
    }
}
