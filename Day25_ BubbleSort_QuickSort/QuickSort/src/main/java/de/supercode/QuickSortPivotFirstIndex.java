package de.supercode;

public class QuickSortPivotFirstIndex {
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivotIndex = partition(arr,left,right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr,pivotIndex+1,right);
        }
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = right + 1;
        for(int j = right; j > left ;j--){
            if(arr[j] >= pivot){
                i--;
                swap(arr,i,j);
            }
        }
        swap(arr,i-1,left);
        return i-1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
