package softeer2nd.cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

    Operator operator;

    @BeforeEach
    public void init() {
        operator = new Operator();
    }

    @Test
    @DisplayName("더하기가 정상적으로 실행되어야 한다.")
    public void add() {
        assertEquals(5, operator.add(2, 3));
    }

    @Test
    @DisplayName("뺴기가 정상적으로 실행되어야 한다.")
    public void minus() {
        assertEquals(2, operator.min(5, 3));
    }

    @Test
    @DisplayName("곱하기가 정상적으로 실행되어야 한다.")
    public void multiply() {
        assertEquals(20, operator.mul(5, 4));
    }

    @Test
    @DisplayName("나누기가 정상적으로 실행되어야 한다.")
    public void divide() {
        assertEquals(10, operator.div(20, 2));
    }
}
