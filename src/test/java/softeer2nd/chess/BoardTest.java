package softeer2nd.chess;

import static org.junit.Assert.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

public class BoardTest {
    Board board;
    Pawn white;
    Pawn black;
    int size;

    @BeforeEach
    public void init() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
        size = 0;
    }
    @Test
    @DisplayName("board 가 정상적으로 생성되어야 한다.")
    public void create() throws Exception {

        verifyBoard(white);
        verifyBoard(black);
    }

    private void verifyBoard(Pawn pawn) {
        board.add(pawn);
        assertEquals(++size, board.size());
        assertEquals(pawn, board.findPawn(size - 1));
    }
}