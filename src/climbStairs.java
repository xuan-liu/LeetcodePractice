public class climbStairs {
    public static int mySolution(int n) {
        // opt(i) denotes the number of distinct ways to climb to the i-step-top
        // opt(i) = opt(i-1) + opt(i-2). opt(1) = 1, opt(0) = 1
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(mySolution(3));
    }
}
