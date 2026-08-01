package StringAndStringBuilder;

public class String__1 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        for (int i = 0; i < s3.length(); i++) {
            System.out.println(s3.charAt(i));
        }


        System.out.println("Kunal");
        System.out.println(55);
        System.out.println(new int[] {5, 4, 3, 7});
        System.out.println(s2.getBytes());
    }
}
