package softeer2nd.chess.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Position;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("정상적으로 String 을 이용해 piece 의 위치를 만들어야 한다.")
    void generatePieceLoc() {

        Position p1 = new Position("b5");
        Position p2 = new Position("b8");
        Position p3 = new Position("d6");
        Position p4 = new Position("f4");
        Position p5 = new Position("h2");

        assertEquals(31, p1.generatePieceLoc());
        assertEquals(1, p2.generatePieceLoc());
        assertEquals(23, p3.generatePieceLoc());
        assertEquals(45, p4.generatePieceLoc());
        assertEquals(67, p5.generatePieceLoc());
    }
}