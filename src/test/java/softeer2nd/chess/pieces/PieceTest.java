package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    public void verifyColor() {

        Piece whitePawn = Piece.create(Piece.Type.PAWN, Piece.Color.WHITE);
        Piece blackPawn = Piece.create(Piece.Type.PAWN, Piece.Color.BLACK);

        verifyWhiteColor(whitePawn);
        verifyBlackColor(blackPawn);
    }

    private void verifyWhiteColor(Piece piece) {
        assertEquals(true, piece.isWhite());
    }

    private void verifyBlackColor(Piece piece) {
        assertEquals(true, piece.isBlack());
    }

    @Test
    @DisplayName("기물의 타입이 정상적으로 검증되어야 한다.")
    public void verifyType() {
        verifyPawnType(Piece.create(Piece.Type.PAWN, Piece.Color.WHITE));
        verifyKnightType(Piece.create(Piece.Type.KNIGHT, Piece.Color.WHITE));
        verifyRookType(Piece.create(Piece.Type.ROOK, Piece.Color.WHITE));
        verifyBishopType(Piece.create(Piece.Type.BISHOP, Piece.Color.WHITE));
        verifyQueenType(Piece.create(Piece.Type.QUEEN, Piece.Color.WHITE));
        verifyKingType(Piece.create(Piece.Type.KING, Piece.Color.WHITE));
    }

    private void verifyPawnType(Piece piece) {
        assertEquals(true, piece.isPawn());
    }

    private void verifyKnightType(Piece piece) {
        assertEquals(true, piece.isKnight());
    }

    private void verifyRookType(Piece piece) {
        assertEquals(true, piece.isRook());
    }

    private void verifyBishopType(Piece piece) {
        assertEquals(true, piece.isBishop());
    }

    private void verifyQueenType(Piece piece) {
        assertEquals(true, piece.isQueen());
    }
    private void verifyKingType(Piece piece) {
        assertEquals(true, piece.isKing());
    }
}
