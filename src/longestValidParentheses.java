public class longestValidParentheses {
    public static int mySolution(String s) {
        // set 2 counters: left and right. traverse string from left to right, when encounter '(', increase left;
        // when encounter ')', increase right. Whenever left == right, record the length, if right > left, set left and right to 0

        int left = 0;
        int right = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(")()())"));
    }
}
