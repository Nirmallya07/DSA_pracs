package Linear_Search;

import java.util.Arrays;

public class Arrays_2d {
    public static void main(String[] args) {
//        int[][] arr2d = new int[3][3];
//        Scanner scn = new Scanner(System.in);
//        for (int i = 0; i < arr2d.length; i++) {
//            for (int j = 0; j < arr2d[i].length; j++) {
//                System.out.print("Give input for row " + (i+1) + " column " + (j+1) + "\t:");
//                arr2d[i][j]= scn.nextInt();
//            }
//        }
//
//        for (int[] i : arr2d) {
//            System.out.print("[");
//            for (int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println("]");
//        }

        int[] arr_rev = {23, 42, 32, 9, 6, 8, 18};
        System.out.println(Arrays.toString(arrayRev(arr_rev)));
    }

    static int[] arrayRev(int[] arr) {
        for (int i = 0; i < (arr.length)/2; i++) {
            int temp = arr[i];
            arr[i] = arr[(arr.length-1) - i];
            arr[(arr.length-1)-i] = temp;
        }
        return arr;
    }
}