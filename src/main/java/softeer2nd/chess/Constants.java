package softeer2nd.chess;

public class Constants {

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

    public enum BoardConfig {

        COLUMN_LENGTH(8),
        ROW_LENGTH(8),
        KEY_GENERATION_MULTIPLIER(10);

        private final int value;

        BoardConfig(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
