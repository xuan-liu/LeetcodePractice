public class searchMatrix2 {
    public static boolean mySolution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // We start search the matrix from top right corner
        int row = 0;
        int col = matrix[0].length - 1;

        // if the target is greater than the value in current position, then the target can not be in entire row of current position.
        // if the target is less than the value in current position, then the target can not in the entire column.
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row += 1;
            } else {
                col -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(mySolution(nums, 20));
    }
}
