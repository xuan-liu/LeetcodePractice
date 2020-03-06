public class mySqrt {
    public static int mySolution(int x) {
        // use binary search, search x in all the square number (from 1 to x).
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                // x = mid ^ 2
                return mid;
            } else if (mid < x / mid) {
                // x > mid ^ 2
                left = mid + 1;
            } else {
                // x < mid ^ 2
                right = mid - 1;
            }
        }

        // final result should be just one "step" less than the left pointer.
        return right;

    }

    public static void main(String[] args) {
        System.out.println(mySolution(8));
    }
}
