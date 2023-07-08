package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.*;
import java.util.stream.IntStream;

public class Board {


    private final int ROW_LENGTH = 8;
    private final int COLUMN_LENGTH = 8;
    private final int KEY_GENERATION_MULTIPLIER = 10;
    private final int WHITE_NON_PAWN_PIECES_INIT_ROW = 7;
    private final int WHITE_PAWN_INIT_ROW = 6;
    private final int BLACK_NON_PAWN_PIECES_INIT_ROW = 0;
    private final int BLACK_PAWN_INIT_ROW = 1;
    private List<Piece> nonPawnPieces;

    // key: row_idx * 10 + col_idx value: Pawn 객체
    private Map<Integer, Piece> map;

    // 현재 보드 위에 있는 기물들
    private List<Piece> pieceList;

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

        pieceList = new ArrayList<>();

        addInitPiecesToList(Piece.Color.WHITE);
        addInitPiecesToList(Piece.Color.BLACK);

        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(row ->
                IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                        map.put(row * KEY_GENERATION_MULTIPLIER + col, createInitPiece(row, col))));
    }

    private void addInitPiecesToList(final Piece.Color color) {

        // pawn
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.create(Piece.Type.PAWN, color)));

        // pawn 을 제외한 기물
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.create(checkPieceType(nonPawnPieces.get(i)), color)));
    }

    private void nonPawnPiecesListInit() {
        nonPawnPieces = new ArrayList<>();
        nonPawnPieces.add(Piece.create(Piece.Type.ROOK, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.KNIGHT, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.BISHOP, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.QUEEN, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.KING, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.BISHOP, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.KNIGHT, Piece.Color.EMPTY));
        nonPawnPieces.add(Piece.create(Piece.Type.ROOK, Piece.Color.EMPTY));

        nonPawnPieces = Collections.unmodifiableList(nonPawnPieces);
    }

    private Piece createInitPiece(int row, int col) {
        if (row == WHITE_PAWN_INIT_ROW) {
            return Piece.create(Piece.Type.PAWN, Piece.Color.WHITE);
        } else if (row == WHITE_NON_PAWN_PIECES_INIT_ROW) {
            return Piece.create(checkPieceType(nonPawnPieces.get(col)), Piece.Color.WHITE);
        } else if (row == BLACK_PAWN_INIT_ROW) {
            return Piece.create(Piece.Type.PAWN, Piece.Color.BLACK);
        } else if (row == BLACK_NON_PAWN_PIECES_INIT_ROW) {
            return Piece.create(checkPieceType(nonPawnPieces.get(col)), Piece.Color.BLACK);
        } else {
            return Piece.create(Piece.Type.EMPTY, Piece.Color.EMPTY);
        }
    }

    private Piece.Type checkPieceType(Piece piece) {

        if(piece.isPawn()) return Piece.Type.PAWN;
        else if(piece.isKnight()) return Piece.Type.KNIGHT;
        else if(piece.isRook()) return Piece.Type.ROOK;
        else if(piece.isBishop()) return Piece.Type.BISHOP;
        else if(piece.isQueen()) return Piece.Type.QUEEN;
        else return Piece.Type.KING;
    }

    public String print() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_LENGTH).forEach(row -> {
            IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                    ret.append(map.get(row * KEY_GENERATION_MULTIPLIER + col).getRepresentation()));
            ret.append("\n");
        });

        return ret.toString();
    }

    public int pieceCount() {
        return pieceList.size();
    }
}
