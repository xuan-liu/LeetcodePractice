import java.util.LinkedList;

public class asteroidCollision {
    public static int[] mySolution(int[] asteroids) {
        LinkedList<Integer> res = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            // pre = res.getLast(), cur = asteroids[i]
            // if pre is -, then cur can be +/-; if cur is +, then cur can be +/-
            if (res.isEmpty() || res.getLast() < 0 || asteroids[i] > 0) {
                res.add(asteroids[i]);
            } else {
                // if pre -, cur +, then there is collision
                if (-asteroids[i] == res.getLast()) {
                    res.pollLast();
                } else if (-asteroids[i] > res.getLast()) {
                    res.pollLast();
                    i -= 1; // for next iterate, cur remains the same, pre is the pre of pre
                }
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, -5};
        System.out.println(mySolution(nums));
    }
}
