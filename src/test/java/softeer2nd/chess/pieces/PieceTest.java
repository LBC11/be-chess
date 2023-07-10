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

        assertEquals(Color.WHITE, whitePawn.getColor());
        assertEquals(Color.BLACK, BlackPawn.getColor());
        assertEquals(Color.NOCOLOR, BlankPiece.getColor());
    }

    @Test
    @DisplayName("기물의 타입이 정상적으로 검증되어야 한다.")
    public void verifyType() {
        assertEquals(Type.PAWN, Piece.create(Type.PAWN, Color.WHITE).getColor());
        assertEquals(Type.KNIGHT, Piece.create(Type.KNIGHT, Color.WHITE).getColor());
        assertEquals(Type.ROOK, Piece.create(Type.ROOK, Color.WHITE).getColor());
        assertEquals(Type.BISHOP, Piece.create(Type.BISHOP, Color.WHITE).getColor());
        assertEquals(Type.QUEEN, Piece.create(Type.QUEEN, Color.WHITE).getColor());
        assertEquals(Type.KING, Piece.create(Type.KING, Color.WHITE).getColor());
        assertEquals(Type.NO_PIECE, Piece.create(Type.NO_PIECE, Color.WHITE).getColor());
    }

    @Test
    @DisplayName("색깔에 따라 대문자인지 소문자인지 정화가하게 표현되어야 한다.")
    public void getRepresentationPerPiece() throws Exception {

        Piece whitePawn = Piece.create(Type.PAWN, Color.WHITE);
        Piece blackPawn = Piece.create(Type.PAWN, Color.WHITE);

        assertEquals('p', whitePawn.getRepresentation());
        assertEquals('P', blackPawn.getRepresentation());
    }
}
