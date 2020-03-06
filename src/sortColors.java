import java.util.Arrays;

public class sortColors {
    // sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
    public static void solution(int[] nums) {
        // use two pointer low and high and an iterator i.
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                // swap nums[i] and nums[start]
                nums[i] = 1;
                nums[start] = 0;
                start += 1;
                i += 1;
            } else if (nums[i] == 2) {
                // swap nums[i] and nums[end]
                nums[i] = nums[end];
                nums[end] = 2;
                end -= 1;
            } else {
                i += 1;
            }
        }
    }

    /* counting sort */
    public static void mySolution(int[] nums) {
        // compute the count of 0, 1, 2
        int[] count = new int[3];
        Arrays.fill(count, 0);
        for (int n: nums) {
            count[n] += 1;
        }

        // compute the start index of 0, 1, 2
        int[] startIdx = new int[4];
        startIdx[0] = 0;
        startIdx[1] = count[0];
        startIdx[2] = count[0] + count[1];
        startIdx[3] = nums.length;

        // sort the array
        for (int i = 0; i < 3; i++) {
            for (int j = startIdx[i]; j < startIdx[i + 1]; j++) {
                nums[j] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        mySolution(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
