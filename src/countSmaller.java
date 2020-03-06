import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countSmaller {
    /* used for mergeSort so that we will get the index of different val */
    static class Pair {
        int index;
        int val;
        public Pair (int i, int v) {
            this.index = i;
            this.val = v;
        }
    }

    public static List<Integer> mySolution(int[] nums) {
        // use mergeSort. Every time we merge left and right, when we choose a left (say left[i])to the merged array, we record how many
        // numbers from array right are moved before this number, denote j. Then count(indexOf(left[i])) += j

        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Pair[] sortPair = new Pair[nums.length];   // used for mergeSort
        Integer[] count = new Integer[nums.length]; // used to store the count
        Arrays.fill(count, 0);

        // fill sortPair
        for (int i = 0; i < nums.length; i++) {
            sortPair[i] = new Pair(i, nums[i]);
        }

        // mergeSort and return count list
        mergeSort(sortPair, count);
        res.addAll(Arrays.asList(count));
        return res;
    }

    /* mergeSort the list, and record all the count */
    private static Pair[] mergeSort(Pair[] sortPair, Integer[] count) {
        // base case: if sortPair.length <= 1
        if (sortPair.length <= 1) {
            return sortPair;
        }

        // divide
        int mid = sortPair.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(sortPair, 0, mid), count);
        Pair[] right = mergeSort(Arrays.copyOfRange(sortPair, mid, sortPair.length), count);

        // merge
        int i = 0;
        int j = 0;
        while (i < left.length || j < right.length) {
            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
                // if left[i] <= right[j], move left, add count
                sortPair[i + j] = left[i];
                count[left[i].index] += j;
                i += 1;
            } else {
                // if left[i] > right[j], move right
                sortPair[i + j] = right[j];
                j += 1;
            }
        }
        return sortPair;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1};
        System.out.println(mySolution(nums));
    }
}
