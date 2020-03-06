public class hammingDistance {
    public static int mySolution_v2(int x, int y) {
        int count = 0;

        for (int i = 0; i < 31; i++) {
            count += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2(1, 4));
    }
}
