public class isMatchExpression {
    /* -------------------------------recursive-------------------------------------------- */
    public static boolean solution1(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        // if p[1]='*', then ignore it or delete s[1]
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return solution1(s, p.substring(2)) || (firstMatch && solution1(s.substring(1), p));
        } else {
            // if not, then continue to compare s[1:n] and p[1:n]
            return (firstMatch && solution1(s.substring(1), p.substring(1)));
        }
    }

    /* -------------------------------dynamic programming-------------------------------------------- */
    public static boolean solution2(String s, String p) {
        // dp[i,j] denotes isMatch(s[i:], p[j:])
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        // iterate from the last, follow the recursive method
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(solution2("mississippi", "mis*is*p*."));
    }
}
