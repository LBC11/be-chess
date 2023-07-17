package softeer2nd.chess.exception.moveException;

public class InvalidBlockedMoveException extends InvalidMoveException{
    public InvalidBlockedMoveException(String sourcePosition, String targetPosition) {
        super(sourcePosition + "에서 " + targetPosition + "로 가는 방향에 장애물이 존재하여 이동이 불가능합니다.");
    }
}
