import java.util.Arrays;
import java.util.PriorityQueue;

public class kClosest {
    public static int[][] solution(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;

        while (l < r) {
            int mid = partition(points, l, r);
            if (mid == K) {
                // if mid == K, then points[0:mid] is the result
                break;
            } else if (mid < K) {
                // if mid < K, then we need to partition points[mid+1: n-1]
                l = mid + 1;
            } else {
                // if mid > K, then we need to partition points[0: mid-1]
                r = mid - 1;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }


    /* partition the points from index l to index r, return the point index after partition */
    private static int partition(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            // if the points[r] >= pivot, move r to left
            while (l < r && myCompare(points[r], pivot) >= 0) {
                r -= 1;
            }
            // if not, swap points[r] with points[l]
            points[l] = points[r];

            // if the points[l] <= pivot, move l to right
            while (l < r && myCompare(points[l], pivot) <= 0) {
                l += 1;
            }
            // if not, swap points[r] with points[l]
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }

    /* compare point1 with point2 based on its distance to origin */
    private static int myCompare (int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    }

    /* -------------------------------Sort-------------------------------------------- */
    public static int[][] mySolution(int[][] points, int K) {
        // the PriorityQueue use to compare points based on their distance, and remain size = K
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        // for each point, add it to the PriorityQueue
        for (int[] point: points) {
            pq.add(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3},{-2,2}};
        int[][] ans = solution(points, 1);
        System.out.println(ans[0][0] + "," + ans[0][1]);
        //System.out.println(ans[1][0] + "," + ans[1][1]);
    }
}
