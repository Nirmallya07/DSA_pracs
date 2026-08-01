package Patterns;

public class Patterns {

    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 1; row <= 2*n; row++ ) {
            int totalCol = row > n ? 2*n - row : row;
            for (int col = 1; col <= totalCol; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 1; row <= 2*n; row++ ) {
            int totalspace = row > n ? row-n : n-row;
            int totalstar = row > n ? 2*n - row : row;
            for( int space = 1; space <= totalspace; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totalstar; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern3(n);
        pattern4(n);
        pattern5(n);
        pattern28(n);
    }

}
