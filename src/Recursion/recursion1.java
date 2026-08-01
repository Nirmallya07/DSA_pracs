package Recursion;

public class recursion1 {
    public static void main(String[] args) {
//        message("Alice", 1);
        System.out.println(fibo(50));
    }


    static void message(String a, int n) {
        System.out.println("Hello " + a);
        printnum(n);
    }

    static void printnum(int n) {
        System.out.println(n);
        printnum(n+1);
    }

    static int fibo(int n) {
        if (n == 0 || n == 1) return n;
        return fibo(n-1) + fibo(n-2);
    }
}