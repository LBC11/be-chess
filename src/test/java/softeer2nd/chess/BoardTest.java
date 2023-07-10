package softeer2nd.chess;

import static org.junit.Assert.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    Board board;

    @BeforeEach
    public void setup() {

        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("board 가 정상적으로 생성되어야 한다.")
    public void create() throws Exception {
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.print());
    }

    @Test
    @DisplayName("board의 piece 개수가 정상적으로 반환된다.")
    public void pieceTypeColorCount() {

        assertEquals(8, board.blackPawnCount());
        assertEquals(8, board.whitePawnCount());
        assertEquals(2, board.blackKnightCount());
        assertEquals(2, board.whiteKnightCount());
        assertEquals(2, board.blackRookCount());
        assertEquals(2, board.whiteRookCount());
        assertEquals(2, board.blackBishopCount());
        assertEquals(2, board.whiteBishopCount());
        assertEquals(1, board.blackQueenCount());
        assertEquals(1, board.whiteQueenCount());
        assertEquals(1, board.blackKingCount());
        assertEquals(1, board.whiteKingCount());

    }
}