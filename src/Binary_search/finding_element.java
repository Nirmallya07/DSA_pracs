package Binary_search;

public class finding_element {

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 16, 18, 22, 23, 24, 29, 32, 42, 100, 101};
        System.out.println(binarySearch(arr, 29));
    }
}
