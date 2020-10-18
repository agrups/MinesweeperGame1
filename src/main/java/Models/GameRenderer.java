package Models;


public class GameRenderer {

    public void renderMap(GameLevel gameLevel) {
        for (int x = 0; x < gameLevel.getGameField().getFieldHeight(); x++) {
            for (int y = 0; y < gameLevel.getGameField().getFieldWidth(); y++) {

                if(gameLevel.hasFlag(new Position(x, y))){
                    System.out.print("F");
                    continue;
                }
                if(!gameLevel.getGameField().getRevealed(x, y)){
                    System.out.print(".");
                    continue;
                }
                if(gameLevel.hasMine(new Position(x, y))){
                    System.out.print("#");
                    continue;
                }

                int near = gameLevel.getGameField().calculateMinesNear(x, y);
                System.out.print(near);

            }
            System.out.println();
        }
    }
}

