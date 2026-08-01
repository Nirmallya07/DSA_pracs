package Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

public class arrays  {
    public static void main(String[] arr) {
        int[] ros; // declaration of array ros in the stack;
        ros = new int[5]; // initialization: here object is being created in the memory (heap);
        System.out.println(ros.length);
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < ros.length; i++) {
            ros[i] = scn.nextInt();
        }

//        for (int i : ros) {
//            System.out.println(i);
//        }
        System.out.println(Arrays.toString(ros));
        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}));

        int[] arr1 = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr1));
    }
}