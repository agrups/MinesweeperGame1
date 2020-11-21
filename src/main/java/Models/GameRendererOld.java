package Models;


public class GameRendererOld {
    public GameRendererOld() {
    }

    public void renderMap(GameField gameField) {
        for (int x = 0; x < gameField.getBorderX(); x++) {
            for (int y = 0; y < gameField.getBorderY(); y++) {

                if (gameField.getFields()[x][y].isFlagged()) {
                    //System.out.print("F  ");
                    System.out.print("\uD83D\uDEA9  ");
                    continue;
                }
                if (!gameField.getFields()[x][y].isRevealed()) {
                    System.out.print(".  ");
                    //System.out.print("\u25FB ");  //tuscias langelis
                    //System.out.print("\u2460 ");

                    continue;
                }
                if (gameField.getFields()[x][y].isMine()) {
                    System.out.print("#  ");
                    System.out.print("\uD83D\uDCA3 ");
                    continue;
                }

                int near = gameField.calculateMinesNear(x, y);
                System.out.print(near + "  ");

            }
            System.out.println();
        }
    }
}

