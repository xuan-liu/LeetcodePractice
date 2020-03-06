import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    public static List<List<Integer>> mySolution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        // base case: add tempList to res
        res.add(new ArrayList<>(tempList));
        System.out.println(tempList);

        // start from the i, add the next item once by once. eg (1,2,3), start at '1', then [1], [1,2], [1,2,3]
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(mySolution(nums));
    }
}
