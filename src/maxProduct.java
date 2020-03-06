public class maxProduct {
    public static int mySolution(int[] nums) {
        // maxProduct[i] denotes the max cumulative product UP TO current element starting from SOMEWHERE in the past
        // minProduct[i] denotes the min .... at each new element, can either add the new element to the existing product,
        // or start fresh the product from current index (wipe out previous results)
        // if we see a negative number, the "candidate" for max should instead become the previous min product
        // so maxProduct[i] = max(nums[i], nums[i] * maxProduct[i-1])

        int res = nums[0]; // store the result that is the max we have found so far
        int imax = res;
        int imin = res;

        for (int i = 1; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so if we see a negative number, we swap imax and imin
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            res = Math.max(res, imax);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -9, -6};
        System.out.println(mySolution(nums));
    }
}
