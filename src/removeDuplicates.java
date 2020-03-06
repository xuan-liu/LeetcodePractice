public class removeDuplicates {
    public int mySolution(int[] nums) {
        int gap = 0; // denotes the gap between not duplicate to the new nums

        // iterate the array, if ith nums == (i-1)th nums, then add the gap; if not, then assign the new num to nums[i-gap]
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                gap += 1;
            } else {
                nums[i - gap] = nums[i];
            }
        }

        // at last, return len(not duplicate) = nums.length - gap
        return nums.length - gap;
    }
}
