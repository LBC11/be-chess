package softeer2nd.utils;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {}

    public static String appendNewLine(String s) {
        return s + NEWLINE;
    }

    public static StringBuilder appendNewLine(StringBuilder sb) {
        return sb.append(NEWLINE);
    }
}
