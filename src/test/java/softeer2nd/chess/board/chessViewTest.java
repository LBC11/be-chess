package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;
import softeer2nd.chess.Board.ChessView;

class chessViewTest {

    ChessView chessView;
    Board board;
    PointCalculator pointCalculator;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        pointCalculator = new PointCalculator(board);
        chessView = new ChessView(board, pointCalculator);
    }
}