package Models;

import java.util.ArrayList;
import java.util.List;

public class GameLevel {

    private GameField gameField;

    private ArrayList<Flag> mines;

    private ArrayList<Flag> flags;

    public GameLevel(GameField map, ArrayList<Flag> mines, ArrayList<Flag> flags) {
        setGameField(map);
        setMines(mines);
        setFlags(flags);
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public ArrayList<Flag> getMines() {
        return mines;
    }

    public void setMines(ArrayList<Flag> mines) {
        this.mines = mines;
    }

    public ArrayList<Flag> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Flag> flags) {
        this.flags = flags;
    }

    public boolean hasMine(Position position) {
        return mines.stream().anyMatch(mine -> mine.getPosition().getX() == position.getX() &&
                mine.getPosition().getY() == position.getY());
    }

    public boolean hasFlag(Position position) {
        return flags.stream().anyMatch(flag -> flag.getPosition().getX() == position.getX() &&
                flag.getPosition().getY() == position.getY());
    }

    public Flag getFlag(Position position) {
        return flags.stream().filter(flag -> flag.getPosition().getX() == position.getX() &&
                flag.getPosition().getY() == position.getY()).findFirst().orElse(null);
    }
}