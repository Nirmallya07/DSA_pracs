package Linear_Search;

public class min_2DArray {

    static int minValueIn2DArray(int[][] arr) {
        int min = arr[0][0];
        for (int[] i : arr) {
            for (int j : i) {
                if (j < min ) min = j;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {23, 44, 53},
                {12, 14, 56, 16},
                {55, 2, 15, 101},
                {18, 22, 80}
        };
        System.out.println(minValueIn2DArray(arr));
    }
}
