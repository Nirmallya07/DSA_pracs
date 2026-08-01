package Miscellenous_Prac;

public class Eucledion_GCP_Optimized {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(150, 15));
    }
}
