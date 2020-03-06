import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    // use a stack to store the nested list
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // push all the nestedList into the stack from back to front
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // we peek the first element in stack currently, and if it is an Integer,
        // we will return true and pop the element. If it is a list, we will further flatten it.
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }

            // if it's a list, we push all the nestedList into the stack from back to front
            List<NestedInteger> tmp = stack.pop().getList();
            for (int i = tmp.size() - 1; i >= 0; i--) {
                stack.push(tmp.get(i));
            }
        }
        // if stack is empty, return false
        return false;
    }
}
