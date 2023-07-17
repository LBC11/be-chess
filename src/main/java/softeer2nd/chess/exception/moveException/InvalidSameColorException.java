package softeer2nd.chess.exception.moveException;

public class InvalidSameColorException extends InvalidMoveException{
    public InvalidSameColorException(String sourcePosition, String targetPosition) {
        super(sourcePosition + "와 " + targetPosition + "의 색깔이 같아 이동이 불가능합니다.");
    }
}
