public class myPow {
    public static double mySolution(double x, int n) {
        // use recursion. x^n = (x^2)^(2/n) if n is even; x^n = x*(x^2)^(2/n) if n is odd
        // base case: if n = 0, return 1
        if (n == 0) {
            return 1;
        }

        // avoid overflow when n = -2^31
        if (n == Integer.MIN_VALUE) {
            return mySolution(x, -Integer.MAX_VALUE) * (1 / x);
        }

        if (n < 0 && n > Integer.MIN_VALUE) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0)? mySolution(x * x, n / 2): x * mySolution(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(mySolution(2.00000, -2));
    }
}
