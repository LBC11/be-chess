package softeer2nd.chess.pieces;

import java.util.List;

import static softeer2nd.chess.Board.Constants.*;
import static softeer2nd.chess.Board.Constants.Type.*;

public class Blank extends Piece {
    protected Blank(Color color) {
        super(NO_PIECE, color, List.of());

    }
}
