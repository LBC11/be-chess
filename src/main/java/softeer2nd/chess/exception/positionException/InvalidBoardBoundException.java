package softeer2nd.chess.exception.positionException;

public class InvalidBoardBoundException extends InvalidPositionException {
    public InvalidBoardBoundException(String message) {
        super(message + "가 보드판 내부에 위치해있지 않습니다.");
    }
}
