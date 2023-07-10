package softeer2nd.chess;


import softeer2nd.chess.Constants.Type;
import softeer2nd.chess.Constants.Color;

import static org.junit.Assert.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

public class BoardTest {

    Board board;

    @BeforeEach
    public void setup() {

        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("board 가 정상적으로 생성되어야 한다.")
    public void create() throws Exception {
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
    public void pieceTypeColorCount() {

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
    public void findPiece() throws Exception {

        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece("a8"));
        assertEquals(Piece.create(Type.ROOK, Color.BLACK), board.findPiece("h8"));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece("a1"));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물의 이동이 정상적으로 실행되어야 한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.create(Type.ROOK, Color.BLACK);
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
}