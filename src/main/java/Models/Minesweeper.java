package Models;

import java.io.IOException;

public class Minesweeper {
    //Minesweeper minesweeper = new Minesweeper();
    GameField gameField = new GameField();
    GameRenderer gameRenderer = new GameRenderer();
    ConsoleInput consoleInput = new ConsoleInput();
    GameRules gameRules = new GameRules();

/*    private int borderX = gameField.getBorderX();
    private int borderY = gameField.getBorderX();*/


/*    public int getBorderX() {
        return borderX;
    }

    public void setBorderX(int borderX) {
        this.borderX = borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public void setBorderY(int borderY) {
        this.borderY = borderY;
    }*/

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    public void setGameRenderer(GameRenderer gameRenderer) {
        this.gameRenderer = gameRenderer;
    }

    public ConsoleInput getConsoleInput() {
        return consoleInput;
    }

    public void setConsoleInput(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

while (!gameRules.isGameOver()) {

        renderer.renderMap(level);

        String key = consoleInput.readConsoleInput(level);

        gameRules.processUserInput(key);
    }

        renderer.renderMap(level);

        if(gameRules.isGameOver() && !gameRules.isWon()){
        System.out.println("There was a mine. You have lost");
    }
}
