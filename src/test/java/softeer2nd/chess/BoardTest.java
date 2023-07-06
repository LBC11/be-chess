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

    @Test
    @DisplayName("보드판이 정상적으로 출려되어야 합니다.")
    public void print() {
        Board board = new Board();
        board.initialize();

        String s = new StringBuilder()
                .append("........\n")
                .append("PPPPPPPP\n")
                .append("........\n")
                .append("........\n")
                .append("........\n")
                .append("........\n")
                .append("pppppppp\n")
                .append("........\n")
                .toString();

        assertEquals(s, board.print());
    }
}