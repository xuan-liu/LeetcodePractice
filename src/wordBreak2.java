import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak2 {
    public static List<String> mySolution(String s, List<String> wordDict){
        if (!isBroken(s, wordDict)) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(res, "", s, wordDict,0);
        return res;

    }

    private static boolean isBroken(String s, List<String> wordDict) {
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

    private static void backtrack(List<String> res, String tempList, String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            res.add(tempList);
        } else {
            for (int i = start; i < s.length(); i++) {
                if (wordDict.contains(s.substring(start, i + 1))) {
                    //tempList.add(s.substring(start, i + 1));
                    String preTemp = tempList;
                    tempList += (tempList == ""? "": " ") + s.substring(start, i + 1);
                    backtrack(res, tempList, s, wordDict, i + 1);
                    //tempList.remove(tempList.size() - 1);
                    tempList = preTemp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(mySolution(s, wordDict));
    }
}
