package de.supercode;

import java.util.Arrays;

import static de.supercode.Content.EMPTY;
import static de.supercode.Content.MINE;
import static de.supercode.State.FLAGGED;

public class GameBoard {

    private final int[] di = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
    private final int[] dj = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

    private int MINES;
    private int ROWS;
    private int COLUMNS;

    private Cell[][] board;

    public GameBoard(int columns, int rows, int mines) {
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.MINES = mines;
        initialiseEmptyBoard();
        minesSetter();
//        setNumberAdiacentMines();
    }

//    For each non-mine cell, calculate the number of adjacent mines and store this number in the cell
    private void setNumberAdiacentMines() {
        for (int i = 0; i < MINES; i++) {
            for (int j=0; j<COLUMNS;j++) {
                board[i][j] = new Cell();
            }
        }
    }

    private void initialiseEmptyBoard() {
        this.board = new Cell[MINES][COLUMNS];
        for (int i = 0; i < MINES; i++) {
            for (int j=0; j<COLUMNS;j++) {
                board[i][j] = new Cell();
            }
        }
    }

    private void minesSetter() {
//        Randomly place the mines on the field
        for (int mine = 0; mine < MINES; mine++) {
            int i = (int) (Math.random() * ROWS);
            int j = (int) (Math.random() * COLUMNS);
            if (board[i][j].getContent() == EMPTY){
                board[i][j].setContent(MINE);
                addCounterToNeighbours(i, j);
            }
            else mine--;
        }
    }

    private void addCounterToNeighbours(int i, int j) {
        for (int x = i-1; x <= i+1; x++)
            for (int y = j-1; y <= j+1; y++)
                if (x>=0 && x<ROWS && y>=0 && y<COLUMNS)
                    if (!board[x][y].isMine()) board[x][y].increaseCouterAdiacentMines();

    }

    public void printGameBoard() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}
