package de.supercode;

import java.util.Scanner;

public class Main {

    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static int columns;
    private static int rows;
    private static int mines;
    private static char action;
    private static int X;
    private static int Y;
    private static GameBoard board;
    private static Boolean isMineRevealed = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printTitle();
        buildGameBoardWithUserInputs(scanner);
        board = new GameBoard(columns, rows, mines);
        board.printGameBoard();
        printRules();
        play(scanner);
        scanner.close();
    }

    private static void play(Scanner scanner) {
        boolean playIsOn = true;
        while (playIsOn) {
            getChoice(scanner);
            switch (action) {
                case 'r' -> {
                    isMineRevealed = board.isMine(X, Y);
                    if (isMineRevealed) {
                        board.endGameAndRevealAllMines();
                        playIsOn = false;
                    } else board.revealCellContent(X,Y);

                }
                case 'f' -> board.flagCell(X, Y);
            }
            if (board.getRemainingFreeCells() == 0) {
                board.yuoWon();
                break;
            }
            board.printGameBoard();

        }
    }

    private static void getChoice(Scanner scanner) {
        while (true) {
            System.out.println("ENTER YOUR CHOICE: ");
            action = scanner.next().charAt(0);

            if (action != 'r' && action != 'f') {
                System.out.println(ANSI_RED + "Invalid input. The action has to be either an 'r' (REVEAL) or an 'f' (FLAG)" + ANSI_RESET);
                continue;
            }

            X = scanner.nextInt();
            if (X >= rows) {
                System.out.println(ANSI_RED + "Invalid input. Coordinate for X has to be 0= < X < Number of Columns" + ANSI_RESET);
                continue;
            }

            Y = scanner.nextInt();
            if (Y >= columns) {
                System.out.println(ANSI_RED + "Invalid input. Coordinate for Y has to be 0= < Y < Number of Columns" + ANSI_RESET);
                continue;
            }
            break;
        }
    }

    private static void buildGameBoardWithUserInputs(Scanner scanner) {
        System.out.println("We will build the game board together. Enter how many rows, columns, and mines you want");
        askForNumberColumns(scanner);
        askForNumberRows(scanner);
        System.out.println("TOTAL CELLS " + (columns*rows));
        askForNumberMines(scanner);
    }

    private static void askForNumberMines(Scanner sc) {
        while (true) {
            System.out.println("MINES: ");
            mines = sc.nextInt();
            if(mines <=0 || mines >= columns*rows) {
                System.out.println(ANSI_RED + "Invalid input. Number of mines hat to be between 0 and number of cells " + (columns*rows) + ANSI_RESET);
                continue;
            }
            break;
        }
    }

    private static void askForNumberRows(Scanner sc) {
        while (true) {
            System.out.println("ROWS: ");
            rows = sc.nextInt();
            if(rows <=0) {
                System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                continue;
            }
            break;
        }
    }

    private static void askForNumberColumns(Scanner sc) {
        while (true) {
            System.out.println("COLUMNS: ");
            columns = sc.nextInt();
            if(columns <=0) {
                System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
                continue;
            }
            break;
        }
    }

    private static void printTitle() {
        System.out.println("*****************************************************");
        System.out.println("********************" + ANSI_GREEN + " MINESWEEPER " + ANSI_RESET + "********************");
        System.out.println("*****************************************************");
    }

    private static void printRules() {
        System.out.println();
        System.out.println("LET'S START");
        System.out.println("To interact with the game board, you can either reveal or flag cells. Here’s how:");
        System.out.println("\tr 1 1 – Reveals the cell at row 1, column 1.  \n\tf 3 4 – Flags or unflags the cell at row 3, column 4.");
    }
}


