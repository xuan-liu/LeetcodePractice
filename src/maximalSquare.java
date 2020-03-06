public class maximalSquare {
    // dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell
    // with index (i,j) in the original matrix. then 2D version: dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1.
    // 1D version: dp[j]=min(dp[j−1],dp[j],prev), prev=old dp[j−1]

    public static int mySolution(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) {
            return 0;
        }
        int C = matrix[0].length;
        int[] dp = new int[C + 1];
        int maxSquare = 0;
        int prev = 0;

        // iterate through each row
        for (int i = 1; i <= R; i++) {
            // iterate through each column,
            for (int j = 1; j <= C; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSquare = Math.max(maxSquare, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxSquare * maxSquare;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{{'1','0','1','0','0'},
                                    {'1','0','1','1','1'},
                                    {'1','1','1','1','1'},
                                    {'1','0','0','1','0'}};
        System.out.println(mySolution(nums));
    }
}
