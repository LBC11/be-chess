package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.*;
import java.util.stream.IntStream;

public class Board {


    private final int ROW_LENGTH = 8;
    private final int COLUMN_LENGTH = 8;
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
                        map.put(row * 10 + col,
                                row == WHITE_PAWN_INIT_ROW ? Piece.create(Piece.Type.PAWN, Piece.Color.WHITE) :
                                row == WHITE_NON_PAWN_PIECES_INIT_ROW ? Piece.create(nonPawnPieces.get(col).getType(), Piece.Color.WHITE) :
                                row == BLACK_PAWN_INIT_ROW ? Piece.create(Piece.Type.PAWN, Piece.Color.BLACK) :
                                row == BLACK_NON_PAWN_PIECES_INIT_ROW ? Piece.create(nonPawnPieces.get(col).getType(), Piece.Color.BLACK) :
                                Piece.create(Piece.Type.EMPTY, Piece.Color.EMPTY))));
    }

    private void addInitPiecesToList(final Piece.Color color) {

        // pawn
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.create(Piece.Type.PAWN, color)));

        // pawn 을 제외한 기물
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.create(nonPawnPieces.get(i).getType(), color)));
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }

    public Piece findPawn(int idx) {
        return pieceList.get(idx);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(WHITE_PAWN_INIT_ROW);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(BLACK_PAWN_INIT_ROW);
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

    private String getPawnsResult(int row) {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                ret.append(map.get(row * 10 + col).getRepresentation()));

        return ret.toString();
    }

    public String print() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_LENGTH).forEach(row -> {
            IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                    ret.append(map.get(row * 10 + col).getRepresentation()));
            ret.append("\n");
        });

        return ret.toString();
    }

    public int pieceCount() {
        return pieceList.size();
    }
}
