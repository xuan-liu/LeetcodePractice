public class countBits {
    public int[] mySolution_v2(int num) {
        // f[i] = f[i / 2] + i % 2, f is the array
        int[] res = new int[num + 1];
        res[0] = 0;

        // dynamic programming with memorizing
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + i & 1;
        }
        return res;
    }
}
