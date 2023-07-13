package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Rank;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.Board.Constants.Color;

import static org.junit.Assert.assertEquals;
import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class RankTest {
    
    Rank rank;
    
    @BeforeEach
    void setup() {
        rank = new Rank();

        rank.addPiece(0, Piece.create(Type.ROOK, Color.WHITE));
        rank.addPiece(1, Piece.create(Type.KNIGHT, Color.WHITE));
        rank.addPiece(2, Piece.create(Type.BISHOP, Color.WHITE));
        rank.addPiece(3, Piece.create(Type.QUEEN, Color.WHITE));
        rank.addPiece(4, Piece.create(Type.KING, Color.WHITE));
        rank.addPiece(5, Piece.create(Type.BISHOP, Color.WHITE));
        rank.addPiece(6, Piece.create(Type.KNIGHT, Color.WHITE));
        rank.addPiece(7, Piece.create(Type.ROOK, Color.WHITE));
    }

    @Test
    @DisplayName("정상적으로 rank 가 출력되어야 한다.")
    void showPieces() {

        assertEquals("rnbqkbnr",
                rank.showPieces());
    }

    @Test
    @DisplayName("정상적으로 rank 에서 Piece 가 조회되어야 한다.")
    void findPiece() {
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), rank.findPiece(0));
        assertEquals(Piece.create(Type.KNIGHT, Color.WHITE), rank.findPiece(1));
        assertEquals(Piece.create(Type.BISHOP, Color.WHITE), rank.findPiece(2));
        assertEquals(Piece.create(Type.QUEEN, Color.WHITE), rank.findPiece(3));
        assertEquals(Piece.create(Type.KING, Color.WHITE), rank.findPiece(4));
        assertEquals(Piece.create(Type.BISHOP, Color.WHITE), rank.findPiece(5));
        assertEquals(Piece.create(Type.KNIGHT, Color.WHITE), rank.findPiece(6));
        assertEquals(Piece.create(Type.ROOK, Color.WHITE), rank.findPiece(7));
    }

    @Test
    @DisplayName("정상적으로 rank 에 포함되 기물들의 숫자가 반환되어야 한다.")
    void pieceCount() {
        assertEquals(2, rank.pieceCount(Type.ROOK, Color.WHITE));
        assertEquals(2, rank.pieceCount(Type.KNIGHT, Color.WHITE));
        assertEquals(2, rank.pieceCount(Type.BISHOP, Color.WHITE));
        assertEquals(1, rank.pieceCount(Type.QUEEN, Color.WHITE));
        assertEquals(1, rank.pieceCount(Type.KING, Color.WHITE));
    }

    @Test
    @DisplayName("정상적으로 blank 가 아닌 모든 기물들의 숫자가 반환되어야 한다.")
    void allPieceCount() {
        assertEquals(8, rank.allPieceCount());
    }

    @Test
    void calculatePoint() {
        assertEquals(22.0, rank.calculatePoint(Color.WHITE));
        assertEquals(0.0, rank.calculatePoint(Color.BLACK));
    }
}