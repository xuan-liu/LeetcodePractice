import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class removeInvalidParentheses {
    static Set<String> validExpressions = new HashSet<>();

    public static List<String> mySolution(String s) {
        int open = 0; // numbers of '(' need to remove
        int close = 0; // numbers of ')' need to remove

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open += 1;
            } else if (s.charAt(i) == ')'){
                // if number of '(' > number of ')', need to remove one ')'
                if (open == 0) {
                    close += 1;
                } else {
                    // if number of ')' > number of '(' at last, need to remove the extra '('
                    open -= 1;
                }
            }
        }
        recurse(s, 0, 0, 0, open, close, new StringBuilder());
        return new ArrayList<String>(validExpressions);

    }

    private static void recurse(String s, int index, int openCount, int closeCount, int openRemove, int closeRemove, StringBuilder expression) {
        if (index == s.length()) {
            // if this is the last char, then check the expression whether satisfy
            if (openRemove == 0 && closeRemove == 0) {
                validExpressions.add(expression.toString());
            }
        } else {
            // if not the last char, check s[index]
            char c = s.charAt(index);
            int len = expression.length();

            // case1: if have space to remove, discard this char
            if ((c == '(' && openRemove > 0) || (c == ')' && closeRemove > 0)) {
                recurse(s, index + 1, openCount, closeCount, openRemove - (c == '(' ? 1: 0), closeRemove - (c == ')' ? 1: 0), expression);
            }

            // for case2,3,4, add the char
            expression.append(c);
            // case2: not parentheses, then add it
            if (c != '(' && c != ')') {
                recurse(s, index + 1, openCount, closeCount, openRemove, closeRemove, expression);
            } else if (c == '(') {
                // case3: if '(', add it
                recurse(s, index + 1, openCount + 1, closeCount, openRemove, closeRemove, expression);
            } else if (openCount > closeCount) {
                // case4: if ')', and number of ')' < number of '(', add it
                recurse(s, index + 1, openCount, closeCount + 1, openRemove, closeRemove, expression);
            }
            expression.deleteCharAt(len);
        }
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(mySolution(s));
    }
}
