package StringAndStringBuilder;

import java.util.ArrayList;

public class string_concatenation {
    public static void main(String[] args) {
        System.out.println('a' + 3);

        System.out.println(Integer.valueOf(5) + "a");
        System.out.println("a" + new ArrayList<>());
//        System.out.println(Integer.valueOf(5) + new ArrayList<>()); // Bad operand, can't concatenate two objects.
        System.out.println(Integer.valueOf(5) + "" + new ArrayList<>()); // empty string is present.
    }
}
