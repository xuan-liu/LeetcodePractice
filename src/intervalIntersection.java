import java.util.ArrayList;
import java.util.List;

public class intervalIntersection {
    public static int[][] mySolution(int[][] A, int[][] B) {
        List<int[]> intersection = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            // check if A[i] intersect with B[j]
            int lo = Math.max(A[i][0], B[j][0]); // lo is the start point of intersection
            int hi = Math.min(A[i][1], B[j][1]); // hi is the end point of intersection

            // if they are intersect, add the intersection to list
            if (lo <= hi) {
                intersection.add(new int[]{lo, hi});
            }

            // if A's end > B's end, then check A[i] and B[j+1]. else check A[i+1] and B[j]
            if (A[i][1] > B[j][1]) {
                j += 1;
            } else {
                i += 1;
            }
        }
        return intersection.toArray(new int[intersection.size()][]);
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] res = mySolution(A, B);
        for (int i = 0; i < res.length; i++) {
            for (int j: res[i]) {
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println("");
        }
    }
}
