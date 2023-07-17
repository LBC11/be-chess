package softeer2nd.chess.exception.moveException;

public class InvalidBlankMoveException extends InvalidMoveException {
    public InvalidBlankMoveException(String sourcePosition) {
        super(sourcePosition + "은 빈 칸입니다.");
    }
}
