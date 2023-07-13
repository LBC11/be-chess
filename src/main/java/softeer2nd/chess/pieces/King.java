package softeer2nd.chess.pieces;

import softeer2nd.chess.Board.Constants.Color;

import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class King extends Piece {

    protected King(Color color) {
        super(KING, color, linearDirection());
    }
}
