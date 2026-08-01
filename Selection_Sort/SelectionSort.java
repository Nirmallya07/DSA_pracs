package Selection_Sort;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int min_ind = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_ind]) min_ind = j;
            }

            int temp = arr[i];
            arr[i] = arr[min_ind];
            arr[min_ind] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
