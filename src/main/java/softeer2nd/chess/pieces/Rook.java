package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Direction.*;

public class Rook extends Piece {

    protected Rook(Color color) {
        super(Type.ROOK, color, diagonalDirection());
    }
}
