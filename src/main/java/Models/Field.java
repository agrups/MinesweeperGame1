package Models;

public class Field {
    private boolean isMine = false;
    private boolean isFlagged = false;
    private boolean isRevealed = false;

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
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        this.isRevealed = revealed;
    }
}
