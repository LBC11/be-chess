package softeer2nd.chess.exception.moveException;

public class InvalidPlayerColorException extends InvalidMoveException {
    public InvalidPlayerColorException(String color) {
        super(color + " 기물은 움직일 수 없습니다.");
    }
}
