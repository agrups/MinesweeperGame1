package Models;

abstract class GameRenderer {

    public void printFlag() { }
    public void printNotRevealed() { }
    public void printBomb() { }
    public void printNumber(int near){}

    public void renderMap(GameField gameField) {
        for (int x = 0; x < gameField.getBorderX(); x++) {
            for (int y = 0; y < gameField.getBorderY(); y++) {

                if (gameField.getFields()[x][y].isFlagged()) {
                    printFlag();
                    continue;
                }
                if (!gameField.getFields()[x][y].isRevealed()) {
                    printNotRevealed();
                    continue;
                }
                if (gameField.getFields()[x][y].isMine()) {
                    printBomb();
                    continue;
                }

                int near = gameField.calculateMinesNear(x, y);
                printNumber(near);

            }
            System.out.println();
        }
    }
}
