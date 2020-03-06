public class RotatedSortSearch {
    public static int solution(int[] nums, int target) {
        // find the pivot's index
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int rot = lo;

        // use binary search to find target
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            int mid = (m + rot) % nums.length;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return -1;
    }


    /* ------------------------------------------------------------------------cannot pass test--- */
    public static int mySolution(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pivit = findPivotIndex(nums, 0, nums.length - 1);
        return searchIndex(nums, target, 0, nums.length - 1, pivit);
    }

    public static int findPivotIndex(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if ((nums[mid - 1] > nums[mid]) && (nums[mid] < nums[mid + 1])) {
            return mid;
        } else if (nums[mid] > nums[hi]) {
            return findPivotIndex(nums, mid + 1, hi);
        } else {
            return findPivotIndex(nums, lo, mid - 1);
        }
    }

    public static int searchIndex(int[] nums, int target, int lo, int hi, int rot) {
        if (lo > hi) {
            return -1;
        }
        int m = (lo + hi) / 2;
        int mid = (m + rot) % nums.length;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target){
            return searchIndex(nums, target, m + 1, hi, rot);
        } else {
            return searchIndex(nums, target, lo, m - 1, rot);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(solution(nums, 0));
    }
}
