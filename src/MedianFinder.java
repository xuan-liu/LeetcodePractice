import java.util.PriorityQueue;

public class MedianFinder {
    // maintain two heaps
    PriorityQueue<Integer> lo; // A max-heap lo to store the smaller half of the numbers
    PriorityQueue<Integer> hi; // A min-heap hi to store the larger half of the numbers

    public MedianFinder() {
        lo = new PriorityQueue<>();
        hi = new PriorityQueue<>((a, b) -> (b - a));

    }

    public void addNum(int num) {
        // Add num to max-heap lo. Then we must do a balancing step for hi, so remove the largest element from lo and offer it to hi.
        // After that, hi might end holding more elements than lo, we fix that by removing the smallest element from hi and offering it to lo.
        lo.add(num);
        hi.add(lo.poll());
        if (hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        // if k is odd, lo's size = n + 1, hi's size = n; if k is even, both size is n
        return (hi.size() < lo.size())? lo.peek(): (lo.peek() + hi.peek()) / 2.0;
    }
}
