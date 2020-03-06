public class firstUniqChar {
    public static int mySolution(String s) {
        int[] freq = new int[26]; // store the frequency of a letter

        // iterate the string to compute all the frequency
        for (char c: s.toCharArray()) {
            freq[c - 'a'] += 1;
        }
        // iterate the string to find the first letter's index that has freq = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("loveleetcode"));
    }
}
