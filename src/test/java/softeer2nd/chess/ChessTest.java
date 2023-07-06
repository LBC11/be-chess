package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    Chess chess;

    @BeforeEach
    public void init() {
        chess = new Chess();
        chess.init();
    }

    @Test
    @DisplayName("게임이 정상적으로 실행되어야 한다.")
    public void start() {

        assertEquals(chess.start(), "게임이 시작되었습니다.");
        assertEquals(chess.start(), "이미 게임중입니다.");
    }

    @Test
    @DisplayName("게임이 정상적으로 종료되어야 한다.")
    public void end() {

        assertEquals(chess.end(), "게임를 하고 있지 않습니다.");
        assertEquals(chess.start(), "게임이 시작되었습니다.");
        assertEquals(chess.end(), "게임이 종료되었습니다.");
    }
}