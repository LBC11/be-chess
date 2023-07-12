package softeer2nd;

import softeer2nd.chess.Chess;

import java.util.Scanner;

public class Main {

    static Chess chess;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        chess = new Chess();
        chess.init();

        // 명령어 입력 받는 이 부분 chess class 안으로 넣어버리자
        // 2중 반복문을 한번에 종료하기 위한 라벨
        outer:
        while(true) {

            System.out.print("명령어를 입력해주세요: ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "start" -> System.out.println(chess.start());
                case "end" -> System.out.println(chess.end());
                case "exit" -> {
                    System.out.println("시스템을 종료합니다.");
                    break outer;
                }
                default -> System.out.println("올바른 명령어가 아닙니다.");
            }
        }
    }
}