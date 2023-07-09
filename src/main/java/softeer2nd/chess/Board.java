package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

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

        addInitPiecesToList();

        map = new HashMap<>();
        IntStream.range(0, ROW_LENGTH).forEach(this::addInitPiecesToMap);
    }

    private void addInitPiecesToList() {

        // pawn
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.createWhitePawn()));
        IntStream.range(0, COLUMN_LENGTH).forEach((i) -> pieceList.add(Piece.createBlackPawn()));

        // pawn 을 제외한 기물
        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());

        pieceList.add(Piece.createBlackRook());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackQueen());
        pieceList.add(Piece.createBlackKing());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackRook());

    }

    private void nonPawnPiecesListInit() {
        nonPawnPieces = new ArrayList<>();
        nonPawnPieces.add(Piece.createWhiteRook());
        nonPawnPieces.add(Piece.createWhiteKnight());
        nonPawnPieces.add(Piece.createWhiteBishop());
        nonPawnPieces.add(Piece.createWhiteQueen());
        nonPawnPieces.add(Piece.createWhiteKing());
        nonPawnPieces.add(Piece.createWhiteBishop());
        nonPawnPieces.add(Piece.createWhiteKnight());
        nonPawnPieces.add(Piece.createWhiteRook());

        nonPawnPieces = Collections.unmodifiableList(nonPawnPieces);
    }

    private void addInitPiecesToMap(int row) {
        if (row == WHITE_PAWN_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.createWhitePawn()));
        } else if (row == WHITE_NON_PAWN_PIECES_INIT_ROW) {
            int col = 0;

            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteRook());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteKnight());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteBishop());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteQueen());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteKing());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteBishop());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createWhiteKnight());
            map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.createWhiteRook());

        } else if (row == BLACK_PAWN_INIT_ROW) {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.createBlackPawn()));
        } else if (row == BLACK_NON_PAWN_PIECES_INIT_ROW) {
            int col = 0;

            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackRook());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackKnight());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackBishop());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackQueen());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackKing());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackBishop());
            map.put(row * KEY_GENERATION_MULTIPLIER + col++, Piece.createBlackKnight());
            map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.createBlackRook());

        } else {
            IntStream.range(0, COLUMN_LENGTH).forEach((col) -> map.put(row * KEY_GENERATION_MULTIPLIER + col, Piece.createNoPiece()));
        }
    }

    public String print() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_LENGTH).forEach(row -> {
            IntStream.range(0, COLUMN_LENGTH).forEach(col ->
                    ret.append(map.get(row * KEY_GENERATION_MULTIPLIER + col).getRepresentation()));
            StringUtils.appendNewLine(ret);
        });

        return ret.toString();
    }

    public int pieceCount() {
        return pieceList.size();
    }
}
