public class numIslands {
    int row;
    int col;

    public int mySolution(char[][] grid) {
        row = grid.length;

        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFSMask(grid, i, j);
                    count += 1;
                }
            }
        }

        return count;
    }

    public void DFSMask(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        DFSMask(grid, i - 1, j);
        DFSMask(grid, i + 1, j);
        DFSMask(grid, i, j - 1);
        DFSMask(grid, i, j + 1);
    }
}
