public class existWord {
    public static boolean mySolution(char[][] board, String word) {
        char[] w = word.toCharArray();

        // check each cell for exist
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* check board[x][y] will be the start cell of the word */
    private static boolean exist(char[][] board, int x, int y, char[] w, int start) {
        // if we iterate over the last char of w, then return true
        if (start == w.length) {
            return true;
        }
        // if the cell is out of boundary, then return false
        if (x < 0 || y < 0 || x == board.length || y == board[0].length) {
            return false;
        }
        // if the value of the cell not equals to the char of w, then return false
        if (board[x][y] != w[start]) {
            return false;
        }
        // mask the cell by XOR with 100000000
        board[x][y] ^= 256;
        boolean exist = (exist(board, x + 1, y, w, start + 1) || exist(board, x - 1, y, w, start + 1)
                || exist(board, x, y + 1, w, start + 1) || exist(board, x, y - 1, w, start + 1));

        board[x][y] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'A','B','C','E'},
                                    {'S','F','C','S'},
                                    {'A','D','E','E'}};
        System.out.println(mySolution(input, "ABCB"));
    }
}
