package Cyclic_Sort;

import java.util.Arrays;

public class Cyclic_Sort {

    static void cycleSort(int[] arr){
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]){ // is item at arr[i] ar its designated index.
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 5, 8, 6, 9, 7, 3, 1};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
