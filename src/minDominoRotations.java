public class minDominoRotations {
    public static int mySolution(int[] A, int[] B) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            countA[a] += 1;
            countB[b] += 1;
            if (a == b) {
                same[a] += 1;
            }
        }

        for (int i = 0; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == A.length) {
                return A.length - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,2,4,2,2};
        int[] b = new int[]{5,2,6,2,3,2};
        System.out.println(mySolution(a,b));
    }
}
