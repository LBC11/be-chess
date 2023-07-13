package softeer2nd.chess.Board;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final int ROW_LENGTH = 8;
    public static final int COLUMN_LENGTH = 8;
    public static final double DUPLICATE_PAWN_POINT = 0.5;

    public enum Color {
        WHITE, BLACK, NOCOLOR
    }

    public enum Type {

        PAWN('p', 1.0, 1),
        KNIGHT('n', 2.5, 1),
        ROOK('r', 5.0, 8),
        BISHOP('b', 3.0, 8),
        QUEEN('q', 9.0, 8),
        KING('k', 0.0, 1),
        NO_PIECE('.', 0.0, 0);

        private final char representation;
        private final double defaultPoint;
        private final int maxMovement;

        Type(char representation, double defaultPoint, int maxMovement) {

            this.representation = representation;
            this.defaultPoint = defaultPoint;
            this.maxMovement = maxMovement;
        }

        public char getRepresentation() {
            return this.representation;
        }

        public double getDefaultPoint() {
            return this.defaultPoint;
        }

        public int getMaxMovement() {return this.maxMovement;}
    }

    public enum SortOrder {ASCENDING, DESCENDING}

    public enum Direction {
        NORTH(0, 1),
        NORTHEAST(1, 1),
        EAST(1, 0),
        SOUTHEAST(1, -1),
        SOUTH(0, -1),
        SOUTHWEST(-1, -1),
        WEST(-1, 0),
        NORTHWEST(-1, 1),

        NNE(1, 2),
        NNW(-1, 2),
        SSE(1, -2),
        SSW(-1, -2),
        EEN(2, 1),
        EES(2, -1),
        WWN(-2, 1),
        WWS(-2, -1);

        private int xDegree;
        private int yDegree;

        private Direction(int xDegree, int yDegree) {
            this.xDegree = xDegree;
            this.yDegree = yDegree;
        }

        public int getXDegree() {
            return xDegree;
        }

        public int getYDegree() {
            return yDegree;
        }

        public static List<Direction> linearDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST);
        }

        public static List<Direction> diagonalDirection() {
            return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> everyDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> knightDirection() {
            return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
        }

        public static List<Direction> whitePawnDirection() {
            return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
        }

        public static List<Direction> blackPawnDirection() {
            return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
        }
    }
}
