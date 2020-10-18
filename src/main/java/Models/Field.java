package Models;

public class Field {
    private boolean isMine = false;
    private boolean isFlagged = false;
    private boolean revealed = false;

    public Field() {
    }

    public String getState() {
        return ".";
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
