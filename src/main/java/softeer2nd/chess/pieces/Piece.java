package softeer2nd.chess.pieces;

import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;
import softeer2nd.utils.StringUtils;

import java.util.List;
import java.util.Objects;

import static softeer2nd.chess.Board.Constants.*;

public class Piece {

    private final Type type;
    private final Color color;
    private final List<Direction> directions;

    protected Piece(Type type, Color color, List<Direction> directions) {
        this.type = type;
        this.color = color;
        this.directions = directions;
    }

    public char getRepresentation() {
        char representation = this.type.getRepresentation();
        return this.color == Color.BLACK ? StringUtils.Uppercase(representation) : representation;
    }

    public double getDefaultPoint() {
        return this.type.getDefaultPoint();
    }

    public int getMaxMovement() {
        return this.type.getMaxMovement();
    }

    public boolean isSameColor(final Color color) {
        return this.color.equals(color);
    }

    public boolean isSameColor(final Piece piece) {
        return this.color.equals(piece.color);
    }

    public boolean isSameType(final Type type) {
        return this.type.equals(type);
    }

    public boolean compare(final Type type, final Color color) {
        return this.isSameType(type) && this.isSameColor(color);
    }

    public List<Direction> getDirections() {
        return directions;
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