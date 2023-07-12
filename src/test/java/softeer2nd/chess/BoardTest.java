package softeer2nd.chess;


import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;

import static org.junit.Assert.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

class BoardTest {

    Board board;

    @BeforeEach
    public void setup() {

        board = new Board();
        board.initialize();
    }



    @Test
    @DisplayName("board의 piece 개수가 정상적으로 반환된다.")
    void pieceTypeColorCount() {

        assertEquals(8, board.pieceCount(Type.PAWN, Color.BLACK));
        assertEquals(8, board.pieceCount(Type.PAWN, Color.WHITE));
        assertEquals(2, board.pieceCount(Type.KNIGHT, Color.BLACK));
        assertEquals(2, board.pieceCount(Type.KNIGHT, Color.WHITE));
        assertEquals(2, board.pieceCount(Type.ROOK, Color.BLACK));
        assertEquals(2, board.pieceCount(Type.ROOK, Color.WHITE));
        assertEquals(2, board.pieceCount(Type.BISHOP, Color.BLACK));
        assertEquals(2, board.pieceCount(Type.BISHOP, Color.WHITE));
        assertEquals(1, board.pieceCount(Type.QUEEN, Color.BLACK));
        assertEquals(1, board.pieceCount(Type.QUEEN, Color.WHITE));
        assertEquals(1, board.pieceCount(Type.KING, Color.BLACK));
        assertEquals(1, board.pieceCount(Type.KING, Color.WHITE));
    }

    @Test
    @DisplayName("위치에 따른 기물이 정상적으로 반환된다.")
    void findPiece() throws Exception {

        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece(0));
        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece(7));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece(70));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece(77));
    }

    @Test
    @DisplayName("기물의 이동이 정상적으로 실행되어야 한다.")
    void move() throws Exception {
        board.initializeEmpty();

        int loc = 31;
        Piece piece = Piece.create(Type.ROOK, Color.BLACK);
        addPiece(loc, piece);

        assertEquals(piece, board.findPiece(loc));
        assertEquals(1, board.allPiecesCount());
    }

    @Test
    @DisplayName("보드판의 점수가 정상적으로 계산되어야 한다.")
    void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece(21, Piece.create(Type.PAWN, Color.BLACK));
        addPiece(24, Piece.create(Type.QUEEN, Color.BLACK));
        addPiece(1, Piece.create(Type.KING, Color.BLACK));
        addPiece(2, Piece.create(Type.ROOK, Color.BLACK));

        addPiece(65, Piece.create(Type.PAWN, Color.WHITE));
        addPiece(66, Piece.create(Type.PAWN, Color.WHITE));
        addPiece(74, Piece.create(Type.ROOK, Color.WHITE));
        addPiece(75, Piece.create(Type.KING, Color.WHITE));

        // 0.01은 오차범위를 의미한다.
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);

        // Pawn 이 같은 세로줄에 2개 이상 있는 경우
        addPiece(31, Piece.create(Type.PAWN, Color.BLACK));
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);

    }

    private void addPiece(int loc, Piece piece) {
        board.move(loc, piece);
    }

    @Test
    @DisplayName("보드판의 기물이 정상적으로 정렬되어야 한다.")
    void sortPieceList() {
        board.initializeEmpty();

        addPiece(21, Piece.create(Type.PAWN, Color.BLACK));
        addPiece(24, Piece.create(Type.QUEEN, Color.BLACK));
        addPiece(1, Piece.create(Type.KING, Color.BLACK));
        addPiece(2, Piece.create(Type.ROOK, Color.BLACK));

        addPiece(65, Piece.create(Type.PAWN, Color.WHITE));
        addPiece(66, Piece.create(Type.PAWN, Color.WHITE));
        addPiece(74, Piece.create(Type.ROOK, Color.WHITE));
        addPiece(75, Piece.create(Type.KING, Color.WHITE));

        List<Piece> pieceList = new ArrayList<>();
        pieceList.add(Piece.create(Type.KING, Color.BLACK));
        pieceList.add(Piece.create(Type.PAWN, Color.BLACK));
        pieceList.add(Piece.create(Type.ROOK, Color.BLACK));
        pieceList.add(Piece.create(Type.QUEEN, Color.BLACK));

        assertEquals(pieceList, board.SortByPointAscending(Color.BLACK));

        pieceList.clear();
        pieceList.add(Piece.create(Type.KING, Color.WHITE));
        pieceList.add(Piece.create(Type.PAWN, Color.WHITE));
        pieceList.add(Piece.create(Type.PAWN, Color.WHITE));
        pieceList.add(Piece.create(Type.ROOK, Color.WHITE));

        assertEquals(true, pieceList.equals(board.SortByPointAscending(Color.WHITE)));

        pieceList.clear();
        pieceList.add(Piece.create(Type.ROOK, Color.WHITE));
        pieceList.add(Piece.create(Type.PAWN, Color.WHITE));
        pieceList.add(Piece.create(Type.PAWN, Color.WHITE));
        pieceList.add(Piece.create(Type.KING, Color.WHITE));

        assertEquals(true, pieceList.equals(board.SortByPointDescending(Color.WHITE)));
    }
}