package softeer2nd;

import softeer2nd.chess.Chess;

public class Main {

    static Chess chess;

    public static void main(String[] args) {
        chess = new Chess();
        chess.gameStart();
    }
}