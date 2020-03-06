public class moveZeroes {
    public static void solution(int[] nums){
        // Shift non-zero values as far forward as possible, Fill remaining space with zeros
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos += 1;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos += 1;
        }
    }



    //----------------------------------------------------------------------------------------
    public static void mySolution(int[] nums) {
        int zeroFront = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // if encounter 0, then move it to last and nums behind it move front one step
            if (nums[i] == 0) {
                moveLast(nums, i, zeroFront);
                zeroFront -= 1;
            }
        }
    }

    /* in nums array, move ith num to the index zeroFront, nums[i+1:zeroFront-1] move front one step */
    private static void moveLast(int[] nums, int i, int zeroFront) {
        int tmp = nums[i];
        for (int j = i + 1; j < zeroFront + 1; j++) {
            nums[j - 1] = nums[j];
        }
        nums[zeroFront] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        solution(nums);
        for (int c: nums) {
            System.out.println(c);
        }
    }
}
