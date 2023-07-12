package softeer2nd.chess;

public class Position {

    private final int KEY_GENERATION_MULTIPLIER = 10;
    private final int ROW_LENGTH = 8;

    public int generatePieceLoc(String position) {


        int row = ROW_LENGTH - (position.charAt(1) - '0');
        int col = position.charAt(0) - 'a';
        
        return KEY_GENERATION_MULTIPLIER * row + col;
    }
}
