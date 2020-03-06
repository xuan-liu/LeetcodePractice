import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValidParentheses {
    public static boolean mySolution_v2(String s) {
        // use map to install {'(':')','{':'}','[':']'}.
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        // If char in map, add it to stack. if char not in map, pop stack, if stack length == 0 or pop item is not according to the char,
        // return false.
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty() || c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(mySolution_v2("(]"));
    }
}
