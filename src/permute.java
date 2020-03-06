import java.util.ArrayList;
import java.util.List;

public class permute {
    public static List<List<Integer>> mySolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        // base case: if tempList.size() == nums.length, then add tempList to res
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            System.out.println(tempList);
        }

        // backtrack: choose -> explore -> unchoose
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(mySolution(nums));
    }
}
