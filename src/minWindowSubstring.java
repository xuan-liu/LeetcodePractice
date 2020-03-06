import java.util.HashMap;
import java.util.Map;

public class minWindowSubstring {

    public String solution(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    /* --------------------------------------------------------------------------- cannot pass all tests */
    /* turn a string to a map, whose key is the char in s, value is the frequency of the char */
    private static Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static String mySolution(String s, String t) {
        String result = "";
        if (s.length() < t.length() || s.length() == 0 || t.length() == 0) {return result;}

        Map<Character, Integer> mapC = strToMap(t);
        Map<Character, Integer> mapS = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLen = s.length() + 1;
        int required = mapC.size();
        int form = 0;

        while (right < s.length()) {
            // add s[right] to mapS
            char c = s.charAt(right);
            if (mapS.containsKey(c)) {
                mapS.put(c, mapS.get(c) + 1);
            } else {
                mapS.put(c, 1);
            }

            // if it satisfy one unique item, form ++
            if (mapC.containsKey(c) && mapC.get(c) == mapS.get(c)) {
                form += 1;
            }

            while (left <= right && required == form) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                // sub s[left] in mapS
                char l = s.charAt(left);
                mapS.put(l, mapS.get(l) - 1);

                // update form
                if (mapC.containsKey(l) && mapC.get(l) > mapS.get(l)) {
                    form -= 1;
                }

                left += 1;

            }

            right += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mySolution(s, t));
    }
}
