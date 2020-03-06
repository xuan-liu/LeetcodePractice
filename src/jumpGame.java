public class jumpGame {
    public static int mySolution(int[] nums) {
        // every index is a vertex, if nums[i] == x, then there are edges between i and i+1, ..., i+x. All the edges
        // have weight 1. We use dfs to solve the shortest path from 0 to n.
        int jump = 0; // the number of level we are now
        int curEnd = 0; // curEnd is the queue size (level size) for the current level you are traversing
        int curFarthest = 0; // curFarthest is used to get the queue size

        // iterate through all the vertexes
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);

            // if i == curEnd, we increment the level we are on
            if (i == curEnd) {
                jump += 1;
                curEnd = curFarthest;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(mySolution(nums));
    }
}
