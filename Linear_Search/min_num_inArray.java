package Linear_Search;

public class min_num_inArray {

    public static int minimumValue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be zero");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {22, 34, 51, 60, 15, 30};
        int[] arr2 = {};
        try {
            System.out.println(minimumValue(arr2));
        } catch (Exception e) {
            System.out.println(e + ": Array length cannot be zero");
        }
    }
}
