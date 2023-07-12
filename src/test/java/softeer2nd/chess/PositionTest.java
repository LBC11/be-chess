package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;

    @BeforeEach
    void setup() {
        position = new Position();
    }

    @Test
    @DisplayName("정상적으로 String 을 이용해 piece 의 위치를 만들어야 한다.")
    void generatePieceLoc() {
        assertEquals(31, position.generatePieceLoc("b5"));
        assertEquals(1, position.generatePieceLoc("b8"));
        assertEquals(23, position.generatePieceLoc("d6"));
        assertEquals(45, position.generatePieceLoc("f4"));
        assertEquals(67, position.generatePieceLoc("h2"));
    }
}