package softeer2nd.chess.Board;


import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;

import softeer2nd.chess.exception.moveException.InvalidColorMoveException;
import softeer2nd.chess.exception.moveException.UnreachablePositionException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

import static softeer2nd.chess.Board.Constants.*;

public class Board {

    private RankFactory rankFactory;
    private ArrayList<Rank> ranks;

    public Board() {
    }

    public void initialize() {
        rankFactory = RankFactory.INSTANCE;
        ranks = new ArrayList<>();
        addInitPieces();
    }

    public void initializeEmpty() {
        rankFactory = RankFactory.INSTANCE;
        ranks = new ArrayList<>();
        addInitBlankPieces();
    }

    private void addInitPieces() {
        ranks.add(rankFactory.createNonPawnPieces(Color.BLACK));
        ranks.add(rankFactory.createPawnPieces(Color.BLACK));
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createPawnPieces(Color.WHITE));
        ranks.add(rankFactory.createNonPawnPieces(Color.WHITE));
    }

    private void addInitBlankPieces() {
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
    }

    public String showBoard() {
        StringBuilder ret = new StringBuilder();
        ranks.forEach(rank -> StringUtils.appendNewLine(ret.append(rank.showPieces())));
        return ret.toString();
    }

    public int pieceCount(final Type type, final Color color) {
        return ranks.stream()
                .mapToInt(rank -> rank.pieceCount(type, color))
                .sum();
    }

    public int allPiecesCount() {
        return ranks.stream()
                .mapToInt(Rank::allPieceCount)
                .sum();
    }

    public Piece findPiece(final String loc) {
        Position position = Position.of(loc);
        return findPieceUsingPosition(position);
    }

    private Piece findPieceUsingPosition(final Position position) {
        Rank rank = getRankByPosition(position);
        return rank.findPiece(position.getXPos());
    }

    public void addPiece(final String loc, final Piece piece) {
        Position position = Position.of(loc);
        addPieceUsingPosition(position, piece);
    }

    private void addPieceUsingPosition(final Position position, final Piece piece) {
        Rank rank = getRankByPosition(position);
        rank.addInitPiece(position.getXPos(), piece);
    }

    public void move(final String sourceLoc, final String targetLoc) {
        Position sourcePosition = Position.of(sourceLoc);
        Position targetPosition = Position.of(targetLoc);

        Piece sourcePiece = findPieceUsingPosition(sourcePosition);
        Piece targetPiece = findPieceUsingPosition(targetPosition);

        if (verifySameColorPieces(sourcePiece, targetPiece))
            throw new InvalidColorMoveException(sourcePosition.getPositionString(), targetPosition.getPositionString());

        Direction direction = sourcePiece.getMaxMovement() == 1 ? findLimitedMovableDirection(sourcePosition, targetPosition) :
                findUnLimitedMovalbeDirection(sourcePosition, targetPosition);

        moveUsingPosition(sourcePosition, targetPosition);
    }

    private void moveUsingPosition(final Position sourcePosition, final Position targetPosition) {
        Piece piece = findPieceUsingPosition(sourcePosition);

        Rank sourceRank = getRankByPosition(sourcePosition);
        Rank targetRank = getRankByPosition(targetPosition);

        sourceRank.removePiece(sourcePosition.getXPos());
        targetRank.addPiece(targetPosition.getXPos(), piece);
    }

    private Direction findUnLimitedMovalbeDirection(final Position sourcePosition, final Position targetPosition) {
        return Direction.EAST;
    }

    private Direction findLimitedMovableDirection(final Position sourcePosition, final Position targetPosition) {

        Piece sourcePiece = findPieceUsingPosition(sourcePosition);

        return sourcePiece.getDirections().stream()
                .filter(direction -> sourcePosition.doesPositionMatchAfterMove(targetPosition, direction.getXDegree(), direction.getYDegree()))
                .findFirst()
                .orElseThrow(() -> new UnreachablePositionException(sourcePosition.getPositionString(), targetPosition.getPositionString()));
    }

    private boolean verifySameColorPieces(final Piece sourcePiece, final Piece targetPiece) {
        return sourcePiece.isSameColor(targetPiece);
    }

    private Rank getRankByPosition(final Position position) {
        return ranks.get(position.getYPos());
    }

    public double calculatePoint(final Color color) {
        return IntStream.range(0, COLUMN_LENGTH)
                .mapToDouble(col -> calculateColPoint(col, color)).sum();
    }

    private double calculateColPoint(final int col, final Color color) {
        return calculateColPawnPoint(col, color) + calculateColNonPawnPoint(col, color);
    }

    private double calculateColNonPawnPoint(final int col, final Color color) {
        return IntStream.range(0, ROW_LENGTH)
                .mapToObj(i -> ranks.get(i).findPiece(col))
                .filter(piece -> !piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .mapToDouble(Piece::getDefaultPoint)
                .sum();
    }

    private double calculateColPawnPoint(final int col, final Color color) {
        double pawnCount = IntStream.range(0, ROW_LENGTH)
                .mapToObj(row -> ranks.get(row).findPiece(col))
                .filter(piece -> piece.isSameType(Type.PAWN) && piece.isSameColor(color))
                .count();

        return pawnCount > 1 ? pawnCount * DUPLICATE_PAWN_POINT : pawnCount * Type.PAWN.getDefaultPoint();
    }
}