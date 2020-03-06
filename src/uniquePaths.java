import java.util.Arrays;

public class uniquePaths {
    public static int solution(int m, int n) {
        // dp[i][j] denotes the number of unique paths for a i x n grid
        // 2D version: dp[i][j - 1] + dp[i - 1][j]. base cases dp[0][j] = dp[i][0] = 1
        // 1D version: dp[j] denotes the col of the dp[i][j], dp[j] = dp[j-1] + pre dp[j]

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }



    /* use math to solve, but if m and n become bigger, (m+n)! may exceed the range of int */
    public static int mySolution(int m, int n) {
        // need m-1 right, n-1 down. the number of ways = m+n-2 choose m-1 =
        // (m+n-2)!/((m-1)!*(n-1)!) = {(m+n)(m+n-1)...(m+1)} / {n(n-1)...1}

        int dvd = 1;
        int dvs = 1;


        // if m < n, then swap, so that m is the bigger number
        if(m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        for (int i = n - 1; i > 0; i--) {
            int j = i + m - 1;
            dvd *= j;
            dvs *= i;
        }
        return dvd / dvs;

    }

    public static void main(String[] args) {
        System.out.println(solution(10, 10));
    }
}
