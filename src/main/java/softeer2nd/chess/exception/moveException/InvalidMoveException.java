package softeer2nd.chess.exception.moveException;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String sourcePosition, String targetPosition) {
        super("invalid move " + sourcePosition + "to" + targetPosition);
    }
}
