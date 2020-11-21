package Models;

import static Models.GameStatus.RUNNING;
import static Models.GameStatus.WON;

public class GameRules {

    public GameRules() {
    }

    public GameStatus processUserInput(String input, GameField gameField) {
        Field[][] fields = gameField.getFields();
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        Field field = fields[x][y];
        GameStatus gameStatus = RUNNING;
        switch (input.charAt(0)) {
            case 'f':
                if (field.isFlagged()) {
                    field.setFlagged(false);
                    gameStatus = RUNNING;
                } else {
                    field.setFlagged(true);
                    gameStatus = checkIfWon(fields, gameField.getMinesCount());
                }
                break;
            case 'o':
                if (!field.isRevealed() && !field.isFlagged()) {
                    if (field.isMine()) {
                        field.setRevealed(true);
                        gameStatus = GameStatus.LOST;
                    } else {
                        gameField.reveal(x, y);
                        gameStatus = checkIfWon(fields, gameField.getMinesCount());
                    }
                }
                break;
        }
        return gameStatus;
    }

    public GameStatus checkIfWon(Field[][] fields, int minesCount) {
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
