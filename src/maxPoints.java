import java.util.HashMap;
import java.util.Map;

public class maxPoints {
    public static int mySolution(int[][] points) {
        int len = points.length;
        if (len == 0) return 0;
        if (len <= 2) return len;

        int res = 0;
        // iterate every point i and build a line of i and j (points behind i), count how many points in the line
        for (int i = 0; i < len - 1; i++) {
            // build a map, key is the slope (expressed as string), value is the count of (i, j) that has the slope
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0; // denotes the number of points overlap
            int lineMax = 0; // denotes the max count of i

            // iterate the point after i
            for (int j = i + 1; j < len; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0 && y == 0) {
                    overlap += 1;
                    continue;
                }

                int gcd = generateGCD(x, y);
                x /= gcd;
                y /= gcd;

                // build the key
                String slope = String.valueOf(x) + String.valueOf(y);
                int count = map.getOrDefault(slope, 0);
                count += 1;
                map.put(slope, count);
                lineMax = Math.max(lineMax, count);
            }
            res = Math.max(res, lineMax + overlap + 1); // res is the max count of all i

        }
        return res;
    }

    /* generate the greatest common divisor */
    private static int generateGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return generateGCD(y, x % y);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        System.out.println(mySolution(nums));
    }
}
