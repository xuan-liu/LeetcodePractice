public class mergeSortedArray {
    public static void mySolution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;

        // start from the last of A and B, check which one is bigger, then put it in the nums1[k]
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i -= 1;
                k -= 1;
            } else {
                nums1[k] = nums2[j];
                j -= 1;
                k -= 1;
            }
        }

        // if nums1 still remains, then do nothing; if nums2 remains, put all of then in nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j -= 1;
            k -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        mySolution(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
