package softeer2nd.chess.Board;

import softeer2nd.chess.exception.positionException.InvalidBoardBoundException;
import softeer2nd.chess.exception.positionException.InvalidPositionException;

import java.util.Objects;

import static softeer2nd.chess.Board.Constants.COLUMN_LENGTH;

public class Position {

    private final int xPos;
    private final int yPos;

    private Position(String position) {
        this.xPos = position.charAt(0) - 'a';
        this.yPos = COLUMN_LENGTH - (position.charAt(1) - '0');
        verifyPosition(position);
    }

    private Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public static Position of(String position) {
        return new Position(position);
    }

    public static Position of(int xPos, int yPos) {
        return new Position(xPos, yPos);
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

        if (!isValidPosition(position)) {
            throw new InvalidPositionException(position);
        }

        if (!isWithinBoardBounds(xPos, yPos)) {
            throw new InvalidBoardBoundException(position);
        }
    }

    public String getPositionString() {
        char x = (char) (this.xPos + 'a');
        int y = COLUMN_LENGTH - this.yPos;

        return String.valueOf(x) + y;
    }

    public boolean doesPositionMatchAfterMove(Position targetPosition, int dx, int dy) {
        return (targetPosition.xPos - this.xPos) == dx && (targetPosition.yPos - this.yPos) == dy;
    }

    public Position generateUnitVector(Position targetPosition) {
        int unitX = targetPosition.xPos - this.xPos;
        int unitY = targetPosition.yPos - this.yPos;

        if (unitX != 0) unitX = unitX / Math.abs(unitX);
        if (unitY != 0) unitY = unitY / Math.abs(unitY);

        return new Position(unitX, unitY);
    }

    public Position moveByAddingPosition(Position position) {
        return new Position(this.xPos + position.xPos, this.yPos + position.getYPos());
    }

    public int calculateStepToTarget(Position position) {
        return Math.min(Math.abs(position.getXPos() - this.xPos), Math.abs(position.getYPos() - this.yPos));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xPos == position.xPos && yPos == position.yPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPos, yPos);
    }
}
