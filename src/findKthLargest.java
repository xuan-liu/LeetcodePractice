public class findKthLargest {
    public static int mySolution(int[] nums, int k) {
        // use partition, if the result position of partitioning nums[i] > len - k, then we partition in the lower space; if <, then
        // in higher space; if =, then we get nums[k]
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];

    }

    /* partition the leftmost int in the nums array */
    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi -= 1;
            }
            // if nums[hi] < pivot, move it to the pivot place, nums[hi] remains the same
            nums[lo] = nums[hi];

            while (lo < hi && nums[lo] <= pivot){
                lo += 1;
            }
            // if nums[lo] > pivot, move it to the right, nums[lo] remains the same
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(mySolution(nums, 4));
    }
}
