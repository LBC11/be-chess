package softeer2nd.chess.exception.positionException;

public abstract class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
