package softeer2nd.chess.Board;

import softeer2nd.chess.pieces.PieceFactory;

import static softeer2nd.chess.Board.Constants.*;

public enum RankFactory {
    INSTANCE;

    public Rank createNonPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addInitPiece(0, PieceFactory.create(Type.ROOK, color));
        rank.addInitPiece(1, PieceFactory.create(Type.KNIGHT, color));
        rank.addInitPiece(2, PieceFactory.create(Type.BISHOP, color));
        rank.addInitPiece(3, PieceFactory.create(Type.QUEEN, color));
        rank.addInitPiece(4, PieceFactory.create(Type.KING, color));
        rank.addInitPiece(5, PieceFactory.create(Type.BISHOP, color));
        rank.addInitPiece(6, PieceFactory.create(Type.KNIGHT, color));
        rank.addInitPiece(7, PieceFactory.create(Type.ROOK, color));

        return rank;
    }

    public Rank createPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addInitPiece(0, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(1, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(2, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(3, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(4, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(5, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(6, PieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(7, PieceFactory.create(Type.PAWN, color));

        return rank;
    }

    public Rank createBlankPieces() {
        Rank rank = new Rank();

        rank.addInitPiece(0, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(1, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(2, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(3, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(4, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(5, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(6, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(7, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));

        return rank;
    }
}
