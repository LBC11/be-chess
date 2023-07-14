package softeer2nd.chess.exception.pieceException;

public class InvalidColorException extends InvalidPieceFieldException {
    public InvalidColorException() {
        super("Invalid color");
    }
}
