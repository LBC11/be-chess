package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class Pawn extends Piece{

    protected Pawn(Color color) {
        super(PAWN, color, linearDirection());
    }
}
