package softeer2nd.chess;

import softeer2nd.chess.Board.Board;

public class Chess {

    private Board board;
    private View view;
    private boolean isStarted;

    public void init() {
        board = new Board();
        board.initialize();
        view = new View(board);

        isStarted = false;
    }

    public String start() {

        if(isStarted) return "이미 게임중입니다.";

        view.showBoard();
        isStarted = true;
        return "게임이 시작되었습니다.";
    }

    public String end() {

        if(!isStarted) return "게임를 하고 있지 않습니다.";

        isStarted = false;
        return "게임이 종료되었습니다.";
    }
}
