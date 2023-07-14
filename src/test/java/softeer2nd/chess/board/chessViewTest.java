package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;
import softeer2nd.chess.Board.chessView;

class chessViewTest {

    chessView chessView;
    Board board;
    PointCalculator pointCalculator;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        pointCalculator = new PointCalculator(board);
        chessView = new chessView(board, pointCalculator);
    }

    @Test
    @DisplayName("보드판이 정상적으로 반환되어야 한다.")
    void showBoard() {
        chessView.showBoard();
    }

    @Test
    @DisplayName("보드판이 정상적으로 반환되어야 한다.")
    void showPoint() {
        chessView.showPoint();
    }


}