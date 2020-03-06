public class isInterleave {
    public static boolean mySolution(String s1, String s2, String s3) {
        // opt(i, j) denotes s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position
        // opt(i, j) = opt(i - 1, j) if s1[i-1] = s3[i+j-1], opt(i, j) = opt(i, j - 1) if s2[j-1] = s3[i+j-1], opt(i, j) = false otherwise.
        // opt(0,0) = true. opt(i, 0) = opt(i-1, 0) if s1[i-1] = s3[i-1]. opt(0, j) = opt(0, j-1) if s2[j-1] = s3[j-1]

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) {
                    // if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving
                    dp[i][j] = true;
                } else if (i == 0) {
                    // If only s1 is empty, then if previous s2 position is interleaving and current s2 position char
                    // is equal to s3 current position char, it is considered interleaving.
                    dp[i][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                } else {
                    // when both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving
                    // and i and current s3 position equal, it s interleaving. Same with if we arrive i,j from i, j-1
                    dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(mySolution("aabcc", "dbbca", "aadbbbaccc"));
    }
}
