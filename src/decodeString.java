import java.util.Stack;

public class decodeString {
    public static String mySolution(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // if the char is number, then store the number to k
                k = k * 10 + c - '0';
            } else if (c == '[') {
                // if the char is '[', then put the number in intStack, put the previous cur to strStack
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // if the char is ']', then pop n in intStack and generate n of cur, and add strStack.pop() before it
                StringBuilder tmp = cur;
                int count = intStack.pop();
                cur = strStack.pop();

                for (int j = 0; j < count; j++) {
                    cur.append(tmp);
                }
            } else {
                // if the char is a letter, append it to cur
                cur.append(c);
            }
        }

        return cur.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(mySolution(s));
    }
}
