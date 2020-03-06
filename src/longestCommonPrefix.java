public class longestCommonPrefix {
    public static String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];

        // For every char in strs[0], find whether all the other strs[1], strs[2], ... have the same char
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

    /* --------------------------------------------------------------------------- */
    public static String mySolution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        // Find common prefix for strs[0] and strs[1], use it to find common prefix with strs[2], etc.
        for (int i = 0; i < strs.length - 1; i++) {
            strs[i + 1] = commonChar(strs[i], strs[i + 1]);
        }
        return strs[strs.length - 1];
    }

    public static String commonChar(String a, String b) {
        int i = 0;
        while (i < Math.min(a.length(), b.length())) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            i += 1;
        }
        return a.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "aba", "ab"};
        System.out.println(solution(strs));
    }
}
