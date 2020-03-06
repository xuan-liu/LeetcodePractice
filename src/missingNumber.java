public class missingNumber {
    /* Bit Manipulation */
    public int mySolution(int[] nums) {
        // eg, the value is 0,1,3,4. Then we do the computation (∧ is XOR): 4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4) = 2
        // Thus missing = nums.length ^ all the value ^ all the index

        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /* use Gauss' Formula */
    public int mySolution2(int[] nums) {
        // First compute the expected sum (if we don't have the missing). Second, iterate the array compute the actual sum.
        // Then missing = expected sum - actual sum

        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int i: nums) actualSum += i;
        return expectedSum - actualSum;
    }
}
