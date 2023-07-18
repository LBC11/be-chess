package softeer2nd.chess.exception.moveException;

public abstract class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String message) {
        super(message);
    }
}
