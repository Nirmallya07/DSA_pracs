package Linear_Search;

public class second_minValue {

    public static int secondMinValue(int[] arr){
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (min2 > arr[i] && min < arr[i] ) {
                min2 = arr[i];
            }
        }
        return min2;
    }

    public static int thirdMinValue(int[] arr) {
        int min2 = secondMinValue(arr);
        int min3 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min3 > arr[i] && arr[i] > min2) {
                min3 = arr[i];
            }
        }
        return min3;
    }

    public static void main(String[] args) {
        int[] arr = {22, 34, 9, 51, 60, 7, 30, 15, 8, 18, 100};
        System.out.println(secondMinValue(arr));
        System.out.println(thirdMinValue(arr));

    }
}
