package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTest {

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    public void verifyColor() {

        Piece whitePawn = Piece.create(Type.PAWN, Color.WHITE);
        Piece BlackPawn = Piece.create(Type.PAWN, Color.BLACK);
        Piece BlankPiece = Piece.create(Type.NO_PIECE, Color.NOCOLOR);

        assertEquals(true, whitePawn.isSameColor(Color.WHITE));
        assertEquals(true, BlackPawn.isSameColor(Color.BLACK));
        assertEquals(true, BlankPiece.isSameColor(Color.NOCOLOR));
    }

    @Test
    @DisplayName("기물의 타입이 정상적으로 검증되어야 한다.")
    public void verifyType() {
        assertEquals(true, Piece.create(Type.PAWN, Color.WHITE).isSameType(Type.PAWN));
        assertEquals(true, Piece.create(Type.KNIGHT, Color.WHITE).isSameType(Type.KNIGHT));
        assertEquals(true, Piece.create(Type.ROOK, Color.WHITE).isSameType(Type.ROOK));
        assertEquals(true, Piece.create(Type.BISHOP, Color.WHITE).isSameType(Type.BISHOP));
        assertEquals(true, Piece.create(Type.QUEEN, Color.WHITE).isSameType(Type.QUEEN));
        assertEquals(true, Piece.create(Type.KING, Color.WHITE).isSameType(Type.KING));
        assertEquals(true, Piece.create(Type.NO_PIECE, Color.WHITE).isSameType(Type.NO_PIECE));
    }

    @Test
    @DisplayName("기물이 정상적으로 비교되어야 한다.")
    public void compare() {
        assertEquals(true, Piece.create(Type.PAWN, Color.WHITE).compare(Type.PAWN, Color.WHITE));
        assertEquals(true, Piece.create(Type.KNIGHT, Color.BLACK).compare(Type.KNIGHT, Color.BLACK));
        assertEquals(true, Piece.create(Type.NO_PIECE, Color.NOCOLOR).compare(Type.NO_PIECE, Color.NOCOLOR));
    }

    @Test
    @DisplayName("색깔에 따라 대문자인지 소문자인지 정확하게 표현되어야 한다.")
    public void getRepresentationPerPiece() throws Exception {

        Piece whitePawn = Piece.create(Type.PAWN, Color.WHITE);
        Piece blackPawn = Piece.create(Type.PAWN, Color.BLACK);

        assertEquals('p', whitePawn.getRepresentation());
        assertEquals('P', blackPawn.getRepresentation());
    }

    @Test
    @DisplayName("기물의 기본점수가 정확하게 표현되어야 한다.")
    public void getDefaultPoint() {

        assertEquals(1.0, Piece.create(Type.PAWN, Color.WHITE).getDefaultPoint());
        assertEquals(2.5, Piece.create(Type.KNIGHT, Color.WHITE).getDefaultPoint());
        assertEquals(5.0, Piece.create(Type.ROOK, Color.WHITE).getDefaultPoint());
        assertEquals(3.0, Piece.create(Type.BISHOP, Color.WHITE).getDefaultPoint());
        assertEquals(9.0, Piece.create(Type.QUEEN, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, Piece.create(Type.KING, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, Piece.create(Type.NO_PIECE, Color.WHITE).getDefaultPoint());
    }
}
