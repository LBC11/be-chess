package softeer2nd.chess.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Position;
import softeer2nd.chess.exception.positionException.InvalidBoardBoundException;
import softeer2nd.chess.exception.positionException.InvalidPositionException;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("정상적으로 String 을 이용해 piece 의 위치를 만들어야 한다.")
    void createPosition() {

        Position p1 = Position.of("b5");
        Position p2 = Position.of("b8");
        Position p3 = Position.of("d6");
        Position p4 = Position.of("f4");
        Position p5 = Position.of("h2");

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

    @Test
    @DisplayName("비정상적인 Position 생성은 예외가 방생해야 합니다.")
    void createAbnormalPosition() {

        assertThrows(InvalidPositionException.class, () -> Position.of("b55"));
        assertThrows(InvalidBoardBoundException.class, () -> Position.of("z2"));
    }


    @Test
    @DisplayName("정상적으로 다시 String position 이 반환되어야 한다.")
    void getPositionString() {

        Position p1 = Position.of("b5");
        Position p2 = Position.of("b8");
        Position p3 = Position.of("d6");
        Position p4 = Position.of("f4");
        Position p5 = Position.of("h2");

        assertEquals("b5", p1.getPositionString());
        assertEquals("b8", p2.getPositionString());
        assertEquals("d6", p3.getPositionString());
        assertEquals("f4", p4.getPositionString());
        assertEquals("h2", p5.getPositionString());

    }

    @Test
    @DisplayName("정상적으로 방향이 밪는지 검증해야 한다.")
    void doesPositionMatchAfterMove() {
        Position p1 = Position.of("b6");
        Position p2 = Position.of("b5");
        assertTrue(p1.doesPositionMatchAfterMove(p2, 0, 1));
    }

    @Test
    @DisplayName("유닛 벡터가 정상적으로 생성되야 한다.")
    void generateUnitVector() {
        Position p1 = Position.of("b8");
        Position p2 = Position.of("b5");
        assertEquals(Position.of("a7"), p1.generateUnitVector(p2));
    }

    @Test
    @DisplayName("두 포지션이 정상적으로 더해져야 한다.")
    void moveByAddingPosition() {
        Position p1 = Position.of("b8");
        Position p2 = Position.of("b5");
        assertEquals(Position.of("c5"), p2.moveByAddingPosition(p1));
    }

}