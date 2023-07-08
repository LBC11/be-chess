package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("기물이 정상적으로 생성되어야 한다")
    public void create_piece() {
        verifyPiece(Piece.create(Piece.Type.PAWN, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.PAWN);
        verifyPiece(Piece.create(Piece.Type.PAWN, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.PAWN);
        verifyPiece(Piece.create(Piece.Type.KNIGHT, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.KNIGHT);
        verifyPiece(Piece.create(Piece.Type.KNIGHT, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.KNIGHT);
        verifyPiece(Piece.create(Piece.Type.ROOK, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.ROOK);
        verifyPiece(Piece.create(Piece.Type.ROOK, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.ROOK);
        verifyPiece(Piece.create(Piece.Type.BISHOP, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.BISHOP);
        verifyPiece(Piece.create(Piece.Type.BISHOP, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.BISHOP);
        verifyPiece(Piece.create(Piece.Type.QUEEN, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.QUEEN);
        verifyPiece(Piece.create(Piece.Type.QUEEN, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.QUEEN);
        verifyPiece(Piece.create(Piece.Type.KING, Piece.Color.WHITE), Piece.Color.WHITE, Piece.Type.KING);
        verifyPiece(Piece.create(Piece.Type.KING, Piece.Color.BLACK), Piece.Color.BLACK, Piece.Type.KING);

    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final Piece.Type type) {
        assertEquals(type, piece.getType());
        assertEquals(true, color == Piece.Color.WHITE ? piece.isWhite() : piece.isBlack());
    }

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    public void colorCheck() {

        Piece whitePawn = Piece.create(Piece.Type.PAWN, Piece.Color.WHITE);
        Piece blackPawn = Piece.create(Piece.Type.PAWN, Piece.Color.BLACK);

        assertEquals(true, whitePawn.isWhite());
        assertEquals(false, whitePawn.isBlack());
        assertEquals(true, blackPawn.isBlack());
        assertEquals(false, blackPawn.isWhite());
    }
}
