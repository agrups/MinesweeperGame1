package Models;

public class GameRules {

    private GameLevel level;

    private boolean gameOver =false;

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
                Flag flag = level.getFlag(new Position(x, y));
                if(flag == null){
                    level.getFlags().add(flag);
                }else{
                    level.getFlags().remove(flag);
                }
                break;
            case 'o':
                if (!level.getGameField().getRevealed()[x][y]){
                    level.getGameField().getRevealed()[x][y] = true;
                    if(level.getMines().contains(new Mine(new Position(x,y)))){
                        setGameOver(true);
                    }
                }
                break;
        }
    }
}
