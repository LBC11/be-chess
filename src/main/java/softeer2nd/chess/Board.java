package softeer2nd.chess;


import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;
import softeer2nd.chess.Constants.SortOrder;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {


    private final int ROW_LENGTH = 8;
    private final int COLUMN_LENGTH = 8;
    private final int KEY_GENERATION_MULTIPLIER = 10;
    private final int WHITE_NON_PAWN_PIECES_INIT_ROW = 7;
    private final int WHITE_PAWN_INIT_ROW = 6;
    private final int BLACK_NON_PAWN_PIECES_INIT_ROW = 0;
    private final int BLACK_PAWN_INIT_ROW = 1;

    // key: row_idx * 10 + col_idx value: Pawn 객체
    private Map<Integer, Piece> map;

    // 현재 보드 위에 있는 기물들
    private List<Piece> nonPawnPieces;

    public Board() {
    }

    /*
        pieceList
        - 초기 기물들을 색깔별로 더해준다.
        
        map 초기화
        - row 가 1이면 white pawn, row 가 6이면 black pawn, 그 외는 empty pawn 으로 채운다.
     */
    public void initialize() {

        nonPawnPiecesListInit();

        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(this::addInitPiecesToMap);
    }

    public void initializeEmpty() {
        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(this::addInitBlankPiecesToMap);
    }

    private void nonPawnPiecesListInit() {
        nonPawnPieces = new ArrayList<>();
        nonPawnPieces.add(Piece.create(Type.ROOK, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.KNIGHT, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.BISHOP, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.QUEEN, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.KING, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.BISHOP, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.KNIGHT, Color.NOCOLOR));
        nonPawnPieces.add(Piece.create(Type.ROOK, Color.NOCOLOR));

        nonPawnPieces = Collections.unmodifiableList(nonPawnPieces);
    }

    private void addInitPiecesToMap(final int row) {
        if (row == WHITE_PAWN_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(Type.PAWN, Color.WHITE)));
        } else if (row == WHITE_NON_PAWN_PIECES_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(nonPawnPieces.get(col).getType(), Color.WHITE)));
        } else if (row == BLACK_PAWN_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(Type.PAWN, Color.BLACK)));
        } else if (row == BLACK_NON_PAWN_PIECES_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(nonPawnPieces.get(col).getType(), Color.BLACK)));
        } else {
            addInitBlankPiecesToMap(row);
        }
    }

    private void addInitBlankPiecesToMap(final int row) {
        IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.create(Type.NO_PIECE, Color.NOCOLOR)));
    }

    public String showBoard() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_LENGTH).forEach(row -> {
            IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                    ret.append(map.get(row * KEY_GENERATION_MULTIPLIER + col).getRepresentation()));
            StringUtils.appendNewLine(ret);
        });

        return ret.toString();
    }

    public int pieceCount(final Type type, final Color color) {
        return (int) map.values().stream()
                .filter(piece -> piece.getType().equals(type) && piece.getColor().equals(color))
                .count();
    }

    public int allPiecesCount() {
        return (int) map.values().stream()
                .filter(piece -> !piece.getType().equals(Type.NO_PIECE))
                .count();
    }

    public Piece findPiece(final String position) {

        int key = positionToKey(position);

        return map.get(key);
    }

    private int positionToKey(final String position) {

        int row = 7 - (position.charAt(1) - '1');
        int col = position.charAt(0) - 'a';

        return row * KEY_GENERATION_MULTIPLIER + col;
    }

    public void move(final String position, final Piece piece) {

        int key = positionToKey(position);
        map.put(key, piece);
    }

    public double calculatePoint(final Color color) {

        return IntStream.range(0, COLUMN_LENGTH)
                .mapToDouble(col -> calculateRowPoint(col, color)).sum();
    }

    /*
    각 col 의 piece 를 순회하면서 점수를 계산한다.
    만약, 한 col 에 두 개 이상의 pawn 이 있다면 pawn 의 점수를 반으로 줄인다.
     */
    private double calculateRowPoint(final int col, final Color color) {

        double nonPawnPointSum = 0.0;
        double pawnPointSum = 0.0;

        for(int row = 0; row < 8; row++) {

            int key = row * KEY_GENERATION_MULTIPLIER + col;

            Piece piece = map.get(key);

            if(!piece.isSameColor(color)) continue;

            if(piece.isPawn()) {

                pawnPointSum += piece.getType().getDefaultPoint();
            }

            else {
                nonPawnPointSum += piece.getType().getDefaultPoint();
            }
        }

        return pawnPointSum > 1 ? nonPawnPointSum + pawnPointSum / 2 : nonPawnPointSum + pawnPointSum;
    }

    public List<Piece> SortByPointAscending(final Color color) {
        return sortByPoint(color, SortOrder.ASCENDING);
    }

    public List<Piece> SortByPointDescending(final Color color) {
        return sortByPoint(color, SortOrder.DESCENDING);
    }

    public List<Piece> sortByPoint(final Color color, final SortOrder sortOrder) {
        return map.values().stream()
                .filter(piece -> !piece.getType().equals(Type.NO_PIECE))
                .filter(piece -> piece.getColor().equals(color))
                .sorted(new Piece.PieceComparator(sortOrder))
                .collect(Collectors.toList());
    }
}
