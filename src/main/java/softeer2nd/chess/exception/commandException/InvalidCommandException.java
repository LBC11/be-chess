package softeer2nd.chess.exception.commandException;

public abstract class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(String message) {
        super(message);
    }
}
