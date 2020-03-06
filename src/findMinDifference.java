import java.util.Arrays;
import java.util.List;

public class findMinDifference {
    public static int mySolution(List<String> timePoints) {
        // There is only 24 * 60 = 1440 possible time points. Create a boolean array,
        // each element stands for if we see that time point or not.

        boolean[] mark = new boolean[24 * 60];

        // iterate the list, and fill the mark array
        for (String tp: timePoints) {
            String[] t = tp.split(":");
            int value = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (mark[value]) {
                return 0;
            } else {
                mark[value] = true;
            }
        }

        int first = Integer.MAX_VALUE;  // first is the smallest time points in the list
        int last = Integer.MIN_VALUE; // // last is the largest time points in the list
        int min = Integer.MAX_VALUE;
        int prev = 0;

        // iterate through the mark array, compute the smallest distance of two index, and first & end
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        return Math.min(min, 24 * 60 - last + first);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("23:59","00:00");
        System.out.println("res:" + mySolution(input));
    }
}
