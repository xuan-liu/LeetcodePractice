public class maxAreaContainer {
    public static int mySolution_v2(int[] height) {
        // Two Pointer Approach. let i be first line, j be the last line, compute area. if height of i < height of j, move i,
        // else move j until i > j. O(N)

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(mySolution_v2(nums));
    }
}
