public class largestRectangleArea {
    public static int mySolution(int[] heights) {
        // For any bar i the maximum rectangle is of hieght heights[i], width r - l - 1 where r is the idx of the first bar the right that is lower than current,
        // l is idx of the first bar the left that is lower than current

        // left(i) denotes the idx of the first bar the left that is lower than ith bar
        // left(i) = i-1, if heights[i-1] < heights[i]. left(i) = left(left(i-1)) always left() until heights[i-1] < heights[i],
        // if heights[i-1] >= heights[i]

        if (heights == null || heights.length == 0) return 0;
        int[] leftMostIdx = new int[heights.length];
        int[] rightMostIdx = new int[heights.length];

        // generate leftMostIdx array
        leftMostIdx[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1; // consider the left num of i

            // whenever height[p] >= height[i], we jump left to p's leftMostIdx, until height[p] < height[i], we stop
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftMostIdx[p];
            }
            leftMostIdx[i] = p;
        }

        // generate rightMostIdx array
        rightMostIdx[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1; // consider the right num of i

            // whenever height[p] >= height[i], we jump right to p's rightMostIdx, until height[p] < height[i], we stop
            while (p < heights.length && heights[p] >= heights[i]) {
                p = rightMostIdx[p];
            }
            rightMostIdx[i] = p;
        }

        // compute the maxArea
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightMostIdx[i] - leftMostIdx[i] - 1));
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(mySolution(nums));
    }
}
