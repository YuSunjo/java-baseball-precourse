package baseball.controller;

import baseball.function.GameStatus;
import baseball.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void gamsStart(int maxNumSize, String status) {
        String gameStatus = status;
        while (gameStatus.equals(GameStatus.START.getStatus())) {
            gameStatus = gameService.playGame(maxNumSize);
        }
    }

}
