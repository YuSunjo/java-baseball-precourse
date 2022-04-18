package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AnswerTest {

    @DisplayName("computerList 와 playerList 두 리스트의 자리 상관없이 일치하는 숫자 개수를 카운트한다.")
    @Test
    void correctNum() {
        // given
        Answer answer = new Answer();
        BaseballComputer baseballComputer = BaseballComputer.of(Arrays.asList(2, 5, 6));
        BaseballPlayer baseballPlayer = BaseballPlayer.of(Arrays.asList(2, 9, 5));

        // when
        int correctNum = answer.correctNum(baseballComputer.getComputerList(), baseballPlayer.getPlayerList());

        // then
        Assertions.assertThat(correctNum).isEqualTo(2);
    }

    @DisplayName("computerList 와 playerList 두 리스트의 자리와 숫자가 일치하는 개수를 카운트한다.")
    @Test
    void strikeNum() {
        // given
        Answer answer = new Answer();
        BaseballComputer baseballComputer = BaseballComputer.of(Arrays.asList(2, 5, 6));
        BaseballPlayer baseballPlayer = BaseballPlayer.of(Arrays.asList(2, 9, 5));
        // when
        int strikeNum = answer.strikeNum(baseballComputer.getComputerList(), baseballPlayer.getPlayerList());

        // then
        Assertions.assertThat(strikeNum).isEqualTo(1);
    }

    @DisplayName("playerList 의 %s볼 %스트라이크를 알려준다.")
    @Test
    void output() {
        // given
        Answer answer = new Answer();
        String result = "1볼 1스트라이크";
        BaseballComputer baseballComputer = BaseballComputer.of(Arrays.asList(2, 5, 6));
        BaseballPlayer baseballPlayer = BaseballPlayer.of(Arrays.asList(2, 9, 5));

        // when
        String output = answer.output(baseballComputer.getComputerList(), baseballPlayer.getPlayerList());

        // then
        Assertions.assertThat(output).isEqualTo(result);
    }

}
