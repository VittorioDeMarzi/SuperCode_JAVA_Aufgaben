package de.supercode;

public class Main {
    public static void main(String[] args) {
        int[] arr = arrayGenerator(20);

        System.out.println("=======================================");
        System.out.println("***** QUICK SORT PIVOT FIRST INDEX*****");
        System.out.println("=======================================");
        System.out.println("ARRAY TO SORT");
        printArray(arr);
        QuickSortPivotFirstIndex.quickSort(arr, 0, arr.length-1);
        System.out.println("SORTED ARRAY");
        printArray(arr);
        System.out.println();

        int[] arr2 = arrayGenerator(19);

        System.out.println("=========================================");
        System.out.println("***** QUICK SORT PIVOT IN THE CENTER*****");
        System.out.println("=========================================");
        System.out.println("ARRAY TO SORT");
        printArray(arr2);
        QuickSortPivotCenterIndex.quickSort(arr2, 0, arr2.length-1);
        System.out.println("SORTED ARRAY");
        printArray(arr2);



    }

    private static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) System.out.print("[" + arr[i] + "]");
        System.out.println();
    }


    public static int[] arrayGenerator(int count){
        int[] numbers = new int[count];
        for(int i=0;i<numbers.length;i++){
            numbers[i] = (int)(Math.random()*20);
        }
        return numbers;
    }
}