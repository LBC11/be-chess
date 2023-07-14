package softeer2nd.chess.Board;

import softeer2nd.utils.StringUtils;

public class chessView {

    private final Board board;
    private final PointCalculator pointCalculator;

    public chessView(Board board, PointCalculator pointCalculator) {

        this.board = board;
        this.pointCalculator = pointCalculator;
    }

    public void showBoard() {
        System.out.println(board.showBoard());
    }

    public void showPoint() {
        StringBuilder sb = new StringBuilder();
        StringUtils.appendNewLine(sb.append("흰색 점수: ").append(pointCalculator.calculateWhitePoint()))
                .append("검은색 점수: ").append(pointCalculator.calculateBlackPoint());

        System.out.println(sb);
    }
}
