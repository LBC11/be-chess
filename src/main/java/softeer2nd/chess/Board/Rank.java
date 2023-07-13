package softeer2nd.chess.Board;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.PieceFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Color.*;
import static softeer2nd.chess.Board.Constants.Type.*;

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

    public void addInitPiece(final int idx, final Piece piece) {
        pieces.add(idx, piece);
    }

    public void addPiece(final int idx, final Piece piece) {
        pieces.remove(idx);
        pieces.add(idx, piece);
    }

    public void removePiece(final int idx) {
        pieces.remove(idx);
        pieces.add(idx, PieceFactory.create(NO_PIECE, NOCOLOR));
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
                .filter(piece -> !piece.compare(NO_PIECE, NOCOLOR))
                .count();
    }

    public List<Piece> pieceList(final Color color) {
        return pieces.stream()
                .filter(piece -> !piece.isSameType(NO_PIECE))
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
