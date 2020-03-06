public class maximalRectangle {
    public static int mySolution(char[][] matrix) {
        int R = matrix.length;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int C = matrix[0].length;

        int[] left = new int[C];
        // Left[row][col] records the leftmost position that the height can extend based on the point (row, col)
        int[] right = new int[C];
        // right[row][col] records the rightmost position that the height can extend based on the point (row, col)
        int[] height = new int[C];
        // Height[row][col] records (row, col) as the height of the histogram column based on the point (row, col)
        int maxA = 0;

        for (int i = 0; i < C; i++) {
            left[i] = 0;
            right[i] = C;
            height[i] = 0;
        }

        for (int i = 0; i < R; i++) {
            int cur_left = 0;
            int cur_right = C;

            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1') {
                    // set height
                    height[j] += 1;
                    // set left: since left records the leftmost index that the height can extend, use max
                    left[j] = Math.max(left[j], cur_left);

                } else {
                    height[j] = 0;
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }

            for (int j = C - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    // set right: since left records the rightmost index that the height can extend, use min
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = C;
                    cur_right = j;
                }
            }

            // iterate all matrix[i][j], choose the max (right[j] - left[j]) * height[j]
            for (int j = 0; j < C; j++) {
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
            }
        }
        return maxA;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{{'1','0','1','0','0'},
                                    {'1','0','1','1','1'},
                                    {'1','1','1','1','1'},
                                    {'1','0','0','1','0'}};
        char[][] test = new char[][]{{'1'}};
        System.out.println(mySolution(test));
    }
}
