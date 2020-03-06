import java.util.HashMap;
import java.util.Map;

public class longestConsecutive {
    public static int mySolution(int[] nums) {
        // use HashMap, keep track of the sequence length and store that in the boundary points of the sequence
        int res = 0;

        // key is the item in nums, value is the longest sequence length that use the key as the boundary
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            if (!map.containsKey(n)) {
                // See if n - 1 and n + 1 exist in the map, if yes, assign it to left or right. otherwise, left or right = 0
                int left = map.containsKey(n - 1)? map.get(n - 1): 0;
                int right = map.containsKey(n + 1)? map.get(n + 1): 0;

                // compute the longest sequence length that with the key in it
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // update the sequence boundary
                map.put(n - left, sum);
                map.put(n + right, sum);

            } else {
                // if the map contains the key, jump the duplicates
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(mySolution(nums));
    }
}
