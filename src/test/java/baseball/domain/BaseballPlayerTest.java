package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballPlayerTest {

    @DisplayName("baseballPlayer 에 입력받은 값을 넘겨줘서 필드에 넣어준다. MAX_NUM_SIZE 에 영향을 받지 않는다. - 문자열 3개")
    @Test
    void create_baseball_player_1() {
        // given
        BaseballPlayer baseballPlayer = new BaseballPlayer();
        String player = "246";

        // when
        baseballPlayer.setPlayerList(player);

        // then
        List<Integer> resultList = Arrays.asList(2, 4, 6);
        assertThat(baseballPlayer.getPlayerList()).isEqualTo(resultList);
    }

    @DisplayName("플레이어가 입력받은 값을 넘겨줘서 필드에 넣어준다. MAX_NUM_SIZE 에 영향을 받지 않는다. - 문자열 4개")
    @Test
    void create_baseball_player_2() {
        // given
        BaseballPlayer baseballPlayer = new BaseballPlayer();
        String player = "2465";

        // when
        baseballPlayer.setPlayerList(player);

        // then
        List<Integer> resultList = Arrays.asList(2, 4, 6, 5);
        assertThat(baseballPlayer.getPlayerList()).isEqualTo(resultList);
    }

}
