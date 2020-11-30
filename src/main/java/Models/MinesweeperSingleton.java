package Models;

import java.util.Scanner;

import static Models.GameStatus.RUNNING;

public class MinesweeperSingleton {

    private static MinesweeperSingleton instance = null;

    private MinesweeperSingleton() {
    }

    GameField gameField = new GameField();
    UnicodeRender unicodeRender = new UnicodeRender();
    ConsoleRender consoleRender = new ConsoleRender();
    ConsoleInput consoleInput = new ConsoleInput();
    GameRules gameRules = new GameRules();

    GameStatus gameStatus = RUNNING;

    public static synchronized MinesweeperSingleton getInstance() {
        if (instance == null) {
            instance = new MinesweeperSingleton();
        }
        return instance;
    }

    public GameRenderer chooseVisual() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!input.equals("1") && !input.equals("2")) {
            System.out.println("If you want the game to be printed in unicode press 1, if not press 2: ");
            input = scan.next();
        }
        if (input.equals("1")) {
            return unicodeRender;
        }
        return consoleRender;
    }

    public void playGame(GameRenderer gameRenderer) {

        while (gameStatus == gameStatus.RUNNING) {

            gameRenderer.renderMap(gameField);

            String key = consoleInput.readConsoleInput(gameField.getFields());

            gameStatus = gameRules.processUserInput(key, gameField);

        }
        gameRenderer.renderMap(gameField);

    }

    public void printResult() {
        if (gameStatus == gameStatus.LOST) {
            System.out.println("There was a mine. You have lost");
        } else {
            System.out.println("Congrads!!! You won");
        }
    }
}
