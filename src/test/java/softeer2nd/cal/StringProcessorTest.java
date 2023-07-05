package softeer2nd.cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringProcessorTest {

    StringProcessor processor;
    
    @BeforeEach
    public void init() {
        processor = new StringProcessor();
    }

    @Test
    @DisplayName("문자열이 정상적으로 처리되어야 한다.")
    public void manipulate() {
        assertEquals(true, Arrays.equals(new String[]{"2", "+", "3", "*", "4", "/", "2"}, processor.manipulate("2 + 3 * 4 / 2")));
    }

    @Test
    @DisplayName("식이 정상적인지 정확하게 확인해야 한다.")
    public void isRightSentence() {
        assertEquals(true, processor.isRightSentence(new String[]{"2", "+", "3", "*", "4", "/", "2"}));
    }

}