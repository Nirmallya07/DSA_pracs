

class Solution {
    public static int reachNumber(int target) {
        int pos = 0;
        int i = 1;

        while(true) {
            if ((target-pos) == 0) {
                i--;
                return i;
            }
            else if (Math.abs(target-pos) >= i) {
                if (target < 0) pos -= i;
                else pos += i;
                i++;
            }
            else {
                if(target < 0) pos += i;
                else pos -= i;
                i++;
            }
        }
        // return -1;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(3));
    }
}