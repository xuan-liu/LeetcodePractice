public class searchRange {
    public static int[] mySolution(int[] nums, int target) {
        // Using two binary search, one to find the leftmost target index, one to find the rightmost target index.
        // Let left = target - 0.5; right = target + 0.5. Then binary search left and right in the array. return [l, r-1]

        double left = target - 0.5;
        double right = target + 0.5;

        int l = bs(nums, left);
        int r = bs(nums, right);

        // if l = r, then we can not find the target. else return [l, r-1]
        if (l == r) return new int[]{-1, -1};
        else return new int[]{l, r - 1};

    }

    /* binary search a double target in int array, return the index of the number that just bigger then target
    * eg, for [1,2,3,4,5], target = 3.5, then return 3 */
    private static int bs(int[] nums, double target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; // avoid overflowing
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] res = mySolution(nums, 8);
        System.out.println("0:" + res[0]);
    }
}
