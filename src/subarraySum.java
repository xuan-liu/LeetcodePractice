import java.util.HashMap;
import java.util.Map;

public class subarraySum {
    public static int mySolution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; // sum[i+1] = nums[0] + ... + nums[i]
        int count = 0; // the result count
        map.put(0, 1);


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if sum[j+1]−sum[i]=k, then subarray nums[i:j] has sum = k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } else {
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(mySolution(nums, 2));
    }
}
