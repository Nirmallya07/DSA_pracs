package Binary_search;

import java.util.Arrays;

public class miss1 {

    static int[] targetIndex_miss1(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;
        // Not binary
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return new int[]{row, col};
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = { // This array is sorted through row and sorted through column but not as a whole.
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 27, 49},
                {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(targetIndex_miss1(matrix, 45)));
    }
}
