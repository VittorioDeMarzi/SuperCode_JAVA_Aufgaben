package de.supercode;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 8, 9, 4, 3, 1, 2, 0};

        System.out.println("***** BUBBLE SORT *****");
        System.out.println("Array to sort:");
        printArray(arr);
        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
        BubbleSort.bubbleSortReverse(arr);
        System.out.println("Sorted array bigger to smaller:");
        printArray(arr);



    }

    private static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) System.out.print("[" + arr[i] + "]");
        System.out.println();
    }
}