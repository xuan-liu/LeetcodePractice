public class reverseBits {
    /* need to treat n as an unsigned value */
    public static int mySolution(int n) {
        if (n == 0) return 0;

        int result = 0;

        //  iterate from 0 to 31 (an integer has 32 bits)
        for (int i = 0; i < 32; i++) {
            result <<= 1; // shift result to the left by 1 bit
            if ((n & 1) == 1) result += 1; //  if the last digit of input n is 1, we add 1 to result
            n >>= 1; // update n by shifting it to the right by 1
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(mySolution(-3));
    }
}
