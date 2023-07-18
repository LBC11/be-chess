package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceTest {
    
    PieceFactory pieceFactory;

    @BeforeEach
    void setup() {
        pieceFactory = PieceFactory.INSTANCE;
    }

    @Test
    @DisplayName("기물의 색깔이 정상적으로 검증되어야 한다.")
    void verifyColor() {

        Piece whitePawn = pieceFactory.create(Type.PAWN, Color.WHITE);
        Piece BlackPawn = pieceFactory.create(Type.PAWN, Color.BLACK);
        Piece BlankPiece = pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR);

        assertTrue(whitePawn.isSameColor(Color.WHITE));
        assertTrue(BlackPawn.isSameColor(Color.BLACK));
        assertTrue(BlankPiece.isSameColor(Color.NOCOLOR));
    }

    @Test
    @DisplayName("기물의 타입이 정상적으로 검증되어야 한다.")
    void verifyType() {
        assertTrue(pieceFactory.create(Type.PAWN, Color.WHITE).isSameType(Type.PAWN));
        assertTrue(pieceFactory.create(Type.KNIGHT, Color.WHITE).isSameType(Type.KNIGHT));
        assertTrue(pieceFactory.create(Type.ROOK, Color.WHITE).isSameType(Type.ROOK));
        assertTrue(pieceFactory.create(Type.BISHOP, Color.WHITE).isSameType(Type.BISHOP));
        assertTrue(pieceFactory.create(Type.QUEEN, Color.WHITE).isSameType(Type.QUEEN));
        assertTrue(pieceFactory.create(Type.KING, Color.WHITE).isSameType(Type.KING));
        assertTrue(pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).isSameType(Type.NO_PIECE));
    }

    @Test
    @DisplayName("기물이 정상적으로 비교되어야 한다.")
    void compare() {
        assertTrue(pieceFactory.create(Type.PAWN, Color.WHITE).compare(Type.PAWN, Color.WHITE));
        assertTrue(pieceFactory.create(Type.KNIGHT, Color.BLACK).compare(Type.KNIGHT, Color.BLACK));
        assertTrue(pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).compare(Type.NO_PIECE, Color.NOCOLOR));
    }

    @Test
    @DisplayName("색깔에 따라 대문자인지 소문자인지 정확하게 표현되어야 한다.")
    void getRepresentationPerPiece() {

        Piece whitePawn = pieceFactory.create(Type.PAWN, Color.WHITE);
        Piece blackPawn = pieceFactory.create(Type.PAWN, Color.BLACK);

        assertEquals('p', whitePawn.getRepresentation());
        assertEquals('P', blackPawn.getRepresentation());
    }

    @Test
    @DisplayName("기물의 기본점수가 정확하게 표현되어야 한다.")
    void getDefaultPoint() {

        assertEquals(1.0, pieceFactory.create(Type.PAWN, Color.WHITE).getDefaultPoint());
        assertEquals(2.5, pieceFactory.create(Type.KNIGHT, Color.WHITE).getDefaultPoint());
        assertEquals(5.0, pieceFactory.create(Type.ROOK, Color.WHITE).getDefaultPoint());
        assertEquals(3.0, pieceFactory.create(Type.BISHOP, Color.WHITE).getDefaultPoint());
        assertEquals(9.0, pieceFactory.create(Type.QUEEN, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, pieceFactory.create(Type.KING, Color.WHITE).getDefaultPoint());
        assertEquals(0.0, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR).getDefaultPoint());
    }
}
