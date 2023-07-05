package softeer2nd.cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator cal;

    @BeforeEach
    public void init() {
        cal = new Calculator();
    }

    @Test
    @DisplayName("사칙연산이 정상적으로 실행됩니다.")
    public void calculate() {
        assertEquals("10", cal.cal("2 + 3 * 4 / 2"));
    }
}
