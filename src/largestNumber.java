import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public static String mySolution(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        // convert int[] nums to String[]
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }

        // implement a String comparator to decide which String should come first during concatenation
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(s_nums, myComp);
        // if input is a bunch of 0, then return one zero
        if (s_nums[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s: s_nums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2};
        System.out.println(mySolution(nums));
    }
}
