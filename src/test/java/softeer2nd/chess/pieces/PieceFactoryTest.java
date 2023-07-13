package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.InvalidPieceFieldException;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Board.Constants.*;

class PieceFactoryTest {
    
    @Test
    @DisplayName("기물이 정상적으로 생성되어야 한다.")
    void create() {

        assertTrue(PieceFactory.create(Type.PAWN, Color.WHITE).compare(Type.PAWN, Color.WHITE));
        assertTrue(PieceFactory.create(Type.KNIGHT, Color.WHITE).compare(Type.KNIGHT, Color.WHITE));
        assertTrue(PieceFactory.create(Type.ROOK, Color.WHITE).compare(Type.ROOK, Color.WHITE));
        assertTrue(PieceFactory.create(Type.BISHOP, Color.WHITE).compare(Type.BISHOP, Color.WHITE));
        assertTrue(PieceFactory.create(Type.QUEEN, Color.WHITE).compare(Type.QUEEN, Color.WHITE));
        assertTrue(PieceFactory.create(Type.KING, Color.WHITE).compare(Type.KING, Color.WHITE));
        assertTrue(PieceFactory.create(Type.NO_PIECE, Color.WHITE).compare(Type.NO_PIECE, Color.WHITE));
    }

    @Test
    @DisplayName("기물의 필드가 정상적이지 않을 떄 예외가 발생해야 한다.")
    void abNormalCreate() {

        assertThrows(InvalidPieceFieldException.class, () -> 
                PieceFactory.create(Type.NO_PIECE, Color.WHITE));
        assertThrows(InvalidPieceFieldException.class, () ->
                PieceFactory.create(Type.PAWN, Color.NOCOLOR));
    }
}