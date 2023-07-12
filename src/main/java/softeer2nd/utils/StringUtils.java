package softeer2nd.utils;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {}

    public static String appendNewLine(final String s) {
        return s + NEWLINE;
    }

    public static StringBuilder appendNewLine(final StringBuilder sb) {
        return sb.append(NEWLINE);
    }

    public static char Uppercase(final char c) {
        return (char) (c - ('a' - 'A'));
    }
}
