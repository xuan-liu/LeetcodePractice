public class gameOfLife {
    public static void mySolution_v2(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        // use 2 bits to store 2 states, [2nd bit, 1st bit] = [next state, current state].
        int m = board.length;
        int n = board[0].length;

        // check every cell for the next status, In the beginning, every cell is either 00 or 01
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = checkNeighbor(board, i, j, m, n);
                // If 1st state is 1, neighbor=2 or 3, Make the 2nd bit 1: 01 ---> 11.
                if (board[i][j] == 1 && (count == 2 || count == 3)){
                    board[i][j] = 3;
                }

                // If 1st state is 0, neighbor=3, Make the 2nd bit 1: 00 ---> 10.
                else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // convert the board to next status
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }

    }

    /* count the number of neighbors that are alive of board[i][j], not include itself */
    public static int checkNeighbor(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        // from i-1 to i+1
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            // from j-1 to j+1
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                // if board[x][y] is alive now, add count
                count += board[x][y] & 1;
            }
        }
        count -= board[i][j] & 1;
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        mySolution_v2(nums);

        // why the difference
        System.out.println(2-0&1);

        int a = 2;
        a -= 0&1;
        System.out.println(a);
    }
}
