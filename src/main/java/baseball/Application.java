package baseball;

import baseball.controller.GameController;
import baseball.function.GameStatus;
import baseball.service.GameService;

public class Application {

    private static final int MAX_NUM_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        String status = GameStatus.START.getStatus();
        gameController.gamsStart(MAX_NUM_SIZE, status);
    }

}
