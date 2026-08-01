package String_Performance;

public class bad_performance {


    // Using String class..

    // Not a good way.
    // Every iteration it creates a new object and old objects stay.
    // Increasing memory consumption, though unreferenced objects go for garbage collection later on.
    // Let’s analyze: Time Complexity !
    //
    //1st iteration → copying 1 char
    //2nd iteration → copying 2 chars
    //3rd iteration → copying 3 chars
    //nth iteration → copying n chars
    //
    //So the total work = 1 + 2 + 3 + … + n = O(n²)


    public static void main(String[] args) {
        String letters = "";
        for (int i = 0; i < 26; i++) {
            letters += (char)('a' + i);
        }
        System.out.println(letters);
    }
}
