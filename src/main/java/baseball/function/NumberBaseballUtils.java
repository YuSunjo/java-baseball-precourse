package baseball.function;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballUtils {

    public static String inputNum(int maxNumSize) {
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();
        validate(player, maxNumSize);
        return player;
    }

    public static String playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String answer = Console.readLine();
        validateAgain(answer);
        return answer;
    }

    private static void validate(String output, int maxNumSize) {
        try {
            if (output.length() < maxNumSize) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (output.length() > maxNumSize) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            Integer.valueOf(output);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static void validateAgain(String answer) {
        try {
            if (answer.length() != 1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            Integer.valueOf(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}