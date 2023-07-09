package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    public void verifyColor() {

        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();

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
        verifyPawnType(Piece.createWhitePawn());
        verifyKnightType(Piece.createWhiteKnight());
        verifyRookType(Piece.createWhiteRook());
        verifyBishopType(Piece.createWhiteBishop());
        verifyQueenType(Piece.createWhiteQueen());
        verifyKingType(Piece.createWhiteKing());
        verifyNoPieceType(Piece.createNoPiece());
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

    private void verifyNoPieceType(Piece piece) {
        assertEquals(true, piece.isNoPiece());
    }

    @Test
    @DisplayName("색깔에 따라 대문자인지 소문자인지 정화가하게 표현되어야 한다.")
    public void getRepresentationPerPiece() throws Exception {

        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();

        assertEquals('p', whitePawn.getRepresentation());
        assertEquals('P', blackPawn.getRepresentation());
    }
}
