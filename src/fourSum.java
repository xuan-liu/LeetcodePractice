import java.util.*;

public class fourSum {
    public static List<List<Integer>> mySolution(int[] nums, int target) {
        // sort an input array
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        // first element
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                // second element
                for (int j = i +1; j < nums.length - 2; j++) {
                    if (j == i +1 || (j > 0 && nums[j] != nums[j - 1])) {

                        // standard bi-directional 2Sum sweep of the remaining part of the array
                        int lo = j + 1; int hi = nums.length - 1; int sum = target -nums[i] - nums[j];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == sum) {
                                results.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));

                                // When do 2 sum, for low and high part, do not consider equal elements
                                while (lo < hi && nums[lo] == nums[lo + 1]) {
                                    lo++;
                                }
                                while (lo < hi && nums[hi] == nums[hi - 1]) {
                                    hi --;
                                }
                                lo ++;
                                hi --;
                            } else if (nums[lo] + nums[hi] < sum) {
                                lo ++;
                            } else {
                                hi --;
                            }
                        }
                    }
                }
            }

        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(mySolution(nums, -11));
    }
}
