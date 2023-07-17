package softeer2nd.chess.board;


import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.Constants.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static softeer2nd.chess.Board.Constants.Color.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.moveException.InvalidBlockedMoveException;
import softeer2nd.chess.exception.moveException.InvalidSameColorException;
import softeer2nd.chess.exception.moveException.UnreachablePositionException;
import softeer2nd.chess.pieces.PieceFactory;

class BoardTest {

    Board board;

    @BeforeEach
    public void setup() {

        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("보드판이 정상적으로 생성되어야 한다.")
    void create(){
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
    @DisplayName("board 의 piece 개수가 정상적으로 반환된다.")
    void pieceTypeColorCount() {

        assertEquals(8, board.pieceCount(Type.PAWN, BLACK));
        assertEquals(8, board.pieceCount(Type.PAWN, WHITE));
        assertEquals(2, board.pieceCount(Type.KNIGHT, BLACK));
        assertEquals(2, board.pieceCount(Type.KNIGHT, WHITE));
        assertEquals(2, board.pieceCount(Type.ROOK, BLACK));
        assertEquals(2, board.pieceCount(Type.ROOK, WHITE));
        assertEquals(2, board.pieceCount(Type.BISHOP, BLACK));
        assertEquals(2, board.pieceCount(Type.BISHOP, WHITE));
        assertEquals(1, board.pieceCount(Type.QUEEN, BLACK));
        assertEquals(1, board.pieceCount(Type.QUEEN, WHITE));
        assertEquals(1, board.pieceCount(Type.KING, BLACK));
        assertEquals(1, board.pieceCount(Type.KING, WHITE));
    }

    @Test
    @DisplayName("위치에 따른 기물이 정상적으로 반환된다.")
    void findPiece() {

        assertEquals(PieceFactory.create(Type.ROOK, BLACK), board.findPiece("a8"));
        assertEquals(PieceFactory.create(Type.ROOK, BLACK), board.findPiece("h8"));
        assertEquals(PieceFactory.create(Type.ROOK, WHITE), board.findPiece("a1"));
        assertEquals(PieceFactory.create(Type.ROOK, WHITE), board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물의 이동이 정상적으로 실행되어야 한다.")
    void move() {
        board.initialize();

        String sourcePosition = "b7";
        String targetPosition = "b6";
        
        board.move(sourcePosition, targetPosition, BLACK);

        assertEquals(PieceFactory.create(Type.NO_PIECE, NOCOLOR), board.findPiece(sourcePosition));
        assertEquals(PieceFactory.create(Type.PAWN, BLACK), board.findPiece(targetPosition));
    }

    @Test
    @DisplayName("기물의 이동거리 밖으로 움직이려 할때 UnreachablePositionException 이 발생해야 한다.")
    void move_UnreachablePositionException() {
        board.initialize();

        String sourcePosition = "a2";
        String targetPosition = "a4";

        assertThrows(UnreachablePositionException.class, () ->
                board.move(sourcePosition, targetPosition, WHITE));
    }

    @Test
    @DisplayName("이동 중간에 장애이물이 있어도 기물이 움직이려 할 때 InvalidBlockedMoveException 이 실행되어야 한다.")
    void move_InvalidBlockedMoveException() {
        board.initialize();

        String sourcePosition = "d8";
        String targetPosition = "d5";

        assertThrows(InvalidBlockedMoveException.class, () ->
                board.move(sourcePosition, targetPosition, BLACK));
    }

    @Test
    @DisplayName("시작점과 도착점의 색깔이 같을 떄 InvalidSameColorException 이 실행되어야 한다.")
    void move_InvalidColorMoveException() {
        board.initialize();

        String sourcePosition = "d1";
        String targetPosition = "d2";

        assertThrows(InvalidSameColorException.class, () ->
                board.move(sourcePosition, targetPosition, WHITE));
    }

    @Test
    @DisplayName("보드판의 점수가 정상적으로 계산되어야 한다.")
    void calculatePoint() {
        board.initializeEmpty();

        board.addPiece("b6", PieceFactory.create(Type.PAWN, BLACK));
        board.addPiece("e6", PieceFactory.create(Type.QUEEN, BLACK));
        board.addPiece("b8", PieceFactory.create(Type.KING, BLACK));
        board.addPiece("c8", PieceFactory.create(Type.ROOK, BLACK));

        board.addPiece("f2", PieceFactory.create(Type.PAWN, WHITE));
        board.addPiece("g2", PieceFactory.create(Type.PAWN, WHITE));
        board.addPiece("e1", PieceFactory.create(Type.ROOK, WHITE));
        board.addPiece("f1", PieceFactory.create(Type.KING, WHITE));

        // 0.01은 오차범위를 의미한다.
        assertEquals(15.0, board.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, board.calculatePoint(WHITE), 0.01);

        // Pawn 이 같은 세로줄에 2개 이상 있는 경우
        board.addPiece("b5", PieceFactory.create(Type.PAWN, BLACK));
        assertEquals(15.0, board.calculatePoint(BLACK), 0.01);

    }
}