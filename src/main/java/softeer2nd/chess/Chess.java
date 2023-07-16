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

    public void gameStart() {

        while(isContinue) {

            try (Scanner sc = new Scanner(System.in)) {
                String[] cmd = sc.nextLine().split(" ");

                switch (cmd[0]) {
                    case START -> handleStartCommand();
                    case END -> handleEndCommand();
                    case MOVE -> handleMoveCommand(cmd[1], cmd[2]);
                    default -> InvalidCommand();
                }
            }
        }
    }

    private void handleStartCommand() {
        if(isContinue) {
            System.out.println("이미 게임중입니다.");
            return;
        }

        start();
    }

    private void handleEndCommand() {
        if(!isContinue) {
            System.out.println("게임를 하고 있지 않습니다.");
            return;
        }

        end();
    }

    private void handleMoveCommand(String sourcePosition, String targetPosition) {
        if(!isContinue) {
            System.out.println("게임을 하고 있지 않습니다.");
            return;
        }

        if(verifySameLocation(sourcePosition, targetPosition)) throw new InvalidSamePositionException(sourcePosition, targetPosition);

        move(sourcePosition, targetPosition);
    }

    private void InvalidCommand() {
        System.out.println("올바른 명령어가 아닙니다. start/ end/ move b1 b2 명령어를 이용해주세요. ");
    }

    private void start() {
        init();

        System.out.println("게임이 시작되었습니다.");

        chessView.showBoard();
        chessView.showPoint();
        isContinue = true;
    }

    private void end() {

        isContinue = false;

        System.out.println("게임이 종료되었습니다.");
    }

    private void move(String sourcePosition, String targetPosition) {
        board.move(sourcePosition, targetPosition);
        chessView.showBoard();
        chessView.showPoint();
    }

    private boolean verifySameLocation(final String sourcePosition, final String targetPosition) {
        return sourcePosition.equals(targetPosition);
    }
}
