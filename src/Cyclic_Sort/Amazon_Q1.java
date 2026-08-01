package Cyclic_Sort;

import java.util.Arrays;

public class Amazon_Q1 {

    static int missingnumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else i++;
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j) return j;
        }
        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int res = missingnumber(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}
