package Models;

public class GameRules {

    GameField gameField;
   // Minesweeper minesweeper;

/*    private boolean gameOver = false;

    private boolean won = false;

    private int revealed = 0;*/

/*    public GameRules(GameLevel level) {
        this.level = level;
    }*/

/*    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }*/

    public GameRules() {
    }

    public GameStatus processUserInput(String input) {
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        Field field = gameField.getFields()[x][y];

        switch (input.charAt(0)) {
            case 'f':

                //Position position = new Position(x, y);
                if (field.isFlagged()) {
                   field.setFlagged(false);
                    //level.getFlags().remove(level.getFlag(position));
                    //level.getGameField().setRevealed(x, y, false);
                    return GameStatus.CONTINUE;
                } else {
                    field.setFlagged(true);
/*                    Flag flag = new Flag(position);
                    level.getFlags().add(flag);
                    level.getGameField().setRevealed(x, y, true);*/
                    checkIfWon(x, y);
                }
                break;
            case 'o':
                if (!field.isRevealed() && !field.isFlagged()) {
                    if (field.isMine()) {
/*                        setGameOver(true);
                        setWon(false);*/
                        field.setRevealed(true);
                        return GameStatus.LOST;
                    } else {
                        field.setRevealed(true);
                        checkIfWon(x, y);
                }
                }
                break;
        }
        return GameStatus.CONTINUE;
    }

    public GameStatus checkIfWon(int x, int y) {
        for (int i = 0; i < gameField.getBorderX(); i++) {
            for (int j = 0; j < gameField.getBorderY(); j++) {
                if (!gameField.getFields()[x][y].isRevealed()) {
                    return GameStatus.CONTINUE;
                }
            }
        }
        if (gameField.getMines() == 10) {
            return GameStatus.WON;
/*            setGameOver(true);
            setWon(true);
            System.out.println("Congrats, you won!!!");*/
        }
        return GameStatus.CONTINUE;
    }
}
