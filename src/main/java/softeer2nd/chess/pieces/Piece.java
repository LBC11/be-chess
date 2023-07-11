package softeer2nd.chess.pieces;

import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;
import softeer2nd.chess.Constants.SortOrder;
import softeer2nd.utils.StringUtils;

import java.util.Comparator;
import java.util.Objects;

public class Piece {

    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {

        this.type = type;
        this.color = color;
    }

    public char getRepresentation() {

        char representation = this.type.getRepresentation();

        return this.color == Color.BLACK ? StringUtils.Uppercase(representation) : representation;
    }

    public static Piece create(final Type type, final Color color) {
        return new Piece(type, color);
    }

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isSameColor(final Color color) {
        return this.color.equals(color);
    }

    public boolean isPawn() {
        return this.type.equals(Type.PAWN);
    }

    public static class PieceComparator implements Comparator<Piece> {

        private final SortOrder sortOrder;

        public PieceComparator(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
        }

        @Override
        public int compare(Piece o1, Piece o2) {

            int result = (int) (o1.getType().getDefaultPoint() - o2.getType().getDefaultPoint());

            return sortOrder == SortOrder.ASCENDING ? result : -result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type == piece.type && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }
}
