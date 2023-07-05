package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    ArrayList<Pawn> board;

    public Board() {
        board = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        board.add(pawn);
    }

    public int size() {
        return board.size();
    }

    public Pawn findPawn(int idx) {
        return board.get(idx);
    }
}
