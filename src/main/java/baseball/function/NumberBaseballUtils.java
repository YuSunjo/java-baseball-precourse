package baseball.function;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberBaseballUtils {

    public static List<Integer> toList(String player) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < player.length(); i++) {
            String substring = player.substring(i, i + 1);
            integerList.add(Integer.valueOf(substring));
        }
        return integerList;
    }

    public static int correctNum(List<Integer> computerList, List<Integer> playerList) {
        int correctNum = 0;
        for (Integer integer : playerList) {
            if(computerList.contains(integer)) {
                correctNum += 1;
            }
        }
        return correctNum;
    }

    public static int strikeNum(List<Integer> computer, List<Integer> player) {
        int strikeNum = 0;
        for (int i = 0; i < player.size(); i++) {
            if(computer.get(i).equals(player.get(i))) {
                strikeNum += 1;
            }
        }
        return strikeNum;
    }

    public static String inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String output(List<Integer> computerList, List<Integer> playerList) {
        int correctNum = NumberBaseballUtils.correctNum(computerList, playerList);
        int strikeNum = NumberBaseballUtils.strikeNum(computerList, playerList);
        int ballNum = correctNum - strikeNum;
        if (correctNum == 0) {
            return "낫싱";
        }
        if (strikeNum == 0) {
            return String.format("%s볼", ballNum);
        }
        if (ballNum == 0) {
            return String.format("%s스트라이크", strikeNum);
        }
        return String.format("%s볼 %s스트라이크", ballNum, strikeNum);
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String answer = Console.readLine();
        validateAgain(answer);
        return !answer.equals("2");
    }

    public static List<Integer> pickNum(int maxNumSize) {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < maxNumSize) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (randomList.contains(number)) {
                continue;
            }
            randomList.add(number);
        }
        return randomList;
    }

    public static void validate(String output, int maxNumSize) {
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

    public static List<Integer> isPlay(boolean isPlay, int maxNumSize) {
        if (isPlay) {
            return NumberBaseballUtils.pickNum(maxNumSize);
        }
        return Collections.emptyList();
    }

}