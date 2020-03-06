import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
    /* Use flag arrays as bitmask */
    public static List<List<String>> solution2(int n) {
        // create a answer that full of .
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] flag_col = new boolean[n]; // The number of columns is n, flag_col[i] indicate whether the ith column has queen
        boolean[] flag_45 = new boolean[2 * n - 1]; // the number of 45° diagonals is 2 * n - 1
        boolean[] flag_135 = new boolean[2 * n - 1];// the number of 135° diagonals is 2 * n - 1

        backtrack2(chess, res, flag_col, flag_45, flag_135, 0);
        return res;
    }

    /* used for backtrack all the possible result, use flag array */
    private static void backtrack2(char[][] chess, List<List<String>> res, boolean[] flag_col, boolean[] flag_45, boolean[] flag_135, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            // When reach [row, col], the column No. is col, the 45° diagonal No. is row + col and the 135° diagonal No. is n - 1 + col - row.
            if (!flag_col[col] && !flag_45[row + col] && !flag_135[chess.length - 1 + col - row]) {
                // choose
                flag_col[col] = true;
                flag_45[row + col] = true;
                flag_135[chess.length - 1 + col - row] = true;
                chess[row][col] = 'Q';

                // backtrack
                backtrack2(chess, res, flag_col, flag_45, flag_135, row + 1);

                // unchoose
                chess[row][col] = '.';
                flag_col[col] = false;
                flag_45[row + col] = false;
                flag_135[chess.length - 1 + col - row] = false;
            }
        }
    }

/* ----------------------------------------------------------------------------------------------------- */
    /* Directly check the validity of each position */
    public static List<List<String>> solution1(int n) {

        // create a answer that full of .
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack1(chess, res, 0);
        return res;
    }

    /* used for backtrack all the possible result, directly */
    private static void backtrack1(char[][] chess, List<List<String>> res, int row) {
        // if row = chess.length, then we add chess to the res
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        // iterate all the column and check if the column, the 45° diagonal and the 135° diagonal had a queen before
        for (int col = 0; col < chess.length; col++) {
            if (isValid(chess, row, col)) {
                // choose: if there are no queen before, we set it to be queen
                chess[row][col] = 'Q';
                // backtrack
                backtrack1(chess, res, row + 1);
                // unchoose
                chess[row][col] = '.';
            }
        }
    }

    /* check chess[row][col] is valid for queen, that is the column, the 45° diagonal and the 135° diagonal do not have a queen before */
    private static boolean isValid(char[][] chess, int row, int col) {
        // check col
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // check 45° diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // check 135° diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    /* turn a char 2D array into a list of string */
    private static List<String> construct(char[][] chess) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String s = "";
            for (char c: chess[i]) {
                s += c;
            }
            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution2(4));
    }
}
