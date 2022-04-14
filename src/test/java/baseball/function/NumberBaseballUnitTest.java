package baseball.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballUnitTest {

    private static final int MAX_NUM_SIZE = 3;
    private static final int MIN_NUM_SIZE = 0;

    @DisplayName("문자열을 리스트로 변환한다.")
    @Test
    void 문자열을_리스트로_변환() {
        // given
        String toList = "167";

        // when
        List<Integer> integers = NumberBaseballUtils.toList(toList);

        // then
        assertThat(integers.get(0)).isEqualTo(1);
        assertThat(integers.get(1)).isEqualTo(6);
        assertThat(integers.get(2)).isEqualTo(7);
        assertThat(integers).hasSize(3);
    }

    @DisplayName("스트라이크, 볼 상관없이 개수 구하기 - 만약 computer, player 가 같으면 MAX_NUM_SIZE 만큼 존재")
    @Test
    void 존재하는_숫자_개수_구하기_1() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        int correctNum = NumberBaseballUtils.correctNum(computer, player);

        // then
        assertThat(correctNum).isEqualTo(MAX_NUM_SIZE);
    }

    @DisplayName("스트라이크, 볼 상관없이 개수 구하기 - 만약 computer, player 가 같지 않지만 존재하는 숫자가 같을 경우")
    @Test
    void 존재하는_숫자_개수_구하기_2() {
        // given
        List<Integer> computer = Arrays.asList(2, 3, 1);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        int correctNum = NumberBaseballUtils.correctNum(computer, player);

        // then
        assertThat(correctNum).isEqualTo(MAX_NUM_SIZE);
    }

    @DisplayName("스트라이크(자리와 숫자 모두 같은) 개수 구하기 - 만약 computer, player 가 같으면 MAX_NUM_SIZE 만큼 존재 ")
    @Test
    void 스트라이크_개수_구하기_1() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        int strikeNum = NumberBaseballUtils.strikeNum(computer, player);

        // then
        assertThat(strikeNum).isEqualTo(MAX_NUM_SIZE);
    }

    @DisplayName("스트라이크(자리와 숫자 모두 같은) 개수 구하기 - 만약 computer, player 가 숫자는 같지만 자리가 모두 다를 경우 0 만큼 존재")
    @Test
    void 스트라이크_개수_구하기_2() {
        // given
        List<Integer> computer = Arrays.asList(2, 3, 1);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        int strikeNum = NumberBaseballUtils.strikeNum(computer, player);

        // then
        assertThat(strikeNum).isEqualTo(MIN_NUM_SIZE);
    }

    @DisplayName("스트라이크, 볼 정보 아웃풋 - 만약 1개는 자리가 같고 1개는 자리는 다르지만 숫자가 같은 경우")
    @Test
    void 스트라이크_볼_정보_아웃풋_1() {
        // given
        List<Integer> computer = Arrays.asList(1, 4, 2);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        String output = NumberBaseballUtils.output(computer, player);

        // then
        assertThat(output).contains("1볼");
        assertThat(output).contains("1스트라이크");
    }

    @DisplayName("스트라이크, 볼 정보 아웃풋 - 만약 같은 숫자가 하나도 없을 경우")
    @Test
    void 스트라이크_볼_정보_아웃풋_2() {
        // given
        List<Integer> computer = Arrays.asList(4, 5, 6);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        String output = NumberBaseballUtils.output(computer, player);

        // then
        assertThat(output).contains("낫싱");
    }

    @DisplayName("스트라이크, 볼 정보 아웃풋 - 모두 같을 경우")
    @Test
    void 스트라이크_볼_정보_아웃풋_3() {
        // given
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        String output = NumberBaseballUtils.output(computer, player);

        // then
        assertThat(output).contains("3스트라이크");
    }

    @DisplayName("무작위 숫자 구하기 길이가 MAX_NUM_SIZE 만큼")
    @Test
    void 무작위_숫자() {
        // when
        List<Integer> randomList = NumberBaseballUtils.pickNum(MAX_NUM_SIZE);

        // then
        assertThat(randomList).hasSize(MAX_NUM_SIZE);
    }

}
