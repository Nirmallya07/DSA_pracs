package Strings.String_Performance;

public class good_performance {
    // StringBuilder is mutable, meaning it stores characters in an internal resizable array.
    //When you call .append(c):
    //It just writes the new char at the end of the array.
    //If the array is full, it resizes (usually doubles the capacity).
    //Each .append() is O(1) amortized (constant time).
    //You do this n times → O(n) total.
    //Finally, .toString() copies all characters once into a new String → that’s O(n) as well.


    public static void main(String[] args) {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            letters.append((char)('a' + i));
        }
        System.out.print("With String Builder: ");
        System.out.println(letters);
    }
}
