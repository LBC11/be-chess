package softeer2nd.chess;

public class Constants {

    public enum Color {
        WHITE, BLACK, NOCOLOR
    }

    public enum Type {

        PAWN('p'), KNIGHT('n'), ROOK('r'),
        BISHOP('b'), QUEEN('q'), KING('k'),
        NO_PIECE('.');

        private final char representation;

        Type(char representation) {

            this.representation = representation;
        }

        public char getRepresentation() {
            return this.representation;
        }
    }
}
