package Models;

import java.io.IOException;

import static Models.GameStatus.CONTINUE;
import static Models.GameStatus.LOST;

public class Minesweeper {
    GameField gameField = new GameField();
    GameRenderer gameRenderer = new GameRenderer();
    ConsoleInput consoleInput = new ConsoleInput();
    GameRules gameRules = new GameRules();

    GameStatus gameStatus = CONTINUE;

    public void playGame() throws IOException {

        gameRenderer.renderMap(gameField);
        while (gameStatus == CONTINUE) {

        gameRenderer.renderMap(gameField);

        String key = consoleInput.readConsoleInput(gameField.getFields());

        gameRules.processUserInput(key, gameField.getFields());
    }

        gameRenderer.renderMap(gameField);
    }

    public void printResult(){
        if(gameStatus == LOST){
            System.out.println("There was a mine. You have lost");
        }
        else{
            System.out.println("Congrads!!! You won");
        }
    }

}
