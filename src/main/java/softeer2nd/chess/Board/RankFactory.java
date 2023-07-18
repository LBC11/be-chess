package softeer2nd.chess.Board;

import softeer2nd.chess.pieces.PieceFactory;

import static softeer2nd.chess.Board.Constants.*;

public enum RankFactory {

    INSTANCE(PieceFactory.INSTANCE);
    
    private final PieceFactory pieceFactory;

    RankFactory(PieceFactory pieceFactory) {
        this.pieceFactory = pieceFactory;
    }

    public Rank createNonPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.ROOK, color));
        rank.addInitPiece(1, pieceFactory.create(Type.KNIGHT, color));
        rank.addInitPiece(2, pieceFactory.create(Type.BISHOP, color));
        rank.addInitPiece(3, pieceFactory.create(Type.QUEEN, color));
        rank.addInitPiece(4, pieceFactory.create(Type.KING, color));
        rank.addInitPiece(5, pieceFactory.create(Type.BISHOP, color));
        rank.addInitPiece(6, pieceFactory.create(Type.KNIGHT, color));
        rank.addInitPiece(7, pieceFactory.create(Type.ROOK, color));

        return rank;
    }

    public Rank createPawnPieces(Color color) {
        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(1, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(2, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(3, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(4, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(5, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(6, pieceFactory.create(Type.PAWN, color));
        rank.addInitPiece(7, pieceFactory.create(Type.PAWN, color));

        return rank;
    }

    public Rank createBlankPieces() {
        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(1, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(2, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(3, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(4, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(5, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(6, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(7, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));

        return rank;
    }
}
