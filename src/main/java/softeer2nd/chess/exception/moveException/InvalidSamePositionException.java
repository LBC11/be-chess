package softeer2nd.chess.exception.moveException;

public class InvalidSamePositionException extends InvalidMoveException {

    public InvalidSamePositionException(String sourcePosition, String targetPosition) {
        super(sourcePosition + "와 " + targetPosition + "의 위치가 같아 이동이 불가능합니다.");

    }
}
