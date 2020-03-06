public class reverseString {
    public static void mySolution(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] nums = new char[]{'H','a','n','n','a','h'};
        mySolution(nums);
        System.out.println(nums);
    }
}
