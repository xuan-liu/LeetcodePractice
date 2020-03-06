import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topKFrequent {
    public static List<Integer> mySolution(int[] nums, int k) {
        // First, we store the frequency of the nums in a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Second, build an array names bucket, in index i store the list of nums that has the frequency = i
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Then we add to res one by one in the order of bucket until we reach k
        List<Integer> res = new ArrayList<>();
        for (int b = bucket.length - 1; b >= 0; b--) {
            if (bucket[b] != null) {
                for (int i = 0; i < bucket[b].size() && res.size() < k; i++) {
                    res.add(bucket[b].get(i));
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(mySolution(nums, 2));
    }
}
