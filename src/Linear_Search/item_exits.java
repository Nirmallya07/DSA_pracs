package Linear_Search;

import java.util.Scanner;

public class item_exits {
    public static void main(String[] args) {
        int[] array = {23, 42, 32, 9, 6, 8, 18};
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Key: ");
        int key = scn.nextInt();
        System.out.println(ifItemExits(array, key));
        scn.close();
    }

    static boolean ifItemExits(int[] arr, int k){
        for (int i : arr) {
            if (k == i) {
                return true;
            }
        }
        return false;
    }
}
