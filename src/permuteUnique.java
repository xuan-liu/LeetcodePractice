import java.util.*;

public class permuteUnique {
    public static List<List<Integer>> mySolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        // base case: if tempList.size() == nums.length, then add tempList to res
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            System.out.println(tempList);
        }

        // backtrack: choose -> explore -> unchoose
        for (int i = 0; i < nums.length; i++) {
            // if there are two duplicates, and (i-1)th item is not been used, then skip it
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(mySolution(nums));
    }
}
