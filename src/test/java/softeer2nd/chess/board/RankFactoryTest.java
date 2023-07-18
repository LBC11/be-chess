package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board.Rank;
import softeer2nd.chess.Board.RankFactory;
import softeer2nd.chess.pieces.PieceFactory;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Board.Constants.*;

class RankFactoryTest {

    RankFactory rankFactory;
    PieceFactory pieceFactory;

    @BeforeEach
    void setup() {
        rankFactory = RankFactory.INSTANCE;
        pieceFactory = PieceFactory.INSTANCE;
    }

    @Test
    @DisplayName("정상적으로 pawn 이 아닌 모든 기물들이 추가된 rank 가 생성되어야 한다.")
    void createNonPawnPieces() {

        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.ROOK, Color.WHITE));
        rank.addInitPiece(1, pieceFactory.create(Type.KNIGHT, Color.WHITE));
        rank.addInitPiece(2, pieceFactory.create(Type.BISHOP, Color.WHITE));
        rank.addInitPiece(3, pieceFactory.create(Type.QUEEN, Color.WHITE));
        rank.addInitPiece(4, pieceFactory.create(Type.KING, Color.WHITE));
        rank.addInitPiece(5, pieceFactory.create(Type.BISHOP, Color.WHITE));
        rank.addInitPiece(6, pieceFactory.create(Type.KNIGHT, Color.WHITE));
        rank.addInitPiece(7, pieceFactory.create(Type.ROOK, Color.WHITE));

        assertEquals(rankFactory.createNonPawnPieces(Color.WHITE), rank);
    }

    @Test
    @DisplayName("정상적으로 pawn 이 8개 추가된 rank 가 생성되어야 한다.")
    void createPawnPieces() {

        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(1, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(2, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(3, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(4, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(5, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(6, pieceFactory.create(Type.PAWN, Color.WHITE));
        rank.addInitPiece(7, pieceFactory.create(Type.PAWN, Color.WHITE));

        assertEquals(rankFactory.createPawnPieces(Color.WHITE), rank);
    }

    @Test
    @DisplayName("정상적으로 blank piece 가 8개 추가된 rank 가 생성되어야 한다.")
    void createBlankPieces() {

        Rank rank = new Rank();

        rank.addInitPiece(0, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(1, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(2, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(3, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(4, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(5, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(6, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));
        rank.addInitPiece(7, pieceFactory.create(Type.NO_PIECE, Color.NOCOLOR));

        assertEquals(rankFactory.createBlankPieces(), rank);
    }
}