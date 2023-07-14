package softeer2nd.chess.Board;


import softeer2nd.utils.StringUtils;

import static softeer2nd.chess.Board.Constants.*;

public class PointCalculator {

    private final Board board;

    public PointCalculator(Board board) {
        this.board = board;
    }

    private double calculateWhitePoint() {
        return board.calculatePoint(Color.WHITE);
    }

    private double calculateBlackPoint() {
        return board.calculatePoint(Color.BLACK);
    }

    public String showPoint() {

        StringBuilder sb = new StringBuilder();
        StringUtils.appendNewLine(sb.append("흰색 점수: ").append(calculateWhitePoint()))
                .append("검은색 점수: ").append(calculateBlackPoint());

        return sb.toString();
    }
}
