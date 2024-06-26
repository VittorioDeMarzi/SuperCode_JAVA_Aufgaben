/* Gegeben ist ein Array mit Integern. Verdrehe die Reihenfolge der Elemente im Array.
Dass heißt, aus { 1, 2, 3, 4, 5, 6, 7, 8, 9 } soll { 9, 8, 7, 6, 5, 4, 3, 2, 1 } werden */

public class ArrayReihenfolge {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[arr.length-1 - i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
            System.out.println(arr[i]);
        }


        // Version 2

        for (int i = 0; i < arr.length / 2; i++) {
            int tempor = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tempor;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

}
}