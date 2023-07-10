package softeer2nd.chess;

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
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.print());
    }

    @Test
    @DisplayName("board의 piece 개수가 정상적으로 반환된다.")
    public void pieceTypeColorCount() {

        assertEquals(8, board.blackPawnCount());
        assertEquals(8, board.whitePawnCount());
        assertEquals(2, board.blackKnightCount());
        assertEquals(2, board.whiteKnightCount());
        assertEquals(2, board.blackRookCount());
        assertEquals(2, board.whiteRookCount());
        assertEquals(2, board.blackBishopCount());
        assertEquals(2, board.whiteBishopCount());
        assertEquals(1, board.blackQueenCount());
        assertEquals(1, board.whiteQueenCount());
        assertEquals(1, board.blackKingCount());
        assertEquals(1, board.whiteKingCount());
    }

    @Test
    @DisplayName("위치에 따른 기물이 정상적으로 반환된다.")
    public void findPiece() throws Exception {

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물의 이동이 정상적으로 실행되어야 한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }
}