package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceTest {

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    void verifyColor() {

        Piece whitePawn = PieceFactory.create(Type.PAWN, Color.WHITE);
        Piece BlackPawn = PieceFactory.create(Type.PAWN, Color.BLACK);
        Piece BlankPiece = PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR);

        assertTrue(whitePawn.isSameColor(Color.WHITE));
        assertTrue(BlackPawn.isSameColor(Color.BLACK));
        assertTrue(BlankPiece.isSameColor(Color.NOCOLOR));
    }

    @Test
    @DisplayName("기물의 타입이 정상적으로 검증되어야 한다.")
    void verifyType() {
        assertTrue(PieceFactory.create(Type.PAWN, Color.WHITE).isSameType(Type.PAWN));
        assertTrue(PieceFactory.create(Type.KNIGHT, Color.WHITE).isSameType(Type.KNIGHT));
        assertTrue(PieceFactory.create(Type.ROOK, Color.WHITE).isSameType(Type.ROOK));
        assertTrue(PieceFactory.create(Type.BISHOP, Color.WHITE).isSameType(Type.BISHOP));
        assertTrue(PieceFactory.create(Type.QUEEN, Color.WHITE).isSameType(Type.QUEEN));
        assertTrue(PieceFactory.create(Type.KING, Color.WHITE).isSameType(Type.KING));
        assertTrue(PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).isSameType(Type.NO_PIECE));
    }

    @Test
    @DisplayName("기물이 정상적으로 비교되어야 한다.")
    void compare() {
        assertTrue(PieceFactory.create(Type.PAWN, Color.WHITE).compare(Type.PAWN, Color.WHITE));
        assertTrue(PieceFactory.create(Type.KNIGHT, Color.BLACK).compare(Type.KNIGHT, Color.BLACK));
        assertTrue(PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).compare(Type.NO_PIECE, Color.NOCOLOR));
    }

    @Test
    @DisplayName("색깔에 따라 대문자인지 소문자인지 정확하게 표현되어야 한다.")
    void getRepresentationPerPiece() {

        Piece whitePawn = PieceFactory.create(Type.PAWN, Color.WHITE);
        Piece blackPawn = PieceFactory.create(Type.PAWN, Color.BLACK);

        assertEquals('p', whitePawn.getRepresentation());
        assertEquals('P', blackPawn.getRepresentation());
    }

    @Test
    @DisplayName("기물의 기본점수가 정확하게 표현되어야 한다.")
    void getDefaultPoint() {

        assertEquals(1.0, PieceFactory.create(Type.PAWN, Color.WHITE).getDefaultPoint());
        assertEquals(2.5, PieceFactory.create(Type.KNIGHT, Color.WHITE).getDefaultPoint());
        assertEquals(5.0, PieceFactory.create(Type.ROOK, Color.WHITE).getDefaultPoint());
        assertEquals(3.0, PieceFactory.create(Type.BISHOP, Color.WHITE).getDefaultPoint());
        assertEquals(9.0, PieceFactory.create(Type.QUEEN, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, PieceFactory.create(Type.KING, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, PieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).getDefaultPoint());
    }
}
