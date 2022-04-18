package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballComputer {

    private List<Integer> computerList;

    public BaseballComputer() {
    }

    public BaseballComputer(List<Integer> computerList) {
        this.computerList = computerList;
    }

    public void setBaseballComputer(int maxNumSize) {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < maxNumSize) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (randomList.contains(number)) {
                continue;
            }
            randomList.add(number);
        }
        this.computerList = randomList;
    }

    public List<Integer> getComputerList() {
        return computerList;
    }

    public static BaseballComputer of(List<Integer> computerList) {
        return new BaseballComputer(computerList);
    }

}
