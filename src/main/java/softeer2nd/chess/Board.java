package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Board {


    private final int ROW_SIZE = 8;
    private final int COLUMN_SIZE = 8;
    private final int PAWN_NUMBER = 8;
    private final int WHITE_PAWN_INIT_ROW = 6;
    private final int BLACK_PAWN_INIT_ROW = 1;

    // key: row_idx * 10 + col_idx value: Pawn 객체
    Map<Integer, Pawn> map;

    // 현재 보드 위에 있는 기물들
    List<Pawn> pieces;

    public Board() {
    }

    /*
        pieces
        - 초기 기물들을 색깔별로 더해준다.
        
        map 초기화
        - row 가 1이면 white pawn, row 가 6이면 black pawn, 그 외는 empty pawn 으로 채운다.
     */
    public void initialize() {
        pieces = new ArrayList<>();

        addInitPieces(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        addInitPieces(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);

        map = new HashMap<>();
        IntStream.range(0, ROW_SIZE).forEach(row ->
                IntStream.range(0, COLUMN_SIZE).forEach(col ->
                        map.put(row * 10 + col,
                                row == WHITE_PAWN_INIT_ROW ? new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION) :
                                row == BLACK_PAWN_INIT_ROW ? new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION) :
                                new Pawn(Pawn.EMPTY_COLOR, Pawn.EMPTY_REPRESENTATION))));
    }

    private void addInitPieces(final String color, final char representation) {
        IntStream.range(0, PAWN_NUMBER).forEach((i) -> pieces.add(new Pawn(color, representation)));
    }

    public void add(Pawn pawn) {
        pieces.add(pawn);
    }

    public int size() {
        return pieces.size();
    }

    public Pawn findPawn(int idx) {
        return pieces.get(idx);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(WHITE_PAWN_INIT_ROW);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(BLACK_PAWN_INIT_ROW);
    }

    private String getPawnsResult(int row) {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, COLUMN_SIZE).forEach(col ->
                ret.append(map.get(row * 10 + col).getRepresentation()));

        return ret.toString();
    }

    public String print() {
        StringBuilder ret = new StringBuilder();

        IntStream.range(0, ROW_SIZE).forEach(row -> {
            IntStream.range(0, COLUMN_SIZE).forEach(col ->
                    ret.append(map.get(row * 10 + col).getRepresentation()));
            ret.append("\n");
        });

        return ret.toString();
    }
}
