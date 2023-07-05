package softeer2nd.chess.object;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("폰이 정상적으로 생성되어야 한다")
    public void create() {

        String color = "white";
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);

        color = "black";
        pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo("black");
    }

    @Test
    @DisplayName("중복 제거")
    public void create2() {
        assertThat(verifyPawn("white")).isEqualTo(true);
        assertThat(verifyPawn("black")).isEqualTo(true);
    }

    private boolean verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        return pawn.getColor().equals(color);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}
