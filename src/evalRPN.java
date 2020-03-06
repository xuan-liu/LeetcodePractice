import java.util.Stack;

public class evalRPN {
    public int mySolution(String[] tokens) {
        // Using stack. If operators, add every token as an integer in the stack. If operations, pop two elements from the stack
        // and then save the result back to it. At last, the remaining element in the stack will be the result.
        int a;
        int b;
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                // note the order
                a = stack.pop();
                b = stack.pop();
                stack.add(b - a);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                // note the order
                a = stack.pop();
                b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
