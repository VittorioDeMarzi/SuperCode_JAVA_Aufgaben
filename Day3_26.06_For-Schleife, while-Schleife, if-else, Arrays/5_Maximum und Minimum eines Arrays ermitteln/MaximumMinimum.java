/* 
Gegeben ist ein Array mit Integern. Ermittle das Größte und das Kleinste Element des Arrays und gebe es aus. 
public class MaxMinArray{
	
	public static void main(String args[]){
	
		int arr [] = {3, 44, 87, 2, 4, 99, 112, -1, 9, 14, 89, 21};

		// Platz für deine Lösung

	}
} */

public class MaximumMinimum {
    public static void main(String args[]){
	
        int arr[] = { 3, 44, 87, 2, 4, 99, 112, -1, 9, 14, 89, 21 };
            int max = arr[0];
            int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = (arr[i] > max) ? arr[i] : max;
            min = (arr[i] < min) ? arr[i] : min;
        }

		System.out.printf("Max: %s%n Min: %s%n", max, min);

	}
}