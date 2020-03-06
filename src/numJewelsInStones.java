import java.util.HashSet;
import java.util.Set;

public class numJewelsInStones {
    public int mySolution_v2(String J, String S) {
        // put all char in J to a hashset
        Set<Character> set = new HashSet<>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }

        // check every char in S whether is jewels
        int count = 0;
        for (char c: S.toCharArray()) {
            if (set.contains(c)) count += 1;
        }
        return count;
    }
}
