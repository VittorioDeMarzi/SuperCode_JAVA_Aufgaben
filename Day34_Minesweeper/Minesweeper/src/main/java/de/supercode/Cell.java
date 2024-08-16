package de.supercode;
import static de.supercode.State.*;

public class Cell {
    private Boolean isMine;
    private State state;
    private int touchingMines;

    public Cell() {
        this.isMine = false;
        this.state = HIDDEN;
        this.touchingMines = 0;
    }

    public int getTouchingMines() {
        return touchingMines;
    }

    public Boolean getIsMine() {
        return isMine;
    }

    public void setIsMine() {
        this.isMine = true;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (this.isFlagged()) return "F";
        if (this.isRevealed()) return this.isMine() ? "*" : String.valueOf(touchingMines);
        else return "□";
    }


//    @Override
//    public String toString() {
//        return content +
//                ", " + state +
//                ", " + touchingMines;
//    }

    private boolean isHidden() {
        return this.state == HIDDEN;
    }

    boolean isMine() {
        return this.isMine;
    }

    public boolean isFlagged() {
        return this.state == FLAGGED;
    }

    public boolean isRevealed() {
        return this.state == REVEALED;
    }

    public void increaseCounterAdiacentMines() {
        this.touchingMines++;
    }
}
