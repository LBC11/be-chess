package softeer2nd.chess.exception.pieceException;

public class InvalidTypeException extends InvalidPieceFieldException {
    public InvalidTypeException() {
        super("Invalid piece type");
    }
}
