package softeer2nd.chess.exception.moveException;

public class UnreachablePositionException extends InvalidMoveException {
    public UnreachablePositionException(String sourcePosition, String targetPosition) {
        super(sourcePosition + "의 이동범위에 " + targetPosition + "가 포함되지 않습니다.");
    }
}
