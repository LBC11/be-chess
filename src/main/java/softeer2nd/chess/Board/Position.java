package softeer2nd.chess.Board;

import softeer2nd.chess.exception.positionException.InvalidBoardBoundException;
import softeer2nd.chess.exception.positionException.InvalidPositionException;

import static softeer2nd.chess.Board.Constants.COLUMN_LENGTH;

public class Position {

    private final int xPos;
    private final int yPos;

    public Position(String position) {

        verifyPosition(position);

        this.xPos = position.charAt(0) - 'a';
        this.yPos = COLUMN_LENGTH - (position.charAt(1) - '0');
    }

    public int getYPos() {
        return yPos;
    }

    public int getXPos() {
        return xPos;
    }

    private boolean isWithinBoardBounds(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private boolean isValidPosition(String position) {
        return position.length() == 2;
    }

    private void verifyPosition(String position) {

        if(!isValidPosition(position)) {
            throw new InvalidPositionException("Invalid position length: " + position);
        }

        if (!isWithinBoardBounds(xPos, yPos)) {
            throw new InvalidBoardBoundException("Invalid position location: " + position);
        }
    }

}
