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
    private static String choice;
    private static char action;
    private static int coordinateX;
    private static int coordinatey;


    public static void main(String[] args) {
        printTitle();
        buildGameBoardWithUserInputs();
        GameBoard board = new GameBoard(columns, rows, mines);
        board.printGameBoard();
        printRules();
        play();
    }

    private static void play() {
        Scanner sc2 = new Scanner(System.in);
        getChoice(sc2);
        sc2.close();
    }

    private static void getChoice(Scanner sc) {
        while (true) {
            System.out.println("ENTER YOUR CHOICE: ");
            choice = sc.nextLine();
            action = choice.charAt(0);
            coordinateX = Integer.parseInt(String.valueOf(choice.charAt(2)));
            if (action != 'r' && action != 'f') {
                System.out.println(ANSI_RED + "Invalid input. The action has to be eather an 'r' or an 'f'" + ANSI_RESET);
                continue;
            }

            break;
        }

    }

    private static void printRules() {
        System.out.println();
        System.out.println("LET'S START");
        System.out.println("To interact with the game board, you can either reveal or flag cells. Here’s how:");
        System.out.println("\tr 1 1 – Reveals the cell at row 1, column 1.  \n\tf 3 4 – Flags or unflags the cell at row 3, column 4.");

    }

    private static void buildGameBoardWithUserInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("We will build the game board together. Enter how many rows, columns, and mines you want");
        askForNumberColumns(sc);
        askForNumberRows(sc);
        System.out.println("TOTAL CELLS " + (columns*rows));
        askForNumberMines(sc);
        sc.close();
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
}
