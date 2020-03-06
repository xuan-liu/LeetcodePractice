import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public static List<Integer> solution1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int r = 0;
        int c = 0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int di = 0;

        for (int i = 0; i < R * C; i++) {
            // iterate every cell, add it and set seen to true
            res.add(matrix[r][c]);
            seen[r][c] = true;

            // generate next cell
            int cr = r + dr[di];
            int cc = c + dc[di];

            // check next cell, if its in the boundary and not been visited, then it's ok, otherwise we need to change the direction
            if (cr >= 0 && cr < R && cc >= 0 && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return res;
    }

    /* Approach 2: Layer-by-Layer */
    public static List<Integer> solution2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i < c2 + 1; i++) {
                res.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i < r2 + 1; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int i = c2 - 1; i > c1; i--) {
                    res.add(matrix[r2][i]);
                }
                for (int i = r2; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }
            r1 += 1;
            c1 += 1;
            r2 -= 1;
            c2 -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3, 4},
                                    {5, 6, 7, 8},
                                    {9,10,11,12}};
        System.out.println(solution1(nums));
    }
}
