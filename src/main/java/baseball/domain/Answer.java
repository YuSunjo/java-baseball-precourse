package baseball.domain;

import java.util.List;

public class Answer {

    String answer = "";

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String output(List<Integer> computerList, List<Integer> playerList) {
        int correctNum = this.correctNum(computerList, playerList);
        int strikeNum = this.strikeNum(computerList, playerList);
        int ballNum = correctNum - strikeNum;
        if (correctNum == 0) {
            return this.answer = "낫싱";
        }
        if (strikeNum == 0) {
            return this.answer = String.format("%s볼", ballNum);
        }
        if (ballNum == 0) {
            return this.answer = String.format("%s스트라이크", strikeNum);
        }
        return this.answer = String.format("%s볼 %s스트라이크", ballNum, strikeNum);
    }

    public int strikeNum(List<Integer> computerList, List<Integer> playerList) {
        int strikeNum = 0;
        for (int i = 0; i < playerList.size(); i++) {
            if(computerList.get(i).equals(playerList.get(i))) {
                strikeNum += 1;
            }
        }
        return strikeNum;
    }

    public int correctNum(List<Integer> computerList, List<Integer> playerList) {
        int correctNum = 0;
        for (Integer integer : playerList) {
            if(computerList.contains(integer)) {
                correctNum += 1;
            }
        }
        return correctNum;
    }

}
