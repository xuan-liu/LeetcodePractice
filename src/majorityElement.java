public class majorityElement {
    public int mySolution(int[] nums) {
        // Boyer-Moore Voting Algorithm. eg, [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
        // we maintain a count, which is incremented whenever we see an instance of our current candidate for majority element
        // and decremented whenever we see anything else. Whenever count equals 0, we effectively forget about everything in
        // nums up to the current index and consider the current number as the candidate for majority element.

        int majority = nums[0];
        int count = 0;

        for (int n: nums) {
            if (count == 0) {
                majority = n;
            }
            count += (n == majority)? 1: -1;
        }

        return majority;
    }
}
