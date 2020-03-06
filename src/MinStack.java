import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    PriorityQueue<Integer> pq;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        pq = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }

    public void pop() {
        int tmp = stack.pop();
        pq.remove(tmp);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}
