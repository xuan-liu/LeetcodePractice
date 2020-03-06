public class isPalindromeNumber {
    public static boolean mySolution_v2(int x) {
        if (x < 0) return false;
        int ori = x;

        // reverse the number
        int rev = 0;
        while (x != 0) {
            int remain = x % 10;
            x = x / 10;
            rev = rev * 10 + remain;

        }

        return rev == ori;
    }

    public static boolean solution(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        // reverse half of the number
        int rev = 0;
        while (x > rev) {
            int remain = x % 10;
            x = x / 10;
            rev = rev * 10 + remain;
        }

        return rev == x || x == rev / 10;
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
    }
}
