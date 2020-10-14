package Models;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.setY(y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position addX(int dx) {
        this.x += dx;
        return this;
    }

    public boolean at(int x2, int y2) {
        return this.x == x2 && this.y == y2;
    }
}
