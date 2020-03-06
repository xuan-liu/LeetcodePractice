public class findMedianSortedArrays {
    public static double mySolution_v2(int[] nums1, int[] nums2) {
        // left_part               |        right_part
        //A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
        //B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
        // The idea is that we divide A and B to be left and right part, then we want len(left_part) == len(right_part) and
        // max(left_part) <= min(right_part), then median = (max(left_part) + min(right_part))/2.
        // To ensure these two conditions, we need ensure: (1) i + j == m - i + n - j (or: m - i + n - j + 1), if n >= m, we just
        // need to set: i = 0 ~ m, j = (m + n + 1)/2 - i; (2) B[j-1] <= A[i] and A[i-1] <= B[j]

        int m = nums1.length;
        int n = nums2.length;

        // we ensure that n > m
        if (n < m) {
            return mySolution_v2(nums2, nums1);
        }

        // Set imin = 0, imax = m, then start searching in [imin, imax]
        int imin = 0;
        int imax = m;
        int i = 0;
        int j = 0;
        int half_len = (m + n + 1) / 2;

        // Set i = (imin + imax)/2, j = (m + n + 1)/2 - i
        double max_of_left = 0;
        double min_of_right = 0;
        while (imin <= imax) {
            i = (imin + imax)/2;
            j = half_len - i;
            // if j > 0 and i < m and B[j - 1] > A[i] means i is too small, we must increase it.
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            // if i > 0 and j < n and A[i - 1] > B[j] means i is too big, we must decrease it.
            else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            }
            // if (j == 0 or i == m or B[j-1] <= A[i]) and (i == 0 or j = n or A[i-1] <= B[j]) means i is perfect, we can stop searching
            else {
                // find the max int in the left side, consider the corner cases
                if (i == 0) {
                    max_of_left = nums2[j-1];
                } else if (j == 0) {
                    max_of_left = nums1[i-1];
                } else {
                    max_of_left = Math.max(nums1[i-1], nums2[j-1]);
                }

                break;
            }
        }

        // if number of all items is odd, then return max_of_left
        if ((m + n) % 2 == 1) return max_of_left;

        // find the min int in the right side, consider the corner cases
        if (i == m) {
            min_of_right = nums2[j];
        } else if (j == n) {
            min_of_right = nums1[i];
        } else {
            min_of_right = Math.min(nums1[i], nums2[j]);
        }

        // if number of all items is even, then return (max_of_left + min_of_right) / 2.0
        return (max_of_left + min_of_right) / 2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(mySolution_v2(nums1, nums2));
    }
}
