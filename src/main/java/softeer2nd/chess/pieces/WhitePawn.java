package softeer2nd.chess.pieces;

import static softeer2nd.chess.Board.Constants.Color.WHITE;
import static softeer2nd.chess.Board.Constants.Direction.*;
import static softeer2nd.chess.Board.Constants.Type.PAWN;

public class WhitePawn extends Piece{

    protected WhitePawn() {
        super(PAWN, WHITE, whitePawnDirection());
    }
}
