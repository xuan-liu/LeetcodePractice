import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zigZagConv {
    public static String solution(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> results = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            results.add(new StringBuilder());
        }

        boolean goDown = false;
        int curRow = 0;

        // iterate through the string
        for (int j = 0; j < s.length(); j++) {
            StringBuilder tmp = results.get(curRow);
            tmp.append(s.charAt(j));

            // If in the first and last row, change direction
            if (curRow == numRows - 1 || curRow == 0) {
                goDown = !goDown;
            }
            curRow = goDown? (curRow + 1) : (curRow - 1);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            result.append(results.get(i));
        }
        return result.toString();

    }



    /* --------------------------------------------------------------------------- */
    public static String mySolution(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int x = 2 * numRows - 2;
        String[] results = new String[numRows];
        for (int j = 0; j < numRows; j++) {
            results[j] = "";
        }

        for (int i = 0; i < s.length(); i++) {
            int tmp = i % x;
            if (tmp < numRows) {
                results[tmp] += s.charAt(i);
            } else {
                results[x - tmp] += s.charAt(i);
            }
        }

        String result = "";
        for (int j = 0; j < numRows; j++) {
            result += results[j].toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("PAYPALISHIRING", 3));
    }
}

