package Miscellenous_Prac;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class codemonk_Array3 {

//    static int decode(String a) {
//        int decimal = Integer.parseInt(a, 2);
//        return decimal;
//    }

    static String shift(String A, int len) {
        // int len = a.length;
        char[] a = A.toCharArray();
        char temp = a[0];
        for (int i = 0; i < len-1; i++) {
            a[i] = a[i+1];
        }
        a[len-1] = temp;

        return new String(a);

    }

    public static void main(String[] args ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            String A = br.readLine();
            int shiftCount = 0;
            String max = "";
            int shifts = 0;
            int period = -1;
            for (int i = 0; i < N; i++) {
                if (A.compareTo(max) > 0) {
                    shifts = i;
                    max = A;
                }
                else if (A.equals(max)) {
                    period = i - shifts;
                    break;
                }
                A = shift(A, A.length());
            }
            if (period == -1) {
                shiftCount = shifts + (K-1)*N;
            } else {
                shiftCount = shifts + (K-1)*period;
            }
            output.append(shiftCount).append("\n");
        }

        System.out.print(output);
    }
}
