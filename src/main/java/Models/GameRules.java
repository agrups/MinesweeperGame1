package Models;

public class GameRules {

    public GameRules() {
    }

    public GameStatus processUserInput(String input, GameField gameField) {
        Field[][] fields = gameField.getFields();
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        Field field = fields[x][y];
        GameStatus gameStatus;
        gameStatus = GameStatus.CONTINUE;
        switch (input.charAt(0)) {
            case 'f':

                if (field.isFlagged()) {
                    field.setFlagged(false);
                    gameStatus = GameStatus.CONTINUE;
                } else {
                    field.setFlagged(true);
                    gameStatus = checkIfWon(x, y, gameField);
                }
                break;
            case 'o':
                if (!field.isRevealed() && !field.isFlagged()) {
                    if (field.isMine()) {
                        field.setRevealed(true);
                        gameStatus = GameStatus.LOST;
                    } else {
                        gameField.reveal(x, y);
                        gameStatus = checkIfWon(x, y, gameField);
                }
                }
                break;
        }
        //return GameStatus.CONTINUE;
        return gameStatus;
    }

    public GameStatus checkIfWon(int x, int y, GameField gameField) {
        Field[][] fields = gameField.getFields();
        GameStatus gameStatus;
        gameStatus = GameStatus.CONTINUE;
        int flaggedFields = 0;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                if (!fields[x][y].isRevealed() && !fields[x][y].isFlagged()) {
                    gameStatus = GameStatus.CONTINUE;
                }
                if(fields[x][y].isFlagged()){
                    flaggedFields++;
                }
            }
        }
        if (flaggedFields == gameField.getMines()) {
            gameStatus = GameStatus.WON;
        }
        return gameStatus;
    }
}
