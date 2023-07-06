package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("Pawn 에 변수를 주지 않아도 정상적으로 하얀색 pawn 이 생성되어야 합니다. ")
    public void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE_COLOR, piece.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, piece.getRepresentation());
    }

    @Test
    @DisplayName("폰이 정상적으로 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

}
