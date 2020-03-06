import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static int[] mySolution_v2(int[] nums, int target){
        // build a hashmap, which key is the item, value is the index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // search whether the map contain (target - nums[i])
            if (map.containsKey(target - nums[i])) {
                int x = map.get(target - nums[i]);
                return new int[]{x, i};
            }
            // if we cannot find, put the item in the map
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(mySolution_v2(nums, 9));
    }
}
