package softeer2nd.chess.Board;

import softeer2nd.chess.pieces.Piece;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static softeer2nd.chess.Board.Constants.*;

public class Rank {

    private final List<Piece> pieces;

    public Rank() {
        pieces = new LinkedList<>();
    }

    public String showPieces() {
        StringBuilder ret = new StringBuilder();

        pieces.forEach(piece -> ret.append(piece.getRepresentation()));

        return ret.toString();
    }

    public void addPiece(final int idx, Piece piece) {
        pieces.add(idx, piece);
    }

    public void removePiece(final int idx) {
        pieces.remove(idx);
    }

    public Piece findPiece(final int idx) {
        return pieces.get(idx);
    }

    public int pieceCount(final Type type, final Color color) {
        return (int) pieces.stream()
                .filter(piece -> piece.compare(type, color))
                .count();
    }

    public int allPieceCount() {
        return (int) pieces.stream()
                .filter(piece -> !piece.compare(Type.NO_PIECE, Color.NOCOLOR))
                .count();
    }

    public double calculatePoint(final Color color) {

        return calculatePawnPoint(color) + calculateNonPawnPoint(color);
    }

    private double calculateNonPawnPoint(final Color color) {

        return pieces.stream()
                .filter(piece -> !piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .mapToDouble(Piece::getDefaultPoint)
                .sum();
    }

    private double calculatePawnPoint(final Color color) {

        double pawnCount = pieces.stream()
                .filter(piece -> piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .count();

        return pawnCount > 1 ? pawnCount * DUPLICATE_PAWN_POINT : pawnCount * Type.PAWN.getDefaultPoint();
    }

    public List<Piece> pieceList(final Color color) {
        return pieces.stream()
                .filter(piece -> !piece.isSameType(Type.NO_PIECE))
                .filter(piece -> piece.isSameColor(color))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(pieces, rank.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces);
    }
}
