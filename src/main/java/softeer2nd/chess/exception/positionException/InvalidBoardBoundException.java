package softeer2nd.chess.exception.positionException;

public class InvalidBoardBoundException extends InvalidPositionException {
    public InvalidBoardBoundException(String message) {
        super("Invalid position location: " + message);
    }
}
