public class maxCoins {
    public static int mySolution(int[] nums) {
        // dp[i][j] denotes the coins obtained from bursting all the balloons between index i and j (not including i or j)
        // dp[i][j] = max(nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]) (k in (i+1,j))
        // If k is the index of the last balloon burst in (i, j), the coins that burst will get are nums[i] * nums[k] * nums[j],
        // we also need to add the coins obtained from bursting balloons between i and k, and between k and j, i.e., dp[i][k] and dp[k][j]

        // let NewNum be [1] + nums + [1]
        int[] NewNum = new int[nums.length + 2];
        int n = 1;
        while (n < nums.length + 1) {
            NewNum[n] = nums[n - 1];
            n += 1;
        }
        NewNum[0] = 1;
        NewNum[n] = 1;
        n += 1; // n = nums.length + 2 now

        int[][] dp = new int[n][n];
        // first iterate through k, since we first compute for every triple combinations
        for (int k = 2; k < n; k++) {
            // then iterate through left index, right index = left + k
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                // iterate through left to right
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            NewNum[left] * NewNum[i] * NewNum[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(mySolution(nums));
    }
}
