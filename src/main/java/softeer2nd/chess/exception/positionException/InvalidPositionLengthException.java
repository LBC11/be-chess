package softeer2nd.chess.exception.positionException;

public class InvalidPositionLengthException extends InvalidPositionException {
    public InvalidPositionLengthException(String message) {
        super(message + "의 길이가 잘못되었습니다.");
    }
}
