package softeer2nd.chess.pieces;

import softeer2nd.utils.StringUtils;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR
    }


    public enum Type {

        PAWN('p'), KNIGHT('n'), ROOK('r'),
        BISHOP('b'), QUEEN('q'), KING('k'),
        NO_PIECE('.');

        private final char representation;

        Type(char representation) {

            this.representation = representation;
        }

        public char getRepresentation() {
            return this.representation;
        }
    }

    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {

        this.type = type;
        this.color = color;
    }

    public char getRepresentation() {

        char representation = this.type.getRepresentation();

        return this.color == Color.BLACK ? StringUtils.Uppercase(representation) : representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Type.PAWN, Color.WHITE);
    }
    public static Piece createBlackPawn() {
        return new Piece(Type.PAWN, Color.BLACK);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Type.KNIGHT, Color.WHITE);
    }

    public static Piece createBlackKnight() {
        return new Piece(Type.KNIGHT, Color.BLACK);
    }

    public static Piece createWhiteRook() {
        return new Piece(Type.ROOK, Color.WHITE);
    }

    public static Piece createBlackRook() {
        return new Piece(Type.ROOK, Color.BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Type.BISHOP, Color.WHITE);
    }

    public static Piece createBlackBishop() {
        return new Piece(Type.BISHOP, Color.BLACK);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Type.QUEEN, Color.WHITE);
    }

    public static Piece createBlackQueen() {
        return new Piece(Type.QUEEN, Color.BLACK);
    }

    public static Piece createWhiteKing() {
        return new Piece(Type.KING, Color.WHITE);
    }

    public static Piece createBlackKing() {
        return new Piece(Type.KING, Color.BLACK);
    }

    public static Piece createNoPiece() {
        return new Piece(Type.NO_PIECE, Color.NOCOLOR);
    }

    public boolean isWhite() {
        return Color.WHITE.equals(this.color);
    }

    public boolean isBlack() {

        return Color.BLACK.equals(this.color);
    }

    public boolean isPawn() {
        return Type.PAWN.equals(this.type);
    }

    public boolean isKnight() {
        return Type.KNIGHT.equals(this.type);
    }

    public boolean isRook() {
        return Type.ROOK.equals(this.type);
    }

    public boolean isBishop() {
        return Type.BISHOP.equals(this.type);
    }

    public boolean isQueen() {
        return Type.QUEEN.equals(this.type);
    }

    public boolean isKing() {
        return Type.KING.equals(this.type);
    }

    public boolean isNoPiece() {
        return Type.NO_PIECE.equals(this.type);
    }
}
