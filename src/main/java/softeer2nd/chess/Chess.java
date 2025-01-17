package softeer2nd.chess;

import softeer2nd.chess.Board.Board;
import softeer2nd.chess.Board.PointCalculator;
import softeer2nd.chess.Board.ChessView;
import softeer2nd.chess.Board.Constants.Color;

import softeer2nd.chess.exception.commandException.InvalidDefaultCommandException;
import softeer2nd.chess.exception.commandException.InvalidMoveCommandException;
import softeer2nd.chess.exception.moveException.InvalidSamePositionException;

import java.util.Scanner;

import static softeer2nd.chess.Board.Constants.Color.*;
import static softeer2nd.chess.Board.Constants.Color.BLACK;

public class Chess {

    private static final String START = "start";
    private static final String END = "end";
    private static final String MOVE = "move";
    private static final int NUMBER_OF_PLAYERS = 2;

    private final Color[] colors = {WHITE, BLACK};
    private int turn = 0;
    private final Color currentPlayerColor = colors[turn % NUMBER_OF_PLAYERS];

    private Board board;
    private ChessView chessView;
    private PointCalculator pointCalculator;

    private boolean isContinue;
    private boolean isStarted;

    private void init() {
        board = new Board();
        board.initialize();

        pointCalculator = new PointCalculator(board);

        chessView = new ChessView(board, pointCalculator);

        isStarted = true;
    }

    public void gameStart() {
        isContinue = true;

        Scanner sc = new Scanner(System.in);

        while (isContinue) {
            RequestCommandInput();

            String[] commands = sc.nextLine().split(" ");

            String cmd = commands[0];

            try {
                switch (cmd) {
                    case START -> handleStartCommand();
                    case END -> handleEndCommand();
                    case MOVE -> handleMoveCommand(commands);
                    default -> throw new InvalidDefaultCommandException();
                }
            } catch (RuntimeException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        sc.close();
    }

    private void handleStartCommand() {
        if (isStarted) {
            System.out.println("이미 게임중입니다.");
            return;
        }

        start();
    }

    private void handleEndCommand() {
        if (!isStarted) {
            System.out.println("게임를 하고 있지 않습니다.");
            return;
        }

        end();
    }

    private void handleMoveCommand(String[] commands) {
        if (!isStarted) {
            System.out.println("게임을 하고 있지 않습니다.");
            return;
        }

        if (commands.length != 3) throw new InvalidMoveCommandException();

        String sourcePosition = commands[1];
        String targetPosition = commands[2];

        if (verifySameLocation(sourcePosition, targetPosition))
            throw new InvalidSamePositionException(sourcePosition, targetPosition);

        move(sourcePosition, targetPosition, currentPlayerColor);
    }

    private void RequestCommandInput() {
        System.out.print("명령어를 입력해주세요: ");
    }

    private void start() {
        init();

        System.out.println("게임이 시작되었습니다.");

        chessView.showUpdate();
    }

    private void end() {
        isContinue = false;
        isStarted = false;

        System.out.println("게임이 종료되었습니다.");
    }

    private void move(String sourcePosition, String targetPosition, Color currentPlayerColor) {
        board.move(sourcePosition, targetPosition, currentPlayerColor);

        turn++;

        chessView.showUpdate();
    }

    private boolean verifySameLocation(final String sourcePosition, final String targetPosition) {
        return sourcePosition.equals(targetPosition);
    }
}
