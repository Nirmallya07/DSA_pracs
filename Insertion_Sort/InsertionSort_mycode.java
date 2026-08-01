package Insertion_Sort;

import java.util.Arrays;

public class InsertionSort_mycode {

    static void insetionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] > key) {
                    int temp = arr[j];
                    arr[j] = key;
                    arr[j+1] = temp;
                }
                else break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        insetionSort(arr);
        System.out.print("Sorted by Insertion Sorting Algorithm: ");
        System.out.println(Arrays.toString(arr));
    }
}
