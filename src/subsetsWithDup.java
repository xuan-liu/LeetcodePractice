import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length;) {
            // check how many duplicates
            int count = 0;
            while (count + i < nums.length && nums[i + count] == nums[i]) {
                count += 1;
            }

            // for every list in res, add combination to its duplicate
            int cur_size = res.size();
            for (int j = 0; j < cur_size; j++) {
                // we do not want to decard the original res.get(j), so we duplicate one
                List<Integer> curList = new ArrayList<>(res.get(j));
                System.out.println(curList);

                // eg, a has count = 2, its combination is "a", "aa"
                for (int z = 0; z < count; z++) {
                    curList.add(nums[i]);
                    // we want to add every combination, so we use new ArrayList here
                    res.add(new ArrayList<>(curList));
                }
            }
            i += count;
        }
        return res;
    }


    /* ---------------------------------------------------------------------------------- */
    public static List<List<Integer>> mySolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        // base case: add tempList to res
        List<Integer> tmp = new ArrayList<>(tempList);
        if (!res.contains(tmp)) {
            res.add(tmp);
        }
        System.out.println(tempList);

        // start from the i, add the next item once by once. eg (1,2,3), start at '1', then [1], [1,2], [1,2,3]
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static void backtrack2(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        // base case: add tempList to res
        res.add(new ArrayList<>(tempList));
        System.out.println(tempList);

        // start from the i, add the next item once by once. eg (1,2,3), start at '1', then [1], [1,2], [1,2,3]
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(solution(nums));
    }
}
