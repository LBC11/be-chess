package softeer2nd.chess.exception;

public class InvalidPieceFieldException extends IllegalArgumentException {
    public InvalidPieceFieldException(String message) {
        super(message);
    }
}
