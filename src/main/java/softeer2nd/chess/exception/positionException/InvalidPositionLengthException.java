package softeer2nd.chess.exception.positionException;

public class InvalidPositionLengthException extends InvalidPositionException {
    public InvalidPositionLengthException(String message) {
        super("Invalid position length: " + message);
    }
}
