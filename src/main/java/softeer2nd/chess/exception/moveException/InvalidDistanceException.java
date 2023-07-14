package softeer2nd.chess.exception.moveException;

public class InvalidDistanceException extends InvalidMoveException {
    public InvalidDistanceException(String sourcePosition, String targetPosition) {
        super("invalid distance " + sourcePosition + "to" + targetPosition);
    }
}
