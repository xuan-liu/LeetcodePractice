public class solveSudoku {
    public void mySolution(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    /* use recursion to try all possible cases to solve sudoku */
    private boolean solve(char[][] board) {
        // iterate all the '.' cell and replace it with a num and try if it can contribute the last answer
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {

                    // set a trial. try to replace with 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            // put c in that cell
                            board[i][j] = c;

                            // check the remain board, if can solve, return true, otherwise go back
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    // if we try all 1 to 9 not work, then return false.
                    return false;
                }
            }
        }
        return true;
    }

    /* test whether replace board[i][j] as num, the board is valid */
    private boolean isValid(char[][] board, int i, int j, char num) {
        int blkRowFirst = (i / 3) * 3; // Block no. is i/3, first element is i/3*3
        int blkColFirst = (j / 3) * 3;

        for (int k = 0; k < 9; k++) {
            // check whether the row, col and block have no same num
            if (board[i][k] == num || board[k][j] == num || board[blkRowFirst + k / 3][blkColFirst + k % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
