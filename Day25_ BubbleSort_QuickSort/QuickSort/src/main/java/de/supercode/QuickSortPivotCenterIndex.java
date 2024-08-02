package de.supercode;

public class QuickSortPivotCenterIndex {
    public static void quickSort(int[] arr,int low, int high){
        if(low < high){
            int pivotIndex = partition(arr,low,high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[(high+low)/2];
        swap(arr, (high+low)/2, high);
        int i = low -1;
        for(int j = low; j < high;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
