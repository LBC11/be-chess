package softeer2nd.chess.exception;

public class InvalidColorException extends InvalidPieceFieldException {
    public InvalidColorException() {
        super("Invalid color");
    }
}
