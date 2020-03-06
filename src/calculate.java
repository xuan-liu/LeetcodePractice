import java.util.Stack;

public class calculate {
    public static int mySolution(String s) {
        // build a stack for calculation, when encounter a '+ or -' sign, push the pre num to the stack; if encounter a '* or /'
        // sign, pop a num from the stack and '* or /' the cur num.

        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // if s[i] is a digit, then use it to composite num
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // if s[i] is a sign, not a space, or i = length - 1, then calculate it
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        // then add all the nums in the stack
        int res = 0;
        for (int i: stack) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("3+5 / 2"));
    }
}
