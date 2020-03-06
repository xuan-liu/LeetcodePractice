public class findPeakElement {
    public int mySolution(int[] nums) {
        // Using binary search. If nums[mid] < nums[mid + 1], peak is on the right hand side. otherwise, on the left hand side
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
