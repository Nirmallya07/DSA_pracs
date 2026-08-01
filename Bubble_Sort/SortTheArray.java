package Bubble_Sort;

import java.util.Arrays;

public class SortTheArray {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < (arr.length - 1) - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            if (swap == false) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

