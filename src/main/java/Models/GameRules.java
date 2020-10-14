package Models;

public class GameRules {

    private GameLevel level;

    private boolean gameOver = false;

    private boolean won = false;

    private int revealed = 0;

    public GameRules(GameLevel level) {
        this.level = level;
    }

    public boolean isGameOver() {
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
    }

    public void processUserInput(String input) {
        int x = Integer.parseInt(input.substring(1, 2));
        int y = Integer.parseInt(input.substring(2));

        switch (input.charAt(0)) {
            case 'f':
                Position position = new Position(x, y);
                if(level.hasFlag(position)){
                    level.getFlags().remove(level.getFlag(position));
                    level.getGameField().setRevealed(x, y, false);
                }else{
                    Flag flag = new Flag(position);
                    level.getFlags().add(flag);
                    level.getGameField().setRevealed(x, y, true);
                    checkIfWon(x, y);
                }
                break;
            case 'o':
                if (!level.getGameField().getRevealed(x, y)){
                    if(level.hasMine(new Position(x, y))){
                        setGameOver(true);
                        setWon(false);
                        level.getGameField().setRevealed(x, y, true);
                    }
                    else{
                        level.getGameField().reveal(x, y);
                    }
                }
                break;
        }
    }

    public void checkIfWon(int x, int y){
        for(int i =0; i < level.getGameField().getFieldHeight(); i++){
            for(int j = 0; j < level.getGameField().getFieldWidth(); j++){
                if(!level.getGameField().getRevealed(x, y)){
                    return;
                }
            }
        }
        if(level.getFlags().size() == 10){
            setGameOver(true);
            setWon(true);
            System.out.println("Congrats, you won!!!");
        }
    }
}
