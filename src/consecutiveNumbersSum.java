public class consecutiveNumbersSum {
    public static int mySolution(int N) {
        // assume x + (x+1) + (x+2)+...+ (x+k-1) = N, then kx + k*(k-1)/2 = N implies kx = N - k*(k-1)/2
        // So we calculate the RHS for every value of k and if it is a multiple of k then we can construct a sum of N using k terms starting from x
        // N - k*(k-1)/2 > 0 => k*(k-1) < 2N => k < sqrt(2N)

        int count = 1;

        for (int k = 2; k < Math.sqrt(2 * N); k++) {
            if ((N - k * (k - 1) / 2) % k == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(15));
    }
}
