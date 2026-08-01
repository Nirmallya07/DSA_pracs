package BitMagic;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Bit_AND {
    public static void main(String[] args) {
        int x = 3;
        int y = 6;
        int z = 100;

        System.out.println(x & y);
        System.out.println(x | y);
        System.out.println(x ^ y);
        System.out.println(~z);
    }
}