package softeer2nd.chess.pieces;

import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;
import softeer2nd.chess.Board.Constants.SortOrder;
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

    public double getDefaultPoint() {
        return this.type.getDefaultPoint();
    }

    public boolean isSameColor(final Color color) {
        return this.color.equals(color);
    }

    public boolean isSameType(final Type type) {
        return this.type.equals(type);
    }

    public boolean compare(final Type type, final Color color) {
        return this.isSameType(type) && this.isSameColor(color);
    }

    public static class PieceComparator implements Comparator<Piece> {

        private final SortOrder sortOrder;

        public PieceComparator(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
        }

        @Override
        public int compare(final Piece o1, final Piece o2) {

            int result = (int) (o1.type.getDefaultPoint() - o2.type.getDefaultPoint());

            return sortOrder == SortOrder.ASCENDING ? result : -result;
        }
    }

    @Override
    public boolean equals(final Object o) {
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
