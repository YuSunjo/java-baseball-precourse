package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballPlayer {

    private List<Integer> playerList;

    public BaseballPlayer() {
    }

    public BaseballPlayer(List<Integer> playerList) {
        this.playerList = playerList;
    }

    public void setPlayerList(String player) {
        List<Integer> playerList = new ArrayList<>();
        for (int i = 0; i < player.length(); i++) {
            String substring = player.substring(i, i + 1);
            playerList.add(Integer.valueOf(substring));
        }
        this.playerList = playerList;
    }

    public List<Integer> getPlayerList() {
        return playerList;
    }

    public static BaseballPlayer of(List<Integer> playerList) {
        return new BaseballPlayer(playerList);
    }

}
