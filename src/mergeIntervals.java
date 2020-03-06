import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {
    public static int[][] mySolution(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) {
            return intervals;
        }

        // sort the intervals by increasing start node
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        // check each interval for overlapping
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[1]) {
                // if overlap, then combine interval
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            } else {
                // if not overlap, add newInterval, let newInterval be this interval
                result.add(newInterval);
                newInterval = intervals[i];
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = mySolution(intervals);
        System.out.println(result[0][0] + ',' + result[0][1]);
        System.out.println(result[1][0] + ',' + result[1][1]);
        System.out.println(result[2][0] + ',' + result[2][1]);
    }
}
