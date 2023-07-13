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

        assertEquals(1, p1.getXPos());
        assertEquals(3, p1.getYPos());
        assertEquals(1, p2.getXPos());
        assertEquals(0, p2.getYPos());
        assertEquals(3, p3.getXPos());
        assertEquals(2, p3.getYPos());
        assertEquals(5, p4.getXPos());
        assertEquals(4, p4.getYPos());
        assertEquals(7, p5.getXPos());
        assertEquals(6, p5.getYPos());
    }
}