package Models;

import java.util.Random;

public class GameField {

    private static final int borderX = 9;
    private static final int borderY = 9;
    private Field[][] fields = new Field[borderX][borderY];
    private static final int mines = 10;

    public GameField(){
        setUpMap();
        generateMines();
    }

    public void setUpMap(){
        for(int x = 0; x < borderX; x++){
            for(int y = 0; y < borderY; y++){
                fields[x][y] = new Field();
            }
        }
    }
    public void generateMines(){
        Random rand = new Random();
        int i = 0;
        while (i < 10) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            if (fields[x][y].isMine()) continue;
            fields[x][y].setMine(true);
            i++;
        }
    }

    public static int getMines() {
        return mines;
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
        if (outBounds(x, y)) return;
        if (fields[x][y].isRevealed()) return;
        fields[x][y].setRevealed(true);
        if (calculateMinesNear(x, y) != 0) return;
        reveal(x - 1, y - 1);
        reveal(x - 1, y + 1);
        reveal(x + 1, y - 1);
        reveal(x + 1, y + 1);
        reveal(x - 1, y);
        reveal(x + 1, y);
        reveal(x, y - 1);
        reveal(x, y + 1);
    }
}
