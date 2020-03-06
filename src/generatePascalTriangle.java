import java.util.ArrayList;
import java.util.List;

public class generatePascalTriangle {
    public List<List<Integer>> mySolution(int numRows) {
        //                   1                row is   [1]
        //                1     1                      [1, 1]
        //             1     2     1                   [1, 2, 1]
        //          1     3     3     1                [1, 3, 3, 1]
        //       1     4     6     4     1             [1, 4, 6, 4, 1]
        //
        // every time start a new row, add a new 1 in the leftmost, then iterate from j=1 to row.size-1, row[j] = row[j]+row[j+1]


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        // add every rows
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);

            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}
