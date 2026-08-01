package Cyclic_Sort;

import java.util.Arrays;

public class LC_287 {

    static int duplicate_num(int[] arr) {
        int[] dup_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dup_arr[i] = arr[i];
        }
        int i = 0;
        while(i < dup_arr.length) {
            int correctIndex = dup_arr[i] - 1;
            if(dup_arr[i] != dup_arr[correctIndex]) {
                int temp = dup_arr[i];
                dup_arr[i] = dup_arr[correctIndex];
                dup_arr[correctIndex] = temp;
            }
            else i++;
        }

//        System.out.println("Duplicate: " + Arrays.toString(dup_arr));
        for (int j = 0; j < dup_arr.length; j++) {
            if (dup_arr[j] != j + 1) return dup_arr[j];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 1, 2};
        System.out.println(duplicate_num(arr));
//        System.out.println("Ori: " + Arrays.toString(arr));
    }
}
