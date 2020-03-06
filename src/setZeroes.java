public class setZeroes {
    public void mySolution(int[][] matrix) {
        // The idea is store states (whether it's 0) of each row in the first of that row, and store states of each column
        // in the first of that column. But we need to first check whether the first row/col need to be all 0. We use
        // isZeroRow/isZeroCol to denote it. After store all the states, we change num to 0 according to the state of row/col

        boolean isZeroRow = false;
        boolean isZeroCol = false;

        // check whether the first col is all 0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            }
        }

        // check whether the first row is all 0
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isZeroRow = true;
                break;
            }
        }

        // set states except the first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // put all the 0 except the first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //handle the first row
        if (isZeroRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //handle the first col
        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
