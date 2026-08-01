package Binary_search;

public class Agnostic_BinarySearch {

    static int agnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        if (arr[start] < arr[end]){
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) return mid;
                if(arr[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
        }
        else {
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] > target) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr_Desc = { 101, 93, 91, 90, 80, 71, 62, 60, 55, 43, 29, 19, 6, 5, 1};
        System.out.println(agnosticBinarySearch(arr_Desc, 60));
    }
}
