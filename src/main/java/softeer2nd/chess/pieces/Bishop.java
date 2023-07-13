package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Direction.*;

public class Bishop extends Piece{

    protected Bishop(Color color) {
        super(Type.BISHOP, color, diagonalDirection());
    }
}
