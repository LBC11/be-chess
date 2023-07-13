package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class Knight extends Piece{

    protected Knight(Color color) {
        super(KNIGHT, color, knightDirection());
    }
}
