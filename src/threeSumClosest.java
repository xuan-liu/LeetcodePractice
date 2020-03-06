import java.util.Arrays;

public class threeSumClosest {
    public static int solution(int[] nums, int target) {
        // set result to a num
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        // sort array
        Arrays.sort(nums);

        // i is current element
        for (int i = 0; i < nums.length - 2; i++) {

            // lo is next element, hi is last element
            int lo = i + 1; int hi = nums.length - 1;

            // If the sum is less than target, move next element to the next.
            // If the sum is greater, last element move to the second last element.

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }

                // compare the difference between sum and target, if it is less than minimum difference so far,
                // then replace result with it, otherwise keep iterating

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }


    /* --------------------------------------------------------------------------- */
    public static int mySolution(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1; int hi = nums.length - 1; int sum = target - nums[i];
                while (lo < hi) {
                    int tmp = nums[lo] + nums[hi];
                    if (tmp == sum) {
                        return target;
                    } else if (tmp < sum) {
                        if (Math.abs(tmp - sum) < Math.abs(result - target)) {
                            result = tmp + nums[i];
                        }
                        lo ++;
                    } else {
                        if (Math.abs(tmp - sum) < Math.abs(result - target)) {
                            result = tmp + nums[i];
                        }
                        hi --;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0};
        int target = 100;
        System.out.println(solution(nums, target));
    }
}
