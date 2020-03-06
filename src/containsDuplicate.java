import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public static boolean mySolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(mySolution(nums));
    }
}
