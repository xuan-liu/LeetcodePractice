public class rob {
    public static int mySolution(int[] nums) {
        // opt(i) denotes the maximum amount of money you can rob until house i
        // opt(i) = max{opt(i-1), opt(i-2)+nums[i]}. Base case: opt(0) = nums[0], opt(1) = max{nums[0], nums[1]}

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(mySolution(nums));
    }
}
