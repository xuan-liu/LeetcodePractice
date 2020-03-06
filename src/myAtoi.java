public class myAtoi {
    public static int solution(String str) {
        if (str.length() == 0) {
            return 0;
        }

        boolean sign = true;
        int base = 0;
        int i = 0;

        // discard whitespace
        while (i < str.length() && str.charAt(i) == ' ') {
            i += 1;
        }

        // detect '+' '-'
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+'? true: false;
            i += 1;
        }

        // check every digit so that within signed integer range: [−2^31,  2^31 − 1]
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7) {
                if (sign == true) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base  = 10 * base + (str.charAt(i) - '0');
            i += 1;
        }

        if (sign) {
            return base;
        } else {
            return (-1) * base;
        }
    }


    public static void main(String[] args) {
//        int test = Integer.parseInt("  61");
        System.out.println(solution(" "));
//        System.out.println('0' < '9');
    }
}
