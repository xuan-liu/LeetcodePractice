import java.util.Arrays;

public class numSquares {

    /* dynamic programming */
    public static int mySolution(int n) {
        // opt(i) denotes the least number of perfect square numbers which sum to i
        // base case: opt(0) = 0. opt(i) = min_(j from 1 to sqrt(i)){opt(i - j*j) + 1}

        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(mySolution(13));
    }
}
