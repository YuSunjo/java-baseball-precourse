package baseball.service;

import baseball.domain.Answer;
import baseball.domain.BaseballComputer;
import baseball.domain.BaseballPlayer;
import baseball.function.NumberBaseballUtils;

public class GameService {

    public String playGame(int maxNumSize) {
        BaseballComputer baseballComputer = new BaseballComputer();
        Answer answer = new Answer();
        BaseballPlayer baseballPlayer = new BaseballPlayer();

        baseballComputer.setBaseballComputer(maxNumSize);
        while (!answer.getAnswer().equals(String.format("%s스트라이크", maxNumSize))) {
            String player = NumberBaseballUtils.inputNum(maxNumSize);
            baseballPlayer.setPlayerList(player);
            String output = answer.output(baseballComputer.getComputerList(), baseballPlayer.getPlayerList());
            System.out.println(output);
        }
        System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료%n", maxNumSize);
        return NumberBaseballUtils.playAgain();
    }

}
