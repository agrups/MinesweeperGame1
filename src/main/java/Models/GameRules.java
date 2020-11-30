package Models;

import static Models.GameStatus.RUNNING;
import static Models.GameStatus.WON;

public class GameRules {

    public GameRules() {
    }

    public GameStatus processUserInput(String input, GameField gameField) {
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        if (input.charAt(0) == 'f') {
            return flagField(gameField, x, y);
        } else {
            return openField(gameField, x, y);
        }
    }

    private GameStatus flagField(GameField gameField, int x, int y) {
        Field[][] fields = gameField.getFields();
        Field field = fields[x][y];
        if (field.isFlagged()) {
            field.setFlagged(false);
            return RUNNING;
        } else {
            field.setFlagged(true);
            return checkIfWon(fields, gameField.getMinesCount());
        }
    }

    private GameStatus openField(GameField gameField, int x, int y) {
        Field[][] fields = gameField.getFields();
        Field field = fields[x][y];

        if (field.isRevealed() || field.isFlagged()) {
            return RUNNING;
        }

        if (field.isMine()) {
            field.setRevealed(true);
            return GameStatus.LOST;
        } else {
            gameField.reveal(x, y);
            return checkIfWon(fields, gameField.getMinesCount());
        }
    }

    private GameStatus checkIfWon(Field[][] fields, int minesCount) {
        int flaggedMines = 0;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                if (fields[i][j].isFlagged()) {
                    if (fields[i][j].isMine()) {
                        flaggedMines++;
                    } else {
                        return RUNNING;
                    }
                }
            }
        }
        return flaggedMines == minesCount ? WON : RUNNING;
    }
}
