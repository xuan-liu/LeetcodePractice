public class productExceptSelf {
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;

        for (int i = 1; i < n; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }


    /* --------------------------------------------------------------------------- */
    public static int[] mySolution(int[] nums) {
        // left[i] = nums[0] * nums[1] * ... * nums[i]
        // right[i] = nums[i] * ... * nums[n - 1]

        int n = nums.length;
        if (n == 0) {
            return null;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] output = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = nums[i] * left[i - 1];
            right[n - 1 - i] = nums[n - 1 - i] * right[n - i];
        }

        for (int i = 0; i < n; i++) {
            int l = i - 1 < 0? 1: left[i - 1];
            int r = i + 1 > n - 1? 1: right[i + 1];
            output[i] = l * r;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] result = solution(nums);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
    }
}
