public class surroundedRegions {
    public void mySolution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int R = board.length;
        int C = board[0].length;

        // First, check the four border of the matrix. If there is a element is
        //'O', alter it and all its neighbor 'O' elements to '1'.
        for (int i = 0; i < R; i++) {
            check(board, i, 0, R, C);
            if (C > 1) check(board, i, C - 1, R, C);
        }

        for (int j = 0; j < C; j++) {
            check(board, 0, j, R, C);
            if (R > 1) check(board, R - 1, j, R, C);
        }

        // Then, alter all the 'O' to 'X'
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // At last,alter all the '1' to 'O'
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    /* check all the neighbors of borad[i][j] is whether 'O' */
    private void check(char[][] board, int i, int j, int R, int C) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 0) check(board, i - 1, j, R, C);
            if (j > 0) check(board, i, j - 1, R, C);
            if (i < R - 1) check(board, i + 1, j, R, C);
            if (j < C - 1) check(board, i, j + 1, R, C);
        }
    }
}
