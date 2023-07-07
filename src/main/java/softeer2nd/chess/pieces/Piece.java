package softeer2nd.chess.pieces;

import softeer2nd.utils.StringUtils;

public class Piece {

    public enum Color {
        WHITE, BLACK, EMPTY
    }


    public enum Type {

        PAWN('p'), KNIGHT('n'), ROOK('r'),
        BISHOP('b'), QUEEN('q'), KING('k'),
        EMPTY('.');

        private final char representation;

        Type(char representation) {

            this.representation = representation;
        }

        public char getRepresentation() {
            return this.representation;
        }
    }

    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {

        this.type = type;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return this.type;
    }

    public char getRepresentation() {

        char representation = this.type.getRepresentation();

        return this.color == Color.BLACK ? StringUtils.Uppercase(representation) : representation;
    }

    public static Piece create(Type type, Color color) {
        return new Piece(type, color);
    }

}
