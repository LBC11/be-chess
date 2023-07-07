package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("폰이 정상적으로 생성되어야 한다")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN);
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT);
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK);
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP);
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN);
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING);
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING);
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type type) {
        assertEquals(type, piece.getType());
        assertEquals(color, piece.getColor());
    }

}
