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
    @DisplayName("보드판이 정상적으로 생성되어야 한다.")
    void create() throws Exception {
        assertEquals(32, board.allPiecesCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
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

        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece(new Board.Position("a8")));
        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece(new Board.Position("h8")));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece(new Board.Position("a1")));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece(new Board.Position("h1")));
    }

    @Test
    @DisplayName("기물의 이동이 정상적으로 실행되어야 한다.")
    void move() throws Exception {
        board.initializeEmpty();

        Board.Position position = new Board.Position("b5");
        Piece piece = Piece.create(Type.ROOK, Color.BLACK);
        addPiece(position, piece);

        assertEquals(piece, board.findPiece(position));
        assertEquals(1, board.allPiecesCount());
    }

    @Test
    @DisplayName("보드판의 점수가 정상적으로 계산되어야 한다.")
    void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece(new Board.Position("b6"), Piece.create(Type.PAWN, Color.BLACK));
        addPiece(new Board.Position("e6"), Piece.create(Type.QUEEN, Color.BLACK));
        addPiece(new Board.Position("b8"), Piece.create(Type.KING, Color.BLACK));
        addPiece(new Board.Position("c8"), Piece.create(Type.ROOK, Color.BLACK));

        addPiece(new Board.Position("f2"), Piece.create(Type.PAWN, Color.WHITE));
        addPiece(new Board.Position("g2"), Piece.create(Type.PAWN, Color.WHITE));
        addPiece(new Board.Position("e1"), Piece.create(Type.ROOK, Color.WHITE));
        addPiece(new Board.Position("f1"), Piece.create(Type.KING, Color.WHITE));

        // 0.01은 오차범위를 의미한다.
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(Color.WHITE), 0.01);

        // Pawn 이 같은 세로줄에 2개 이상 있는 경우
        addPiece(new Board.Position("b5"), Piece.create(Type.PAWN, Color.BLACK));
        assertEquals(15.0, board.calculatePoint(Color.BLACK), 0.01);

    }

    private void addPiece(Board.Position position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("보드판의 기물이 정상적으로 정렬되어야 한다.")
    void sortPieceList() {
        board.initializeEmpty();

        addPiece(new Board.Position("b6"), Piece.create(Type.PAWN, Color.BLACK));
        addPiece(new Board.Position("e6"), Piece.create(Type.QUEEN, Color.BLACK));
        addPiece(new Board.Position("b8"), Piece.create(Type.KING, Color.BLACK));
        addPiece(new Board.Position("c8"), Piece.create(Type.ROOK, Color.BLACK));

        addPiece(new Board.Position("f2"), Piece.create(Type.PAWN, Color.WHITE));
        addPiece(new Board.Position("g2"), Piece.create(Type.PAWN, Color.WHITE));
        addPiece(new Board.Position("e1"), Piece.create(Type.ROOK, Color.WHITE));
        addPiece(new Board.Position("f1"), Piece.create(Type.KING, Color.WHITE));
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