package Models;

public class GameRules {

    private GameLevel level;

    private boolean gameOver =false;

    //private int revealed

    public GameRules(GameLevel level) {
        this.level = level;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void processUserInput(String input) {
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        switch (input.charAt(0)) {
            case 'f':
                Position position = new Position(x, y);
                if(level.hasFlag(position)){
                    level.getFlags().remove(level.getFlag(position));
                }else{
                    Flag flag = new Flag(position);
                    level.getFlags().add(flag);
                    level.getGameField().setRevealed(x, y); //
                }
                break;
            case 'o':
                if (!level.getGameField().getRevealed(x, y)){
                    if(level.hasMine(new Position(x, y))){
                        setGameOver(true);
                        level.getGameField().setRevealed(x, y);
                    }
                    else{
                        level.getGameField().reveal(x, y);
                    }
                    //else parasyti
                }
                break;
        }
    }
}
