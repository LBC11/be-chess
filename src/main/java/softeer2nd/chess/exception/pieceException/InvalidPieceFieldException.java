package softeer2nd.chess.exception.pieceException;

public abstract class InvalidPieceFieldException extends RuntimeException {
    public InvalidPieceFieldException(String message) {
        super(message);
    }
}
