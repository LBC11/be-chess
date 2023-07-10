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

    private static Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }
    
    private static Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }
    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
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

    public boolean isBlank() {
        return Type.NO_PIECE.equals(this.type);
    }
}
