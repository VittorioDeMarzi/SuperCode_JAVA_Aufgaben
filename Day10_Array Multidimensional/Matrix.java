public class Matrix {
    public static void main(String[] args) {
        int numrows = 6;
        int[][] matrix = matrixAusgabe(numrows);

        printMatrix(matrix);
        int[][] matrixTransported = transponieren(matrix);
        System.out.println("___________________");
        printMatrix(matrixTransported);

    }

    private static int[][] transponieren(int[][] matrix) {
        int length = matrix.length;
        int[][] output = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                output[i][j] = matrix[j][i];
            }
        }
        return output;
    }

    private static void printMatrix(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixAusgabe(int numrows) {
        int valueAtIndex = 1;
        int[][] matrix = new int[numrows][numrows];
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numrows; j++) {
                matrix[i][j] = valueAtIndex;
                valueAtIndex += 1;
            }
        }
        return matrix;
    }
}