public class divide {
    public static int mySolution(int dividend, int divisor) {
        // handle the dividend == Integer.MIN_VALUE, divisor == -1 case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // handle sign
        int sign = (dividend > 0) ^ (divisor > 0)? -1: 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        // eg, compute 15/3. we shift 3 by 1 (6), 15 > 6. shift 6 by 1 (12), 15 > 12. shift 12 by 1 (24), 15 < 24 (stop).
        // then we have 15 = 3 * 4 (shift twice) + 3. we then do the same process let dividend = 3, divisor = 3

        int res = 0;
        while (dvd >= dvs) {
            // shift divisor and compute the number of shift we try
            long tmp = dvs;
            long shift =1;
            while (dvd >= tmp << 1) {
                tmp <<= 1;
                shift <<= 1;
            }
            // set new dividend and divisor
            dvd -= tmp;
            res += shift;
        }

        return sign == 1? res: -res;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(7, -3));
    }
}
