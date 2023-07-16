package softeer2nd.chess;

import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;
import softeer2nd.chess.Board.chessView;
import softeer2nd.chess.exception.moveException.InvalidSamePositionException;

import java.util.Scanner;

public class Chess {

    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";

    private Board board;
    private chessView chessView;
    private PointCalculator pointCalculator;
    private boolean isContinue;

    private void init() {
        board = new Board();
        board.initialize();

        pointCalculator = new PointCalculator(board);

        chessView = new chessView(board, pointCalculator);

        isContinue = false;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        // 2중 반복문을 한번에 종료하기 위한 라벨
        while(isContinue) {

            System.out.print("명령어를 입력해주세요: ");
            String[] cmd = sc.nextLine().split(" ");

            switch (cmd[0]) {
                case START -> gameStart();
                case END -> end();
                case MOVE -> move(cmd[1], cmd[2]);
                default -> InvalidCommand();
            }
        }
    }

    private void InvalidCommand() {
        System.out.println("올바른 명령어가 아닙니다. start/ end/ move b1 b2 명령어를 이용해주세요. ");
    }

    private void gameStart() {
        init();

        if(isContinue) {
            System.out.println("이미 게임중입니다.");
            return;
        }

        System.out.println("게임이 시작되었습니다.");

        chessView.showBoard();
        chessView.showPoint();
        isContinue = true;
    }

    private void end() {

        if(!isContinue) {
            System.out.println("게임를 하고 있지 않습니다.");
            return;
        }

        isContinue = false;
        System.out.println("게임이 종료되었습니다.");
    }

    private void move(String sourcePosition, String targetPosition) {
        if(!isContinue) System.out.println("게임을 하고 있지 않습니다.");

        if(verifySameLocation(sourcePosition, targetPosition)) throw new InvalidSamePositionException(sourcePosition, targetPosition);

        board.move(sourcePosition, targetPosition);
        chessView.showBoard();
        chessView.showPoint();
    }

    private boolean verifySameLocation(final String sourcePosition, final String targetPosition) {
        return sourcePosition.equals(targetPosition);
    }
}
