package baseball;

import baseball.function.NumberBaseballUtils;

import java.util.List;

public class Application {

    private static final int MAX_NUM_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isPlay = true;

        while (isPlay) {
            List<Integer> computerList = NumberBaseballUtils.pickNum(MAX_NUM_SIZE);

            String output = "";
            while (!output.equals(String.format("%s스트라이크", MAX_NUM_SIZE))) {
                String player = NumberBaseballUtils.inputNum();
                NumberBaseballUtils.validate(player, MAX_NUM_SIZE);
                List<Integer> playerList = NumberBaseballUtils.toList(player);
                output = NumberBaseballUtils.output(computerList, playerList);
                System.out.println(output);
            }
            System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료%n", MAX_NUM_SIZE);
            isPlay = NumberBaseballUtils.playAgain();
        }
    }

}
