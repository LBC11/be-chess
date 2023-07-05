package softeer2nd.chess.object;

public class Pawn {

    public final String WHITE_COLOR = "white";
    public final String BLACK_COLOR = "black";

    String color = WHITE_COLOR;

    public Pawn() {
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
