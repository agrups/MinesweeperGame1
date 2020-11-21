package Models;

import static Models.GameStatus.LOST;
import static Models.GameStatus.RUNNING;

public class Minesweeper {
    GameField gameField = new GameField();
    GameRendererOld gameRenderer = new GameRendererOld();
    ConsoleInput consoleInput = new ConsoleInput();
    GameRules gameRules = new GameRules();

    GameStatus gameStatus = RUNNING;

    public void playGame() {
        int moves = 0;
        while (gameStatus == gameStatus.RUNNING) {

            gameRenderer.renderMap(gameField);

            String key = consoleInput.readConsoleInput(gameField.getFields());

            gameStatus = gameRules.processUserInput(key, gameField);

            moves++;

        }
        gameRenderer.renderMap(gameField);

        if (moves == 1 && gameStatus == LOST) {
            startAgain();
        }
    }

    public void printResult() {
        if (gameStatus == gameStatus.LOST) {
            System.out.println("There was a mine. You have lost");
        } else {
            System.out.println("Congrads!!! You won");
        }
    }

    private void startAgain() {
        Minesweeper mineSweeper = new Minesweeper();
        System.out.println();
        mineSweeper.playGame();
    }
}
