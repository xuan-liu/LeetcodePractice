public class numDecodings {
    public static int mySolution(String s) {
        // let ways(i) denote the ways to decode s[0:i-1]
        // ways(i) += ways(i-1) if 1 <= s[i-1] <= 9
        // ways(i) += ways(i-2) if 10 <= s[i-2:i-1] <= 26

        if (s.length() == 0 || s == null) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0: 1;

        for (int i = 2; i <= s.length(); i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(mySolution(s));
    }
}
