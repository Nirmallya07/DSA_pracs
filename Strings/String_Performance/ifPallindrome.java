package String_Performance;

public class ifPallindrome {

    static boolean if_Pallindrome(String string) {
        StringBuilder str = new StringBuilder();
        for (int i = string.length()-1; i >= 0; i--) {
            str.append(string.charAt(i));
        }
        return String.valueOf(str).equalsIgnoreCase(string);
    }
    public static void main(String[] args) {
        String string1 = "abcba";
        String string2 = "aaaa";
        String string3 = "Alice";
        String string4 = "Charlie";
        String string5 = "Bob";
        String string6 = "Alice1";
        String string7 = "1Alice1";

        System.out.println(if_Pallindrome(string1));
        System.out.println(if_Pallindrome(string2));
        System.out.println(if_Pallindrome(string3));
        System.out.println(if_Pallindrome(string4));
        System.out.println(if_Pallindrome(string5));
        System.out.println(if_Pallindrome(string6));
        System.out.println(if_Pallindrome(string7));
    }
}
