import java.util.Stack;

public class calculate1 {
    public static int mySolution(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                // if char is digit, then it should be one digit from the current number
                num = 10 * num + c - '0';
            } else if (c == '+'){
                // if c = '+', number is over, we can add the previous number and start a new number
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-'){
                // if c = '-', number is over, we can add the previous number and start a new number
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // if c = '(', push the previous result and the sign into the stack, set result to 0, just calculate
                // the new result within the parenthesis.
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            } else if (c == ')') {
                // if c = ')', pop out the top two numbers from stack, first one is the sign before this pair of parenthesis,
                // second is the temporary result before this pair of parenthesis. We add them together.
                result += sign * num;
                num = 0;
                result = stack.pop() * result;
                result += stack.pop();
            }

        }

        if (num != 0) {
            result += sign * num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySolution("(1+(4+5+2)-3)+(6+8)"));
    }
}
