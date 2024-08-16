package de.supercode;

import static de.supercode.Main.*;

public class GameBoard {

    private int MINES;
    private int ROWS;
    private int COLUMNS;
    private int remainingFreeCells;

    // The game board as a 2D array of Cell objects
    private Cell[][] board;

    // Constructor to initialize the game board with the given columns, rows, and mines.
    public GameBoard(int columns, int rows, int mines) {
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.MINES = mines;
        this.remainingFreeCells = (ROWS*COLUMNS) - MINES;
        initialiseEmptyBoard();
        minesSetter();
    }

    // Initializes the board with empty cells
    private void initialiseEmptyBoard() {
        this.board = new Cell[ROWS][COLUMNS];
        for (int x = 0; x < ROWS; x++) {
            for (int y=0; y<COLUMNS;y++) {
                board[x][y] = new Cell();
            }
        }
    }

    private void minesSetter() {
//        Randomly place the mines on the field
        for (int mine = 0; mine < MINES; mine++) {
            int x = (int) (Math.random() * ROWS);
            int y = (int) (Math.random() * COLUMNS);
            if (!board[x][y].isMine()){
                board[x][y].setIsMine();   // Place a mine in the cell
                increaseCounterAdjacentCells(x, y); //  Update adjacent cells' mine counts
            }
            else mine--;
        }
    }

    private void increaseCounterAdjacentCells(int i, int j) {
        for (int x = i-1; x <= i+1; x++)
            for (int y = j-1; y <= j+1; y++)
                if (x>=0 && x<ROWS && y>=0 && y<COLUMNS)
                    if (!board[x][y].isMine()) board[x][y].increaseCounterAdiacentMines();

    }

    public void printGameBoard() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void revealCellContent(int x, int y) {
        if (board[x][y].isFlagged()) return;
        board[x][y].setState(State.REVEALED);
        remainingFreeCells--;
        if (board[x][y].getTouchingMines() == 0) {
            revealAdjacentCellContent(x, y);
        }
    }

    private void revealAdjacentCellContent(int i, int j) {
        for (int x = i-1; x <= i+1; x++)
            for (int y = j-1; y <= j+1; y++)
                if (x>=0 && x<ROWS && y>=0 && y<COLUMNS && !board[x][y].isRevealed() && !board[x][y].isFlagged())
                    revealCellContent(x, y);
    }

    public void endGameAndRevealAllMines() {
        System.out.println(ANSI_RED + "You uncovered a mine! Game over." + ANSI_RESET);
        for (Cell[] row : board) {
            for (Cell cell : row) {
                cell.setState(State.REVEALED);
            }
        }
    }

    public Boolean isMine(int x, int y) {
        return board[x][y].isMine();
    }

    public void flagCell(int x, int y) {

        switch (board[x][y].getState()) {
            case HIDDEN -> board[x][y].setState(State.FLAGGED);
            case FLAGGED -> board[x][y].setState(State.HIDDEN);
        }

    }

    public int getRemainingFreeCells() {
        return remainingFreeCells;
    }

    public void yuoWon() {
        System.out.println(ANSI_GREEN + "CONGRATULATION.. YOU WON THE GAME!" + ANSI_RESET);
        for (Cell[] row : board) {
            for (Cell cell : row) {
                cell.setState(State.REVEALED);
            }
        }
        printGameBoard();
    }
}
