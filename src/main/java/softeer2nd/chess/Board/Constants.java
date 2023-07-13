package softeer2nd.chess.Board;

public class Constants {

    public static final int ROW_LENGTH = 8;
    public static final int COLUMN_LENGTH = 8;
    public static final int KEY_GENERATION_MULTIPLIER = 10;
    public static final double DUPLICATE_PAWN_POINT = 0.5;


    public enum Color {
        WHITE, BLACK, NOCOLOR
    }

    public enum Type {

        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        ROOK('r', 5.0),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {

            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getRepresentation() {
            return this.representation;
        }

        public double getDefaultPoint() {
            return this.defaultPoint;
        }
    }

    public enum SortOrder {ASCENDING, DESCENDING}
}
