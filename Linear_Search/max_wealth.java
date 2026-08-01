package Linear_Search;

public class max_wealth {

    static int maxWealth(int[][] arr) {
        int[] wealth = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
            }
            wealth[i] = sum;
        }

        int max = wealth[0];
        for (int i : wealth) {
            if (i > max) max = i;
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 5},
                {7, 3},
                {3, 5}
        };

        System.out.println(maxWealth(arr));
    }
}
