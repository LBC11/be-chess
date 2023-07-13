package softeer2nd.chess.exception;

public class InvalidTypeException extends InvalidPieceFieldException {
    public InvalidTypeException() {
        super("Invalid piece color");
    }
}
