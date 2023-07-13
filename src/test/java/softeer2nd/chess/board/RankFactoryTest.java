package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Rank;
import softeer2nd.chess.Board.RankFactory;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Board.Constants.*;

class RankFactoryTest {

    RankFactory rankFactory;

    @BeforeEach
    void setup() {
        rankFactory = RankFactory.INSTANCE;
    }

    @Test
    @DisplayName("정상적으로 pawn 이 아닌 모든 기물들이 추가된 rank 가 생성되어야 한다.")
    void createNonPawnPieces() {

        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.ROOK, Color.WHITE));
        rank.addPiece(1, Piece.create(Type.KNIGHT, Color.WHITE));
        rank.addPiece(2, Piece.create(Type.BISHOP, Color.WHITE));
        rank.addPiece(3, Piece.create(Type.QUEEN, Color.WHITE));
        rank.addPiece(4, Piece.create(Type.KING, Color.WHITE));
        rank.addPiece(5, Piece.create(Type.BISHOP, Color.WHITE));
        rank.addPiece(6, Piece.create(Type.KNIGHT, Color.WHITE));
        rank.addPiece(7, Piece.create(Type.ROOK, Color.WHITE));

        assertEquals(rankFactory.createNonPawnPieces(Color.WHITE), rank);
    }

    @Test
    @DisplayName("정상적으로 pawn 이 8개 추가된 rank 가 생성되어야 한다.")
    void createPawnPieces() {

        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(1, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(2, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(3, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(4, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(5, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(6, Piece.create(Type.PAWN, Color.WHITE));
        rank.addPiece(7, Piece.create(Type.PAWN, Color.WHITE));

        assertEquals(rankFactory.createPawnPieces(Color.WHITE), rank);
    }

    @Test
    @DisplayName("정상적으로 blank piece 가 8개 추가된 rank 가 생성되어야 한다.")
    void createBlankPieces() {

        Rank rank = new Rank();

        rank.addPiece(0, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(1, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(2, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(3, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(4, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(5, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(6, Piece.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addPiece(7, Piece.create(Type.NO_PIECE, Color.NOCOLOR));

        assertEquals(rankFactory.createBlankPieces(), rank);
    }
}