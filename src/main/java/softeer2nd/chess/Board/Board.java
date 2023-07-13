package softeer2nd.chess.Board;


import softeer2nd.chess.Board.Constants.Type;
import softeer2nd.chess.Board.Constants.Color;
import softeer2nd.chess.Board.Constants.SortOrder;

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

        Position position = new Position(loc);

        Rank rank = ranks.get(position.getYPos());

        return rank.findPiece(position.getXPos());
    }

    public void addPiece(final String loc, final Piece piece) {

        Position position = new Position(loc);

        Rank rank = ranks.get(position.getYPos());

        rank.addInitPiece(position.getXPos(), piece);
    }

    public void move(final String sourceLoc, final String targetLoc) {

        Position sourcePosition = new Position(sourceLoc);
        Position targetPosition = new Position(targetLoc);

        Piece piece = findPiece(sourceLoc);

        Rank sourceRank = ranks.get(sourcePosition.getYPos());
        Rank targetRank = ranks.get(targetPosition.getYPos());

        sourceRank.removePiece(sourcePosition.getXPos());
        targetRank.addPiece(targetPosition.getXPos(), piece);
    }

    public double calculatePoint(final Color color) {

        return IntStream.range(0, COLUMN_LENGTH)
                .mapToDouble(col -> calculateColPoint(col, color)).sum();
    }

    /*
    각 col 의 piece 를 순회하면서 점수를 계산한다.
    만약, 한 col 에 두 개 이상의 pawn 이 있다면 pawn 의 점수를 반으로 줄인다.
     */
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

    public List<Piece> SortByPointAscending(final Color color) {
        return sortByPoint(color, SortOrder.ASCENDING);
    }

    public List<Piece> SortByPointDescending(final Color color) {
        return sortByPoint(color, SortOrder.DESCENDING);
    }

    private List<Piece> sortByPoint(final Color color, final SortOrder sortOrder) {
        return ranks.stream()
                .flatMap(rank -> rank.pieceList(color).stream())
                .sorted(new Piece.PieceComparator(sortOrder))
                .toList();
    }
}
