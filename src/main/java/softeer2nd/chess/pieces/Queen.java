package softeer2nd.chess.pieces;

import softeer2nd.chess.Board.Constants.Color;

import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class Queen extends Piece{

    protected Queen(Color color) {
        super(QUEEN, color, everyDirection());
    }
}
