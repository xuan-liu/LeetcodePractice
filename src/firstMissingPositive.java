public class firstMissingPositive {
    public static int mySolution(int[] nums) {
        int n = nums.length;

        // set the number to right position, eg, we swap 5 with nums[4]
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        // check the array for whether all nums[i] == i + 1, if not return i+1, else continue
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        System.out.println(mySolution(nums));
    }
}

