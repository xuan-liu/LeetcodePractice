public class rotateImage {
    public void mySolution(int[][] matrix) {
        // clockwise rotate: first reverse up to down, then swap the symmetry
        int start = 0;
        int end = matrix.length - 1;

        while (start < end) {
            // swap matrix[start] with matrix[end]
            int[] tmp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmp;
            start += 1;
            end -= 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                // swap matrix[i][j] with matrix[j][i]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
