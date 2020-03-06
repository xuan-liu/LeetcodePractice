import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public static int mySolution_v2(String s) {
        // Sliding Window Optimized. if string[j] has a duplicate in [i,j) as j'. then we can increase i directly to j'+1. use map to implement
        // build a map, whose key is the char, val is the index of the char
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        // use two pointer i and j for sliding window
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            // if map already contain the key, then find the key's value, move i to index+1
            if (map.containsKey(c)) {
                // map.get(c) + 1 need to bigger then current i, so that can update i. consider "abba"
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            maxLen = Math.max(maxLen, j - i + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2("abba"));
    }
}
