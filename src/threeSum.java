import java.util.*;

public class threeSum {
    public static List<List<Integer>> solution(int[] nums) {
        // sort an input array
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        // run through all indices of the array as possible first element
        for (int i = 0; i < nums.length - 2; i++) {

            // if the first element > 0, then there are no result
            if (nums[i] > 0) {
                break;
            }

            // For the first elements, do not consider equal elements.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                // standard bi-directional 2Sum sweep of the remaining part of the array
                int lo = i + 1; int hi = nums.length - 1; int sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        // When do 2 sum, for low and high part, do not consider equal elements
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi --;
                        }
                        lo ++;
                        hi --;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo ++;
                    } else {
                        hi --;
                    }
                }
            }
        }
        return results;
    }



    /* --------------------------------------------------------------------------- */
    public static List<List<Integer>> mySolution(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // check compliments
            List<Integer> sum = sumMap.get(-nums[i]);
            if (sum != null) {
                for (int j = 0; j < sum.size() - 1; j += 2) {
                    List<Integer> result = Arrays.asList(nums[i], sum.get(j), sum.get(j + 1));
                    results.add(result);
                }
            }

            // add to sumMap
            for (int s: numSet) {
                List<Integer> tmp;
                if (sumMap.get(s + nums[i]) == null) {
                    tmp = new ArrayList<>();
                } else {
                    tmp = sumMap.get(s + nums[i]);
                }
                tmp.add(s);
                tmp.add(nums[i]);
                sumMap.put(s + nums[i], tmp);
            }

            // add to numSet
            numSet.add(nums[i]);
        }

        // check equal result
        int size = results.size();
        for (int i = size - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (results.get(i).equals(results.get(j))) {
                    results.remove(i);
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> m = new HashMap<>();
//        System.out.println(m.get(0));
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(solution(nums));
    }
}
