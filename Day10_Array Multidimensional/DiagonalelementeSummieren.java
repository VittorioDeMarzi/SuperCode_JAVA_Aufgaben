public class DiagonalelementeSummieren {
    public static void main(String[] args) {
        int numrows = 3;
        int[][] matrix = matrixAusgabe(numrows);
        printMatrix(matrix);

        int sumOfDiagonal = sumOfMainDiagonal(matrix);
        System.out.println("Summe der Hauptdiagonale: " + sumOfDiagonal);

    }

    private static int sumOfMainDiagonal(int[][] matrix) {
        int length = matrix.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j)
                    sum += matrix[i][j];
            }
        }
        return sum;
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

    private static void printMatrix(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
