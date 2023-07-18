package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.pieceException.InvalidColorException;
import softeer2nd.chess.exception.pieceException.InvalidPieceFieldException;
import softeer2nd.chess.exception.pieceException.InvalidTypeException;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Color.*;

public enum PieceFactory {

    INSTANCE;

    public static Piece create(Type type, Color color) {
        verifyField(type, color);

        switch (type) {
            case PAWN -> {
                if (color == WHITE) {
                    return new WhitePawn();
                }

                else {
                    return new BlackPawn();
                }
            }
            case KNIGHT -> {
                return new Knight(color);
            }
            case ROOK -> {
                return new Rook(color);
            }
            case BISHOP -> {
                return new Bishop(color);
            }
            case QUEEN -> {
                return new Queen(color);
            }
            case KING -> {
                return new King(color);
            }
            case NO_PIECE -> {
                return new Blank(color);
            }

            default -> throw new InvalidTypeException();
        }
    }

    private static void verifyField(Type type, Color color) throws InvalidPieceFieldException{
        if(type == Type.NO_PIECE && color != NOCOLOR) throw new InvalidTypeException();
        if(type != Type.NO_PIECE && color == NOCOLOR) throw new InvalidColorException();
    }
}
