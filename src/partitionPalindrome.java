import java.util.ArrayList;
import java.util.List;

public class partitionPalindrome {
    public static List<List<String>> mySolution(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(res, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    /* tell whether s[lo:hi] is palindrome, include hi */
    private static boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo += 1;
            hi -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(mySolution(s));
    }
}
