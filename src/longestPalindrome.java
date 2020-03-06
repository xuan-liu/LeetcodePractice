public class longestPalindrome {
    static int maxLen; // the longest palindrome length
    static int loIdx; // the longest palindrome substring low index

    public static String mySolution_v2(String s) {
        if (s.length() <= 1) return s;

        // For every char in s, denote c, expand it using 2 approached
        for (int i = 0; i < s.length() - 1; i++) {
            expandCenter(s, i, i);
            expandCenter(s, i, i + 1);
        }

        return s.substring(loIdx, loIdx + maxLen);
    }

    /* treat index i, j as center, expand the string and check whether it's palindrome, if the length is longer, change maxLen and loIdx */
    private static void expandCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i -= 1;
            j += 1;
        }
        if (maxLen < j - i - 1) {
            maxLen = j - i - 1;
            loIdx = i + 1;
        }
    }

    /* --------------------------------------------------------------------------- */
    public static String solution(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int max = 0;
        String result = "";

        // For every char in s, denote c
        for (int i = 0; i < s.length(); i++) {

            // expand it using 2 approached: treat c as center, treat c and c+1 as center.
            int l1 = expandFromCen(s, i, i);
            int l2 = expandFromCen(s, i, i + 1);
            int l = l1 > l2? l1: l2;
            if (l > max) {
                max = l;
                result = s.substring(i - (l - 1)/2, i + l/2 + 1);
            }
        }
        return result;
    }

    public static int expandFromCen(String s, int t1, int t2) {
        while (t1 >= 0 && t2 < s.length() && s.charAt(t1) == s.charAt(t2)) {
            t1--;
            t2++;
        }
        return t2 - t1 - 1;
    }

    /* --------------------------------------------------------------------------- */
    public static String mySolution(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String ns = s.substring(i, j + 1);
                if (checkPalindrome(ns) && (j - i + 1) > max) {
                    max = (j - i + 1);
                    result = ns;
                }
            }
        }
        return result;
    }

    public static boolean checkPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2("ccc"));
    }
}
