package softeer2nd.chess.Board;

import static softeer2nd.chess.Board.Constants.COLUMN_LENGTH;

public class Position {

    private final int xPos;
    private final int yPos;

    public Position(String position) {

        this.xPos = position.charAt(0) - 'a';
        this.yPos = COLUMN_LENGTH - (position.charAt(1) - '0');
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }

}
