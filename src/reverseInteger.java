public class reverseInteger {
    public static int mySolution_v2(int x) {
        // pop the original last element, push it to the new.
        int remain = 0;
        int res = 0;
        while (x != 0) {
            remain = x % 10;
            x = x / 10;

            // check the range
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && remain > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && remain < -8)) {
                return 0;
            }

            res = res * 10 + remain;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2(120));
    }
}
