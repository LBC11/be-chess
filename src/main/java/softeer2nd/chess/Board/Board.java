package softeer2nd.chess.Board;


import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;

import softeer2nd.chess.exception.moveException.*;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Color.*;

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
        ranks.add(rankFactory.createNonPawnPieces(BLACK));
        ranks.add(rankFactory.createPawnPieces(BLACK));
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createBlankPieces());
        ranks.add(rankFactory.createPawnPieces(WHITE));
        ranks.add(rankFactory.createNonPawnPieces(WHITE));
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

    public void move(final String sourceLoc, final String targetLoc, final Color currentPlayerColor) {
        Position sourcePosition = Position.of(sourceLoc);
        Position targetPosition = Position.of(targetLoc);

        Piece sourcePiece = findPieceUsingPosition(sourcePosition);
        Piece targetPiece = findPieceUsingPosition(targetPosition);

        validateColor(currentPlayerColor, sourcePiece);

        if (sourcePiece.isSameColor(NOCOLOR)) throw new InvalidBlankMoveException(sourceLoc);

        if (verifySameColorPieces(sourcePiece, targetPiece))
            throw new InvalidSameColorException(sourcePosition.getPositionString(), targetPosition.getPositionString());

        if (sourcePiece.getMaxMovement() == 1) {
            isLimitedMovable(sourcePosition, targetPosition);
        }

        if (sourcePiece.getMaxMovement() == 8) {
            isUnlimitedMovable(sourcePosition, targetPosition);
        }

        moveUsingPosition(sourcePosition, targetPosition);
    }

    private void validateColor(final Color currentPlayerColor, Piece sourcePiece) {
        String color = currentPlayerColor == BLACK ? WHITE.getName() : BLACK.getName();

        if (!sourcePiece.isSameColor(currentPlayerColor)) throw new InvalidPlayerColorException(color);
    }

    private void moveUsingPosition(final Position sourcePosition, final Position targetPosition) {
        Piece piece = findPieceUsingPosition(sourcePosition);

        Rank sourceRank = getRankByPosition(sourcePosition);
        Rank targetRank = getRankByPosition(targetPosition);

        sourceRank.removePiece(sourcePosition.getXPos());
        targetRank.addPiece(targetPosition.getXPos(), piece);
    }

    private void isUnlimitedMovable(final Position sourcePosition, final Position targetPosition) {
        Direction direction = findUnLimitedMovalbleDirection(sourcePosition, targetPosition);
        isUnLimitedBlocked(sourcePosition, targetPosition, direction);
    }

    private void isLimitedMovable(final Position sourcePosition, final Position targetPosition) {
        findLimitedMovableDirection(sourcePosition, targetPosition);
        // 한 번의 step 만 움직이는 경우에는 block 의 여부를 검사할 필요가 없다.
    }

    private void isUnLimitedBlocked(final Position sourcePosition, final Position targetPosition, final Direction direction) {

        int distance = sourcePosition.calculateStepToTarget(targetPosition);

        IntStream.range(0, distance - EXCLUDE_TARGET_POSITION).forEach(i -> {
            Position middlePosition = sourcePosition.moveByAddingPosition(Position.of(direction.getXDegree(), direction.getYDegree()));
            if (!findPieceUsingPosition(middlePosition).isSameType(Type.NO_PIECE))
                throw new InvalidBlockedMoveException(sourcePosition.getPositionString(), targetPosition.getPositionString());
        });
    }

    private Direction findUnLimitedMovalbleDirection(final Position sourcePosition, final Position targetPosition) {
        Position unitVector = sourcePosition.generateUnitVector(targetPosition);
        Position sourcePositionWithUnitVector = sourcePosition.moveByAddingPosition(unitVector);
        Piece sourcePiece = findPieceUsingPosition(sourcePosition);

        return findMatchingDirection(sourcePiece, sourcePosition, sourcePositionWithUnitVector);
    }

    private void findLimitedMovableDirection(final Position sourcePosition, final Position targetPosition) {
        Piece sourcePiece = findPieceUsingPosition(sourcePosition);
        findMatchingDirection(sourcePiece, sourcePosition, targetPosition);
    }

    private Direction findMatchingDirection(Piece piece, Position sourcePosition, Position targetPosition) {
        return piece.getDirections().stream()
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