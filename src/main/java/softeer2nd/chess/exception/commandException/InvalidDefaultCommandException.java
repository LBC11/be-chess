package softeer2nd.chess.exception.commandException;

public class InvalidDefaultCommandException extends InvalidCommandException {
    public InvalidDefaultCommandException() {
        super("올바른 명령어가 아닙니다. start / end / move b1 b2 명령어를 이용해주세요.");
    }
}
