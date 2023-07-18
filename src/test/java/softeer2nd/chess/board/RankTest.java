package softeer2nd.chess.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Rank;
import softeer2nd.chess.Board.Constants.Color;
import softeer2nd.chess.pieces.PieceFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static softeer2nd.chess.Board.Constants.*;

class RankTest {
    
    Rank rank;

    PieceFactory pieceFactory;
    
    
    @BeforeEach
    void setup() {
        pieceFactory = PieceFactory.INSTANCE;

        rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.ROOK, Color.WHITE));
        rank.addInitPiece(1, pieceFactory.create(Type.KNIGHT, Color.WHITE));
        rank.addInitPiece(2, pieceFactory.create(Type.BISHOP, Color.WHITE));
        rank.addInitPiece(3, pieceFactory.create(Type.QUEEN, Color.WHITE));
        rank.addInitPiece(4, pieceFactory.create(Type.KING, Color.WHITE));
        rank.addInitPiece(5, pieceFactory.create(Type.BISHOP, Color.WHITE));
        rank.addInitPiece(6, pieceFactory.create(Type.KNIGHT, Color.WHITE));
        rank.addInitPiece(7, pieceFactory.create(Type.ROOK, Color.WHITE));
    }

    @Test
    @DisplayName("정상적으로 rank 가 출력되어야 한다.")
    void showPieces() {

        Assertions.assertEquals("rnbqkbnr", rank.showPieces());
    }

    @Test
    @DisplayName("정상적으로 rank 에서 Piece 가 조회되어야 한다.")
    void findPiece() {
        Assertions.assertEquals(pieceFactory.create(Type.ROOK, Color.WHITE), rank.findPiece(0));
        assertEquals(pieceFactory.create(Type.KNIGHT, Color.WHITE), rank.findPiece(1));
        assertEquals(pieceFactory.create(Type.BISHOP, Color.WHITE), rank.findPiece(2));
        assertEquals(pieceFactory.create(Type.QUEEN, Color.WHITE), rank.findPiece(3));
        assertEquals(pieceFactory.create(Type.KING, Color.WHITE), rank.findPiece(4));
        assertEquals(pieceFactory.create(Type.BISHOP, Color.WHITE), rank.findPiece(5));
        assertEquals(pieceFactory.create(Type.KNIGHT, Color.WHITE), rank.findPiece(6));
        assertEquals(pieceFactory.create(Type.ROOK, Color.WHITE), rank.findPiece(7));
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
    @DisplayName("정상적으로 기물이 rank 에서 삭제된다.")
    void removePiece() {
        rank.removePiece(0);
        assertEquals(rank.findPiece(0), pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
    }

    @Test
    @DisplayName("정상적으로 기물이 rank 위에 놓여진다.")
    void addPiece() {
        rank.addPiece(0, pieceFactory.create(Type.KING, Color.BLACK));
        assertEquals(rank.findPiece(0), pieceFactory.create(Type.KING, Color.BLACK));
    }

}