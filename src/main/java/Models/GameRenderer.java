package Models;


public class GameRenderer {

    public void renderMap(GameField gameField) {
        for (int x = 0; x < gameField.getBorderX(); x++) {
            for (int y = 0; y < gameField.getBorderY(); y++) {

                if(gameField.getFields()[x][y].isFlagged()){
                    System.out.print("F");
                    continue;
                }
                if(!gameField.getFields()[x][y].isRevealed()){
                    System.out.print(".");
                    continue;
                }
                if(gameField.getFields()[x][y].isMine()){
                    System.out.print("#");
                    continue;
                }

                int near = gameField.calculateMinesNear(x, y);
                System.out.print(near);

            }
            System.out.println();
        }
    }
}

