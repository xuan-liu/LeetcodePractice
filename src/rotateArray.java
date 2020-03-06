public class rotateArray {
    public static void mySolution(int[] nums, int k) {
        // to have constant space, we can first reverse the whole array, then reverse from 0 to k-1, reverse from k to n-1.
        // eg. [1,2,3,4,5,6,7] and k = 3, first [7,6,5,4,3,2,1], then reverse [7,6,5] and [4,3,2,1], return [5,6,7,1,2,3,4]

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    /* reverse the array from index start to index end, include end */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        mySolution(nums, 3);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
