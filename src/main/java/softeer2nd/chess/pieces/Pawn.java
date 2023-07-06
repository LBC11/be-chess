package softeer2nd.chess.pieces;

public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String EMPTY_COLOR = "empty";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char EMPTY_REPRESENTATION = 'e';

    String color = WHITE_COLOR;
    char representation = WHITE_REPRESENTATION;

    public Pawn() {
    }

    public Pawn(String color, char representation) {

        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.representation;
    }
}
