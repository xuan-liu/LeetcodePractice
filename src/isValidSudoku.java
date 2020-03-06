import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {
    public boolean mySolution(char[][] board) {
        // Collect the set of things we see, encoded as strings. return false if we ever fail to add something
        // because it was already added (i.e., seen before)

        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // check whether we seen it before
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) || !seen.add(num + " in col " + j) || !seen.add(num + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
