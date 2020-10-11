package Models;

import java.util.HashMap;

public class Mine {
/*    private int x;
    private int y;*/

    Position position;

/*    public Mine(int x, int y) {
        this.x = x;
        this.y = y;
    }*/

    public Mine(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

/*    HashMap<int[][], Boolean> flagedMines = new HashMap<>();




*/
}
