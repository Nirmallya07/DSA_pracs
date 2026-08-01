package Cyclic_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Google_Q1 {
    // constrains : 1 - N, arr(len) = N
    static List<Integer> missingNums(int[] arr){
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else i++;
        }
        List<Integer> miss_num = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1) miss_num.add(j+1);
        }
        return miss_num;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> missed_num = missingNums(arr);
        System.out.println(missed_num);
        System.out.println(Arrays.toString(arr));
    }
}
