public class longestIncreasingPath {
    // define four directions: down, right, up, left
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int mySolution(int[][] matrix) {
        // Do DFS from every cell recursively, Compare every 4 direction and skip cells that are out of boundary or smaller.
        // Get matrix max from every cell's max. cache the previous running result of cell

        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n]; // used to cache previous results
        int max = 1;

        // iterate every cell, choose the max length
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /* return the longest increasing path that starts with matrix[i][j] */
    private static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        // if we already cache it, return the cache value
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;

        // try four directions, choose the max length
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            // check whether the neighbor is out of boundary or the path not increasing
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(mySolution(input));
    }
}
