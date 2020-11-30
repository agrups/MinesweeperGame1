package Models;

import org.junit.Assert;
import org.junit.Test;

public class GameRulesTest {

    private GameRules gameRules = new GameRules();

    @Test
    public void gameLostWhenMineIsOpened() {
        GameField gameField = new GameField();
        Field[][] fields = gameField.getFields();
        String input = findFirstMine(fields);
        GameStatus gameStatus = gameRules.processUserInput(input, gameField);
        Assert.assertTrue(gameStatus.equals(GameStatus.LOST));
    }

    private String findFirstMine(Field[][] fields) {
        String input = "o";
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                if (fields[i][j].isMine()) {
                    return input + i + j;
                }
            }
        }
        return null;
    }

    @Test
    public void gameWonWhenLastMineIsFlagged() {

    }

    @Test
    public void gameRunningWhenNotAllMinesAreFlagged() {
        GameField gameField = new GameField();
        Field[][] fields = gameField.getFields();
        String input = "o";
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                if (!fields[i][j].isMine()) {
                    input += i + j;
                }
            }
        }

        GameStatus gameStatus = gameRules.processUserInput(input, gameField);
        Assert.assertTrue(gameStatus.equals(GameStatus.RUNNING));
    }

}