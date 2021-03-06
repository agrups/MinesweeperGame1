package Models;

import java.util.Random;

public class GameField {

    private static final int borderX = 9;
    private static final int borderY = 9;
    private Field[][] fields = new Field[borderX][borderY];
    private static final int MINES_COUNT = 10;

    public GameField() {
        setUpMap();
        generateMines();
    }

    public void setUpMap() {
        for (int x = 0; x < borderX; x++) {
            for (int y = 0; y < borderY; y++) {
                fields[x][y] = new Field();
            }
        }
    }

    public void generateMines() {
        Random rand = new Random();
        int i = 0;
        while (i < MINES_COUNT) {
            int x = rand.nextInt(borderX - 1);
            int y = rand.nextInt(borderY - 1);
            if (fields[x][y].isMine())
                continue;

            fields[x][y].setMine(true);
            i++;
        }
    }

    public static int getMinesCount() {
        return MINES_COUNT;
    }

    public static int getBorderX() {
        return borderX;
    }

    public static int getBorderY() {
        return borderY;
    }

    public Field[][] getFields() {
        return fields;
    }

    public boolean outBounds(int x, int y) {
        return x < 0 || y < 0 || x >= borderX || y >= borderY;
    }

    public int calculateMinesNear(int x, int y) {
        if (outBounds(x, y)) return 0;
        int count = 0;
        for (int boundX = -1; boundX <= 1; boundX++) {
            for (int boundY = -1; boundY <= 1; boundY++) {
                if (outBounds(boundX + x, boundY + y)) continue;
                if (fields[boundX + x][boundY + y].isMine()) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public void reveal(int x, int y) {
        if (outBounds(x, y))
            return;
        if (fields[x][y].isRevealed())
            return;
        fields[x][y].setRevealed(true);
        if (calculateMinesNear(x, y) != 0)
            return;

        for (int boundX = -1; boundX <= 1; boundX++) {
            for (int boundY = -1; boundY <= 1; boundY++) {
                if (!(boundX == 0 && boundY == 0)) {
                    reveal(boundX + x, boundY + y);
                }
            }
        }
    }
}
