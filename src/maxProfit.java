public class maxProfit {
    public static int mySolution(int[] prices) {
        // opt(i) indicates the max profit if sell the stock at day i
        // opt(i) = max(0, (price(i) - price(i-1)) + opt(i-1))

        int result = 0;

        if (prices.length == 0) {
            return result;
        }
        int[] maxPro = new int[prices.length];
        maxPro[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            maxPro[i] = Math.max(0, (prices[i] - prices[i - 1]) + maxPro[i - 1]);
            if (maxPro[i] > result) {
                result = maxPro[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(mySolution(nums));
    }
}
