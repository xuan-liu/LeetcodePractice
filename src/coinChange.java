public class coinChange {
    public static int mySolution(int[] coins, int amount) {
        // opt(amount) denote the fewest number of coins that you need to make up that amount
        // opt(amount) = min_(i from n-1 to 0) {1 + opt(amount - coins[i])} if coins[i] <= amount
        // opt(amount) = 0 if amount = 0; opt(amount) = -1 if n = 0;

        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        // iterate through every amount value from small to large
        for (int i = 1; i <= amount; i++) {
            int min = -1;

            // iterate through every coin
            for (int j = 0; j < coins.length; j++) {
                // when coins[i] <= amount and n != 0, change the min
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    int tmp = 1 + dp[i - coins[j]];
                    if (min < 0 || tmp < min)
                        min = tmp;
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        System.out.println(mySolution(nums, 11));
    }
}
