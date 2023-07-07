package softeer2nd.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("개행문자가 정상적으로 추가된다.")
    public void appendNewLine() {

        String a = "a";
        String b = "b";
        assertEquals(a + "\n" + b, StringUtils.appendNewLine(a) + b);

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        assertEquals(sb2.append(a).append("\n").append(b).toString(), StringUtils.appendNewLine(sb1.append(a)).append(b).toString());
    }

    @Test
    @DisplayName("정상적으로 소문자에서 대문자가 되어야 한다.")
    public void uppercase() {
        assertEquals('D', StringUtils.Uppercase('d'));
    }

}