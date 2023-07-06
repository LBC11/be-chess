package softeer2nd.chess;

import static org.junit.Assert.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    @DisplayName("board 가 정상적으로 생성되어야 한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}