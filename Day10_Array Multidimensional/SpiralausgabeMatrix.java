public class SpiralausgabeMatrix {
    public static void main(String[] args) {
        int numrows = 3;
        int numCol = 6;
        int[][] matrix = matrixAusgabe(numrows, numCol);
        printMatrix(matrix);
        System.out.println("___________________");

        spiralMatrix(matrix);
    }

    private static void spiralMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCol = matrix[0].length;

        int topRow = 0;
        int bottomRow = matrix.length-1;
        int leftCol = 0;
        int rightCol = matrix[0].length-1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            
            for (int i = leftCol; i <= rightCol; i++) {
                System.out.print(matrix[topRow][i] + " ");
            }
            topRow++;
            for (int i = topRow; i <= bottomRow; i++) {
                System.out.print(matrix[i][rightCol] + " ");
            }
            rightCol--;
            for (int i = rightCol; i >= leftCol; i--) {
                System.out.print(matrix[bottomRow][i] + " ");
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow; i--) {
                System.out.print(matrix[i][leftCol] + " ");
            }
            leftCol++;
        }
        
    }

    private static int[][] matrixAusgabe(int numrows, int numCol) {
        int valueAtIndex = 1;
        int[][] matrix = new int[numrows][numCol];
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numCol; j++) {
                matrix[i][j] = valueAtIndex;
                valueAtIndex += 1;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCol = matrix[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCol; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}