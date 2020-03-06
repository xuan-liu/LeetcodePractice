import java.util.*;

public class getSkyline {
    private static class Point implements Comparable<Point>{
        int x;
        int height;
        boolean isStart;

        public Point(int x, int h, boolean isStart) {
            this.x = x;
            this.height = h;
            this.isStart = isStart;
        }

        public int compareTo(Point p) {
            if (this.x != p.x) {
                return this.x - p.x; // x small, point small
            } else {
                if (this.isStart && p.isStart) {
                    // if x equal, both start, then height large, point small
                    return p.height - this.height;
                }
                if (!this.isStart && !p.isStart) {
                    // if x equal, both end, then height small, point small
                    return this.height - p.height;
                }
                return this.isStart? -1: 1; // if x equal, start point small
            }
        }
    }

    public static List<List<Integer>> mySolution(int[][] buildings) {
        if (buildings.length == 0 || buildings[0].length == 0) {
            return new ArrayList<>();
        }

        // extract and sort the critical points
        Point[] critPoint = new Point[2 * buildings.length];

        for (int i = 0; i < buildings.length; i++) {
            int x = buildings[i][0];
            int y = buildings[i][1];
            int h = buildings[i][2];
            critPoint[i] = new Point(x, h, true);
            critPoint[2 * buildings.length - i - 1] = new Point(y, h, false);
        }

        Arrays.sort(critPoint);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // initial a big heap
        List<List<Integer>> res = new ArrayList<>();
        heap.add(0);

        int preMaxVal = 0;
        // scan across the critical points from left to right
        for (Point p: critPoint) {
            if (p.isStart) {
                // When we encounter the left edge of a rectangle, we add that rectangle to the heap with its height as the key
                heap.add(p.height);
                // we set the height of that critical point to the value peeked from the top of the heap.
                int curMaxVal = heap.peek();
                // if current height > previous height, we set the critical point to the result list
                if (curMaxVal > preMaxVal) {
                    res.add(Arrays.asList(p.x, p.height));
                    preMaxVal = curMaxVal;
                }
            } else {
                // When we encounter the right edge of a rectangle, we remove that rectangle from the heap.
                heap.remove(p.height);
                int curMaxVal = heap.peek();
                // if current height < previous height, we set the critical point's x and curMaxVal to the result list
                if (curMaxVal < preMaxVal) {
                    res.add(Arrays.asList(p.x, curMaxVal));
                    preMaxVal = curMaxVal;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} };
        System.out.println(mySolution(nums));
    }
}
