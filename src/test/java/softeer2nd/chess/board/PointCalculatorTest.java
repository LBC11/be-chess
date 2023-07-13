package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;

import static org.junit.jupiter.api.Assertions.*;

class PointCalculatorTest {

    PointCalculator pointCalculator;
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        pointCalculator = new PointCalculator(board);
    }

    @Test
    @DisplayName("하얀색 기물들의 점수가 정상적으로 반환되어야 한다.")
    void calculateWhitePoint() {
        assertEquals(38.0, pointCalculator.calculateWhitePoint());
    }

    @Test
    @DisplayName("검은색 기물들의 점수가 정상적으로 반환되어야 한다.")
    void calculateBlackPoint() {
        assertEquals(38.0, pointCalculator.calculateBlackPoint());
    }

}