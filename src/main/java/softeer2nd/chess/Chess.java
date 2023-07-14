package softeer2nd.chess;

import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;
import softeer2nd.chess.Board.chessView;

public class Chess {

    private Board board;
    private chessView chessView;
    private PointCalculator pointCalculator;
    private boolean isStarted;

    public void init() {
        board = new Board();
        board.initialize();

        pointCalculator = new PointCalculator(board);

        chessView = new chessView(board, pointCalculator);

        isStarted = false;
    }

    public String start() {

        if(isStarted) return "이미 게임중입니다.";
        
        chessView.showBoard();
        chessView.showPoint();
        isStarted = true;
        return "게임이 시작되었습니다.";
    }

    public String end() {

        if(!isStarted) return "게임를 하고 있지 않습니다.";

        isStarted = false;
        return "게임이 종료되었습니다.";
    }

    public void move(String sourcePosition, String targetPosition) {
        if(!isStarted) System.out.println("게임을 하고 있지 않습니다.");

        board.move(sourcePosition, targetPosition);
        chessView.showBoard();
        chessView.showPoint();
    }
}
