package Linear_Search;

public class even_digits {

    static String[] evenDigits(int[] arr) {
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int div = arr[i];
            int count = 0;
            while (div != 0) {
                int rem = div%10;
                div /= 10;
                if (rem%2 == 0) count++;
            }
            if (count == 1) str[i] = arr[i] + " has " + count + " even digit";
            else str[i] = arr[i] + " has " + count + " even digits";
        }
        return str;
    }

    public static void main(String[] args) {
        int[] arr = {12, 345, 2, 6, 7896, -64646984, -37791535};
        String[] ans = evenDigits(arr);
        for (String i : ans) {
            System.out.println(i);
        }
    }
}
