import java.util.Arrays;

public class nextPermutation {
    public static void mySolution(int[] nums) {
        // find i that nums[i] < nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i -= 1;
        }

        // from nums[i:n], find the index j that nums[j] is just larger then nums[i], swap them
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j -= 1;
            }
            // swap nums[i] and nums[j]
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }

        // reverse nums[i+1:n]
        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l += 1;
            r -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5};
        mySolution(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
