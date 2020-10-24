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

        while (gameStatus == CONTINUE) {

        gameRenderer.renderMap(gameField);

        String key = consoleInput.readConsoleInput(gameField.getFields());

        gameStatus = gameRules.processUserInput(key, gameField);
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
