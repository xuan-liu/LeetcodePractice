public class minEditDistance {
    public static int mySolution(String word1, String word2) {
        // opt(i, j) denote the minimum number of operations required to convert word1[:i] to word2[:j]
        // If word1[i - 1] != word2[j - 1], opt(i, j) = min{opt(i-1, j), opt(i, j-1), opt(i-1, j-1)} + 1
        // if word1[i - 1] == word2[j - 1], opt(i, j) = opt(i-1, j-1)
        // opt(i, 0) = i, opt(0, j) = j
        // for 2D: opt(j) = min{opt(j-1), pre opt(j), pre opt(j-1)}

        int m = word1.length();
        int n = word2.length();
        int[] curdp = new int[n + 1];
        int pre;

        // opt(0, j) = j
        for (int j = 1; j <= n; j++) {
            curdp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            pre = curdp[0];
            // opt(i, 0) = i
            curdp[0] = i;

            for (int j = 1; j <= n; j++) {
                int tmp = curdp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curdp[j] = pre;
                } else {
                    curdp[j] = Math.min(pre, Math.min(curdp[j - 1], curdp[j])) + 1;
                }
                pre = tmp;
            }
        }
        return curdp[n];
    }

    public static void main(String[] args) {
        System.out.println(mySolution("intention", "execution"));
    }
}
