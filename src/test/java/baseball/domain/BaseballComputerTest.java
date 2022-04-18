package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballComputerTest {

    @DisplayName("컴퓨터가 무작위로 생성한다. - maxNumSize 만큼의 리스트를 무작위로 생성한다.")
    @Test
    void create_baseball_computer_1() {
        // given
        BaseballComputer baseballComputer = new BaseballComputer();
        int maxNumSize = 3;

        // when
        baseballComputer.setBaseballComputer(maxNumSize);

        // then
        assertThat(baseballComputer.getComputerList()).hasSize(maxNumSize);
    }

    @DisplayName("컴퓨터가 무작위로 생성한다. - maxNumSize 만큼의 리스트를 무작위로 생성한다.")
    @Test
    void create_baseball_computer_2() {
        // given
        BaseballComputer baseballComputer = new BaseballComputer();
        int maxNumSize = 4;

        // when
        baseballComputer.setBaseballComputer(maxNumSize);

        // then
        assertThat(baseballComputer.getComputerList()).hasSize(maxNumSize);
    }

}
