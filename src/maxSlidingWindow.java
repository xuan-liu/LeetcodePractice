import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow {
    public static int[] mySolution(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        // use a deque to keep "promising" elements' index in window [i-(k-1),i] at each i
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // scan every num
        for (int i = 0; i < nums.length; i++) {
            // If an element in the deque and it is out of i-(k-1), we discard them
            while (!q.isEmpty() && q.peek() < i - (k - 1)) {
                q.poll();
            }
            // discard elements smaller than a[i] from the tail. Since if a[x]<a[i] and x<i,
            // then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // Thus elements in the deque are ordered in both sequence in array and their value.
            // At each step the head of the deque is the max element in [i-(k-1),i]
            q.offer(i);
            if (i >= k - 1) {
                res[i - (k - 1)] = nums[q.peek()];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        int[] res = mySolution(nums, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
