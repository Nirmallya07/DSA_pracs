package Insertion_Sort;

import java.util.Arrays;public class Insertion_Sort {

    static void insetionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        insetionSort(arr);
        System.out.print("Sorted by Insertion Sorting Algorithm: ");
        System.out.println(Arrays.toString(arr));
    }
}
