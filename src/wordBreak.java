import java.util.Arrays;
import java.util.List;

public class wordBreak {
    public static boolean mySolution(String s, List<String> wordDict) {
        // let OPT(i) demote that whether s[:i] can be broken into word, not include i
        // OPT(i) = OPT(x) AND dict.contains(s[x+1:i]) where x < i
        // the answer is OPT(n)

        int len = s.length();
        boolean[] isBroken = new boolean[len + 1];
        isBroken[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (isBroken[j] && wordDict.contains(s.substring(j, i))) {
                    isBroken[i] = true;
                    break;
                }
            }
        }

        return isBroken[len];
    }

    public static void main(String[] args) {
        System.out.println(mySolution("leetcode", Arrays.asList("leet", "code")));
    }
}
