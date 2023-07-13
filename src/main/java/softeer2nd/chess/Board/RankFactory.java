package softeer2nd.chess.Board;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.Board.Constants.*;

public enum RankFactory {
    INSTANCE;

    public Rank createNonPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.ROOK, color));
        rank.addPiece(1, Piece.create(Type.KNIGHT, color));
        rank.addPiece(2, Piece.create(Type.BISHOP, color));
        rank.addPiece(3, Piece.create(Type.QUEEN, color));
        rank.addPiece(4, Piece.create(Type.KING, color));
        rank.addPiece(5, Piece.create(Type.BISHOP, color));
        rank.addPiece(6, Piece.create(Type.KNIGHT, color));
        rank.addPiece(7, Piece.create(Type.ROOK, color));

        return rank;
    }

    public Rank createPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.PAWN, color));
        rank.addPiece(1, Piece.create(Type.PAWN, color));
        rank.addPiece(2, Piece.create(Type.PAWN, color));
        rank.addPiece(3, Piece.create(Type.PAWN, color));
        rank.addPiece(4, Piece.create(Type.PAWN, color));
        rank.addPiece(5, Piece.create(Type.PAWN, color));
        rank.addPiece(6, Piece.create(Type.PAWN, color));
        rank.addPiece(7, Piece.create(Type.PAWN, color));

        return rank;
    }

    public Rank createBlankPieces() {
        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(1, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(2, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(3, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(4, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(5, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(6, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(7, Piece.create(Type.NO_PIECE, Color.NOCOLOR));

        return rank;
    }
}
