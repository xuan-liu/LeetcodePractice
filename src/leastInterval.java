public class leastInterval {
    /* Using greedy, Calculating Idle slots */
    public static int solution1(char[] tasks, int n) {
        // Example1: we have tasks : 3A, 2B, 1C, n = 2. Then we first arrange A, A??A??A, "?" is "empty" slots.
        // After that, we fill B in it, AB?AB?A, then fill C, ABCAB?A. Example2: 3A, 3B, 1C, n = 2. After arranging A and B,
        // we have AB?AB?AB.

        int[] counter = new int[26]; // store the count of every letter
        int max = 0; // the max count of all letter, in ex2 is 3
        int maxCount = 0; // how many letters have the max count, in ex2 is 2 (A and B)

        // iterate the tasks array to compute the count and max, maxCount
        for (char c: tasks) {
            counter[c - 'A'] += 1;
            if (max == counter[c - 'A']) {
                maxCount += 1;
            } else if (max < counter[c - 'A']) {
                max = counter[c - 'A'];
                maxCount = 1;
            }
        }

        int emptySlots = (n - (maxCount - 1)) * (max - 1); // the number of empty slots
        int availableTasks = tasks.length - maxCount * max; // the number of tasks except the most frequent tasks
        int idleSlots = Math.max(0, emptySlots - availableTasks); // if availableTasks > emptySlots, we will have no idle slots
        return idleSlots + tasks.length;
    }


    public static void main(String[] args) {
        char[] input = new char[]{'A','A','A','B','B','B'};
        System.out.println(solution1(input, 2));
    }
}
