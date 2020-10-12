package Models;

public class GameField {
    private int fieldWidth = 9;
    private int fieldHeight = 9;

    private boolean[][] revealed = new boolean[fieldWidth][fieldHeight];

    private int model[][] = new int[fieldWidth][fieldHeight];

/*    private int model[][] = new int[][] {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
    };*/

    public GameField() {
        setup();
    }

    public int getValue(int x, int y){
        return model[x][y];
    }
    public void setup() {
        for (int x = 0; x < fieldWidth; x++) {
            for (int y = 0; y < fieldHeight; y++) {
                this.revealed[x][y] = false;
                model[x][y] = 0;
            }
        }
    }
    public int getFieldWidth() {
        return 9;
    }

    public void setFieldWidth(int fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public int getFieldHeight() {
        return 9;
    }

    public void setFieldHeight(int fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public boolean[][] getRevealed() {
        return this.revealed;
    }

    public void setRevealed(boolean[][] revealed) {
        this.revealed = revealed;
    }

    public boolean outBounds(int x, int y){
        return x<0 || y<0 || x>=fieldWidth || y>=fieldHeight;
    }

    //calculate nearest mines
    public int calculateMinesNear(int x, int y) {
        if(outBounds(x,y))return 0;
        int count=0;
        for (int boundX=-1; boundX<=1; boundX++) {
            for (int boundY=-1; boundY<=1; boundY++) {
                if (outBounds(boundX+x, boundY+y))continue;
                if(model[boundX + x][boundY + y] == 1){count += 1;}
            }
        }
        return count;
    }

    public void reveal(int x, int y){
        if(outBounds(x,y))return;
        if(revealed[x][y])return;
        revealed[x][y]=true;
        if(calculateMinesNear(x,y)!=0)return;
        reveal(x-1,y-1);
        reveal(x-1,y+1);
        reveal(x+1,y-1);
        reveal(x+1,y+1);
        reveal(x-1,y);
        reveal(x+1,y);
        reveal(x,y-1);
        reveal(x,y+1);
    }
}
