public class isAnagram {
    public boolean mySolution(String s, String t) {
        // build a hashtable for the count of each letter, we add the count when we encounter it in s, subject the count when we
        // encounter it in t. Last, we check whether all letter has 0 count

        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }

        for (int c: count) {
            if (c != 0) return false;
        }
        return true;
    }
}
