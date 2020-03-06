public class splitArray {
    public static int mySolution(int[] nums, int m) {
        // the result will in [max of nums, sum of nums], binary search it. Let mid = (l + r) / 2, if
        // we can divide the array into more than m subarrays that the result < target, then r = mid - 1. else l = mid + 1.
        int l = 0;
        int r = 0;
        for (int n: nums) {
            l = Math.max(l, n);
            r += n;
        }
        if (m == 1) {
            return r;
        }

        // binary search the result
        while (l <= r) {
            int mid = (l + r) / 2;
            if (valid(nums, m, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    /* tell whether we can divide the array into more than m subarrays that the largest sub sum <= target */
    private static boolean valid(int[] nums, int m, int target) {
        int count = 1;
        int subSum = 0;

        for (int n: nums) {
            subSum += n;
            if (subSum > target) {
                // if the subSum > target, we add count and reset subSum
                count += 1;
                subSum = n;
                if (count > m) {
                    // if we can divide the array more than m, return false
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(mySolution(nums, 2));
    }
}
