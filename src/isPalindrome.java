public class isPalindrome {
    public static boolean mySolution(String s) {
        if (s.isEmpty()){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j -= 1;
            } else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i += 1;
                j -= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("rar"));
    }
}
