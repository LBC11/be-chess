package softeer2nd.chess.exception.commandException;

public class InvalidMoveCommandException extends InvalidCommandException{
    public InvalidMoveCommandException() {
        super("move는 총 3개의 parameter가 필요합니다.");
    }
}
