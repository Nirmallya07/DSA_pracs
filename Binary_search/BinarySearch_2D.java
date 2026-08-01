package Binary_search;

import java.util.Arrays;

public class BinarySearch_2D {
    static int[] binarySearch2D(int[][] arr, int target) {
        int start_row = 0;
        int end_row = arr.length - 1;
        while(start_row <= end_row) {
            int mid_row = start_row + (end_row - start_row)/2;
            if (arr[mid_row][0] <= target && target <= arr[mid_row][arr[mid_row].length -1]){
                int start = 0;
                int end = arr[mid_row].length - 1;
                while (start <= end) {
                    int mid = start + (end - start)/2;
                    if (arr[mid_row][mid] == target) return new int[]{mid_row, mid};
                    else if (arr[mid_row][mid] < target) start = mid + 1;
                    else end = mid - 1;
                }
                return new int[]{-1, -1}; // Use Debug pointer to understand.
            }
            else if (target < arr[mid_row][0]) end_row = mid_row -1;
            else if (arr[mid_row][arr[mid_row].length -1] < target) start_row = mid_row + 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {  1,  4,  7, 10 },
                { 16, 19, 22, 25, 28 },
                { 31, 40, 43 },
                { 46, 49, 52, 55, 58 , 60 }
        };

        System.out.println(Arrays.toString(binarySearch2D(matrix,60)));
    }
}
