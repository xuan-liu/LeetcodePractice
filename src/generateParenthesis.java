import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {
    /* Backtracking */
    public static List<String> solution (int n) {
        List<String> result = new LinkedList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    /* generate the valid combination of parenthesis */
    public static void generate (List<String> result, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            result.add(current);
        } else {
            // if the number of '(' < n, then we can add '('
            if (open < max) {
                generate(result, current + '(', open + 1, close, max);
            }
            // if the number of ')' < '(', then we can add ')'
            if (close < open) {
                generate(result, current + ')', open, close + 1, max);
            }
        }
    }



    /* -------------------------------Brute Force-------------------------------------------- */
    public static List<String> mySolution (int n) {
        List<String> result = new LinkedList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /* generate all the possible combination of parenthesis recursively, can check whether it's valid */
    public static void generateAll (char[] c, int pos, List<String> combination) {
        if (pos == c.length) {
            if (valid(c)) {
                combination.add(String.valueOf(c));
            }
        } else {
            c[pos] = '(';
            generateAll(c, pos + 1, combination);
            c[pos] = ')';
            generateAll(c, pos + 1, combination);
        }
    }

    /* check whether the character array is valid */
    public static boolean valid(char[] c) {
        int count = 0;

        for (char cc: c) {
            if (cc == '(') {
                count += 1;
            } else {
                count -= 1;
            }

            if (count < 0) {return false;}
        }

        return count == 0;
    }

    public static void main(String[] args) {

        System.out.println(solution(3));
    }
}
