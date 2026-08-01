package Miscellenous_Prac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class isPrime {

    static boolean prime(int a) {
        for (int i = 2; i < a; i++) {
            if (a%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Is prime: " + prime(191));

//        Scanner sc = new Scanner(System.in);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder output = new StringBuilder();
//        System.out.print("Enter the number:");
//        int T =  Integer.parseInt(br.readLine());
//        output.append("The number is ").append(T);



    }
}