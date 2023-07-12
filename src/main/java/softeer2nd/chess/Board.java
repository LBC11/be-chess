package softeer2nd.chess;


import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;
import softeer2nd.chess.Constants.SortOrder;
import softeer2nd.chess.Constants.BoardConfig;

import softeer2nd.chess.pieces.Piece;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private final int ROW_LENGTH = BoardConfig.ROW_LENGTH.getValue();
    private final int COLUMN_LENGTH = BoardConfig.COLUMN_LENGTH.getValue();
    private final int KEY_GENERATION_MULTIPLIER = BoardConfig.KEY_GENERATION_MULTIPLIER.getValue();
    private final int WHITE_NON_PAWN_PIECES_INIT_ROW = 7;
    private final int WHITE_PAWN_INIT_ROW = 6;
    private final int BLACK_NON_PAWN_PIECES_INIT_ROW = 0;
    private final int BLACK_PAWN_INIT_ROW = 1;
    private final int FIRST_ROOK_INIT_COL = 0;
    private final int FIRST_KNIGHT_INIT_COL = 1;
    private final int FIRST_BISHOP_INIT_COL = 2;
    private final int QUEEN_INIT_COL = 3;
    private final int KING_INIT_COL = 4;
    private final int SECOND_BISHOP_INIT_COL = 5;
    private final int SECOND_KNIGHT_INIT_COL = 6;
    private final int SECOND_ROOK_INIT_COL = 7;

    // key: row_idx * 10 + col_idx value: Pawn 객체
    private Map<Integer, Piece> map;

    public Board() {
    }

    public void initialize() {

        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(this::addInitPieces);
    }

    public void initializeEmpty() {
        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(row -> fillRowWithPieces(row, Type.NO_PIECE, Color.NOCOLOR));
    }

    private void addInitPieces(final int row) {
        if (row == WHITE_PAWN_INIT_ROW) {
            fillRowWithPieces(row, Type.PAWN, Color.WHITE);
        } else if (row == WHITE_NON_PAWN_PIECES_INIT_ROW) {
            fillRowWithNonPawnPieces(row, Color.WHITE);
        } else if (row == BLACK_PAWN_INIT_ROW) {
            fillRowWithPieces(row, Type.PAWN, Color.BLACK);
        } else if (row == BLACK_NON_PAWN_PIECES_INIT_ROW) {
            fillRowWithNonPawnPieces(row, Color.BLACK);
        } else {
            fillRowWithPieces(row, Type.NO_PIECE, Color.NOCOLOR);
        }
    }

    private void fillRowWithPieces(final int row, final Type type, final Color color) {
        IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(type, color)));
    }

    private void fillRowWithNonPawnPieces(final int row, Color color) {

        map.put(row * KEY_GENERATION_MULTIPLIER + FIRST_ROOK_INIT_COL, Piece.create(Type.ROOK, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + FIRST_KNIGHT_INIT_COL, Piece.create(Type.KNIGHT, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + FIRST_BISHOP_INIT_COL, Piece.create(Type.BISHOP, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + QUEEN_INIT_COL, Piece.create(Type.QUEEN, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + KING_INIT_COL, Piece.create(Type.KING, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + SECOND_BISHOP_INIT_COL, Piece.create(Type.BISHOP, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + SECOND_KNIGHT_INIT_COL, Piece.create(Type.KNIGHT, color));
        map.put(row * KEY_GENERATION_MULTIPLIER + SECOND_ROOK_INIT_COL, Piece.create(Type.ROOK, color));

    }

    public int pieceCount(final Type type, final Color color) {
        return (int) map.values().stream()
                .filter(piece -> piece.compare(type, color))
                .count();
    }

    public int allPiecesCount() {
        return (int) map.values().stream()
                .filter(piece -> !piece.isSameType(Type.NO_PIECE))
                .count();
    }

    public Piece findPiece(final int loc) {

        return map.get(loc);
    }

    public void move(final int loc, final Piece piece) {

        map.put(loc, piece);
    }

    public double calculatePoint(final Color color) {

        return IntStream.range(0, COLUMN_LENGTH)
                .mapToDouble(col -> calculateColPoint(col, color)).sum();
    }

    /*
    각 col 의 piece 를 순회하면서 점수를 계산한다.
    만약, 한 col 에 두 개 이상의 pawn 이 있다면 pawn 의 점수를 반으로 줄인다.
     */
    private double calculateColPoint(final int col, final Color color) {

        double nonPawnPointSum = IntStream.range(0, ROW_LENGTH)
                .mapToObj(row -> map.get(row * KEY_GENERATION_MULTIPLIER + col))
                .filter(piece -> !piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .mapToDouble(Piece::getDefaultPoint)
                .sum();

        double pawnPointSum = IntStream.range(0, ROW_LENGTH)
                .mapToObj(row -> map.get(row * KEY_GENERATION_MULTIPLIER + col))
                .filter(piece -> piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .mapToDouble(Piece::getDefaultPoint)
                .sum();

        return pawnPointSum > 1 ? nonPawnPointSum + pawnPointSum / 2 : nonPawnPointSum + pawnPointSum;
    }

    public List<Piece> SortByPointAscending(final Color color) {
        return sortByPoint(color, SortOrder.ASCENDING);
    }

    public List<Piece> SortByPointDescending(final Color color) {
        return sortByPoint(color, SortOrder.DESCENDING);
    }

    private List<Piece> sortByPoint(final Color color, final SortOrder sortOrder) {
        return map.values().stream()
                .filter(piece -> !piece.isSameType(Type.NO_PIECE))
                .filter(piece -> piece.isSameColor(color))
                .sorted(new Piece.PieceComparator(sortOrder))
                .collect(Collectors.toList());
    }
}
