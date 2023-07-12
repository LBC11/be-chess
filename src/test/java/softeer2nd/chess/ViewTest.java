package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static softeer2nd.utils.StringUtils.appendNewLine;

class ViewTest {

    View view;
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        view = new View(board);
    }

    @Test
    @DisplayName("보드판이 정상적으로 반환되어야 한다.")
    void showBoard() throws Exception {
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                view.showBoard());
    }
}