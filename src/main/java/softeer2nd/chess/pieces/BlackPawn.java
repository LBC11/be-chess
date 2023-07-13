package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.Color.*;
import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class BlackPawn extends Piece{

    protected BlackPawn() {
        super(PAWN, BLACK, blackPawnDirection());
    }
}
