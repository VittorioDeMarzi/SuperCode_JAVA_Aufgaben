package de.supercode;

import static de.supercode.Content.EMPTY;
import static de.supercode.Content.MINE;
import static de.supercode.State.*;

public class Cell {
    private Content content;
    private State state;
    private int touchingMines;

    public Cell() {
        this.content = EMPTY;
        this.state = REVEALED;
        this.touchingMines = 0;
    }

    public int getTouchingMines() {
        return touchingMines;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
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
        return this.content == MINE;
    }

    public boolean isFlagged() {
        return this.state == FLAGGED;
    }

    public boolean isRevealed() {
        return this.state == REVEALED;
    }

    public void increaseCouterAdiacentMines() {
        this.touchingMines++;
    }
}
