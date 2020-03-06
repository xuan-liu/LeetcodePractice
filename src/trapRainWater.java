public class trapRainWater {
    public static int mySolution(int[] height) {
        int ans = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        int ml = 0;
        for (int i = 0; i < height.length; i++) {
            max_left[i] = Math.max(ml, height[i]);
            ml = max_left[i];
        }

        int mr = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max_right[i] = Math.max(mr, height[i]);
            mr = max_right[i];
        }

        for (int i = 0; i < height.length; i++) {
            ans += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(mySolution(h));
    }
}
