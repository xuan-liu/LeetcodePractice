public class canJump {
    public static boolean mySolution(int[] nums) {
        // iterate and update the maximal index that I can reach, if we can iterate to the last num, then return true
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == nums.length;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(mySolution(nums));
    }
}
