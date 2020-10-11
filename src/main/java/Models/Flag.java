package Models;

public class Flag {
    Position position;

    public Flag(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
